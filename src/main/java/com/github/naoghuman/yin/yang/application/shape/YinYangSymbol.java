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
package com.github.naoghuman.yin.yang.application.shape;

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.yin.yang.configuration.ActionConfiguration;
import java.util.Optional;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.Cursor;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public final class YinYangSymbol implements ActionConfiguration {
    
    private static final double CENTER_X     = 155.0d;
    private static final double CENTER_Y     = 155.0d;
    private static final double RADIUS       = 150.0d;
    private static final double STROKE_WIDTH = 4.0d;
    
    private static final Optional<YinYangSymbol> INSTANCE = Optional.of(new YinYangSymbol());

    public static final YinYangSymbol getDefault() {
        return INSTANCE.get();
    }
    
    private Arc      halfYangSymbol;
    private Circle   littleYangSymbol;
    private Circle   littleYinSymbol;
    private Circle   yinSymbol;
    private Rotate   rotation;
    private Shape    yangSymbol;
    private Timeline tlRotation;
    
    private YinYangSymbol() {
        this.initialize();
    }
    
    private void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initialize()"); // NOI18N
        
        this.initializeLittleYinSymbol();
        this.initializeYinSymbol();
        
        this.initializeLittleYangSymbol();
        this.initializeYangSymbol();
        
        this.initializeYinYangRotation();
    }
    
    private void initializeLittleYangSymbol() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initializeLittleYangSymbol()"); // NOI18N
       
        // Little YangSymbol
        littleYangSymbol = new Circle();
        littleYangSymbol.setRadius(RADIUS / 10.0d);
        littleYangSymbol.setCenterX(CENTER_X - RADIUS / 2.0d);
        littleYangSymbol.setCenterY(CENTER_Y);
    }
    
    private void initializeLittleYinSymbol() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initializeLittleYinSymbol()"); // NOI18N
       
        // Little YinSymbol
        littleYinSymbol = new Circle();
        littleYinSymbol.setRadius(RADIUS / 10.0d);
        littleYinSymbol.setCenterX(CENTER_X + RADIUS / 2.0d);
        littleYinSymbol.setCenterY(CENTER_Y);
    }

    private void initializeYinYangRotation() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initializeYinYangRotation()"); // NOI18N
        
        rotation = new Rotate();
        rotation.pivotXProperty().bind(halfYangSymbol.centerXProperty());
        rotation.pivotYProperty().bind(halfYangSymbol.centerYProperty());
        
        tlRotation = new Timeline(
                new KeyFrame(Duration.ZERO,       new KeyValue(rotation.angleProperty(), 0.0d)),
                new KeyFrame(Duration.seconds(5), new KeyValue(rotation.angleProperty(), 360.0d)));
        tlRotation.setCycleCount(Animation.INDEFINITE);
        
        yangSymbol.getTransforms().add(rotation);
    }

    private void initializeYangSymbol() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initializeYangSymbol()"); // NOI18N
        
        // YangSymbol
        halfYangSymbol = new Arc();
        halfYangSymbol.setCenterX(CENTER_X);
        halfYangSymbol.setCenterY(CENTER_Y);
        halfYangSymbol.setRadiusX(RADIUS - STROKE_WIDTH);
        halfYangSymbol.setRadiusY(RADIUS - STROKE_WIDTH);
        halfYangSymbol.setStartAngle(0.0f);
        halfYangSymbol.setLength(180.0f);
        halfYangSymbol.setType(ArcType.CHORD);
        
        Circle littleAddCirle = new Circle();
        littleAddCirle.setRadius(RADIUS / 2.0d - STROKE_WIDTH / 2);
        littleAddCirle.setCenterX(CENTER_X + RADIUS / 2.0d - STROKE_WIDTH / 2);
        littleAddCirle.setCenterY(CENTER_Y);
        yangSymbol = Shape.union(halfYangSymbol, littleAddCirle);
        
        Circle littleMinusCirle = new Circle();
        littleMinusCirle.setRadius(RADIUS / 2.0d - STROKE_WIDTH / 2);
        littleMinusCirle.setCenterX(CENTER_X - RADIUS / 2.0d + STROKE_WIDTH / 2);
        littleMinusCirle.setCenterY(CENTER_Y);
        yangSymbol = Shape.subtract(yangSymbol, littleMinusCirle);
        
        // Little YinSymbol
        yangSymbol = Shape.subtract(yangSymbol, littleYinSymbol);
        
        // Little YangSymbol
        yangSymbol = Shape.union(yangSymbol, littleYangSymbol);
        
        // Tweak the ready YangSymbol
        yangSymbol.setFill(Color.LIGHTGREEN);
        yangSymbol.setMouseTransparent(Boolean.TRUE);
    }

    private void initializeYinSymbol() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initializeYinSymbol()"); // NOI18N
        
        // YinSymbol
        yinSymbol = new Circle();
        yinSymbol.setCursor(Cursor.DEFAULT);
        yinSymbol.setRadius(RADIUS);
        yinSymbol.setCenterX(CENTER_X);
        yinSymbol.setCenterY(CENTER_Y);
        
        final DropShadow glow = new DropShadow();
        glow.setOffsetY(0f);
        glow.setOffsetX(0f);
        glow.setColor(Color.BLACK);
        glow.setWidth(12.0d);
        glow.setHeight(12.0d);
        yinSymbol.setEffect(glow);
        yinSymbol.setFill(Color.BLACK);
        
        // MouseEvents
        yinSymbol.setOnMouseDragged((mouseEvent) -> {
            if (
                    mouseEvent.getButton() == MouseButton.PRIMARY
                    && mouseEvent.isControlDown()
            ) {
                ActionHandlerFacade.getDefault()
                        .handle(TransferDataBuilder.create()
                                .actionId(ON_MOUSE__DRAGGED)
                                .disableLogging() // Avoid msg spawning
                                .objectValue(mouseEvent)
                                .build());
            }
        });
        
        yinSymbol.setOnMouseEntered((mouseEvent) -> {
            final boolean showOptions = Boolean.TRUE;
            ActionHandlerFacade.getDefault()
                    .handle(TransferDataBuilder.create()
                            .actionId(ON_ACTION__SHOW_OPTIONS)
                            .booleanValue(showOptions)
                            .build());
        });
        
        yinSymbol.setOnMouseExited((mouseEvent) -> {
            if (!yinSymbol.contains(mouseEvent.getX(), mouseEvent.getY())) {
                if (yinSymbol.getCursor().equals(Cursor.MOVE)) {
                    yinSymbol.setCursor(Cursor.DEFAULT);
                }
                
                final boolean showOptions = Boolean.FALSE;
                ActionHandlerFacade.getDefault()
                        .handle(TransferDataBuilder.create()
                                .actionId(ON_ACTION__SHOW_OPTIONS)
                                .booleanValue(showOptions)
                                .build());
            }
        });
        
        yinSymbol.setOnMousePressed((mouseEvent) -> {
            if (
                    mouseEvent.getButton() == MouseButton.PRIMARY
                    && mouseEvent.isPrimaryButtonDown()
                    && mouseEvent.isControlDown()
            ) {
                yinSymbol.setCursor(Cursor.MOVE);
                
                ActionHandlerFacade.getDefault()
                        .handle(TransferDataBuilder.create()
                                .actionId(ON_MOUSE__PRESSED)
                                .objectValue(mouseEvent)
                                .build());
            }
        });
        
        yinSymbol.setOnMouseReleased((mouseEvent) -> {
            if (
                    mouseEvent.getButton() == MouseButton.PRIMARY
                    && mouseEvent.isControlDown()
            ) {
                yinSymbol.setCursor(Cursor.DEFAULT);
            }
        });
    }
    
    public void configure(final AnchorPane apApplication) {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangSymbol.configure(AnchorPane)"); // NOI18N
        
        apApplication.getChildren().add(0, yinSymbol);
        apApplication.getChildren().add(1, yangSymbol);
    }
    
    public Shape getYinSymbol() {
        return yinSymbol;
    }
    
    public Shape getYangSymbol() {
        return yangSymbol;
    }
    
    public void startYinYangRotation() {
        final PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.millis(500.0d));
        pt.setOnFinished((event) -> {
            LoggerFacade.getDefault().debug(this.getClass(), "YinYangSymbol.startYinYangRotation()"); // NOI18N
        
            tlRotation.playFromStart();
        });
        
        pt.playFromStart();
    }
    
}
