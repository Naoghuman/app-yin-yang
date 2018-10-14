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
package com.github.naoghuman.app.yy.color;

import java.util.Optional;

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
public final class ColorProvider  {
    
    private static final Optional<ColorProvider> INSTANCE = Optional.of(new ColorProvider());
    
    public static final ColorProvider getDefault() {
        return INSTANCE.get();
    }
    
    final ColorConverter colorConverter = new DefaultColorConverter();
    
    private ColorProvider() {
        
    }
    
    public ColorComboBox getColorComboBox() {
        return new DefaultColorComboBox();
    }
    
    // TODO move all color converting methods to here
    public ColorConverter getColorConverter() {
        return colorConverter;
    }
    
    
}
