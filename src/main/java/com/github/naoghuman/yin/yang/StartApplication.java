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
package com.github.naoghuman.yin.yang;

import com.airhacks.afterburner.injection.Injector;
import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.database.core.DatabaseFacade;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.lib.properties.core.PropertiesFacade;
import com.github.naoghuman.yin.yang.application.ApplicationView;
import com.github.naoghuman.yin.yang.configuration.ActionConfiguration;
import com.github.naoghuman.yin.yang.configuration.ApplicationConfiguration;
import java.util.Optional;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public class StartApplication extends Application implements 
        ApplicationConfiguration, ActionConfiguration, RegisterActions
{
    public static void main(String[] args) {
        launch(args);
    }
    
    private double xOffset = 0;
    private double yOffset = 0;
    
    private PauseTransition ptSavePositionToPreferences = null;
    private Stage           stage = null;

    @Override
    public void init() throws Exception {
        super.init();
        
        LoggerFacade.getDefault().debug(this.getClass(), "StartApplication.init()"); // NOI18N
        
        PropertiesFacade.getDefault().register(PREF_KEY__APPLICATION__RESOURCE_BUNDLE);
        
        final char borderSign = this.getProperty(PREF_KEY__APPLICATION__BORDER_SIGN).charAt(0);
        final String message = this.getProperty(PREF_KEY__APPLICATION__MESSAGE_START);
        final String title = this.getProperty(PREF_KEY__APPLICATION__TITLE) + this.getProperty(PREF_KEY__APPLICATION__VERSION);
        LoggerFacade.getDefault().message(borderSign, 80, String.format(message, title));
        
        final Boolean dropPreferencesFileAtStart = Boolean.FALSE;
        PreferencesFacade.getDefault().init(dropPreferencesFileAtStart);
        
        DatabaseFacade.getDefault().register(this.getProperty(PREF_KEY__APPLICATION__DATABASE));
        
        this.register();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        LoggerFacade.getDefault().debug(this.getClass(), "StartApplication.start(Stage)"); // NOI18N
        
        stage = primaryStage;
        
        final ApplicationView view  = new ApplicationView();
        final Scene           scene = new Scene(view.getView(), 310, 310);
        scene.setFill(Color.TRANSPARENT);
        
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle(this.getProperty(PREF_KEY__APPLICATION__TITLE) + this.getProperty(PREF_KEY__APPLICATION__VERSION));
        stage.setScene(scene);
        
        this.onActionSetApplicationPosition();
        
        stage.show();
        
        ptSavePositionToPreferences = new PauseTransition();
        ptSavePositionToPreferences.setDuration(DURATION__125);
        ptSavePositionToPreferences.setOnFinished((event) -> {
            PreferencesFacade.getDefault().putDouble(APPLICATION_WINDOW__POSITION_X, stage.getX());
            PreferencesFacade.getDefault().putDouble(APPLICATION_WINDOW__POSITION_Y, stage.getY());
        });
    }
    
    private String getProperty(String propertyKey) {
        return PropertiesFacade.getDefault().getProperty(PREF_KEY__APPLICATION__RESOURCE_BUNDLE, propertyKey);
    }
    
    private void onActionCloseRequest() {
        LoggerFacade.getDefault().debug(this.getClass(), "StartApplication.onActionCloseRequest()"); // NOI18N
        
        // afterburner.fx
        Injector.forgetAll();
        
        // Database
        DatabaseFacade.getDefault().shutdown();
        
        // Message
        final char   borderSign = this.getProperty(PREF_KEY__APPLICATION__BORDER_SIGN).charAt(0);
        final String message    = this.getProperty(PREF_KEY__APPLICATION__MESSAGE_STOP);
        final String title      = this.getProperty(PREF_KEY__APPLICATION__TITLE) + this.getProperty(PREF_KEY__APPLICATION__VERSION);
        LoggerFacade.getDefault().message(borderSign, 80, String.format(message, title));
        
        // Timer
        final PauseTransition pt = new PauseTransition();
        pt.setDuration(DURATION__125);
        pt.setOnFinished((ActionEvent event) -> {
            Platform.exit();
        });
        
        pt.playFromStart();
    }
    
    private void onActionSavePositionToPreferences() {
        // Commant out to avoid spawning messages
        // LoggerFacade.getDefault().info(this.getClass(), "StartApplication.onActionSavePositionToPreferences()"); // NOI18N
        
        // Check if the PauseTransition is running
        if (ptSavePositionToPreferences.getStatus().equals(Animation.Status.RUNNING)) {
            ptSavePositionToPreferences.stop();
        }
        
        // Start the PauseTransition
        ptSavePositionToPreferences.playFromStart();
    }
    
    private void onActionSetApplicationPosition() {
        LoggerFacade.getDefault().info(this.getClass(), "StartApplication.onActionSetApplicationPosition()"); // NOI18N
        
        // X
        final double x = PreferencesFacade.getDefault().getDouble(APPLICATION_WINDOW__POSITION_X, APPLICATION_WINDOW__POSITION_X_DEFAULT_VALUE);
        if (x != APPLICATION_WINDOW__POSITION_X_DEFAULT_VALUE) {
            stage.setX(x);
        }
        
        // Y
        final double y = PreferencesFacade.getDefault().getDouble(APPLICATION_WINDOW__POSITION_Y, APPLICATION_WINDOW__POSITION_Y_DEFAULT_VALUE);
        if (y != APPLICATION_WINDOW__POSITION_Y_DEFAULT_VALUE) {
            stage.setY(y);
        }
    }
    
    private void onMouseDragged(final MouseEvent mouseEvent) {
        // Commant out to avoid spawning messages
        // LoggerFacade.getDefault().info(this.getClass(), "StartApplication.onMouseDragged(MouseEvent)"); // NOI18N
        
        stage.setX(mouseEvent.getScreenX() - xOffset);
        stage.setY(mouseEvent.getScreenY() - yOffset);
        
        this.onActionSavePositionToPreferences();
    }
    
    private void onMousePressed(final MouseEvent mouseEvent) {
        LoggerFacade.getDefault().info(this.getClass(), "StartApplication.onMousePressed(MouseEvent)"); // NOI18N
        
        xOffset = mouseEvent.getSceneX();
        yOffset = mouseEvent.getSceneY();
    }

    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "StartApplication.register()"); // NOI18N
        
        this.registerOnActionCloseRequest();
        this.registerOnMouseDragged();
        this.registerOnMousePressed();
    }
    
    private void registerOnActionCloseRequest() {
        LoggerFacade.getDefault().info(this.getClass(), "StartApplication.registerOnActionCloseRequest()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__CLOSE_REQUEST,
                (ActionEvent event) -> {
                    this.onActionCloseRequest();
                });
    }

    private void registerOnMouseDragged() {
        LoggerFacade.getDefault().info(this.getClass(), "StartApplication.registerOnMouseDragged()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_MOUSE__DRAGGED,
                (ActionEvent event) -> {
                    final Object source = event.getSource();
                    if (source instanceof TransferData) {
                        final TransferData     transferData = (TransferData) source;
                        final Optional<Object> optional     = transferData.getObject();
                        if(optional.isPresent() && optional.get() instanceof MouseEvent) {
                            final MouseEvent mouseEvent = (MouseEvent) optional.get();
                            this.onMouseDragged(mouseEvent);
                        }
                    }
                });
    }

    private void registerOnMousePressed() {
        LoggerFacade.getDefault().info(this.getClass(), "StartApplication.registerOnMousePressed()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_MOUSE__PRESSED,
                (ActionEvent event) -> {
                    final Object source = event.getSource();
                    if (source instanceof TransferData) {
                        final TransferData     transferData = (TransferData) source;
                        final Optional<Object> optional     = transferData.getObject();
                        if(optional.isPresent() && optional.get() instanceof MouseEvent) {
                            final MouseEvent mouseEvent = (MouseEvent) optional.get();
                            this.onMousePressed(mouseEvent);
                        }
                    }
                });
    }
    
}
