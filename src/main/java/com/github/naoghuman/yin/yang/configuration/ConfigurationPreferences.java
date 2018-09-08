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

import com.github.naoghuman.yin.yang.color.ColorMaterialDesign;

/**
 *
 * @author Naoghuman
 * @since  0.2.0
 */
public interface ConfigurationPreferences {
    
    // Application
    public static final String  PREF__APPLICATION__POSITION_X                  = "PREF__APPLICATION__POSITION_X"; // NOI18N
    public static final double  PREF__APPLICATION__POSITION_X_DEFAULT_VALUE    = 0.0d;
    public static final String  PREF__APPLICATION__POSITION_Y                  = "PREF__APPLICATION__POSITION_Y"; // NOI18N
    public static final double  PREF__APPLICATION__POSITION_Y_DEFAULT_VALUE    = 0.0d;
    
    // Language
    public static final String PREF__I18N__LANGUAGE               = "PREF__I18N__LANGUAGE"; // NOI18N
    public static final String PREF__I18N__LANGUAGE_DEFAULT_VALUE = "ENGLISH"; // NOI18N
    public static final String PREF__I18N__LANGUAGE_ENGLISH       = "ENGLISH"; // NOI18N
    public static final String PREF__I18N__LANGUAGE_GERMAN        = "GERMAN"; // NOI18N
    
    // Options
    public static final String  PREF__OPTIONS__EXTRAS__ALWAYS_ON_TOP               = "PREF__OPTIONS__EXTRAS__ALWAYS_ON_TOP"; // NOI18N
    public static final boolean PREF__OPTIONS__EXTRAS__ALWAYS_ON_TOP_DEFAULT_VALUE = Boolean.TRUE;
    
    // TaiChi
    public static final String PREF__TAICHI_SYMBOL__DIAMETER                 = "PREF__TAICHI_SYMBOL__DIAMETER"; // NOI18N
    public static final double PREF__TAICHI_SYMBOL__DIAMETER_DEFAULT_VALUE   = 320.0d;
    public static final String PREF__TAICHI_SYMBOL__YANG_COLOR               = "PREF__TAICHI_SYMBOL__YANG_COLOR"; // NOI18N
    public static final String PREF__TAICHI_SYMBOL__YANG_COLOR_DEFAULT_VALUE = ColorMaterialDesign.GREY_050.rgb();
    public static final String PREF__TAICHI_SYMBOL__YIN_COLOR                = "PREF__TAICHI_SYMBOL__YIN_COLOR"; // NOI18N
    public static final String PREF__TAICHI_SYMBOL__YIN_COLOR_DEFAULT_VALUE  = ColorMaterialDesign.GREY_900.rgb();
    
}
