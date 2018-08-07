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
package com.github.naoghuman.yin.yang.application.options;

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.lib.properties.core.PropertiesFacade;
import com.github.naoghuman.yin.yang.color.ColorComboBox;
import com.github.naoghuman.yin.yang.configuration.ActionConfiguration;
import com.github.naoghuman.yin.yang.configuration.ApplicationConfiguration;
import static com.github.naoghuman.yin.yang.configuration.ApplicationConfiguration.PREF_KEY__APPLICATION__OPTIONS_RESOURCE_BUNDLE_DE;
import static com.github.naoghuman.yin.yang.configuration.ApplicationConfiguration.PREF_KEY__APPLICATION__OPTIONS_RESOURCE_BUNDLE_EN;
import com.github.naoghuman.yin.yang.configuration.YinYangConfiguration;
import java.util.Locale;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * @author Naoghuman
 * @since  0.2.0
 */
public final class Options implements 
        ActionConfiguration, ApplicationConfiguration, 
        RegisterActions, YinYangConfiguration
{
    private static final Color COLOR__BACKGROUND_OPTIONS = Color.color(1.0d, 1.0d, 1.0d, 0.66d);
    
    private static final Optional<Options> INSTANCE = Optional.of(new Options());
    
    public static final Options getDefault() {
        return INSTANCE.get();
    }
    
    private Button      bCloseApplication;
    private Circle      cOptionsBackground;
    private ComboBox    cbYangColors;
    private ComboBox    cbYinColors;
    private Label       lLanguages;
    private Label       lYangColors;
    private Label       lYinColors;
    private Label       lYinYangColors;
    private Label       lYangTerm;
    private Label       lYinTerm;
    private RadioButton rbEnglishLanguage;
    private RadioButton rbGermanLanguage;
    private Separator   bSeparator1;
    
    private Locale language = Locale.ENGLISH;
    
    private Options() {
        this.initialize();
    }
    
    private void initialize() {
        LoggerFacade.getDefault().info(this.getClass(), "Options.initialize()"); // NOI18N
        
        this.register();
    }
    
    public void configure(
            final Circle      cOptionsBackground, final Button      bCloseApplication,
            final Separator   bSeparator1,        final Label       lYinYangColors,
            final Label       lYinColors,         final ComboBox    cbYinColors,
            final Label       lYangColors,        final ComboBox    cbYangColors,
            final Label       lLanguages,         final RadioButton rbEnglishLanguage,
            final RadioButton rbGermanLanguage
    ) {
        LoggerFacade.getDefault().debug(this.getClass(), "Options.configure()"); // NOI18N
        
        this.cOptionsBackground = cOptionsBackground;
        this.bCloseApplication  = bCloseApplication;
        this.bSeparator1        = bSeparator1;
        this.lYinYangColors     = lYinYangColors;
        this.lYinColors         = lYinColors;
        this.cbYinColors        = cbYinColors;
        this.lYangColors        = lYangColors;
        this.cbYangColors       = cbYangColors;
        this.lLanguages         = lLanguages;
        this.rbEnglishLanguage  = rbEnglishLanguage;
        this.rbGermanLanguage   = rbGermanLanguage;
        
        this.configureOptions();
        
        final boolean showOptions = Boolean.FALSE;
        this.onActionShowOptions(showOptions);
    }
    
    private void configureOptions() {
        LoggerFacade.getDefault().debug(this.getClass(), "Options.configureOptions()"); // NOI18N
    
        cOptionsBackground.setFill(COLOR__BACKGROUND_OPTIONS);
        cOptionsBackground.setStroke(null);
        
        final ColorComboBox yangColorComboBox = new ColorComboBox();
        final String yangSelectedColor = PreferencesFacade.getDefault().get(YIN_YANG__SYMBOL__YANG_COLOR, YIN_YANG__SYMBOL__YANG_COLOR_DEFAULT_VALUE);
        yangColorComboBox.configure(cbYangColors, ColorComboBox.Type.YANG_SYMBOL, yangSelectedColor);
        
        final ColorComboBox yinColorComboBox = new ColorComboBox();
        final String yinSelectedColor = PreferencesFacade.getDefault().get(YIN_YANG__SYMBOL__YIN_COLOR, YIN_YANG__SYMBOL__YIN_COLOR_DEFAULT_VALUE);
        yinColorComboBox.configure(cbYinColors, ColorComboBox.Type.YIN_SYMBOL, yinSelectedColor);
    }
    
    private String getProperty(final String propertyKey) {
        return PropertiesFacade.getDefault().getProperty((language == Locale.ENGLISH)
                        ? PREF_KEY__APPLICATION__OPTIONS_RESOURCE_BUNDLE_EN 
                        : PREF_KEY__APPLICATION__OPTIONS_RESOURCE_BUNDLE_DE,
                propertyKey);
    }
    
    public Locale onActionChangeLanguage() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.onActionChangeLanguage()"); // NOI18N
        
        Locale language = Locale.ENGLISH;
        if (rbEnglishLanguage.isSelected()) {
            language = Locale.ENGLISH;
        }
        
        if (rbGermanLanguage.isSelected()) {
            language = Locale.GERMAN;
        }
        
        this.onActionChangeLanguage(language);
        
        return language;
    }
    
    private void onActionChangeLanguage(final Locale language) {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.onActionChangeLanguage(Locale)"); // NOI18N

        // Change language
        this.language = language;
        
        // Update gui
        lYinYangColors.setText(this.getProperty(String.format(PREF_KEY__APPLICATION__OPTIONS_COLORS)));
        lYangColors.setText(this.getProperty(String.format(PREF_KEY__APPLICATION__OPTIONS_YANG_COLOR)));
        lYinColors.setText(this.getProperty(String.format(PREF_KEY__APPLICATION__OPTIONS_YIN_COLOR)));
        
        lLanguages.setText(this.getProperty(String.format(PREF_KEY__APPLICATION__OPTIONS_LANGUAGES)));
        rbEnglishLanguage.setText(this.getProperty(String.format(PREF_KEY__APPLICATION__OPTIONS_LANGUAGE_ENGLISH)));
        rbGermanLanguage.setText(this.getProperty(String.format(PREF_KEY__APPLICATION__OPTIONS_LANGUAGE_GERMAN)));
    }

    private void onActionShowOptions(final boolean showOptions) {
        LoggerFacade.getDefault().info(this.getClass(), String.format(
                "Options.onActionShowOptions(showOption=%b)", showOptions)); // NOI18N
    
        // Background
        cOptionsBackground.setManaged(showOptions);
        cOptionsBackground.setVisible(showOptions);
        
        // Close
        bCloseApplication.setManaged(showOptions);
        bCloseApplication.setVisible(showOptions);
        
        bSeparator1.setManaged(showOptions);
        bSeparator1.setVisible(showOptions);
        
        // Colors
        lYinYangColors.setManaged(showOptions);
        lYinYangColors.setVisible(showOptions);
        
        lYinColors.setManaged(showOptions);
        lYinColors.setVisible(showOptions);
        cbYinColors.setManaged(showOptions);
        cbYinColors.setVisible(showOptions);
        
        lYangColors.setManaged(showOptions);
        lYangColors.setVisible(showOptions);
        cbYangColors.setManaged(showOptions);
        cbYangColors.setVisible(showOptions);
        
        // Languages
        lLanguages.setManaged(showOptions);
        lLanguages.setVisible(showOptions);
        
        rbEnglishLanguage.setManaged(showOptions);
        rbEnglishLanguage.setVisible(showOptions);
        
        rbGermanLanguage.setManaged(showOptions);
        rbGermanLanguage.setVisible(showOptions);
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().debug(this.getClass(), "Options.register()"); // NOI18N
        
        this.registerOnActionShowOptions();
    }
    
    private void registerOnActionShowOptions() {
        LoggerFacade.getDefault().info(this.getClass(), "Options.registerOnActionShowOptions()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__SHOW_OPTIONS,
                (ActionEvent event) -> {
                    final Object source = event.getSource();
                    if (source instanceof TransferData) {
                        final TransferData      transferData = (TransferData) source;
                        final Optional<Boolean> optional     = transferData.getBoolean();
                        if(optional.isPresent()) {
                            final boolean isShowOptions = optional.get();
                            this.onActionShowOptions(isShowOptions);
                        }
                    }
                });
    }
    
}
