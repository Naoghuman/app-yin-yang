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
package com.github.naoghuman.yin.yang.application;

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.lib.properties.core.PropertiesFacade;
import com.github.naoghuman.yin.yang.color.ColorComboBox;
import com.github.naoghuman.yin.yang.yinyang.YinYangSymbol;
import com.github.naoghuman.yin.yang.yinyang.YinYangTerms;
import com.github.naoghuman.yin.yang.configuration.ActionConfiguration;
import com.github.naoghuman.yin.yang.configuration.ApplicationConfiguration;
import com.github.naoghuman.yin.yang.configuration.YinYangConfiguration;
import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public class ApplicationPresenter implements 
        Initializable, ActionConfiguration, ApplicationConfiguration,
        RegisterActions, YinYangConfiguration
{
    private static final Color COLOR__BACKGROUND_OPTIONS = Color.color(1.0d, 1.0d, 1.0d, 0.66d);
    
    @FXML private AnchorPane  apApplication;
    @FXML private Button      bCloseApplication;
    @FXML private Circle      cOptionsBackground;
    @FXML private ComboBox    cbYangColors;
    @FXML private ComboBox    cbYinColors;
    @FXML private HBox        hbYinYangTerms;
    @FXML private Label       lLanguages;
    @FXML private Label       lYangColors;
    @FXML private Label       lYinColors;
    @FXML private Label       lYinYangColors;
    @FXML private Label       lYangTerm;
    @FXML private Label       lYinTerm;
    @FXML private RadioButton rbEnglishLanguage;
    @FXML private RadioButton rbGermanLanguage;
    @FXML private Separator   bSeparator1;
    @FXML private ToggleGroup tgLanguages;
    
    private Locale language = Locale.ENGLISH;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.initialize(URL, ResourceBundle)"); // NOI18N
        
//        assert (apView != null) : "fx:id=\"apView\" was not injected: check your FXML file 'application.fxml'."; // NOI18N
        
        this.initializeOptions();
        
        PropertiesFacade.getDefault().register(PREF_KEY__APPLICATION__OPTIONS_RESOURCE_BUNDLE_DE);
        PropertiesFacade.getDefault().register(PREF_KEY__APPLICATION__OPTIONS_RESOURCE_BUNDLE_EN);
        
        this.register();
        
        final boolean showOptions = Boolean.FALSE;
        this.onActionShowOptions(showOptions);
        
        YinYangSymbol.getDefault().configure(apApplication);
        YinYangSymbol.getDefault().onActionStartYinYangRotation();
        
        YinYangTerms.getDefault().configure(hbYinYangTerms, lYinTerm, lYangTerm);
        YinYangTerms.getDefault().onActionShowYinAndYangTerm();
    }
    
    private void initializeOptions() {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.initializeOptions()"); // NOI18N
    
        cOptionsBackground.setFill(COLOR__BACKGROUND_OPTIONS);
        cOptionsBackground.setStroke(null);
        
        final ColorComboBox yangColorComboBox = new ColorComboBox();
        final String yangSelectedColor = PreferencesFacade.getDefault().get(YIN_YANG__SYMBOL__YANG_COLOR, YIN_YANG__SYMBOL__YANG_COLOR_DEFAULT_VALUE);
        yangColorComboBox.configure(cbYangColors, ColorComboBox.Type.YANG_SYMBOL, yangSelectedColor);
        
        final ColorComboBox yinColorComboBox = new ColorComboBox();
        final String yinSelectedColor = PreferencesFacade.getDefault().get(YIN_YANG__SYMBOL__YIN_COLOR, YIN_YANG__SYMBOL__YIN_COLOR_DEFAULT_VALUE);
        yinColorComboBox.configure(cbYinColors, ColorComboBox.Type.YIN_SYMBOL, yinSelectedColor);
    }
    
    private String getProperty(final String propertyKey) {
        return PropertiesFacade.getDefault().getProperty(
                (language == Locale.ENGLISH) ? PREF_KEY__APPLICATION__OPTIONS_RESOURCE_BUNDLE_EN 
                        : PREF_KEY__APPLICATION__OPTIONS_RESOURCE_BUNDLE_DE,
                propertyKey);
    }
    
    public void onActionChangeLanguage() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.onActionChangeLanguage()"); // NOI18N
        
        Locale language = Locale.ENGLISH;
        if (rbEnglishLanguage.isSelected()) {
            language = Locale.ENGLISH;
        }
        
        if (rbGermanLanguage.isSelected()) {
            language = Locale.GERMAN;
        }
        
        this.onActionChangeLanguage(language);
        YinYangTerms.getDefault().onActionChangeLanguage(language);
    }
    
    private void onActionChangeLanguage(final Locale language) {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.onActionChangeLanguage(Locale)"); // NOI18N

        // Change language
        this.language = language;
        
        // Update gui
        lYinYangColors.setText(this.getProperty(String.format(PREF_KEY__APPLICATION__OPTIONS_COLORS)));
        lYangColors.setText(this.getProperty(String.format(PREF_KEY__APPLICATION__OPTIONS_YANG_COLOR)));
        lYinColors.setText(this.getProperty(String.format(PREF_KEY__APPLICATION__OPTIONS_YIN_COLOR)));
        
        lLanguages.setText(this.getProperty(String.format(PREF_KEY__APPLICATION__OPTIONS_LANGUAGES)));
        rbEnglishLanguage.setText(this.getProperty(String.format(PREF_KEY__APPLICATION__OPTIONS_LANGUAGE_ENGLISH)));
        rbGermanLanguage.setText(this.getProperty(String.format(PREF_KEY__APPLICATION__OPTIONS_LANGUAGE_GERMAN)));
    }
    
    public void onActionCloseRequest() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.onActionCloseRequest()"); // NOI18N
    
        ActionHandlerFacade.getDefault().handle(ActionConfiguration.ON_ACTION__CLOSE_REQUEST);
    }

    private void onActionShowOptions(final boolean showOptions) {
        LoggerFacade.getDefault().info(this.getClass(), String.format(
                "ApplicationPresenter.onActionShowOptions(showOption=%b)", showOptions)); // NOI18N
    
        // Background
        cOptionsBackground.setManaged(showOptions);
        cOptionsBackground.setVisible(showOptions);
        
        // Close
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
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.register()"); // NOI18N
        
        this.registerOnActionShowOptions();
    }
    
    private void registerOnActionShowOptions() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.registerOnActionShowOptions()"); // NOI18N
        
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
    
}
