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
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.lib.properties.core.PropertiesFacade;
import com.github.naoghuman.yin.yang.color.ColorConverter;
import com.github.naoghuman.yin.yang.configuration.ActionConfiguration;
import static com.github.naoghuman.yin.yang.configuration.ActionConfiguration.ON_ACTION__CHANGE_COLOR__YANG_SYMBOL;
import com.github.naoghuman.yin.yang.configuration.YinYangConfiguration;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
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
        ActionConfiguration, RegisterActions, YinYangConfiguration
{
    private static final double OPACITY__TERM    = 1.0d;
    private static final double OPACITY__ZERO    = 0.0d;
    
    private static final Random RANDOM = new Random();
    private static final String PATTERN__RGB_COLOR = "rgb(%s)"; // NOI18N
    
    private static final Optional<YinYangTerms> INSTANCE = Optional.of(new YinYangTerms());

    public static final YinYangTerms getDefault() {
        return INSTANCE.get();
    }
    
    private int termIndex       = 0;
    private int termMaxQuantity = 0;
    
    private HBox   hbYinYangTerms;
    private Label  lYangTerm;
    private Label  lYinTerm;
    private Locale language = Locale.ENGLISH;
    
    private YinYangTerms() {
        this.initialize();
    }
    
    private void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangTerms.initialize()"); // NOI18N
        
        PropertiesFacade.getDefault().register(PREF_KEY__YIN_YANG_TERM__RESOURCE_BUNDLE_DE);
        PropertiesFacade.getDefault().register(PREF_KEY__YIN_YANG_TERM__RESOURCE_BUNDLE_EN);
        
        termMaxQuantity = Integer.parseInt(this.getProperty(PREF_KEY__YIN_YANG_TERM__MAX_QUANTITY));
        
        this.register();
    }
    
    public void configure(final HBox hbYinYangTerms, final Label lYinTerm, final Label lYangTerm) {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangTerms.configure(HBox, Label, Label)"); // NOI18N
        
        this.hbYinYangTerms = hbYinYangTerms;
        this.lYinTerm       = lYinTerm;
        this.lYangTerm      = lYangTerm;
        
        this.hbYinYangTerms.getChildren().clear();
        this.lYinTerm.setOpacity(OPACITY__ZERO);
        this.lYinTerm.setPrefWidth(RADIUS__BIG_SYMBOL);
        this.lYangTerm.setOpacity(OPACITY__ZERO);
        this.lYangTerm.setPrefWidth(RADIUS__BIG_SYMBOL);
        
        this.onActionUpdateTermColors();
    }
    
    /**
     * 1) Start delay
     * 2) Blend in   YinTerm
     * 3) Delay show YinTerm
     * 4) Blend out  YinTerm
     * 5) Switch to  YangTerm
     * 6) Blend in   YangTerm
     * 7) Delay show YangTerm
     * 8) Blend out  YangTerm
     * 9) Like 1)
     */
    private SequentialTransition createSequentialTransition() {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangTerms.createSequentialTransition()"); // NOI18N
        
        final SequentialTransition st = new SequentialTransition();
        termIndex = RANDOM.nextInt(termMaxQuantity) + 1;

        // 1
        PauseTransition pt = new PauseTransition();
        pt.setDuration(Duration.millis(5000.0d + RANDOM.nextInt(15000)));
        pt.setOnFinished((event) -> {
            hbYinYangTerms.getChildren().clear();
            hbYinYangTerms.setAlignment(Pos.CENTER_RIGHT);
            hbYinYangTerms.getChildren().add(lYinTerm);
            
            lYinTerm.setText(this.getProperty(String.format(PREF_KEY__YIN_YANG_TERM__YIN, termIndex)));
        });
        st.getChildren().add(pt);
        
        // 2
        Timeline tl = new Timeline(
                new KeyFrame(Duration.ZERO,           new KeyValue(lYinTerm.opacityProperty(), OPACITY__ZERO)),
                new KeyFrame(Duration.millis(500.0d), new KeyValue(lYinTerm.opacityProperty(), OPACITY__TERM)));
        st.getChildren().add(tl);
        
        // 3
        final double durationShowTerm = 5000.0d + RANDOM.nextInt(15000);
        pt = new PauseTransition();
        pt.setDuration(Duration.millis(durationShowTerm));
        st.getChildren().add(pt);
        
        // 4
        tl = new Timeline(
                new KeyFrame(Duration.ZERO,           new KeyValue(lYinTerm.opacityProperty(), OPACITY__TERM)),
                new KeyFrame(Duration.millis(500.0d), new KeyValue(lYinTerm.opacityProperty(), OPACITY__ZERO)));
        st.getChildren().add(tl);
        
        // 5
        pt = new PauseTransition();
        pt.setDuration(Duration.millis(750.0d));
        pt.setOnFinished((event) -> {
            hbYinYangTerms.getChildren().clear();
            hbYinYangTerms.setAlignment(Pos.CENTER_LEFT);
            hbYinYangTerms.getChildren().add(lYangTerm);
            
            lYangTerm.setText(this.getProperty(String.format(PREF_KEY__YIN_YANG_TERM__YANG, termIndex)));
        });
        st.getChildren().add(pt);
        
        // 6
        tl = new Timeline(
                new KeyFrame(Duration.ZERO,           new KeyValue(lYangTerm.opacityProperty(), OPACITY__ZERO)),
                new KeyFrame(Duration.millis(500.0d), new KeyValue(lYangTerm.opacityProperty(), OPACITY__TERM)));
        st.getChildren().add(tl);
        
        // 7
        pt = new PauseTransition();
        pt.setDuration(Duration.millis(durationShowTerm));
        st.getChildren().add(pt);
        
        // 8
        tl = new Timeline(
                new KeyFrame(Duration.ZERO,           new KeyValue(lYangTerm.opacityProperty(), OPACITY__TERM)),
                new KeyFrame(Duration.millis(500.0d), new KeyValue(lYangTerm.opacityProperty(), OPACITY__ZERO)));
        st.getChildren().add(tl);
        
        return st;
    }
    
    private String getProperty(final String propertyKey) {
        return PropertiesFacade.getDefault().getProperty(
                (language == Locale.ENGLISH) ? PREF_KEY__YIN_YANG_TERM__RESOURCE_BUNDLE_EN 
                        : PREF_KEY__YIN_YANG_TERM__RESOURCE_BUNDLE_DE,
                propertyKey);
    }

    public void onActionChangeLanguage(final Locale language) {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangTerms.onActionChangeLanguage(Locale)"); // NOI18N
        
        // Change language
        this.language = language;
        
        // Update gui
        lYangTerm.setText(this.getProperty(String.format(PREF_KEY__YIN_YANG_TERM__YANG, termIndex)));
        lYinTerm.setText(this.getProperty(String.format(PREF_KEY__YIN_YANG_TERM__YIN, termIndex)));
    }

    public void onActionShowYinAndYangTerm() {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangTerms.onActionShowYinAndYangTerm()"); // NOI18N
        
        final SequentialTransition st = this.createSequentialTransition();
        st.setOnFinished((event) -> {
            this.onActionShowYinAndYangTerm();
        });
        
        st.playFromStart();
    }
    
    private void onActionUpdateTermColors() {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangTerms.onActionUpdateTermColors()"); // NOI18N
        
        final String yinSelectedColor  = PreferencesFacade.getDefault().get(YIN_YANG__SYMBOL__YIN_COLOR,  YIN_YANG__SYMBOL__YIN_COLOR_DEFAULT_VALUE);
        final String yangSelectedColor = PreferencesFacade.getDefault().get(YIN_YANG__SYMBOL__YANG_COLOR, YIN_YANG__SYMBOL__YANG_COLOR_DEFAULT_VALUE);
        
        this.lYinTerm.setStyle(String.format(
                "-fx-background-color:%s;-fx-background-radius:5;", // NOI18N
                ColorConverter.convertToBrighter(yinSelectedColor, 0.8d)));
        this.lYinTerm.setTextFill(Color.web(String.format(PATTERN__RGB_COLOR, yangSelectedColor)));
        
        this.lYangTerm.setStyle(String.format(
                "-fx-background-color:%s;-fx-background-radius:5;", // NOI18N
                ColorConverter.convertToBrighter(yangSelectedColor, 0.8d)));
        this.lYangTerm.setTextFill(Color.web(String.format(PATTERN__RGB_COLOR, yinSelectedColor)));
    }

    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "YinYangTerms.register()"); // NOI18N
        
        this.registerOnActionUpdateTermColors();
    }
    
    private void registerOnActionUpdateTermColors() {
        LoggerFacade.getDefault().info(this.getClass(), "YinYangTerms.registerOnActionUpdateTermColors()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__UPDATE_TERM_COLORS,
                (ActionEvent event) -> {
                    this.onActionUpdateTermColors();
                });
    }
    
    
    
}
