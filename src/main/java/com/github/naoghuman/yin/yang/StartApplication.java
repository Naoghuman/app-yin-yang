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
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.yin.yang.application.ApplicationPresenter;
import com.github.naoghuman.yin.yang.application.ApplicationView;
import com.github.naoghuman.yin.yang.configuration.ApplicationConfiguration;
import com.github.naoghuman.yin.yang.configuration.EventConfiguration;
import com.github.naoghuman.yin.yang.configuration.I18nConfiguration;
import com.github.naoghuman.yin.yang.configuration.PreferencesConfiguration;
import com.github.naoghuman.yin.yang.i18n.I18nProperty;
import com.github.naoghuman.yin.yang.i18n.I18nProvider;
import com.github.naoghuman.yin.yang.taichi.TaiChiProvider;
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
        ApplicationConfiguration, EventConfiguration, I18nConfiguration,
        PreferencesConfiguration, RegisterActions
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
        
        LoggerFacade.getDefault().info(this.getClass(), "StartApplication.init()"); // NOI18N
        
        I18nProvider.getDefault().register();
        
        final I18nProperty i18nProperty = I18nProvider.getDefault().getI18nApplication();
        final char         borderSign   = i18nProperty.getProperty(I18N_KEY__APPLICATION__BORDER_SIGN).charAt(0);
        final String       message      = i18nProperty.getProperty(I18N_KEY__APPLICATION__MESSAGE_START);
        final String       title        = i18nProperty.getProperty(I18N_KEY__APPLICATION__TITLE);
        final String       version      = i18nProperty.getProperty(I18N_KEY__APPLICATION__VERSION);
        final String       titleVersion = title + version;
        LoggerFacade.getDefault().message(borderSign, 80, String.format(message, titleVersion));
        
        final Boolean dropPreferencesFileAtStart = Boolean.FALSE;
        PreferencesFacade.getDefault().init(dropPreferencesFileAtStart);
        
        this.register();
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        LoggerFacade.getDefault().info(this.getClass(), "StartApplication.start(Stage)"); // NOI18N
        
        stage = primaryStage;
        
        ptSavePositionToPreferences = new PauseTransition();
        ptSavePositionToPreferences.setDuration(DURATION__125);
        ptSavePositionToPreferences.setOnFinished((event) -> {
            PreferencesFacade.getDefault().putDouble(PREF__APPLICATION__POSITION_X, stage.getX());
            PreferencesFacade.getDefault().putDouble(PREF__APPLICATION__POSITION_Y, stage.getY());
        });
        
        final ApplicationView      view      = new ApplicationView();
        final ApplicationPresenter presenter = view.getRealPresenter();
        presenter.configure(stage);
        
        final Scene            scene = new Scene(view.getView(), 330.0d, 330.0d); // TODO Pref
        scene.setFill(Color.TRANSPARENT);
        
        final boolean alwaysOnTop = PreferencesFacade.getDefault().getBoolean(PREF__OPTIONS__EXTRAS__ALWAYS_ON_TOP, PREF__OPTIONS__EXTRAS__ALWAYS_ON_TOP_DEFAULT_VALUE);
        stage.setAlwaysOnTop(alwaysOnTop);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle(I18nProvider.getDefault().getI18nApplication().getProperty(I18N_KEY__APPLICATION__TITLE)
                + I18nProvider.getDefault().getI18nApplication().getProperty(I18N_KEY__APPLICATION__VERSION));
        stage.setScene(scene);
        
        this.onActionUpdateApplicationPosition();
        
        stage.show();
        
        TaiChiProvider.getDefault().initialize();
    }
    
    private void onActionChangeAlwaysOnTop(final boolean alwaysOnTop) {
        LoggerFacade.getDefault().debug(this.getClass(), "StartApplication.onActionChangeAlwaysOnTop()"); // NOI18N
        
        Platform.runLater(() -> {
            stage.setAlwaysOnTop(alwaysOnTop);
        });
    }
    
    private void onActionCloseApplication() {
        LoggerFacade.getDefault().debug(this.getClass(), "StartApplication.onActionCloseRequest()"); // NOI18N
        
        // afterburner.fx
        Injector.forgetAll();
        
        // Message
        final char   borderSign = I18nProvider.getDefault().getI18nApplication().getProperty(I18N_KEY__APPLICATION__BORDER_SIGN).charAt(0);
        final String message    = I18nProvider.getDefault().getI18nApplication().getProperty(I18N_KEY__APPLICATION__MESSAGE_STOP);
        final String title      = I18nProvider.getDefault().getI18nApplication().getProperty(I18N_KEY__APPLICATION__TITLE)
                + I18nProvider.getDefault().getI18nApplication().getProperty(I18N_KEY__APPLICATION__VERSION);
        LoggerFacade.getDefault().message(borderSign, 80, String.format(message, title));
        
        // Timer
        final PauseTransition pt = new PauseTransition();
        pt.setDuration(DURATION__125);
        pt.setOnFinished((ActionEvent event) -> {
            Platform.exit();
        });
        
        pt.playFromStart();
    }
    
    public void onActionMinimizeApplication() {
        LoggerFacade.getDefault().debug(this.getClass(), "StartApplication.onActionMinimizeApplication()"); // NOI18N
        
        Platform.runLater(() -> {
            stage.setIconified(Boolean.TRUE);
        });
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
    
    private void onActionUpdateApplicationPosition() {
        LoggerFacade.getDefault().debug(this.getClass(), "StartApplication.onActionUpdateApplicationPosition()"); // NOI18N
        
        // X
        final double x = PreferencesFacade.getDefault().getDouble(PREF__APPLICATION__POSITION_X, PREF__APPLICATION__POSITION_X_DEFAULT_VALUE);
        if (x != PREF__APPLICATION__POSITION_X_DEFAULT_VALUE) {
            stage.setX(x);
        }
        
        // Y
        final double y = PreferencesFacade.getDefault().getDouble(PREF__APPLICATION__POSITION_Y, PREF__APPLICATION__POSITION_Y_DEFAULT_VALUE);
        if (y != PREF__APPLICATION__POSITION_Y_DEFAULT_VALUE) {
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
        LoggerFacade.getDefault().debug(this.getClass(), "StartApplication.onMousePressed(MouseEvent)"); // NOI18N
        
        xOffset = mouseEvent.getSceneX();
        yOffset = mouseEvent.getSceneY();
    }

    @Override
    public void register() {
        LoggerFacade.getDefault().info(this.getClass(), "StartApplication.register()"); // NOI18N
        
        this.registerOnActionChangeAlwaysOnTop();
        this.registerOnActionCloseApplication();
        this.registerOnActionMinimizeApplication();
        this.registerOnMouseDragged();
        this.registerOnMousePressed();
        
        TaiChiProvider.getDefault().register();
    }
    
    private void registerOnActionChangeAlwaysOnTop() {
        LoggerFacade.getDefault().info(this.getClass(), "StartApplication.registerOnActionChangeAlwaysOnTop()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__CHANGE__ALWAYS_ON_TOP,
                (ActionEvent event) -> {
                    
                    final Object source = event.getSource();
                    if (source instanceof TransferData) {
                        final TransferData     transferData = (TransferData) source;
                        final Optional<Boolean> optional     = transferData.getBoolean();
                        if(optional.isPresent()) {
                            final boolean alwaysOnTop = optional.get();
                            this.onActionChangeAlwaysOnTop(alwaysOnTop);
                        }
                    }
                });
    }
    
    private void registerOnActionCloseApplication() {
        LoggerFacade.getDefault().info(this.getClass(), "StartApplication.registerOnActionCloseApplication()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__CLOSE_APPLICATION,
                (ActionEvent event) -> {
                    this.onActionCloseApplication();
                });
    }
    
    private void registerOnActionMinimizeApplication() {
        LoggerFacade.getDefault().info(this.getClass(), "StartApplication.registerOnActionMinimizeApplication()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__MINIMIZE_APPLICATION,
                (ActionEvent event) -> {
                    this.onActionMinimizeApplication();
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
