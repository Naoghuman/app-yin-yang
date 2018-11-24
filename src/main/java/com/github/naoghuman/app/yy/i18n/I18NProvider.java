/*
 * Copyright (C) 2018 Naoghuman
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.github.naoghuman.app.yy.i18n;

import static com.github.naoghuman.app.yy.configuration.ConfigurationI18N.I18N__RESOURCE_BUNDLE__MESSAGES;

import com.github.naoghuman.app.yy.configuration.ConfigurationEvent;
import com.github.naoghuman.app.yy.configuration.ConfigurationPreferences;
import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.i18n.core.I18NFacade;
import com.github.naoghuman.lib.i18n.core.I18NResourceBundleBuilder;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import java.util.Locale;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

/**
 *
 * @author Naoghuman
 * @since  0.2.0
 */
public final class I18NProvider implements 
        ConfigurationEvent, ConfigurationPreferences, RegisterActions
{
    private static final Optional<I18NProvider> INSTANCE = Optional.of(new I18NProvider());
    
    public static final I18NProvider getDefault() {
        return INSTANCE.get();
    }
    
    private final I18NBinding   i18NBinding     = new DefaultI18NBinding();
    private final I18NConverter i18NConverter   = new DefaultI18NConverter();
    private final I18NLanguage  i18NApplication = new DefaultI18NApplication();
    
    private I18NProvider() {
        
    }
    
    public I18NLanguage getI18NApplication() {
        return i18NApplication;
    }
    
    public I18NBinding getI18NBinding() {
        return i18NBinding;
    }
    
    public I18NConverter getI18NConverter() {
        return i18NConverter;
    }
    
    public I18NFacade getI18NFacade() {
        return I18NFacade.getDefault();
    }
    
    private void onActionLoadLanguageFromProperties() {
        LoggerFacade.getDefault().debug(this.getClass(), "I18nProvider.onActionLoadLanguageFromProperties(String)"); // NOI18N

        // Load locale
        final Locale locale = i18NConverter.convertTo(PreferencesFacade.getDefault().get(
                PREF__I18N__LANGUAGE,
                i18NConverter.convertTo(PREF__I18N__LANGUAGE_DEFAULT_VALUE)));
        
        // Update the locale
        I18NFacade.getDefault().setActualLocale(locale);
    }
    
    public void onActionSwitchLanguage(final Locale locale) {
        LoggerFacade.getDefault().debug(this.getClass(), "I18nProvider.onActionSwitchLanguage(Locale)"); // NOI18N

        // Persit in .properties
        PreferencesFacade.getDefault().put(PREF__I18N__LANGUAGE, i18NConverter.convertTo(locale));
        
        // Update binded texts
        I18NFacade.getDefault().setActualLocale(locale);
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().info(this.getClass(), "I18nProvider.register()"); // NOI18N
        
        i18NApplication.register();
        
        this.registerOnActionConfigureResourceBundle();
        this.registerOnActionUpdateLanguage();
    }

    private void registerOnActionConfigureResourceBundle() {
        LoggerFacade.getDefault().info(this.getClass(), "I18nProvider.registerOnActionConfigureResourceBundle()"); // NOI18N
        
        // TODO .actualLocale(Locale.ENGLISH) PreferencesFacade.getDefault().getString(...)
        final ObservableList<Locale> locales = FXCollections.observableArrayList();
        locales.addAll(Locale.ENGLISH, Locale.GERMAN);
        I18NResourceBundleBuilder.configure()
                .baseBundleName(I18N__RESOURCE_BUNDLE__MESSAGES)
                .supportedLocales(locales)
                .defaultLocale(Locale.ENGLISH)
                .actualLocale(Locale.ENGLISH)
                .build();
    }

    private void registerOnActionUpdateLanguage() {
        LoggerFacade.getDefault().info(this.getClass(), "I18nProvider.registerOnActionUpdateLanguage()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__UPDATE__LANGUAGE,
                (ActionEvent event) -> {
                    this.onActionLoadLanguageFromProperties();
                });
    }
    
}
