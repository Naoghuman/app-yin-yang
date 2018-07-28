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
import com.github.naoghuman.yin.yang.configuration.ActionConfiguration;
import com.github.naoghuman.yin.yang.configuration.ApplicationConfiguration;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.input.MouseButton;
import javafx.scene.shape.Circle;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public class ApplicationPresenter implements 
        Initializable, ApplicationConfiguration, ActionConfiguration, RegisterActions
{
    @FXML private Button bShutdownApplication;
    @FXML private Circle yinyangBackground;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.initialize(URL, ResourceBundle)"); // NOI18N
        
//        assert (apView != null) : "fx:id=\"apView\" was not injected: check your FXML file 'application.fxml'."; // NOI18N
        
        this.initializeCircleYinYang();

        this.register();
        
        final boolean isShowOptions = Boolean.FALSE;
        this.onActionShowOptions(isShowOptions);
    }
    
    public void initializeAfterWindowIsShowing() {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.initializeAfterWindowIsShowing()"); // NOI18N
    }
    
    private void initializeCircleYinYang() {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.initializeCircleYinYang()"); // NOI18N
    
        yinyangBackground.setOnMouseDragged((mouseEvent) -> {
            if (
                    mouseEvent.getButton() == MouseButton.PRIMARY
                    && mouseEvent.isControlDown()
            ) {
                final TransferData transferData = TransferDataBuilder.create()
                        .actionId(ON_MOUSE__DRAGGED)
                        .disableLogging()
                        .objectValue(mouseEvent)
                        .build();
                ActionHandlerFacade.getDefault().handle(transferData);
            }
        });
        
        yinyangBackground.setOnMouseEntered((mouseEvent) -> {
            LoggerFacade.getDefault().info(this.getClass(), " - yinyangBackground.setOnMouseEntered(MouseEvent)"); // NOI18N
    
            final boolean isShowOptions = Boolean.TRUE;
            this.onActionShowOptions(isShowOptions);
        });
        
        yinyangBackground.setOnMouseExited((mouseEvent) -> {
            if (!yinyangBackground.contains(mouseEvent.getX(), mouseEvent.getY())) {
                final boolean isShowOptions = Boolean.FALSE;
                this.onActionShowOptions(isShowOptions);
            }
        });
        
        yinyangBackground.setOnMousePressed((mouseEvent) -> {
            if (
                    mouseEvent.getButton() == MouseButton.PRIMARY
                    && mouseEvent.isPrimaryButtonDown()
                    && mouseEvent.isControlDown()
            ) {
                LoggerFacade.getDefault().info(this.getClass(), " - yinyangBackground.setOnMousePressed(MouseEvent)"); // NOI18N
    
                yinyangBackground.setCursor(Cursor.MOVE);
                
                final TransferData transferData = TransferDataBuilder.create()
                        .actionId(ON_MOUSE__PRESSED)
                        .objectValue(mouseEvent)
                        .build();
                ActionHandlerFacade.getDefault().handle(transferData);
            }
        });
        
        yinyangBackground.setOnMouseReleased((mouseEvent) -> {
            if (
                    mouseEvent.getButton() == MouseButton.PRIMARY
                    && mouseEvent.isControlDown()
            ) {
                yinyangBackground.setCursor(Cursor.DEFAULT);
            }
        });
    }
    
    public void onActionCloseRequest() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.onActionCloseRequest()"); // NOI18N
    
        ActionHandlerFacade.getDefault().handle(ActionConfiguration.ON_ACTION__CLOSE_REQUEST);
    }

    private void onActionShowOptions(final boolean isShowOptions) {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.onActionShowOptions(boolean)"); // NOI18N
    
        bShutdownApplication.setManaged(isShowOptions);
        bShutdownApplication.setVisible(isShowOptions);
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.register()"); // NOI18N
    }
    
}
