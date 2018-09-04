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
package com.github.naoghuman.yin.yang.taichi;

import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.util.Optional;

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
public final class TaiChiProvider implements RegisterActions {
    
    private static final Optional<TaiChiProvider> INSTANCE = Optional.of(new TaiChiProvider());
    
    public static final TaiChiProvider getDefault() {
        return INSTANCE.get();
    }
    
    private final TaiChiColors   taiChiColors   = new DefaultTaiChiColors();
    private final TaiChiRotation taiChiRotation = new DefaultTaiChiRotation();
    private final TaiChiSymbol   taiChiSymbol   = new DefaultTaiChiSymbol();
    private final TaiChiTerms    taiChiTerms    = new DefaultTaiChiTerms();
    
    private TaiChiProvider() {
        
    }
    
    public void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiProvider.initialize()"); // NOI18N
        
        taiChiColors.initialize();
        taiChiRotation.initialize();
        taiChiSymbol.initialize();
        taiChiTerms.initialize();
    }
    
    public TaiChiColors getTaiChiColors() {
        return taiChiColors;
    }
    
    public TaiChiRotation getTaiChiRotation() {
        return taiChiRotation;
    }
    
    public TaiChiSymbol getTaiChiSymbol() {
        return taiChiSymbol;
    }
    
    public TaiChiTerms getTaiChiTerms() {
        return taiChiTerms;
    }

    @Override
    public void register() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiProvider.register()"); // NOI18N
        
        taiChiColors.register();
        taiChiSymbol.register();
    }
    
}
