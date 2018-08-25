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
 * @since  0.2.0
 */
public interface I18nConfiguration {
    
    // Resourcebundles
    public static final String I18N__RESOURCE_BUNDLE__APPLICATION = "/com/github/naoghuman/yin/yang/application/i18n_application.properties"; // NOI18N
    
    public static final String I18N__RESOURCE_BUNDLE__OPTIONS_DE = "/com/github/naoghuman/yin/yang/options/i18n_options_de.properties"; // NOI18N
    public static final String I18N__RESOURCE_BUNDLE__OPTIONS_EN = "/com/github/naoghuman/yin/yang/options/i18n_options_en.properties"; // NOI18N
    
    public static final String I18N__RESOURCE_BUNDLE__YINYANG_DE = "/com/github/naoghuman/yin/yang/yinyang/i18n_yinyang_de.properties"; // NOI18N
    public static final String I18N__RESOURCE_BUNDLE__YINYANG_EN = "/com/github/naoghuman/yin/yang/yinyang/i18n_yinyang_en.properties"; // NOI18N
    
    // Keys
    public static final String I18N_KEY__APPLICATION__BORDER_SIGN    = "i18n.key.application.border.sign"; // NOI18N
    public static final String I18N_KEY__APPLICATION__BUILD_DATETIME = "i18n.key.application.build.datetime"; // NOI18N
    public static final String I18N_KEY__APPLICATION__MESSAGE_START  = "i18n.key.application.message.start"; // NOI18N
    public static final String I18N_KEY__APPLICATION__MESSAGE_STOP   = "i18n.key.application.message.stop"; // NOI18N
    public static final String I18N_KEY__APPLICATION__TITLE          = "i18n.key.application.title"; // NOI18N
    public static final String I18N_KEY__APPLICATION__VERSION        = "i18n.key.application.version"; // NOI18N
    
    public static final String I18N_KEY__OPTION__EXTRAS__ALWAYS_ON_TOP = "i18n.key.option.extras.alwaysontop"; // NOI18N
    public static final String I18N_KEY__OPTION__LANGUAGES        = "i18n.key.option.languages"; // NOI18N
    public static final String I18N_KEY__OPTION__LANGUAGE_ENGLISH = "i18n.key.option.language.english"; // NOI18N
    public static final String I18N_KEY__OPTION__LANGUAGE_GERMAN  = "i18n.key.option.language.german"; // NOI18N
    public static final String I18N_KEY__OPTION__LANGUAGE_MULTI   = "i18n.key.option.language.multi"; // NOI18N
    public static final String I18N_KEY__OPTION__LANGUAGE_SINGLE  = "i18n.key.option.language.single"; // NOI18N
    public static final String I18N_KEY__OPTION__SINGLE_COLORS    = "i18n.key.option.singlecolors"; // NOI18N
    public static final String I18N_KEY__OPTION__YANG_COLOR       = "i18n.key.option.yangcolor"; // NOI18N
    public static final String I18N_KEY__OPTION__YIN_COLOR        = "i18n.key.option.yincolor"; // NOI18N
    
    public static final String I18N_KEY__OPTION_DIALOG__BUTTON       = "i18n.key.option.dialog.button"; // NOI18N
    public static final String I18N_KEY__OPTION_DIALOG__TAB_ABOUT    = "i18n.key.option.dialog.tab.about"; // NOI18N
    public static final String I18N_KEY__OPTION_DIALOG__TAB_COLOR    = "i18n.key.option.dialog.tab.color"; // NOI18N
    public static final String I18N_KEY__OPTION_DIALOG__TAB_EXTRAS   = "i18n.key.option.dialog.tab.extras"; // NOI18N
    public static final String I18N_KEY__OPTION_DIALOG__TAB_LANGUAGE = "i18n.key.option.dialog.tab.language"; // NOI18N
    public static final String I18N_KEY__OPTION_DIALOG__TAB_SPEED    = "i18n.key.option.dialog.tab.speed"; // NOI18N
    public static final String I18N_KEY__OPTION_DIALOG__TITLE        = "i18n.key.option.dialog.title"; // NOI18N
    
    public static final String I18N_KEY__YINYANG__TERM_NR       = "i18n.key.yinyang.term.nr%d"; // NOI18N
    public static final String I18N_KEY__YINYANG__TERM_QUANTITY = "i18n.key.yinyang.term.quantity"; // NOI18N
    
}
