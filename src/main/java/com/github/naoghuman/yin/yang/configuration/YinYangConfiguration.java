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
    
    public static final String PREF__YIN_YANG__RESOURCE_BUNDLE_DE            = "/com/github/naoghuman/yin/yang/yinyang/yinyangterms_de.properties"; // NOI18N
    public static final String PREF__YIN_YANG__RESOURCE_BUNDLE_EN            = "/com/github/naoghuman/yin/yang/yinyang/yinyangterms_en.properties"; // NOI18N
    public static final String PREF__YIN_YANG__SYMBOL_DIAMETER               = "PREF__YIN_YANG__SYMBOL_DIAMETER"; // NOI18N
    public static final double PREF__YIN_YANG__SYMBOL_DIAMETER_DEFAULT_VALUE = 320.0d;
    public static final String PREF__YIN_YANG__YANG_COLOR                    = "PREF__YIN_YANG__YANG_COLOR"; // NOI18N
    public static final String PREF__YIN_YANG__YANG_COLOR_DEFAULT_VALUE      = "255, 255, 255"; // NOI18N
    public static final String PREF__YIN_YANG__YIN_COLOR                     = "PREF__YIN_YANG__YIN_COLOR"; // NOI18N
    public static final String PREF__YIN_YANG__YIN_COLOR_DEFAULT_VALUE       = "0, 0, 0"; // NOI18N
    
    public static final String PREF_KEY__YIN_YANG__TERM_MAX_QUANTITY = "yinyangterms.maxquantity"; // NOI18N
    public static final String PREF_KEY__YIN_YANG__TERM_YANG         = "yinyangterm%d.yang"; // NOI18N
    public static final String PREF_KEY__YIN_YANG__TERM_YIN          = "yinyangterm%d.yin"; // NOI18N
    
    public static final double YIN_YANG_SYMBOLE__OUTER_BORDER = 5.0d;
    
}
