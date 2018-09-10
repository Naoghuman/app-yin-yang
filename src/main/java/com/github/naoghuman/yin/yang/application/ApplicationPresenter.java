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
package com.github.naoghuman.yin.yang.application;

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.RegisterActions;
import com.github.naoghuman.lib.action.core.TransferData;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import com.github.naoghuman.lib.preferences.core.PreferencesFacade;
import com.github.naoghuman.yin.yang.color.ColorProvider;
import com.github.naoghuman.yin.yang.i18n.I18nProvider;
import com.github.naoghuman.yin.yang.options.OptionsView;
import com.github.naoghuman.yin.yang.taichi.TaiChiColorType;
import com.github.naoghuman.yin.yang.taichi.TaiChiProvider;
import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Window;
import com.github.naoghuman.yin.yang.configuration.ConfigurationApplication;
import com.github.naoghuman.yin.yang.configuration.ConfigurationEvent;
import com.github.naoghuman.yin.yang.configuration.ConfigurationI18n;
import com.github.naoghuman.yin.yang.configuration.ConfigurationPreferences;
import com.github.naoghuman.yin.yang.configuration.ConfigurationTaiChi;
import javafx.geometry.Insets;

/**
 *
 * @author Naoghuman
 * @since  0.4.0
 */
public class ApplicationPresenter implements 
        ConfigurationApplication, ConfigurationEvent, ConfigurationI18n,
        ConfigurationPreferences, ConfigurationTaiChi, Initializable,
        RegisterActions
{
    private static final String STYLE__BACKGROUND_COLOR_RADIUS = "-fx-background-color:%s;-fx-background-radius:5.0;"; // NOI18N
    
    @FXML private Button    bCloseApplication;
    @FXML private Button    bMinimizeApplication;
    @FXML private Button    bShowOptionDialog;
    @FXML private HBox      hbMenuButtons;
    @FXML private HBox      hbTaiChiTerms;
    @FXML private Label     lInfoByName;
    @FXML private Label     lInfoTitle;
    @FXML private Label     lInfoVersion;
    @FXML private Label     lYangTerm;
    @FXML private Label     lYinTerm;
    @FXML private StackPane spApplication;
    @FXML private VBox      vbInfos;
    
    private double diameterTheOne  = PREF__TAICHI_SYMBOL__DIAMETER_DEFAULT_VALUE;
    
    private Window owner;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.initialize(URL, ResourceBundle)"); // NOI18N
        
        this.initializeDiameterTheOne();
        this.initializeInfos();
        this.initializeMenu();
        
        final boolean showOptionMenu = Boolean.FALSE;
        this.onActionShowOptionMenu(showOptionMenu);
    }
    
    private void initializeDiameterTheOne() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.initializeDiameterTheOne()"); // NOI18N
    
        diameterTheOne = PreferencesFacade.getDefault().getDouble(PREF__TAICHI_SYMBOL__DIAMETER, PREF__TAICHI_SYMBOL__DIAMETER_DEFAULT_VALUE);
    }
    
    private void initializeInfos() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.initializeInfos()"); // NOI18N
    
        // VBox
        vbInfos.setPrefWidth(diameterTheOne / 2.0d);
        
        final double diameter = PreferencesFacade.getDefault().getDouble(PREF__TAICHI_SYMBOL__DIAMETER, PREF__TAICHI_SYMBOL__DIAMETER_DEFAULT_VALUE);
        final double top      = diameter / 2.0d + hbMenuButtons.getPrefHeight() * 2.0d;// - 4.0d;// STROKE_WIDTH
        StackPane.setMargin(vbInfos, new Insets(top, 0.0d, 0.0d, 0.0d));
        
        lInfoTitle.setText(String.format(
                I18nProvider.getDefault().getI18nOptions().getProperty(I18N_KEY__OPTION_DIALOG__TAB_ABOUT__TITLE),
                I18nProvider.getDefault().getI18nApplication().getProperty(I18N_KEY__APPLICATION__TITLE)));
        
        lInfoVersion.setText(String.format(
                I18nProvider.getDefault().getI18nOptions().getProperty(I18N_KEY__OPTION_DIALOG__TAB_ABOUT__VERSION),
                I18nProvider.getDefault().getI18nApplication().getProperty(I18N_KEY__APPLICATION__VERSION)));
        
        lInfoByName.setText(I18nProvider.getDefault().getI18nOptions().getProperty(I18N_KEY__OPTION_DIALOG__TAB_ABOUT__BYNAME));
    }
    
    private void initializeMenu() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.initializeMenu()"); // NOI18N

        hbMenuButtons.setPrefWidth(diameterTheOne / 2.0d);
        
        final double diameter = PreferencesFacade.getDefault().getDouble(PREF__TAICHI_SYMBOL__DIAMETER, PREF__TAICHI_SYMBOL__DIAMETER_DEFAULT_VALUE);
        final double bottom   = diameter / 2.0d + hbMenuButtons.getPrefHeight() * 2.0d + 4.0d;// STROKE_WIDTH
        StackPane.setMargin(hbMenuButtons, new Insets(0.0d, 0.0d, bottom, 0.0d));
    }
    
    public void configure(final Window owner) {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.configure(Window)"); // NOI18N
    
        this.owner = owner;
    }
    
    public void onActionCloseApplication() {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.onActionCloseApplication()"); // NOI18N
    
        ActionHandlerFacade.getDefault().handle(ON_ACTION__CLOSE_APPLICATION);
    }
    
    public void onActionMinimizeApplication() {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.onActionMinimizeApplication()"); // NOI18N
    
        // Minimize the application
        ActionHandlerFacade.getDefault().handle(ON_ACTION__MINIMIZE_APPLICATION);
        
        // Hide the options
        final PauseTransition pt = new PauseTransition();
        pt.setDuration(DURATION__125);
        pt.setOnFinished((event) -> {
            // Hide it a little later (mouseover)
            final boolean showOptions = Boolean.FALSE;
            ActionHandlerFacade.getDefault()
                    .handle(TransferDataBuilder.create()
                            .actionId(ON_ACTION__SHOW_OPTIONS)
                            .booleanValue(showOptions)
                            .build());
        });
        
        pt.playFromStart();
    }
    
    public void onActionShowOptionDialog() {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.onActionShowOptionDialog()"); // NOI18N
        
        final Dialog<String> dialog = new Dialog<>();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner(owner);
        dialog.setTitle(I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__TITLE)));
        dialog.setWidth(800.0d);
        dialog.setHeight(600.0d);
        dialog.setResizable(Boolean.FALSE);
        
        final OptionsView view = new OptionsView();
        dialog.getDialogPane().setContent(view.getView());
        
        final ButtonType buttonTypeOk = new ButtonType(
                I18nProvider.getDefault().getI18nOptions().getProperty(String.format(I18N_KEY__OPTION_DIALOG__BUTTON)),
                ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().add(buttonTypeOk);
        
        dialog.showAndWait();
    }
    
    private void onActionShowOptionMenu(final boolean showOptionMenu) {
        LoggerFacade.getDefault().info(this.getClass(), String.format(
                "ApplicationPresenter.onActionShowOptionMenu(showOptionMenu=%b)", showOptionMenu)); // NOI18N
        
        // Menu buttons
        hbMenuButtons.setManaged(showOptionMenu);
        hbMenuButtons.setVisible(showOptionMenu);
        
        bCloseApplication.setManaged(showOptionMenu);
        bCloseApplication.setVisible(showOptionMenu);
        bMinimizeApplication.setManaged(showOptionMenu);
        bMinimizeApplication.setVisible(showOptionMenu);
        bShowOptionDialog.setManaged(showOptionMenu);
        bShowOptionDialog.setVisible(showOptionMenu);
        
        // Infos
        vbInfos.setManaged(showOptionMenu);
        vbInfos.setVisible(showOptionMenu);
        
        lInfoByName.setManaged(showOptionMenu);
        lInfoByName.setVisible(showOptionMenu);
        lInfoTitle.setManaged(showOptionMenu);
        lInfoTitle.setVisible(showOptionMenu);
    }

    private void onActionUpdateColorInApplicationOptions() {
        LoggerFacade.getDefault().debug(this.getClass(), "ApplicationPresenter.onActionUpdateColorInApplicationOptions()"); // NOI18N
        
        // Option buttons
        final LocalDate now    = LocalDate.now();
        final boolean   oddDay = now.getDayOfMonth() % 2 != 0;
        final String yinSelectedColor  = PreferencesFacade.getDefault().get(PREF__TAICHI_SYMBOL__YIN_COLOR,  PREF__TAICHI_SYMBOL__YIN_COLOR_DEFAULT_VALUE);
        final String yangSelectedColor = PreferencesFacade.getDefault().get(PREF__TAICHI_SYMBOL__YANG_COLOR, PREF__TAICHI_SYMBOL__YANG_COLOR_DEFAULT_VALUE);

        // Option info
        vbInfos.setStyle(String.format(STYLE__BACKGROUND_COLOR_RADIUS,
                ColorProvider.getDefault().getColorConverter().convertToBrighter(
                        (!oddDay ? yangSelectedColor : yinSelectedColor),
                        0.8d)));
        
        lInfoTitle.setTextFill(  Color.web(String.format(PATTERN__RGB_COLOR, (oddDay ? yangSelectedColor : yinSelectedColor))));
        lInfoVersion.setTextFill(Color.web(String.format(PATTERN__RGB_COLOR, (oddDay ? yangSelectedColor : yinSelectedColor))));
        lInfoByName.setTextFill( Color.web(String.format(PATTERN__RGB_COLOR, (oddDay ? yangSelectedColor : yinSelectedColor))));
    }
    
    @Override
    public void register() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.register()"); // NOI18N
        
        this.registerOnActionShowOptionMenu();
        this.registerOnActionUpdateColorInApplicationOptions();
        
        TaiChiProvider.getDefault().getTaiChiSymbol().register(spApplication);
        
        TaiChiProvider.getDefault().getTaiChiColors().register(hbMenuButtons, ON_ACTION__UPDATE__YANG_COLOR);
        TaiChiProvider.getDefault().getTaiChiColors().register(lInfoByName,   TaiChiColorType.TEXTFILL, ON_ACTION__UPDATE__YANG_COLOR);
        TaiChiProvider.getDefault().getTaiChiColors().register(lInfoTitle,    TaiChiColorType.TEXTFILL, ON_ACTION__UPDATE__YANG_COLOR);
        TaiChiProvider.getDefault().getTaiChiColors().register(lInfoVersion,  TaiChiColorType.TEXTFILL, ON_ACTION__UPDATE__YANG_COLOR);
        
        TaiChiProvider.getDefault().getTaiChiColors().register(vbInfos,   ON_ACTION__UPDATE__YIN_COLOR);
        TaiChiProvider.getDefault().getTaiChiColors().register(lYangTerm, TaiChiColorType.STYLE,    ON_ACTION__UPDATE__YANG_COLOR);
        TaiChiProvider.getDefault().getTaiChiColors().register(lYangTerm, TaiChiColorType.TEXTFILL, ON_ACTION__UPDATE__YIN_COLOR);
        TaiChiProvider.getDefault().getTaiChiColors().register(lYinTerm,  TaiChiColorType.STYLE,    ON_ACTION__UPDATE__YIN_COLOR);
        TaiChiProvider.getDefault().getTaiChiColors().register(lYinTerm,  TaiChiColorType.TEXTFILL, ON_ACTION__UPDATE__YANG_COLOR);
        
        TaiChiProvider.getDefault().getTaiChiTerms().register(hbTaiChiTerms, lYinTerm, lYangTerm);
    }
    
    private void registerOnActionShowOptionMenu() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.registerOnActionShowOptionMenu()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__SHOW_OPTIONS,
                (ActionEvent event) -> {
                    final Object source = event.getSource();
                    if (source instanceof TransferData) {
                        final TransferData      transferData = (TransferData) source;
                        final Optional<Boolean> optional     = transferData.getBoolean();
                        if(optional.isPresent()) {
                            final boolean showOptionMenu = optional.get();
                            this.onActionShowOptionMenu(showOptionMenu);
                        }
                    }
                });
    }

    private void registerOnActionUpdateColorInApplicationOptions() {
        LoggerFacade.getDefault().info(this.getClass(), "ApplicationPresenter.registerOnActionUpdateColorInApplicationOptions()"); // NOI18N
        
        ActionHandlerFacade.getDefault().register(
                ON_ACTION__UPDATE__COLOR_IN_APPLICATION_OPTIONS,
                (ActionEvent event) -> {
                    this.onActionUpdateColorInApplicationOptions();
                });
    }
    
}
