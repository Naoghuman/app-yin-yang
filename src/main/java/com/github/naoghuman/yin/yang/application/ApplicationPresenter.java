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
import com.github.naoghuman.yin.yang.color.ColorComboBox;
import com.github.naoghuman.yin.yang.shape.YinYangSymbol;
import com.github.naoghuman.yin.yang.configuration.ActionConfiguration;
import com.github.naoghuman.yin.yang.configuration.YinYangSymbolConfiguration;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public class ApplicationPresenter implements 
        Initializable, ActionConfiguration, RegisterActions,
        YinYangSymbolConfiguration
{
    @FXML private AnchorPane apApplication;
    @FXML private Button     bCloseApplication;
    @FXML private Circle     cOptionsBackground;
    @FXML private ComboBox   cbYangColors;
    @FXML private ComboBox   cbYinColors;
    @FXML private Label      lYangColors;
    @FXML private Label      lYinColors;
    @FXML private Separator  bSeparator1;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.initialize(URL, ResourceBundle)"); // NOI18N
        
//        assert (apView != null) : "fx:id=\"apView\" was not injected: check your FXML file 'application.fxml'."; // NOI18N
        
        final String yangSelectedColor = PreferencesFacade.getDefault().get(YIN_YANG_SYMBOL__YANG_COLOR, YIN_YANG_SYMBOL__YANG_COLOR_DEFAULT_VALUE);
        final String yinSelectedColor  = PreferencesFacade.getDefault().get(YIN_YANG_SYMBOL__YIN_COLOR,  YIN_YANG_SYMBOL__YIN_COLOR_DEFAULT_VALUE);
        this.initializeOptions(yangSelectedColor, yinSelectedColor);
        
        this.register();
        
        final boolean showOptions = Boolean.FALSE;
        this.onActionShowOptions(showOptions);
        
        YinYangSymbol.getDefault().configure(apApplication, yangSelectedColor, yinSelectedColor);
        YinYangSymbol.getDefault().onActionStartYinYangRotation();
    }
    
    private void initializeOptions(final String yangSelectedColor, final String yinSelectedColor) {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.initializeOptions(String, String)"); // NOI18N
    
        final Color cOptions = Color.color(Color.BLACK.getRed(), Color.BLACK.getGreen(), 
                Color.BLACK.getRed(), 0.33d).invert();
        
        cOptionsBackground.setFill(cOptions);
        cOptionsBackground.setStroke(null);
        
        final ColorComboBox yangColorComboBox = new ColorComboBox();
        yangColorComboBox.configure(cbYangColors, ColorComboBox.Type.YANG_SYMBOL, yangSelectedColor);
        
        final ColorComboBox yinColorComboBox = new ColorComboBox();
        yinColorComboBox.configure(cbYinColors, ColorComboBox.Type.YIN_SYMBOL, yinSelectedColor);
    }
    
    public void onActionCloseRequest() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.onActionCloseRequest()"); // NOI18N
    
        ActionHandlerFacade.getDefault().handle(ActionConfiguration.ON_ACTION__CLOSE_REQUEST);
    }

    private void onActionShowOptions(final boolean showOptions) {
        LoggerFacade.getDefault().info(this.getClass(), String.format(
                "ApplicationPresenter.onActionShowOptions(showOption=%b)", showOptions)); // NOI18N
    
        cOptionsBackground.setManaged(showOptions);
        cOptionsBackground.setVisible(showOptions);
        
        bCloseApplication.setManaged(showOptions);
        bCloseApplication.setVisible(showOptions);
        
        bSeparator1.setManaged(showOptions);
        bSeparator1.setVisible(showOptions);
        
        lYinColors.setManaged(showOptions);
        lYinColors.setVisible(showOptions);
        cbYinColors.setManaged(showOptions);
        cbYinColors.setVisible(showOptions);
        
        lYangColors.setManaged(showOptions);
        lYangColors.setVisible(showOptions);
        cbYangColors.setManaged(showOptions);
        cbYangColors.setVisible(showOptions);
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
