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

import javafx.util.Duration;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public interface ApplicationConfiguration {
    
    public static final Duration DURATION__125 = Duration.millis(125.0d);
    
    public static final String APPLICATION_WINDOW__POSITION_X               = "APPLICATION_WINDOW__POSITION_X"; // NOI18N
    public static final double APPLICATION_WINDOW__POSITION_X_DEFAULT_VALUE = 0.0d;
    public static final String APPLICATION_WINDOW__POSITION_Y               = "APPLICATION_WINDOW__POSITION_Y"; // NOI18N
    public static final double APPLICATION_WINDOW__POSITION_Y_DEFAULT_VALUE = 0.0d;
    
    public static final String PREF_KEY__APPLICATION__BORDER_SIGN     = "application.border.sign"; // NOI18N
    public static final String PREF_KEY__APPLICATION__BUILD_DATETIME  = "application.build.datetime"; // NOI18N
    public static final String PREF_KEY__APPLICATION__MESSAGE_START   = "application.message.start"; // NOI18N
    public static final String PREF_KEY__APPLICATION__MESSAGE_STOP    = "application.message.stop"; // NOI18N
    public static final String PREF_KEY__APPLICATION__RESOURCE_BUNDLE = "/com/github/naoghuman/yin/yang/application/application.properties"; // NOI18N
    public static final String PREF_KEY__APPLICATION__OPTIONS_RESOURCE_BUNDLE_DE = "/com/github/naoghuman/yin/yang/application/options_de.properties"; // NOI18N
    public static final String PREF_KEY__APPLICATION__OPTIONS_RESOURCE_BUNDLE_EN = "/com/github/naoghuman/yin/yang/application/options_en.properties"; // NOI18N
    public static final String PREF_KEY__APPLICATION__OPTIONS_COLORS             = "application.options.colors"; // NOI18N
    public static final String PREF_KEY__APPLICATION__OPTIONS_LANGUAGES          = "application.options.languages"; // NOI18N
    public static final String PREF_KEY__APPLICATION__OPTIONS_LANGUAGE_ENGLISH   = "application.options.language.english"; // NOI18N
    public static final String PREF_KEY__APPLICATION__OPTIONS_LANGUAGE_GERMAN    = "application.options.language.german"; // NOI18N
    public static final String PREF_KEY__APPLICATION__OPTIONS_YANG_COLOR         = "application.options.yangcolor"; // NOI18N
    public static final String PREF_KEY__APPLICATION__OPTIONS_YIN_COLOR          = "application.options.yincolor"; // NOI18N
    public static final String PREF_KEY__APPLICATION__TITLE   = "application.title"; // NOI18N
    public static final String PREF_KEY__APPLICATION__VERSION = "application.version"; // NOI18N
    
}
