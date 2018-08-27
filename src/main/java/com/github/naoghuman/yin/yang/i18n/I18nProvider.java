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
package com.github.naoghuman.yin.yang.i18n;

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.yin.yang.configuration.EventConfiguration;
import com.github.naoghuman.yin.yang.configuration.PreferencesConfiguration;
import java.util.Locale;
import java.util.Optional;
import javafx.event.ActionEvent;

/**
 *
 * @author Naoghuman
 * @since  0.2.0
 */
public final class I18nProvider implements 
        EventConfiguration, I18nRegister, PreferencesConfiguration
{
    private static final Optional<I18nProvider> INSTANCE = Optional.of(new I18nProvider());
    
    public static final I18nProvider getDefault() {
        return INSTANCE.get();
    }
    
    private I18nProvider() {
        this.initialize();
    }
    
    private void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "I18nProvider.initialize()"); // NOI18N
    }
    
    public I18nApplication getI18nApplication() {
        return I18nApplication.getDefault();
    }
    
    public I18nOptions getI18nOptions() {
        return I18nOptions.getDefault();
    }
    
    public I18nTaiChi getI18nYinYang() {
        return I18nTaiChi.getDefault();
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
        I18nOptions.getDefault().setLanguage(locale);
        I18nTaiChi.getDefault().setLanguage(locale);
        
        // Update gui
        ActionHandlerFacade.getDefault().handle(ON_ACTION__UPDATE__LANGUAGE_IN_OPTIONDIALOG);
        ActionHandlerFacade.getDefault().handle(ON_ACTION__UPDATE__LANGUAGE_IN_TAICHI_TERMS);
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "I18nProvider.register()"); // NOI18N
        
        I18nApplication.getDefault().register();
        I18nOptions.getDefault().register();
        I18nTaiChi.getDefault().register();
        
        this.registerOnActionLoadLanguageFromProperties();
    }

    private void registerOnActionLoadLanguageFromProperties() {
        LoggerFacade.getDefault().info(this.getClass(), "I18nProvider.registerOnActionLoadLanguageFromProperties()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__LOAD_LANGUAGE_FROM_PREFERENCES,
                (ActionEvent event) -> {
                    this.onActionLoadLanguageFromProperties();
                });
    }
    
}
