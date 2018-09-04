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
import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.yin.yang.configuration.EventConfiguration;
import java.time.LocalDate;
import java.time.Month;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
final class DefaultTaiChiRotation implements 
        EventConfiguration, RegisterActions, TaiChiRotation
{
    private static final ObservableMap<Month, Double> MONTHLY_ROTATION_SPEED = FXCollections.observableHashMap();
    
    private LocalDate oldDayInYear   = LocalDate.now();
    private LocalDate oldMonthInYear = LocalDate.now();
    
    private Rotate   rotation;
    private Timeline tlRotation;
    
    public DefaultTaiChiRotation() {
        
    }
    
    @Override
    public void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiRotation.initialize()"); // NOI18N
        
        this.initializeTaiChiRotation();
        this.initializeTaiChiMonthlyRotationSpeed();
        this.initializeTaiChiTimeline();
        
        this.register();
    }
    
    private void initializeTaiChiRotation() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiRotation.initializeTaiChiRotation()"); // NOI18N
        
        rotation = new Rotate();
    }

    private void initializeTaiChiMonthlyRotationSpeed() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiRotation.initializeTaiChiMonthlyRotationSpeed()"); // NOI18N
        
        MONTHLY_ROTATION_SPEED.put(Month.JANUARY,   19.200d); // Slowest month in year
        MONTHLY_ROTATION_SPEED.put(Month.FEBRUARY,  17.066d);
        MONTHLY_ROTATION_SPEED.put(Month.MARCH,     14.932d);
        MONTHLY_ROTATION_SPEED.put(Month.APRIL,     12.798d);
        MONTHLY_ROTATION_SPEED.put(Month.MAY,       10.664d);
        MONTHLY_ROTATION_SPEED.put(Month.JUNE,       8.530d);
        MONTHLY_ROTATION_SPEED.put(Month.JULY,       6.400d); // Fastest month in year
        MONTHLY_ROTATION_SPEED.put(Month.AUGUST,     8.530d);
        MONTHLY_ROTATION_SPEED.put(Month.SEPTEMBER, 10.664d);
        MONTHLY_ROTATION_SPEED.put(Month.OCTOBER,   12.798d);
        MONTHLY_ROTATION_SPEED.put(Month.NOVEMBER,  14.932d);
        MONTHLY_ROTATION_SPEED.put(Month.DECEMBER,  17.066d);
    }

    private void initializeTaiChiTimeline() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiRotation.initializeTaiChiTimeline()"); // NOI18N
        
        /*
          Yang -> odd  nummers -> right spinning
          Yin  -> even nummers -> left  spinning
        */
        final LocalDate now         = LocalDate.now(); 
        final double    endDuration = MONTHLY_ROTATION_SPEED.get(now.getMonth());
        final double    endValue    = (now.getDayOfMonth() % 2) == 0 ? -360.0d : 360.0d;
        tlRotation = new Timeline(
                new KeyFrame(Duration.ZERO,                 new KeyValue(rotation.angleProperty(), 0.0d)),
                new KeyFrame(Duration.seconds(endDuration), new KeyValue(rotation.angleProperty(), endValue)));
        tlRotation.setCycleCount(Animation.INDEFINITE);
    }
    
    private boolean isNewDayInYear(final LocalDate newDayInYear) {
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
    
    private boolean isNewMonthInYear(final LocalDate newMonthInYear) {
        boolean isNewMonthInYear = Boolean.FALSE;
        // TODO works that also with 2018.1 / 2017.12?
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
    
    private void onActionStartTaiChiRotation() {
        final PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.millis(500.0d));
        pt.setOnFinished((event) -> {
            LoggerFacade.getDefault().debug(this.getClass(), "TaiChiRotation.onActionStartTaiChiRotation()"); // NOI18N
        
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
    
    @Override
    public void register(final Shape yangSymbol, final Arc halfYangSymbol) {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiRotation.register()"); // NOI18N
        
        rotation.pivotXProperty().bind(halfYangSymbol.centerXProperty());
        rotation.pivotYProperty().bind(halfYangSymbol.centerYProperty());
        
        yangSymbol.getTransforms().add(rotation);
    }

    @Override
    public void register() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiRotation.register()"); // NOI18N
        
        this.registerOnActionStartTaiChiRotation();
    }

    private void registerOnActionStartTaiChiRotation() {
        LoggerFacade.getDefault().info(this.getClass(), "TaiChiRotation.registerOnActionStartTaiChiRotation()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__START_TAICHI_ROTATION,
                (ActionEvent event) -> {
                    this.onActionStartTaiChiRotation();
                });
    }
    
}
