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
package com.github.naoghuman.app.yy.options;

import com.github.naoghuman.app.yy.color.ColorMaterialDesign;
import com.github.naoghuman.app.yy.color.ColorProvider;
import com.github.naoghuman.app.yy.configuration.ConfigurationEvent;
import com.github.naoghuman.app.yy.configuration.ConfigurationPreferences;
import com.github.naoghuman.app.yy.i18n.I18NProvider;
import com.github.naoghuman.app.yy.taichi.TaiChiYangColors;
import com.github.naoghuman.app.yy.taichi.TaiChiYinColors;
import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TabPane;
import javafx.scene.control.ToggleGroup;
import com.github.naoghuman.app.yy.configuration.ConfigurationI18N;

/**
 *
 * @author Naoghuman
 * @since  0.3.0
 */
public class OptionsPresenter implements 
        ConfigurationEvent, ConfigurationI18N, ConfigurationPreferences,
        Initializable, RegisterActions
{
    @FXML private CheckBox    cbAlwaysOnTop;
    @FXML private ComboBox<ColorMaterialDesign> cbYangColors;
    @FXML private ComboBox<ColorMaterialDesign> cbYinColors;
    @FXML private Label       lOptionAbout;
    @FXML private Label       lOptionColor;
    @FXML private Label       lOptionExtras;
    @FXML private Label       lOptionLanguage;
    @FXML private Label       lOptionSpeed;
    @FXML private Label       lYangColors;
    @FXML private Label       lYinColors;
    @FXML private RadioButton rbSingleColors;
    @FXML private RadioButton rbMultiLanguages;
    @FXML private RadioButton rbSingleLanguage;
    @FXML private RadioButton rbSingleLanguageEnglish;
    @FXML private RadioButton rbSingleLanguageGerman;
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
    }
    
    private void initializeOptionTabPane() {
        LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initializeOptionTabPane()"); // NOI18N
        
        I18NProvider.getDefault().getI18NBinding().bindTo(lOptionAbout.textProperty(),    I18N__OPTION_DIALOG__TAB_ABOUT);
        I18NProvider.getDefault().getI18NBinding().bindTo(lOptionColor.textProperty(),    I18N__OPTION_DIALOG__TAB_COLOR);
        I18NProvider.getDefault().getI18NBinding().bindTo(lOptionExtras.textProperty(),   I18N__OPTION_DIALOG__TAB_EXTRAS);
        I18NProvider.getDefault().getI18NBinding().bindTo(lOptionLanguage.textProperty(), I18N__OPTION_DIALOG__TAB_LANGUAGE);
        I18NProvider.getDefault().getI18NBinding().bindTo(lOptionSpeed.textProperty(),    I18N__OPTION_DIALOG__TAB_SPEED);
    }
    
    private void initializeOptionTabAbout() {
        LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initializeOptionTabAbout()"); // NOI18N
        
    }
    
    private void initializeOptionTabColor() {
        LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initializeOptionTabColor()"); // NOI18N
        
        // Bind text
        I18NProvider.getDefault().getI18NBinding().bindTo(rbSingleColors.textProperty(), I18N__OPTION__SINGLE_COLORS);
        I18NProvider.getDefault().getI18NBinding().bindTo(lYinColors.textProperty(),     I18N__OPTION__YIN_COLOR);
        I18NProvider.getDefault().getI18NBinding().bindTo(lYangColors.textProperty(),    I18N__OPTION__YANG_COLOR);
        
        // Load color
        // TODO returns momentary r,g,b instead ColorMaterialDesign.XY.name()
        final String yangColor = PreferencesFacade.getDefault().get(
                PREF__TAICHI_SYMBOL__YANG_COLOR,
                PREF__TAICHI_SYMBOL__YANG_COLOR_DEFAULT_VALUE);
        ColorProvider.getDefault().getColorComboBox().configure(
                cbYangColors, TaiChiYangColors.getColors(),
                ColorMaterialDesign.get(yangColor, ColorMaterialDesign.GREY_050),
                ON_ACTION__UPDATE__YANG_COLOR);
        
        final String yinColor = PreferencesFacade.getDefault().get(
                PREF__TAICHI_SYMBOL__YIN_COLOR,
                PREF__TAICHI_SYMBOL__YIN_COLOR_DEFAULT_VALUE);
        ColorProvider.getDefault().getColorComboBox().configure(
                cbYinColors, TaiChiYinColors.getColors(),
                ColorMaterialDesign.get(yinColor, ColorMaterialDesign.GREY_900),
                ON_ACTION__UPDATE__YIN_COLOR);
    }
    
    private void initializeOptionTabExtras() {
        LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initializeOptionTabExtras()"); // NOI18N
        
        // Bind text
        I18NProvider.getDefault().getI18NBinding().bindTo(cbAlwaysOnTop.textProperty(), I18N__OPTION_DIALOG__TAB_EXTRAS__ALWAYS_ON_TOP);
        
        // Select CheckBox
        final boolean alwaysOnTop = PreferencesFacade.getDefault().getBoolean(
                PREF__OPTIONS__EXTRAS__ALWAYS_ON_TOP,
                PREF__OPTIONS__EXTRAS__ALWAYS_ON_TOP_DEFAULT_VALUE);
        cbAlwaysOnTop.setSelected(alwaysOnTop);
    }
    
    private void initializeOptionTabLanguage() {
        LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initializeOptionTabLanguage()"); // NOI18N
        
        // Bind text
        I18NProvider.getDefault().getI18NBinding().bindTo(rbSingleLanguage.textProperty(),        I18N__OPTION_DIALOG__TAB_LANGUAGE__SINGLE);
        I18NProvider.getDefault().getI18NBinding().bindTo(rbSingleLanguageEnglish.textProperty(), I18N__OPTION_DIALOG__TAB_LANGUAGE__ENGLISH);
        I18NProvider.getDefault().getI18NBinding().bindTo(rbSingleLanguageGerman.textProperty(),  I18N__OPTION_DIALOG__TAB_LANGUAGE__GERMAN);
        I18NProvider.getDefault().getI18NBinding().bindTo(rbMultiLanguages.textProperty(),        I18N__OPTION_DIALOG__TAB_LANGUAGE__MULTI);
        
        // Select the right RadioButton
        rbSingleLanguageEnglish.setUserData(I18NProvider.getDefault().getI18NConverter().convertTo(PREF__I18N__LANGUAGE_ENGLISH));
        rbSingleLanguageGerman.setUserData(I18NProvider.getDefault().getI18NConverter().convertTo(PREF__I18N__LANGUAGE_GERMAN));
        
        final ObservableList<RadioButton> radioButtons = FXCollections.observableArrayList();
        radioButtons.addAll(rbSingleLanguageEnglish, rbSingleLanguageGerman);
        
        final String language = PreferencesFacade.getDefault().get(PREF__I18N__LANGUAGE,
                I18NProvider.getDefault().getI18NConverter().convertTo(PREF__I18N__LANGUAGE_DEFAULT_VALUE));
        radioButtons.stream()
                .filter(radioButton -> radioButton.getUserData().equals(language))
                .forEach(radioButton -> {
                    radioButton.setSelected(Boolean.TRUE);
                });
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
        Locale locale = PREF__I18N__LANGUAGE_DEFAULT_VALUE;
        if (rbSingleLanguageEnglish.isSelected()) {
            locale = PREF__I18N__LANGUAGE_ENGLISH;
        }
        
        if (rbSingleLanguageGerman.isSelected()) {
            locale = PREF__I18N__LANGUAGE_GERMAN;
        }
        
        I18NProvider.getDefault().onActionSwitchLanguage(locale);
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

    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "OptionsPresenter.register()"); // NOI18N
    }
    
}
