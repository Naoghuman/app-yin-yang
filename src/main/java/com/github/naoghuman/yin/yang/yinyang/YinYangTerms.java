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
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.yin.yang.configuration.ActionConfiguration;
import com.github.naoghuman.yin.yang.configuration.YinYangSymbolConfiguration;
import java.util.Optional;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.util.Duration;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public final class YinYangTerms implements 
        ActionConfiguration, RegisterActions, YinYangSymbolConfiguration
{
    private static final double OPACITY__BACKGROUND = 0.9d;
    private static final double OPACITY__TERM       = 1.0d;
    private static final double OPACITY__ZERO       = 0.0d;
    
    private static final int TERM_TYPE__YANG = 1;
    private static final int TERM_TYPE__YIN  = 2;
    
    private static final Random RANDOM = new Random();
    private static final String PATTERN__RGB_COLOR = "rgb(%s)"; // NOI18N
    
    private static final Optional<YinYangTerms> INSTANCE = Optional.of(new YinYangTerms());

    public static final YinYangTerms getDefault() {
        return INSTANCE.get();
    }
    
    private HBox  hbYinYangTerms;
    private Label lYinYangTerms;
    
    private int actualTermType = TERM_TYPE__YIN;
    
    private YinYangTerms() {
        this.initialize();
    }
    
    private void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangTerms.initialize()"); // NOI18N
        
        this.register();
    }
    
    public void configure(final HBox hbYinYangTerms, final Label lYinYangTerms) {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangTerms.configure(HBox, Label)"); // NOI18N
        
        this.hbYinYangTerms = hbYinYangTerms;
        this.lYinYangTerms  = lYinYangTerms;
        
        this.hbYinYangTerms.setOpacity(OPACITY__ZERO);
        this.lYinYangTerms .setOpacity(OPACITY__ZERO);
        
        this.onActionChangeTermColors();
    }
    
    private SequentialTransition createSequentialTransition() {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangTerms.createSequentialTransition()"); // NOI18N
        
        final SequentialTransition st = new SequentialTransition();
        
        // 1
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.millis(5000.0d + RANDOM.nextInt(15000)));
        st.getChildren().add(pt);
        
        // 2
        Timeline tl = new Timeline(
                new KeyFrame(Duration.ZERO,           new KeyValue(hbYinYangTerms.opacityProperty(), OPACITY__ZERO)),
                new KeyFrame(Duration.millis(500.0d), new KeyValue(hbYinYangTerms.opacityProperty(), OPACITY__BACKGROUND)),
                new KeyFrame(Duration.ZERO,           new KeyValue(lYinYangTerms.opacityProperty(),  OPACITY__ZERO)),
                new KeyFrame(Duration.millis(500.0d), new KeyValue(lYinYangTerms.opacityProperty(),  OPACITY__TERM)));
        st.getChildren().add(tl);
        
        // 3
        pt = new PauseTransition();
        pt.setDuration(Duration.millis(5000.0d + RANDOM.nextInt(15000)));
        st.getChildren().add(pt);
        
        // 4
        tl = new Timeline(
                new KeyFrame(Duration.ZERO,           new KeyValue(hbYinYangTerms.opacityProperty(), OPACITY__BACKGROUND)),
                new KeyFrame(Duration.millis(500.0d), new KeyValue(hbYinYangTerms.opacityProperty(), OPACITY__ZERO)),
                new KeyFrame(Duration.ZERO,           new KeyValue(lYinYangTerms.opacityProperty(),  OPACITY__TERM)),
                new KeyFrame(Duration.millis(500.0d), new KeyValue(lYinYangTerms.opacityProperty(),  OPACITY__ZERO)));
        st.getChildren().add(tl);
        
        return st;
    }
    
    private void onActionChangeTermColors() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangTerms.onActionChangeTermColors(String)"); // NOI18N
        
        actualTermType = (actualTermType % 2 == 0) ? TERM_TYPE__YANG : TERM_TYPE__YIN;
        
        this.onActionUpdateTermColors();
    }

    public void onActionShowYinOrYangTerm() {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangTerms.onActionShowYinOrYangTerm()"); // NOI18N
        
        final SequentialTransition st = this.createSequentialTransition();
        st.setOnFinished((event) -> {
            this.onActionChangeTermColors();
            this.onActionShowYinOrYangTerm();
        });
        
        st.playFromStart();
    }
    
    private void onActionUpdateTermColors() {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangTerms.onActionUpdateTermColors()"); // NOI18N
        
        final String yangSelectedColor = PreferencesFacade.getDefault().get(YIN_YANG_SYMBOL__YANG_COLOR, YIN_YANG_SYMBOL__YANG_COLOR_DEFAULT_VALUE);
        final String yinSelectedColor  = PreferencesFacade.getDefault().get(YIN_YANG_SYMBOL__YIN_COLOR,  YIN_YANG_SYMBOL__YIN_COLOR_DEFAULT_VALUE);
        
        switch (actualTermType) {
            case TERM_TYPE__YANG: {
                hbYinYangTerms.setStyle(String.format("-fx-background-color:rgb(%s);-fx-background-radius:5.0d;", yangSelectedColor)); // NOI18N
                lYinYangTerms.setTextFill(Color.web(String.format(PATTERN__RGB_COLOR, yinSelectedColor)));
                break;
            }
            case TERM_TYPE__YIN: {
                hbYinYangTerms.setStyle(String.format("-fx-background-color:rgb(%s);-fx-background-radius:5.0d;", yinSelectedColor)); // NOI18N
                lYinYangTerms.setTextFill(Color.web(String.format(PATTERN__RGB_COLOR, yangSelectedColor)));
                break;
            }
        }
    }

    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangTerms.register()"); // NOI18N
        
        this.registerOnActionUpdateTermColors();
    }
    
    private void registerOnActionUpdateTermColors() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangTerms.registerOnActionUpdateTermColors()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__CHANGE_COLOR__UPDATE_TERM_COLORS,
                (ActionEvent event) -> {
                    this.onActionUpdateTermColors();
                });
    }
    
}
