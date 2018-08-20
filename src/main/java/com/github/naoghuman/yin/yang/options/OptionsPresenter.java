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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

/**
 *
 * @author Naoghuman
 * @since  0.2.0
 */
public class OptionsPresenter implements 
        EventConfiguration, I18nConfiguration, Initializable,
        PreferencesConfiguration, RegisterActions
{
    @FXML private ComboBox    cbYangColors;
    @FXML private ComboBox    cbYinColors;
    @FXML private Label       lYangColors;
    @FXML private Label       lYinColors;
    @FXML private RadioButton rbSingleColors;
    @FXML private Tab         tOptionAbout;
    @FXML private Tab         tOptionColor;
    @FXML private Tab         tOptionExtras;
    @FXML private Tab         tOptionLanguage;
    @FXML private Tab         tOptionSpeed;
    @FXML private TabPane     tpOptions;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initialize(URL, ResourceBundle)"); // NOI18N
        
        this.initializeOptionTabPane();
        this.initializeOptionTabColor();
        
        this.register();
    }
    
    private void initializeOptionTabPane() {
       LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initializeOptionTabPane()"); // NOI18N
         
    }
    
    private void initializeOptionTabColor() {
        LoggerFacade.getDefault().info(this.getClass(), "OptionsPresenter.initializeOptionTabColor()"); // NOI18N
        
        final ColorComboBox yangColorComboBox = new ColorComboBox();
        final String yangSelectedColor = PreferencesFacade.getDefault().get(PREF__YINYANG__YANG_COLOR, PREF__YINYANG__YANG_COLOR_DEFAULT_VALUE);
        yangColorComboBox.configure(cbYangColors, ColorComboBox.Type.YANG_SYMBOL, yangSelectedColor);
        
        final ColorComboBox yinColorComboBox = new ColorComboBox();
        final String yinSelectedColor = PreferencesFacade.getDefault().get(PREF__YINYANG__YIN_COLOR, PREF__YINYANG__YIN_COLOR_DEFAULT_VALUE);
        yinColorComboBox.configure(cbYinColors, ColorComboBox.Type.YIN_SYMBOL, yinSelectedColor);
    }
    
    private void onActionUpdateLanguageInOptions() {
        LoggerFacade.getDefault().info(this.getClass(), "Options.onActionUpdateLanguageInOptions()"); // NOI18N
        
        tOptionAbout.setText(   I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_ABOUT)));
        tOptionColor.setText(   I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_COLOR)));
        tOptionExtras.setText(  I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_EXTRAS)));
        tOptionLanguage.setText(I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_LANGUAGE)));
        tOptionSpeed.setText(   I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TAB_SPEED)));
    }

    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "OptionsPresenter.register()"); // NOI18N
        
        this.registerOnActionUpdateLanguageInOptions();
    }
    
    private void registerOnActionUpdateLanguageInOptions() {
        LoggerFacade.getDefault().debug(this.getClass(), "Options.registerOnActionUpdateLanguageInOptions()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__UPDATE__LANGUAGE_IN_OPTIONS,
                (ActionEvent event) -> {
                    this.onActionUpdateLanguageInOptions();
                });
    }
    
}
