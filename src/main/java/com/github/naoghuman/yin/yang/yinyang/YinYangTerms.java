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

import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.yin.yang.color.ColorConverter;
import com.github.naoghuman.yin.yang.configuration.ActionConfiguration;
import com.github.naoghuman.yin.yang.configuration.YinYangSymbolConfiguration;
import java.util.Optional;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
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
    private static final double OPACITY__TERM       = 1.0d;
    private static final double OPACITY__ZERO       = 0.0d;
    
    private static final Random RANDOM = new Random();
    private static final String PATTERN__RGB_COLOR = "rgb(%s)"; // NOI18N
    
    private static final Optional<YinYangTerms> INSTANCE = Optional.of(new YinYangTerms());

    public static final YinYangTerms getDefault() {
        return INSTANCE.get();
    }
    
    private Label lYangTerm;
    private Label lYinTerm;
    
    private YinYangTerms() {
        this.initialize();
    }
    
    private void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangTerms.initialize()"); // NOI18N
        
        this.register();
    }
    
    public void configure(final Label lYinTerm, final Label lYangTerm) {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangTerms.configure(Label, Label)"); // NOI18N
        
        this.lYinTerm  = lYinTerm;
        this.lYangTerm = lYangTerm;
        
        final String yinSelectedColor = PreferencesFacade.getDefault().get(YIN_YANG_SYMBOL__YIN_COLOR,  YIN_YANG_SYMBOL__YIN_COLOR_DEFAULT_VALUE);
        final String yangSelectedColor = PreferencesFacade.getDefault().get(YIN_YANG_SYMBOL__YANG_COLOR, YIN_YANG_SYMBOL__YANG_COLOR_DEFAULT_VALUE);
        
        this.lYinTerm.setOpacity(OPACITY__ZERO);
        this.lYinTerm.setStyle(String.format(
                "-fx-background-color:%s;-fx-background-radius:5;", // NOI18N
                ColorConverter.convertToBrighter(yinSelectedColor, 0.8d)));
        this.lYinTerm.setTextFill(Color.web(String.format(PATTERN__RGB_COLOR, yangSelectedColor)));
        
        this.lYangTerm.setOpacity(OPACITY__ZERO);
        this.lYangTerm.setStyle(String.format(
                "-fx-background-color:%s;-fx-background-radius:5;", // NOI18N
                ColorConverter.convertToBrighter(yangSelectedColor, 0.8d)));
        this.lYangTerm.setTextFill(Color.web(String.format(PATTERN__RGB_COLOR, yinSelectedColor)));
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
                new KeyFrame(Duration.ZERO,           new KeyValue(lYinTerm.opacityProperty(),  OPACITY__ZERO)),
                new KeyFrame(Duration.millis(500.0d), new KeyValue(lYinTerm.opacityProperty(),  OPACITY__TERM)),
                new KeyFrame(Duration.ZERO,           new KeyValue(lYangTerm.opacityProperty(),  OPACITY__ZERO)),
                new KeyFrame(Duration.millis(500.0d), new KeyValue(lYangTerm.opacityProperty(),  OPACITY__TERM)));
        st.getChildren().add(tl);
        
        // 3
        pt = new PauseTransition();
        pt.setDuration(Duration.millis(5000.0d + RANDOM.nextInt(15000)));
        st.getChildren().add(pt);
        
        // 4
        tl = new Timeline(
                new KeyFrame(Duration.ZERO,           new KeyValue(lYinTerm.opacityProperty(),  OPACITY__TERM)),
                new KeyFrame(Duration.millis(500.0d), new KeyValue(lYinTerm.opacityProperty(),  OPACITY__ZERO)),
                new KeyFrame(Duration.ZERO,           new KeyValue(lYangTerm.opacityProperty(),  OPACITY__TERM)),
                new KeyFrame(Duration.millis(500.0d), new KeyValue(lYangTerm.opacityProperty(),  OPACITY__ZERO)));
        st.getChildren().add(tl);
        
        return st;
    }

    public void onActionShowYinAndYangTerm() {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangTerms.onActionShowYinAndYangTerm()"); // NOI18N
        
        final SequentialTransition st = this.createSequentialTransition();
        st.setOnFinished((event) -> {
            this.onActionShowYinAndYangTerm();
        });
        
        st.playFromStart();
    }

    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangTerms.register()"); // NOI18N
        
    }
    
}
