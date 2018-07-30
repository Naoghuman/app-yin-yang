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
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.yin.yang.application.shape.YinYangSymbol;
import com.github.naoghuman.yin.yang.configuration.ActionConfiguration;
import static com.github.naoghuman.yin.yang.configuration.ActionConfiguration.ON_ACTION__SHOW_OPTIONS;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Separator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public class ApplicationPresenter implements 
        Initializable, ActionConfiguration, RegisterActions
{
    @FXML private AnchorPane apApplication;
    @FXML private Button     bCloseApplication;
    @FXML private Circle     cOptionsBackground;
    @FXML private Separator  bSeparator1;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.initialize(URL, ResourceBundle)"); // NOI18N
        
//        assert (apView != null) : "fx:id=\"apView\" was not injected: check your FXML file 'application.fxml'."; // NOI18N
        
        this.register();
        
        final boolean showOptions = Boolean.FALSE;
        this.onActionShowOptions(showOptions);
        
        YinYangSymbol.getDefault().configure(apApplication);
        YinYangSymbol.getDefault().startYinYangRotation();
    }
    
    public void initializeAfterWindowIsShowing() {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.initializeAfterWindowIsShowing()"); // NOI18N
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
