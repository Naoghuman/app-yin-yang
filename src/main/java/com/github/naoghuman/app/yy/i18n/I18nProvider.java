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

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.app.yy.configuration.ConfigurationEvent;
import com.github.naoghuman.app.yy.configuration.ConfigurationPreferences;
import java.util.Locale;
import java.util.Optional;
import javafx.event.ActionEvent;

/**
 *
 * @author Naoghuman
 * @since  0.2.0
 */
public final class I18nProvider implements 
        ConfigurationEvent, ConfigurationPreferences, RegisterActions
{
    private static final Optional<I18nProvider> INSTANCE = Optional.of(new I18nProvider());
    
    public static final I18nProvider getDefault() {
        return INSTANCE.get();
    }
    
    private final I18nLanguage i18nApplication = new DefaultI18nApplication();
    private final I18nLanguage i18nOptions     = new DefaultI18nOptions();
    private final I18nLanguage i18nTaiChi      = new DefaultI18nTaiChi();
    
    private I18nProvider() {
        
    }
    
    public I18nLanguage getI18nApplication() {
        return i18nApplication;
    }
    
    public I18nLanguage getI18nOptions() {
        return i18nOptions;
    }
    
    public I18nLanguage getI18nTaiChi() {
        return i18nTaiChi;
    }
    
    private void onActionLoadLanguageFromProperties() {
        LoggerFacade.getDefault().info(this.getClass(), "I18nProvider.onActionLoadLanguageFromProperties(String)"); // NOI18N

        // Load locale
        Locale locale = Locale.ENGLISH;
        final String language = PreferencesFacade.getDefault().get(PREF__I18N__LANGUAGE, PREF__I18N__LANGUAGE_DEFAULT_VALUE);
        switch(language) {
            case PREF__I18N__LANGUAGE_ENGLISH: { locale = Locale.ENGLISH; break; }
            case PREF__I18N__LANGUAGE_GERMAN:  { locale = Locale.GERMAN;  break; }
        }
        
        // Set locale
        i18nOptions.setLanguage(locale);
        i18nTaiChi.setLanguage(locale);
        
        // Update gui
        ActionHandlerFacade.getDefault().handle(ON_ACTION__UPDATE__LANGUAGE_IN_OPTIONDIALOG);
        ActionHandlerFacade.getDefault().handle(ON_ACTION__UPDATE__LANGUAGE_IN_TAICHI_TERMS);
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().info(this.getClass(), "I18nProvider.register()"); // NOI18N
        
        i18nApplication.register();
        i18nOptions.register();
        i18nTaiChi.register();
        
        this.registerOnActionUpdateLanguage();
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
