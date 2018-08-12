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

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.properties.core.PropertiesFacade;
import com.github.naoghuman.yin.yang.configuration.I18nConfiguration;
import java.util.Locale;
import java.util.Optional;

/**
 *
 * @author Naoghuman
 * @since  0.2.0
 */
public final class I18nYinYang implements I18nConfiguration, I18nLanguage, I18nProperty, I18nRegister {
    
    private static final Optional<I18nYinYang> INSTANCE = Optional.of(new I18nYinYang());
    
    public static final I18nYinYang getDefault() {
        return INSTANCE.get();
    }
    
    private Locale language = Locale.ENGLISH;
    
    private I18nYinYang() {
        this.initialize();
    }
    
    private void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "I18nYinYang.initialize()"); // NOI18N
        
    }

    @Override
    public String getProperty(String key) {
        return PropertiesFacade.getDefault().getProperty(
                (language == Locale.ENGLISH)
                        ? I18N__RESOURCE_BUNDLE__YINYANG_EN 
                        : I18N__RESOURCE_BUNDLE__YINYANG_DE,
                key);
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "I18nYinYang.register()"); // NOI18N
        
        PropertiesFacade.getDefault().register(I18N__RESOURCE_BUNDLE__YINYANG_DE);
        PropertiesFacade.getDefault().register(I18N__RESOURCE_BUNDLE__YINYANG_EN);
    }
    
    @Override
    public void setLanguage(final Locale language) {
        LoggerFacade.getDefault().debug(this.getClass(), "I18nYinYang.setLanguage(Locale)"); // NOI18N
        
        this.language = language;
    }
    
}
