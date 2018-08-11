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
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.yin.yang.options.Options;
import com.github.naoghuman.yin.yang.yinyang.YinYangSymbol;
import com.github.naoghuman.yin.yang.yinyang.YinYangTerms;
import com.github.naoghuman.yin.yang.configuration.ApplicationConfiguration;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
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
import javafx.scene.shape.Circle;
import com.github.naoghuman.yin.yang.configuration.EventConfiguration;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public class ApplicationPresenter implements 
        Initializable, EventConfiguration, ApplicationConfiguration,
        RegisterActions
{
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
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.initialize(URL, ResourceBundle)"); // NOI18N
        
//        assert (apView != null) : "fx:id=\"apView\" was not injected: check your FXML file 'application.fxml'."; // NOI18N
        
        this.register();
        
        Options.getDefault().configure(
                cOptionsBackground, bCloseApplication, bSeparator1, 
                lYinYangColors, lYinColors, cbYinColors, lYangColors, 
                cbYangColors, lLanguages, rbEnglishLanguage, rbGermanLanguage);
        
        YinYangSymbol.getDefault().configure(apApplication);
        YinYangSymbol.getDefault().onActionStartYinYangRotation();
        
        YinYangTerms.getDefault().configure(hbYinYangTerms, lYinTerm, lYangTerm);
        YinYangTerms.getDefault().onActionShowYinAndYangTerm();
    }
    
    public void onActionChangeLanguage() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.onActionChangeLanguage()"); // NOI18N
        
        final Locale language = Options.getDefault().onActionChangeLanguage();
        YinYangTerms.getDefault().onActionChangeLanguage(language);
    }
    
    public void onActionCloseRequest() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.onActionCloseRequest()"); // NOI18N
    
        ActionHandlerFacade.getDefault().handle(ON_ACTION__CLOSE_REQUEST);
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.register()"); // NOI18N
        
    }
    
}
