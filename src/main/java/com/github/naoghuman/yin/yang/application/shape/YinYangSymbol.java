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
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.yin.yang.configuration.ActionConfiguration;
import static com.github.naoghuman.yin.yang.configuration.ActionConfiguration.ON_MOUSE__PRESSED;
import java.util.Optional;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

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
    
    private Circle yinSymbol;
    private Shape  yanSymbol;
    
    private YinYangSymbol() {
        this.initialize();
    }
    
    private void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initialize()"); // NOI18N
        
        this.initializeYinSymbol();
        this.initializeYangSymbol();
    }

    private void initializeYinSymbol() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initializeYinSymbol()"); // NOI18N
        
        // Yin
        yinSymbol = new Circle();
        yinSymbol.setRadius(RADIUS);
        yinSymbol.setCenterX(CENTER_X);
        yinSymbol.setCenterY(CENTER_Y);
        yinSymbol.setFill(Color.ALICEBLUE);
        yinSymbol.setStroke(Color.BLUE);
        yinSymbol.setStrokeWidth(STROKE_WIDTH);
        
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

    private void initializeYangSymbol() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initializeYangSymbol()"); // NOI18N
        
        /*
            - YanSymbol ist ein zusammengesetztes Symbol.
            - LittleYin ist ebenfalls ein Clircle (wird bei Yan integriert).
        */
    }
    
    public void configure(final AnchorPane apApplication) {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangSymbol.configure(AnchorPane)"); // NOI18N
        
        apApplication.getChildren().add(0, yinSymbol);
    }
    
    public Shape getYinSymbol() {
        return yinSymbol;
    }
    
    public Shape getYangSymbol() {
        return yanSymbol;
    }
    
}
