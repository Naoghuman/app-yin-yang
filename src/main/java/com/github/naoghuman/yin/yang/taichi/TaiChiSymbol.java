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
package com.github.naoghuman.yin.yang.taichi;

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.yin.yang.configuration.EventConfiguration;
import com.github.naoghuman.yin.yang.configuration.PreferencesConfiguration;
import com.github.naoghuman.yin.yang.configuration.TaiChiConfiguration;
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
import javafx.scene.Cursor;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.StackPane;
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
public final class TaiChiSymbol implements 
        EventConfiguration, PreferencesConfiguration, TaiChiConfiguration
{
    private static final double STROKE_WIDTH = 4.0d;
    
    private static final ObservableMap<Month, Double> MONTH_ROTATIONS = FXCollections.observableHashMap();
    private static final Optional<TaiChiSymbol>      INSTANCE         = Optional.of(new TaiChiSymbol());
    
    public static final TaiChiSymbol getDefault() {
        return INSTANCE.get();
    }
    
    private double centerXtheOne       = PREF__TAICHI_SYMBOL__DIAMETER_DEFAULT_VALUE / 2.0d + STROKE_WIDTH;
    private double centerYtheOne       = PREF__TAICHI_SYMBOL__DIAMETER_DEFAULT_VALUE / 2.0d + STROKE_WIDTH;
    private double diameterTheOne      = PREF__TAICHI_SYMBOL__DIAMETER_DEFAULT_VALUE;
    private double radiusLittleYinYang = PREF__TAICHI_SYMBOL__DIAMETER_DEFAULT_VALUE / 8.0d / 2.0d;
    
    private Arc       halfYangSymbol;
    private Circle    littleYangSymbol;
    private Circle    littleYinSymbol;
    private Circle    yinSymbol;
    private LocalDate oldDayInYear   = LocalDate.now();
    private LocalDate oldMonthInYear = LocalDate.now();
    private Rotate    rotation;
    private Shape     yangSymbol;
    private Timeline  tlRotation;
    
    private TaiChiSymbol() {
        this.initialize();
    }
    
    private void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiSymbol.initialize()"); // NOI18N
        
        /*
         * Rework math for the TaiChi-Symbol
         *  - The One       == 1 == d   == Circle
         *  - Yin, Yang     == 2 == d/2 == 2 Half
         *  - Yin, Yang     == 4 == d/4 ==   Half +- half/2
         *  - l.Yin, l.Yang == 8 == d/8 == Size of the little yin, yang
         */
        diameterTheOne      = PreferencesFacade.getDefault().getDouble(PREF__TAICHI_SYMBOL__DIAMETER, PREF__TAICHI_SYMBOL__DIAMETER_DEFAULT_VALUE);
        centerXtheOne       = diameterTheOne / 2.0d + STROKE_WIDTH; //YINYANG_SYMBOLE__OUTER_BORDER;
        centerYtheOne       = 50; //diameterTheOne / 2.0d + STROKE_WIDTH; //YINYANG_SYMBOLE__OUTER_BORDER;
        radiusLittleYinYang = diameterTheOne / 8.0d / 2.0d;
        
        this.initializeLittleYinSymbol();
        this.initializeYinSymbol();
        this.initializeYinSymbolMouseListeners();
        this.initializeLittleYangSymbol();
        this.initializeYangSymbol();
        this.initializeTaiChiRotation();
        this.initializeTaiChiTimeline();
    }
    
    private void initializeLittleYangSymbol() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiSymbol.initializeLittleYangSymbol()"); // NOI18N
       
        // Little YangSymbol
        littleYangSymbol = new Circle();
        littleYangSymbol.setRadius(radiusLittleYinYang);
        littleYangSymbol.setCenterX(centerXtheOne - diameterTheOne / 4.0d);
        littleYangSymbol.setCenterY(centerYtheOne);
    }
    
    private void initializeLittleYinSymbol() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiSymbol.initializeLittleYinSymbol()"); // NOI18N
       
        // Little YinSymbol
        littleYinSymbol = new Circle();
        littleYinSymbol.setRadius(radiusLittleYinYang);
        littleYinSymbol.setCenterX(centerXtheOne + diameterTheOne / 4.0d);
        littleYinSymbol.setCenterY(centerYtheOne);
    }

    private void initializeTaiChiRotation() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiSymbol.initializeTaiChiRotation()"); // NOI18N
        
        // Rotation
        rotation = new Rotate();//0, diameterTheOne / 2.0d + YINYANG_SYMBOLE__OUTER_BORDER, diameterTheOne / 2.0d + YINYANG_SYMBOLE__OUTER_BORDER);
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

    private void initializeTaiChiTimeline() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiSymbol.initializeTaiChiTimeline()"); // NOI18N
        
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
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiSymbol.initializeYangSymbol()"); // NOI18N
        
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
        littleAddCirle.setRadius(diameterTheOne / 4.0d - STROKE_WIDTH / 2.0d);
        littleAddCirle.setCenterX(centerXtheOne + diameterTheOne / 4.0d - STROKE_WIDTH / 2.0d);
        littleAddCirle.setCenterY(centerYtheOne);
        yangSymbol = Shape.union(halfYangSymbol, littleAddCirle);
        
        Circle littleMinusCirle = new Circle();
        littleMinusCirle.setRadius(diameterTheOne / 4.0d - STROKE_WIDTH / 2.0d);
        littleMinusCirle.setCenterX(centerXtheOne - diameterTheOne / 4.0d + STROKE_WIDTH / 2.0d);
        littleMinusCirle.setCenterY(centerYtheOne);
        yangSymbol = Shape.subtract(yangSymbol, littleMinusCirle);
        
        // Little YinSymbol
        yangSymbol = Shape.subtract(yangSymbol, littleYinSymbol);
        
        // Little YangSymbol
        yangSymbol = Shape.union(yangSymbol, littleYangSymbol);
        
        // Tweak the ready YangSymbol
        yangSymbol.setMouseTransparent(Boolean.TRUE);
        yangSymbol.setTranslateY(yangSymbol.getTranslateY() + -littleAddCirle.getRadius() / 2);
        
        // Register the yang-symbol for color changes
        TaiChiColors.getDefault().register(yangSymbol, ON_ACTION__CHOOSE__SINGLE_YANG_COLOR);
    }

    private void initializeYinSymbol() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiSymbol.initializeYinSymbol()"); // NOI18N
        
        yinSymbol = new Circle();
        yinSymbol.setCursor(Cursor.DEFAULT);
        yinSymbol.setRadius(diameterTheOne / 2.0d);
        
        final DropShadow glow = new DropShadow();
        glow.setOffsetY(0f);
        glow.setOffsetX(0f);
        glow.setColor(Color.BLACK);
        glow.setWidth(12.0d);
        glow.setHeight(12.0d);
        yinSymbol.setEffect(glow);
        yinSymbol.setFill(Color.BLACK);
        
        // Register the yin-symbol for color changes
        TaiChiColors.getDefault().register(yinSymbol, ON_ACTION__CHOOSE__SINGLE_YIN_COLOR);
    }
    
    private void initializeYinSymbolMouseListeners() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiSymbol.initializeYinSymbolMouseListeners()"); // NOI18N
        
        yinSymbol.setOnMouseDragged((event) -> {
            if (event.getButton() == MouseButton.PRIMARY) {
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
            if (event.getButton() == MouseButton.PRIMARY) {
                yinSymbol.setCursor(Cursor.DEFAULT);
            }
        });
    }
    
    public void configure(final StackPane spApplication) {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangSymbol.configure(AnchorPane)"); // NOI18N
        
        spApplication.getChildren().add(0, yinSymbol);
        spApplication.getChildren().add(1, yangSymbol);
    }
    
    private boolean isNewDayInYear(LocalDate newDayInYear) {
        boolean isNewDayInYear = Boolean.FALSE;
        if (newDayInYear.getYear() > oldDayInYear.getYear()) {
            isNewDayInYear = Boolean.TRUE;
            oldDayInYear   = newDayInYear;
        }
        
        if (
                newDayInYear.getYear()         == oldDayInYear.getYear()
                && newDayInYear.getDayOfYear() >  oldDayInYear.getDayOfYear()
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
                newMonthInYear.getYear()          == oldMonthInYear.getYear()
                && newMonthInYear.getMonthValue() >  oldMonthInYear.getMonthValue()
        ) {
            isNewMonthInYear = Boolean.TRUE;
            oldMonthInYear   = newMonthInYear;
        }
        
        return isNewMonthInYear;
    }
    
    public void onActionStartTaiChiRotation() {
        final PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.millis(500.0d));
        pt.setOnFinished((event) -> {
            LoggerFacade.getDefault().debug(this.getClass(), "TaiChiSymbol.onActionStartTaiChiRotation()"); // NOI18N
        
            if (
                    this.isNewDayInYear(LocalDate.now())
                    || this.isNewMonthInYear(LocalDate.now())
            ) {
                this.initializeTaiChiTimeline();
            }
            
            tlRotation.playFromStart();
        });
        
        pt.playFromStart();
    }
    
}
