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
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.yin.yang.color.ColorComboBox;
import com.github.naoghuman.yin.yang.configuration.EventConfiguration;
import com.github.naoghuman.yin.yang.configuration.I18nConfiguration;
import com.github.naoghuman.yin.yang.configuration.PreferencesConfiguration;
import com.github.naoghuman.yin.yang.i18n.I18nProvider;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @author Naoghuman
 * @since  0.3.0
 */
public class OptionsPresenter implements 
        EventConfiguration, I18nConfiguration, Initializable,
        PreferencesConfiguration, RegisterActions
{
    @FXML private CheckBox    cbAlwaysOnTop;
    @FXML private ComboBox<String> cbYangColors;
    @FXML private ComboBox<String> cbYinColors;
    @FXML private Label       lYangColors;
    @FXML private Label       lYinColors;
    @FXML private RadioButton rbSingleColors;
    @FXML private RadioButton rbMultiLanguages;
    @FXML private RadioButton rbSingleLanguage;
    @FXML private RadioButton rbSingleLanguageEnglish;
    @FXML private RadioButton rbSingleLanguageGerman;
    @FXML private Tab         tOptionAbout;
    @FXML private Tab         tOptionColor;
    @FXML private Tab         tOptionExtras;
    @FXML private Tab         tOptionLanguage;
    @FXML private Tab         tOptionSpeed;
    @FXML private TabPane     tpOptions;
    @FXML private ToggleGroup tgLanguages;
    @FXML private ToggleGroup tgSingleLanguages;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initialize(URL, ResourceBundle)"); // NOI18N
        
        this.initializeOptionTabPane();
        this.initializeOptionTabColor();
        this.initializeOptionTabSpeed();
        this.initializeOptionTabLanguage();
        this.initializeOptionTabExtras();
        this.initializeOptionTabAbout();
        
        this.register();
        
        ActionHandlerFacade.getDefault().handle(ON_ACTION__LOAD_LANGUAGE_FROM_PREFERENCES);
    }
    
    private void initializeOptionTabPane() {
       LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initializeOptionTabPane()"); // NOI18N
         
    }
    
    private void initializeOptionTabAbout() {
        LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initializeOptionTabAbout()"); // NOI18N
        
    }
    
    private void initializeOptionTabColor() {
        LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initializeOptionTabColor()"); // NOI18N
        
        final ColorComboBox yangColorComboBox = new ColorComboBox();
        final String yangSelectedColor = PreferencesFacade.getDefault().get(PREF__TAICHI_SYMBOL__YANG_COLOR,
                PREF__TAICHI_SYMBOL__YANG_COLOR_DEFAULT_VALUE);
        yangColorComboBox.configure(cbYangColors, ColorComboBox.Type.YANG_SYMBOL, yangSelectedColor);
        
        final ColorComboBox yinColorComboBox = new ColorComboBox();
        final String yinSelectedColor = PreferencesFacade.getDefault().get(PREF__TAICHI_SYMBOL__YIN_COLOR,
                PREF__TAICHI_SYMBOL__YIN_COLOR_DEFAULT_VALUE);
        yinColorComboBox.configure(cbYinColors, ColorComboBox.Type.YIN_SYMBOL, yinSelectedColor);
    }
    
    private void initializeOptionTabExtras() {
        LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initializeOptionTabExtras()"); // NOI18N
        
        // Always on top
        final boolean alwaysOnTop = PreferencesFacade.getDefault().getBoolean(
                PREF__OPTIONS__EXTRAS__ALWAYS_ON_TOP,
                PREF__OPTIONS__EXTRAS__ALWAYS_ON_TOP_DEFAULT_VALUE);
        cbAlwaysOnTop.setSelected(alwaysOnTop);
    }
    
    private void initializeOptionTabLanguage() {
        LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initializeOptionTabLanguage()"); // NOI18N
        
        // Language
        final String language = PreferencesFacade.getDefault().get(
                PREF__I18N__LANGUAGE,
                PREF__I18N__LANGUAGE_DEFAULT_VALUE);
        switch(language) {
            case PREF__I18N__LANGUAGE_ENGLISH: { rbSingleLanguageEnglish.setSelected(Boolean.TRUE); break; }
            case PREF__I18N__LANGUAGE_GERMAN:  { rbSingleLanguageGerman.setSelected( Boolean.TRUE); break; }
        }
    }
    
    private void initializeOptionTabSpeed() {
        LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initializeOptionTabSpeed()"); // NOI18N
        
    }

    public void onActionChangeAlwaysOnTop() {
        LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.onActionChangeAlwaysOnTop()"); // NOI18N

        final boolean alwaysOnTop = cbAlwaysOnTop.isSelected();
        PreferencesFacade.getDefault().putBoolean(PREF__OPTIONS__EXTRAS__ALWAYS_ON_TOP, alwaysOnTop);
        
        ActionHandlerFacade.getDefault()
                .handle(TransferDataBuilder.create()
                        .actionId(ON_ACTION__CHANGE__ALWAYS_ON_TOP)
                        .booleanValue(alwaysOnTop)
                        .build());
    }
    
    public void onActionChangeLanguage() {
        LoggerFacade.getDefault().debug(this.getClass(), "OptionsPresenter.onActionChangeLanguage()"); // NOI18N
        
        // Compute the new locale
        String language = PREF__I18N__LANGUAGE_DEFAULT_VALUE;
        if (rbSingleLanguageEnglish.isSelected()) {
            language = PREF__I18N__LANGUAGE_ENGLISH;
        }
        
        if (rbSingleLanguageGerman.isSelected()) {
            language = PREF__I18N__LANGUAGE_GERMAN;
        }
        
        // Save the new locale
        PreferencesFacade.getDefault().put(PREF__I18N__LANGUAGE, language);
        
        // Reload the gui
        ActionHandlerFacade.getDefault().handle(ON_ACTION__LOAD_LANGUAGE_FROM_PREFERENCES);
    }
    
    public void onActionSwitchLanguageMode() {
        LoggerFacade.getDefault().debug(this.getClass(), "OptionsPresenter.onActionSwitchLanguageMode()"); // NOI18N
        
//        String language = PREF__I18N__LANGUAGE_DEFAULT_VALUE;
//        if (rbSingleLanguage.isSelected()) {
//            language = PREF__I18N__LANGUAGE_ENGLISH;
//        }
//        
//        if (rbMultiLanguages.isSelected()) {
//            language = PREF__I18N__LANGUAGE_GERMAN;
//        }
// 
//        // Save the new locale
//        PreferencesFacade.getDefault().put(PREF__I18N__LANGUAGE, language);
//        
//        // Reload the gui
//        ActionHandlerFacade.getDefault().handle(ON_ACTION__UPDATE__LANGUAGE_IN_OPTIONDIALOG);
    }

    private void onActionUpdateLanguageInTabPane() {
        LoggerFacade.getDefault().debug(this.getClass(), "OptionsPresenter.onActionUpdateLanguageInTabPane()"); // NOI18N
        
        tOptionAbout.setText(   I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_ABOUT)));
        tOptionColor.setText(   I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_COLOR)));
        tOptionExtras.setText(  I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_EXTRAS)));
        tOptionLanguage.setText(I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_LANGUAGE)));
        tOptionSpeed.setText(   I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_SPEED)));
    }

    private void onActionUpdateLanguageInTabColor() {
        LoggerFacade.getDefault().debug(this.getClass(), "OptionsPresenter.onActionUpdateLanguageInTabColor()"); // NOI18N
        
        // Single Colors
        rbSingleColors.setText(I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION__SINGLE_COLORS)));
        lYinColors.setText(    I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION__YIN_COLOR)));
        lYangColors.setText(   I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION__YANG_COLOR)));
    }

    private void onActionUpdateLanguageInTabSpeed() {
        LoggerFacade.getDefault().debug(this.getClass(), "OptionsPresenter.onActionUpdateLanguageInTabSpeed()"); // NOI18N
        
    }

    private void onActionUpdateLanguageInTabLanguage() {
        LoggerFacade.getDefault().debug(this.getClass(), "OptionsPresenter.onActionUpdateLanguageInTabLanguage()"); // NOI18N
        
        // Single Language
        rbSingleLanguage.setText(       I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_LANGUAGE__SINGLE)));
        rbSingleLanguageEnglish.setText(I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_LANGUAGE__ENGLISH)));
        rbSingleLanguageGerman.setText( I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_LANGUAGE__GERMAN)));
        
        // Multi Language
        rbMultiLanguages.setText(   I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_LANGUAGE__MULTI)));
    }

    private void onActionUpdateLanguageInTabExtras() {
        LoggerFacade.getDefault().debug(this.getClass(), "OptionsPresenter.onActionUpdateLanguageInTabExtras()"); // NOI18N
        
        // Always on top TODO
        cbAlwaysOnTop.setText(I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_EXTRAS__ALWAYS_ON_TOP)));
    }

    private void onActionUpdateLanguageInTabAbout() {
        LoggerFacade.getDefault().debug(this.getClass(), "OptionsPresenter.onActionUpdateLanguageInTabAbout()"); // NOI18N
        
    }

    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "OptionsPresenter.register()"); // NOI18N
        
        this.registerOnActionUpdateLanguageInOptions();
    }
    
    private void registerOnActionUpdateLanguageInOptions() {
        LoggerFacade.getDefault().debug(this.getClass(), "Options.registerOnActionUpdateLanguageInOptions()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__UPDATE__LANGUAGE_IN_OPTIONDIALOG,
                (ActionEvent event) -> {
                    this.onActionUpdateLanguageInTabPane();
                    this.onActionUpdateLanguageInTabColor();
                    this.onActionUpdateLanguageInTabSpeed();
                    this.onActionUpdateLanguageInTabLanguage();
                    this.onActionUpdateLanguageInTabExtras();
                    this.onActionUpdateLanguageInTabAbout();
                });
    }
    
}
