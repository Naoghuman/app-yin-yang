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
package com.github.naoghuman.yin.yang.configuration;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public interface YinYangConfiguration {
    
    public static final double RADIUS__BIG_SYMBOL    = 150.0d;
    public static final double RADIUS__LITTLE_SYMBOL = 150.0d / 10.0d;
    
    public static final String YIN_YANG__SYMBOL__YANG_COLOR               = "YIN_YANG__SYMBOL__YANG_COLOR"; // NOI18N
    public static final String YIN_YANG__SYMBOL__YANG_COLOR_DEFAULT_VALUE = "255, 255, 255"; // NOI18N
    public static final String YIN_YANG__SYMBOL__YIN_COLOR                = "YIN_YANG__SYMBOL__YIN_COLOR"; // NOI18N
    public static final String YIN_YANG__SYMBOL__YIN_COLOR_DEFAULT_VALUE  = "0, 0, 0"; // NOI18N
    
}
