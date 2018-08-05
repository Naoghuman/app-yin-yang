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
package com.github.naoghuman.yin.yang.color;

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import javafx.scene.paint.Color;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public class ColorConverter {
    
    /**
     * Returns a color string which can be transformed to a color with 
     * Color.web(string). The color will be a brighter(0.1) version from the 
     * 'color'.
     * 
     * Format: rgba(int, int, int, double)
     *         where int    == 0-255
     *         where double == 0.0-1.0
     * 
     * @param color
     * @param opacity
     * @return 
     */
    public static String convertToBrighter(final String color, double opacity) {
        LoggerFacade.getDefault().debug(ColorConverter.class, "ColorConverter.convertToBrighter()"); // NOI18N
        
        final StringBuilder sb = new StringBuilder();
        
        Color c = Color.web(String.format("rgb(%s)", color)); // NOI18N
              c = Color.color(c.getRed(), c.getGreen(), c.getBlue(), opacity);
        
        double brightness = c.getBrightness();
               brightness = (brightness >= 0.15d) ? brightness - 0.1d : brightness + 0.1d;
                        c = Color.hsb(c.getHue(), c.getSaturation(), brightness, opacity);
        
        sb.append("rgba("); // NOI18N
        sb.append((int)(255 * c.getRed()));
        sb.append(","); // NOI18N
        sb.append((int)(255 * c.getGreen()));
        sb.append(","); // NOI18N
        sb.append((int)(255 * c.getBlue()));
        sb.append(","); // NOI18N
        sb.append(opacity);
        sb.append(")"); // NOI18N
        
        return sb.toString();
    }
    
}
