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

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
public interface ColorConverter {

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
    public String convertToBrighter(final String color, double opacity);
    
}
