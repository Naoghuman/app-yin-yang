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
package com.github.naoghuman.yin.yang.yinyang;

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.yin.yang.configuration.EventConfiguration;
import com.github.naoghuman.yin.yang.configuration.PreferencesConfiguration;
import com.github.naoghuman.yin.yang.configuration.YinYangConfiguration;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
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
public final class YinYangSymbol implements 
        EventConfiguration,
        PreferencesConfiguration,
        RegisterActions,
        YinYangConfiguration
{
    private static final double STROKE_WIDTH = 4.0d;
    
    private static final String                       PATTERN__RGB_COLOR = "rgb(%s)"; // NOI18N
    private static final ObservableMap<Month, Double> MONTH_ROTATIONS    = FXCollections.observableHashMap();
    private static final Optional<YinYangSymbol>      INSTANCE           = Optional.of(new YinYangSymbol());
    
    public static final YinYangSymbol getDefault() {
        return INSTANCE.get();
    }
    
    private double centerXtheOne       = PREF__YINYANG__SYMBOL_DIAMETER_DEFAULT_VALUE / 2.0d + YINYANG_SYMBOLE__OUTER_BORDER;
    private double centerYtheOne       = PREF__YINYANG__SYMBOL_DIAMETER_DEFAULT_VALUE / 2.0d + YINYANG_SYMBOLE__OUTER_BORDER;
    private double diameterTheOne      = PREF__YINYANG__SYMBOL_DIAMETER_DEFAULT_VALUE;
    private double radiusLittleYinYang = PREF__YINYANG__SYMBOL_DIAMETER_DEFAULT_VALUE / 8.0d / 2.0d;
    
    private Arc       halfYangSymbol;
    private Circle    littleYangSymbol;
    private Circle    littleYinSymbol;
    private Circle    yinSymbol;
    private LocalDate oldDayInYear   = LocalDate.now();
    private LocalDate oldMonthInYear = LocalDate.now();
    private Rotate    rotation;
    private Shape     yangSymbol;
    private Timeline  tlRotation;
    
    private YinYangSymbol() {
        this.initialize();
    }
    
    private void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initialize()"); // NOI18N
        
        /*
         * Rework math for the TaiChi-Symbol
         *  - The One       == 1 == d   == Circle
         *  - Yin, Yang     == 2 == d/2 == 2 Half
         *  - Yin, Yang     == 4 == d/4 ==   Half +- half/2
         *  - l.Yin, l.Yang == 8 == d/8 == Size of the little yin, yang 
         *
         */
        diameterTheOne      = PreferencesFacade.getDefault().getDouble(PREF__YINYANG__SYMBOL_DIAMETER, PREF__YINYANG__SYMBOL_DIAMETER_DEFAULT_VALUE);
        centerXtheOne       = diameterTheOne / 2.0d + YINYANG_SYMBOLE__OUTER_BORDER;
        centerYtheOne       = diameterTheOne / 2.0d + YINYANG_SYMBOLE__OUTER_BORDER;
        radiusLittleYinYang = diameterTheOne / 8.0d / 2.0d;
        
        this.initializeLittleYinSymbol();
        this.initializeYinSymbol();
        this.initializeYinSymbolMouseListeners();
        this.initializeLittleYangSymbol();
        this.initializeYangSymbol();
        this.initializeYinYangRotation();
        this.initializeYinYangTimeline();
        
        this.register();
    }
    
    private void initializeLittleYangSymbol() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initializeLittleYangSymbol()"); // NOI18N
       
        // Little YangSymbol
        littleYangSymbol = new Circle();
        littleYangSymbol.setRadius(radiusLittleYinYang);
        littleYangSymbol.setCenterX(centerXtheOne - diameterTheOne / 4.0d);
        littleYangSymbol.setCenterY(centerYtheOne);
    }
    
    private void initializeLittleYinSymbol() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initializeLittleYinSymbol()"); // NOI18N
       
        // Little YinSymbol
        littleYinSymbol = new Circle();
        littleYinSymbol.setRadius(radiusLittleYinYang);
        littleYinSymbol.setCenterX(centerXtheOne + diameterTheOne / 4.0d);
        littleYinSymbol.setCenterY(centerYtheOne);
    }

    private void initializeYinYangRotation() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initializeYinYangRotation()"); // NOI18N
        
        // Rotation
        rotation = new Rotate();
        rotation.pivotXProperty().bind(halfYangSymbol.centerXProperty());
        rotation.pivotYProperty().bind(halfYangSymbol.centerYProperty());
        
        yangSymbol.getTransforms().add(rotation);
        
        // Rotation speed
        MONTH_ROTATIONS.put(Month.JANUARY,   19.200d); // Slowest month in year
        MONTH_ROTATIONS.put(Month.FEBRUARY,  17.066d);
        MONTH_ROTATIONS.put(Month.MARCH,     14.932d);
        MONTH_ROTATIONS.put(Month.APRIL,     12.798d);
        MONTH_ROTATIONS.put(Month.MAY,       10.664d);
        MONTH_ROTATIONS.put(Month.JUNE,       8.530d);
        MONTH_ROTATIONS.put(Month.JULY,       6.400d); // Fastest month in year
        MONTH_ROTATIONS.put(Month.AUGUST,     8.530d);
        MONTH_ROTATIONS.put(Month.SEPTEMBER, 10.664d);
        MONTH_ROTATIONS.put(Month.OCTOBER,   12.798d);
        MONTH_ROTATIONS.put(Month.NOVEMBER,  14.932d);
        MONTH_ROTATIONS.put(Month.DECEMBER,  17.066d);
    }

    private void initializeYinYangTimeline() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initializeYinYangTimeline()"); // NOI18N
        
        /*
          Yang -> odd  nummers -> right spinning
          Yin  -> even nummers -> left  spinning
        */
        final LocalDate now         = LocalDate.now(); 
        final double    endDuration = MONTH_ROTATIONS.get(now.getMonth());
        final double    endValue    = (now.getDayOfMonth() % 2) == 0 ? -360.0d : 360.0d;
        tlRotation = new Timeline(
                new KeyFrame(Duration.ZERO,                 new KeyValue(rotation.angleProperty(), 0.0d)),
                new KeyFrame(Duration.seconds(endDuration), new KeyValue(rotation.angleProperty(), endValue)));
        tlRotation.setCycleCount(Animation.INDEFINITE);
    }

    private void initializeYangSymbol() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initializeYangSymbol()"); // NOI18N
        
        // YangSymbol
        halfYangSymbol = new Arc();
        halfYangSymbol.setCenterX(centerXtheOne);
        halfYangSymbol.setCenterY(centerYtheOne);
        halfYangSymbol.setRadiusX(diameterTheOne / 2.0d - STROKE_WIDTH);
        halfYangSymbol.setRadiusY(diameterTheOne / 2.0d - STROKE_WIDTH);
        halfYangSymbol.setStartAngle(0.0f);
        halfYangSymbol.setLength(180.0f);
        halfYangSymbol.setType(ArcType.CHORD);
        
        Circle littleAddCirle = new Circle();
        littleAddCirle.setRadius(diameterTheOne / 4.0d - STROKE_WIDTH / 2);
        littleAddCirle.setCenterX(centerXtheOne + diameterTheOne / 4.0d - STROKE_WIDTH / 2);
        littleAddCirle.setCenterY(centerYtheOne);
        yangSymbol = Shape.union(halfYangSymbol, littleAddCirle);
        
        Circle littleMinusCirle = new Circle();
        littleMinusCirle.setRadius(diameterTheOne / 4.0d - STROKE_WIDTH / 2);
        littleMinusCirle.setCenterX(centerXtheOne - diameterTheOne / 4.0d + STROKE_WIDTH / 2);
        littleMinusCirle.setCenterY(centerYtheOne);
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
        
        yinSymbol = new Circle();
        yinSymbol.setCursor(Cursor.DEFAULT);
        yinSymbol.setRadius(diameterTheOne / 2.0d);
        yinSymbol.setCenterX(centerXtheOne);
        yinSymbol.setCenterY(centerYtheOne);
        
        final DropShadow glow = new DropShadow();
        glow.setOffsetY(0f);
        glow.setOffsetX(0f);
        glow.setColor(Color.BLACK);
        glow.setWidth(12.0d);
        glow.setHeight(12.0d);
        yinSymbol.setEffect(glow);
        yinSymbol.setFill(Color.BLACK);
    }
    
    private void initializeYinSymbolMouseListeners() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.initializeYinSymbolMouseListeners()"); // NOI18N
        
        yinSymbol.setOnMouseDragged((event) -> {
            if (
                    event.getButton() == MouseButton.PRIMARY
                    && event.isControlDown()
            ) {
                ActionHandlerFacade.getDefault()
                        .handle(TransferDataBuilder.create()
                                .actionId(ON_MOUSE__DRAGGED)
                                .disableLogging() // Avoid msg spawning
                                .objectValue(event)
                                .build());
            }
        });
        
        yinSymbol.setOnMouseEntered((event) -> {
            final boolean showOptions = Boolean.TRUE;
            ActionHandlerFacade.getDefault()
                    .handle(TransferDataBuilder.create()
                            .actionId(ON_ACTION__SHOW_OPTIONS)
                            .booleanValue(showOptions)
                            .build());
        });
        
        yinSymbol.setOnMouseExited((event) -> {
            if (!yinSymbol.contains(event.getX(), event.getY())) {
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
        
        yinSymbol.setOnMousePressed((event) -> {
            if (
                    event.getButton() == MouseButton.PRIMARY
                    && event.isPrimaryButtonDown()
                    && event.isControlDown()
            ) {
                yinSymbol.setCursor(Cursor.MOVE);
                
                ActionHandlerFacade.getDefault()
                        .handle(TransferDataBuilder.create()
                                .actionId(ON_MOUSE__PRESSED)
                                .objectValue(event)
                                .build());
            }
        });
        
        yinSymbol.setOnMouseReleased((event) -> {
            if (
                    event.getButton() == MouseButton.PRIMARY
                    && event.isControlDown()
            ) {
                yinSymbol.setCursor(Cursor.DEFAULT);
            }
        });
    }
    
    public void configure(final AnchorPane apApplication) {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangSymbol.configure(AnchorPane)"); // NOI18N
        
        final String yangSelectedColor = PreferencesFacade.getDefault().get(PREF__YINYANG__YANG_COLOR, PREF__YINYANG__YANG_COLOR_DEFAULT_VALUE);
        yangSymbol.setFill(Color.web(String.format(PATTERN__RGB_COLOR, yangSelectedColor)));
        
        final String yinSelectedColor = PreferencesFacade.getDefault().get(PREF__YINYANG__YIN_COLOR, PREF__YINYANG__YIN_COLOR_DEFAULT_VALUE);
        yinSymbol.setFill(Color.web(String.format(PATTERN__RGB_COLOR, yinSelectedColor)));
        
        apApplication.getChildren().add(0, yinSymbol);
        apApplication.getChildren().add(1, yangSymbol);
    }
    
    public Shape getYinSymbol() {
        return yinSymbol;
    }
    
    public Shape getYangSymbol() {
        return yangSymbol;
    }
    
    private boolean isNewDayInYear(LocalDate newDayInYear) {
        boolean isNewDayInYear = Boolean.FALSE;
        if (newDayInYear.getYear() > oldDayInYear.getYear()) {
            isNewDayInYear = Boolean.TRUE;
            oldDayInYear   = newDayInYear;
        }
        
        if (
                newDayInYear.getYear() == oldDayInYear.getYear()
                && newDayInYear.getDayOfYear() > oldDayInYear.getDayOfYear()
        ) {
            isNewDayInYear = Boolean.TRUE;
            oldDayInYear   = newDayInYear;
        }
        
        return isNewDayInYear;
    }
    
    private boolean isNewMonthInYear(LocalDate newMonthInYear) {
        boolean isNewMonthInYear = Boolean.FALSE;
        if (newMonthInYear.getYear() > oldMonthInYear.getYear()) {
            isNewMonthInYear = Boolean.TRUE;
            oldMonthInYear   = newMonthInYear;
        }
        
        if (
                newMonthInYear.getYear() == oldMonthInYear.getYear()
                && newMonthInYear.getMonthValue() > oldMonthInYear.getMonthValue()
        ) {
            isNewMonthInYear = Boolean.TRUE;
            oldMonthInYear   = newMonthInYear;
        }
        
        return isNewMonthInYear;
    }
    
    private void onActionChangeColorYangSymbol(final String color) {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.onActionChangeColorYangSymbol(String)"); // NOI18N
    
        yangSymbol.setFill(Color.web(String.format(PATTERN__RGB_COLOR, color)));
        
        PreferencesFacade.getDefault().put(PREF__YINYANG__YANG_COLOR, color);
    }
    
    private void onActionChangeColorYinSymbol(final String color) {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.onActionChangeColorYinSymbol(String)"); // NOI18N
    
        yinSymbol.setFill(Color.web(String.format(PATTERN__RGB_COLOR, color)));
        
        PreferencesFacade.getDefault().put(PREF__YINYANG__YIN_COLOR, color);
    }
    
    public void onActionStartYinYangRotation() {
        final PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.millis(500.0d));
        pt.setOnFinished((event) -> {
            LoggerFacade.getDefault().debug(this.getClass(), "YinYangSymbol.onActionStartYinYangRotation()"); // NOI18N
        
            if (
                    this.isNewDayInYear(LocalDate.now())
                    || this.isNewMonthInYear(LocalDate.now())
            ) {
                this.initializeYinYangTimeline();
            }
            
            tlRotation.playFromStart();
        });
        
        pt.playFromStart();
    }

    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangSymbol.register()"); // NOI18N
        
        this.registerOnActionChangeColorYangSymbol();
        this.registerOnActionChangeColorYinSymbol();
    }
    
    private void registerOnActionChangeColorYangSymbol() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.registerOnActionChangeColorYangSymbol()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__CHANGE__COLOR_YANG_SYMBOL,
                (ActionEvent event) -> {
                    final Object source = event.getSource();
                    if (source instanceof TransferData) {
                        final TransferData     transferData = (TransferData) source;
                        final Optional<String> optional     = transferData.getString();
                        if(optional.isPresent()) {
                            final String color = optional.get();
                            this.onActionChangeColorYangSymbol(color);
                        }
                    }
                });
    }

    private void registerOnActionChangeColorYinSymbol() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangSymbol.registerOnActionChangeColorYinSymbol()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__CHANGE__COLOR_YIN_SYMBOL,
                (ActionEvent event) -> {
                    final Object source = event.getSource();
                    if (source instanceof TransferData) {
                        final TransferData     transferData = (TransferData) source;
                        final Optional<String> optional     = transferData.getString();
                        if(optional.isPresent()) {
                            final String color = optional.get();
                            this.onActionChangeColorYinSymbol(color);
                        }
                    }
                });
    }
    
}
