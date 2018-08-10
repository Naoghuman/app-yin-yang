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
import java.util.Optional;

/**
 *
 * @author Naoghuman
 * @since  0.2.0
 */
public final class I18nProvider implements I18nRegister {
    
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
    
    public I18nYinYang getI18nYinYang() {
        return I18nYinYang.getDefault();
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "I18nProvider.register()"); // NOI18N
        
        I18nApplication.getDefault().register();
        I18nOptions.getDefault().register();
        I18nYinYang.getDefault().register();
    }
    
}
