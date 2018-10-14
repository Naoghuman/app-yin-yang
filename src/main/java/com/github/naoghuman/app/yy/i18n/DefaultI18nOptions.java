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

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.properties.core.PropertiesFacade;
import com.github.naoghuman.app.yy.configuration.ConfigurationI18n;
import java.util.Locale;

/**
 *
 * @author Naoghuman
 * @since  0.2.0
 */
final class DefaultI18nOptions implements 
        ConfigurationI18n, I18nLanguage
{
    private Locale language = Locale.ENGLISH;
    
    DefaultI18nOptions() {
        
    }

    @Override
    public String getProperty(final String key) {
        return PropertiesFacade.getDefault().getProperty(
                (language == Locale.ENGLISH)
                        ? I18N__RESOURCE_BUNDLE__OPTIONS_EN 
                        : I18N__RESOURCE_BUNDLE__OPTIONS_DE,
                key);
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().info(this.getClass(), "DefaultI18nApplication.register()"); // NOI18N
        
        PropertiesFacade.getDefault().register(I18N__RESOURCE_BUNDLE__OPTIONS_DE);
        PropertiesFacade.getDefault().register(I18N__RESOURCE_BUNDLE__OPTIONS_EN);
    }
    
    @Override
    public void setLanguage(final Locale language) {
        LoggerFacade.getDefault().debug(this.getClass(), "DefaultI18nApplication.setLanguage(Locale)"); // NOI18N
        
        this.language = language;
    }
    
}
