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
package com.github.naoghuman.yin.yang.options;

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.yin.yang.color.ColorComboBox;
import com.github.naoghuman.yin.yang.configuration.EventConfiguration;
import com.github.naoghuman.yin.yang.configuration.I18nConfiguration;
import com.github.naoghuman.yin.yang.configuration.PreferencesConfiguration;
import com.github.naoghuman.yin.yang.i18n.I18nProvider;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Naoghuman
 * @since  0.2.0
 */
public final class Options implements 
        EventConfiguration, I18nConfiguration, PreferencesConfiguration,
        RegisterActions
{
    private static final Color COLOR__BACKGROUND_OPTIONS = Color.color(1.0d, 1.0d, 1.0d, 0.66d);
    
    private static final Optional<Options> INSTANCE = Optional.of(new Options());
    
    public static final Options getDefault() {
        return INSTANCE.get();
    }
    
    private Button      bMinimizeApplication;
    private Button      bCloseApplication;
    private CheckBox    cbAlwaysOnTop;
    private Circle      cOptionsBackground;
    private ComboBox    cbYangColors;
    private ComboBox    cbYinColors;
    private Label       lLanguages;
    private Label       lYangColors;
    private Label       lYinColors;
    private Label       lYinYangColors;
    private Label       lYangTerm;
    private Label       lYinTerm;
    private RadioButton rbEnglishLanguage;
    private RadioButton rbGermanLanguage;
    private Separator   bSeparator1;
    
    private Options() {
        this.initialize();
    }
    
    private void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "Options.initialize()"); // NOI18N
        
        this.register();
    }
    
    public void configure(
            final Circle      cOptionsBackground, final Button      bMinimizeApplication,
            final Button      bCloseApplication,  final Separator   bSeparator1,
            final Label       lYinYangColors,     final Label       lYinColors,
            final ComboBox    cbYinColors,        final Label       lYangColors,
            final ComboBox    cbYangColors,       final Label       lLanguages,
            final RadioButton rbEnglishLanguage,  final RadioButton rbGermanLanguage,
            final CheckBox    cbAlwaysOnTop
    ) {
        LoggerFacade.getDefault().debug(this.getClass(), "Options.configure()"); // NOI18N
        
        this.cOptionsBackground   = cOptionsBackground;
        this.bMinimizeApplication = bMinimizeApplication;
        this.bCloseApplication    = bCloseApplication;
        this.bSeparator1          = bSeparator1;
        this.lYinYangColors       = lYinYangColors;
        this.lYinColors           = lYinColors;
        this.cbYinColors          = cbYinColors;
        this.lYangColors          = lYangColors;
        this.cbYangColors         = cbYangColors;
        this.lLanguages           = lLanguages;
        this.rbEnglishLanguage    = rbEnglishLanguage;
        this.rbGermanLanguage     = rbGermanLanguage;
        this.cbAlwaysOnTop        = cbAlwaysOnTop;
        
        this.configureOptions();
        
        final boolean showOptions = Boolean.FALSE;
        this.onActionShowOptions(showOptions);
    }
    
    private void configureOptions() {
        LoggerFacade.getDefault().debug(this.getClass(), "Options.configureOptions()"); // NOI18N
    
        // Background
        cOptionsBackground.setFill(COLOR__BACKGROUND_OPTIONS);
        cOptionsBackground.setStroke(null);
        
        // Colors
        final ColorComboBox yangColorComboBox = new ColorComboBox();
        final String yangSelectedColor = PreferencesFacade.getDefault().get(PREF__YINYANG__YANG_COLOR, PREF__YINYANG__YANG_COLOR_DEFAULT_VALUE);
        yangColorComboBox.configure(cbYangColors, ColorComboBox.Type.YANG_SYMBOL, yangSelectedColor);
        
        final ColorComboBox yinColorComboBox = new ColorComboBox();
        final String yinSelectedColor = PreferencesFacade.getDefault().get(PREF__YINYANG__YIN_COLOR, PREF__YINYANG__YIN_COLOR_DEFAULT_VALUE);
        yinColorComboBox.configure(cbYinColors, ColorComboBox.Type.YIN_SYMBOL, yinSelectedColor);
        
        // Language
        final String language = PreferencesFacade.getDefault().get(PREF__I18N__LANGUAGE, PREF__I18N__LANGUAGE_DEFAULT_VALUE);
        switch(language) {
            case PREF__I18N__LANGUAGE_ENGLISH: { rbEnglishLanguage.setSelected(Boolean.TRUE); break; }
            case PREF__I18N__LANGUAGE_GERMAN:  { rbGermanLanguage.setSelected(Boolean.TRUE);  break; }
        }
        
        ActionHandlerFacade.getDefault().handle(ON_ACTION__LOAD_LANGUAGE_FROM_PREFERENCES);
        
        // Always on top
        final boolean alwaysOnTop = PreferencesFacade.getDefault().getBoolean(PREF__APPLICATION__ALWAYS_ON_TOP, PREF__APPLICATION__ALWAYS_ON_TOP_DEFAULT_VALUE);
        cbAlwaysOnTop.setSelected(alwaysOnTop);
    }

    public void onActionChangeAlwaysOnTop() {
        LoggerFacade.getDefault().info(this.getClass(), "Options.onActionChangeAlwaysOnTop()"); // NOI18N

        final boolean alwaysOnTop = cbAlwaysOnTop.isSelected();
        PreferencesFacade.getDefault().putBoolean(PREF__APPLICATION__ALWAYS_ON_TOP, alwaysOnTop);
        
        ActionHandlerFacade.getDefault()
                .handle(TransferDataBuilder.create()
                        .actionId(ON_ACTION__CHANGE__ALWAYS_ON_TOP)
                        .booleanValue(alwaysOnTop)
                        .build());
    }
    
    /**
     * Will be executed from the RadionButtons in 'application.fxml'.
     */
    public void onActionChangeLanguage() {
        LoggerFacade.getDefault().info(this.getClass(), "Options.onActionChangeLanguage()"); // NOI18N
        
        // Compute the new locale
        String language = PREF__I18N__LANGUAGE_DEFAULT_VALUE;
        if (rbEnglishLanguage.isSelected()) {
            language = PREF__I18N__LANGUAGE_ENGLISH;
        }
        
        if (rbGermanLanguage.isSelected()) {
            language = PREF__I18N__LANGUAGE_GERMAN;
        }
        
        // Save the new locale
        PreferencesFacade.getDefault().put(PREF__I18N__LANGUAGE, language);
        
        // Reload the gui
        ActionHandlerFacade.getDefault().handle(ON_ACTION__LOAD_LANGUAGE_FROM_PREFERENCES);
    }

    private void onActionShowOptions(final boolean showOptions) {
        LoggerFacade.getDefault().info(this.getClass(), String.format(
                "Options.onActionShowOptions(showOption=%b)", showOptions)); // NOI18N
    
        // Background
        cOptionsBackground.setManaged(showOptions);
        cOptionsBackground.setVisible(showOptions);
        
        // Actions
        bMinimizeApplication.setManaged(showOptions);
        bMinimizeApplication.setVisible(showOptions);
        bCloseApplication.setManaged(showOptions);
        bCloseApplication.setVisible(showOptions);
        
        bSeparator1.setManaged(showOptions);
        bSeparator1.setVisible(showOptions);
        
        // Colors
        lYinYangColors.setManaged(showOptions);
        lYinYangColors.setVisible(showOptions);
        
        lYinColors.setManaged(showOptions);
        lYinColors.setVisible(showOptions);
        cbYinColors.setManaged(showOptions);
        cbYinColors.setVisible(showOptions);
        
        lYangColors.setManaged(showOptions);
        lYangColors.setVisible(showOptions);
        cbYangColors.setManaged(showOptions);
        cbYangColors.setVisible(showOptions);
        
        // Languages
        lLanguages.setManaged(showOptions);
        lLanguages.setVisible(showOptions);
        
        rbEnglishLanguage.setManaged(showOptions);
        rbEnglishLanguage.setVisible(showOptions);
        
        rbGermanLanguage.setManaged(showOptions);
        rbGermanLanguage.setVisible(showOptions);
        
        // Always on top
        cbAlwaysOnTop.setManaged(showOptions);
        cbAlwaysOnTop.setVisible(showOptions);
    }
    
    private void onActionUpdateLanguageOptions() {
        LoggerFacade.getDefault().info(this.getClass(), "Options.onActionUpdateLanguageOptions()"); // NOI18N
        
        lYinYangColors.setText(I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION__COLORS)));
        lYangColors.setText(   I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION__YANG_COLOR)));
        lYinColors.setText(    I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION__YIN_COLOR)));
        
        lLanguages.setText(       I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION__LANGUAGES)));
        rbEnglishLanguage.setText(I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION__LANGUAGE_ENGLISH)));
        rbGermanLanguage.setText( I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION__LANGUAGE_GERMAN)));
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "Options.register()"); // NOI18N
        
//        this.registerOnActionShowOptions();
        this.registerOnActionUpdateLanguageOptions();
    }
    
    private void registerOnActionShowOptions() {
        LoggerFacade.getDefault().debug(this.getClass(), "Options.registerOnActionShowOptions()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__SHOW_OPTIONS,
                (ActionEvent event) -> {
                    final Object source = event.getSource();
                    if (source instanceof TransferData) {
                        final TransferData      transferData = (TransferData) source;
                        final Optional<Boolean> optional     = transferData.getBoolean();
                        if(optional.isPresent()) {
                            final boolean isShowOptions = optional.get();
                            this.onActionShowOptions(isShowOptions);
                        }
                    }
                });
    }
    
    private void registerOnActionUpdateLanguageOptions() {
        LoggerFacade.getDefault().debug(this.getClass(), "Options.registerOnActionUpdateLanguageOptions()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__UPDATE_LANGUAGE__OPTIONS,
                (ActionEvent event) -> {
                    this.onActionUpdateLanguageOptions();
                });
    }
    
}
