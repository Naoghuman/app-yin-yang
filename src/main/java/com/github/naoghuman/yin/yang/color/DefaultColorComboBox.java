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
package com.github.naoghuman.yin.yang.color;

import com.github.naoghuman.lib.action.core.ActionHandlerFacade;
import com.github.naoghuman.lib.action.core.TransferDataBuilder;
import com.github.naoghuman.lib.logger.core.LoggerFacade;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
final class DefaultColorComboBox implements ColorComboBox {
    
    private static final String STYLE_BACKGROUND = "-fx-background-color:rgb(%s); -fx-background-insets:2.0;"; // NOI18N
    
    public DefaultColorComboBox() {
        
    }
    
    @Override
    public void configure(
            final ComboBox<ColorMaterialDesign> comboBox, final ObservableList<ColorMaterialDesign> colors,
            final ColorMaterialDesign selected, final String actionId
    ) {
        LoggerFacade.getDefault().debug(this.getClass(), "MaterialDesignComboBox.configure(ComboBox<MaterialDesign>, ObservableList<MaterialDesign>, MaterialDesign, String)"); // NOI18N
        
        this.configureComboBoxColors(comboBox, colors, selected);
        this.configureComboBoxButtonCell(comboBox);
        this.configureComboBoxCellFactory(comboBox);
        this.configureComboBoxValueProperty(comboBox, actionId);
    }
    
    private void configureComboBoxColors(final ComboBox<ColorMaterialDesign> comboBox, final ObservableList<ColorMaterialDesign> colors, final ColorMaterialDesign selected) {
        LoggerFacade.getDefault().debug(this.getClass(), "MaterialDesignComboBox.configureComboBoxColors(ComboBox<MaterialDesign>, ObservableList<MaterialDesign>, MaterialDesign)"); // NOI18N
        
        comboBox.setItems(colors);
        comboBox.getSelectionModel().select(selected);
    }
    
    private void configureComboBoxButtonCell(final ComboBox<ColorMaterialDesign> comboBox) {
        LoggerFacade.getDefault().debug(this.getClass(), "ColorComboBox.configureComboBoxButtonCell(ComboBox<MaterialDesign>)"); // NOI18N
        
        comboBox.setButtonCell(new ListCell<ColorMaterialDesign>() {
            @Override
            protected void updateItem(ColorMaterialDesign item, boolean empty) {
                super.updateItem(item, empty);
                super.setText(null);
                
                if (item != null) {
                    super.setStyle(String.format(STYLE_BACKGROUND, item.rgb()));
                }
            }
        });
    }
    
    private void configureComboBoxCellFactory(final ComboBox<ColorMaterialDesign> comboBox) {
        LoggerFacade.getDefault().debug(this.getClass(), "ColorComboBox.configureComboBoxCellFactory(ComboBox<MaterialDesign>)"); // NOI18N
        
        comboBox.setCellFactory(new Callback<ListView<ColorMaterialDesign>, ListCell<ColorMaterialDesign>>() {
            @Override
            public ListCell<ColorMaterialDesign> call(ListView<ColorMaterialDesign> param) {
                final ListCell<ColorMaterialDesign> cell = new ListCell<ColorMaterialDesign>() { 
                    @Override
                    public void updateItem(ColorMaterialDesign item, boolean empty) {
                        super.updateItem(item, empty);
                        super.setText(null);

                        if (item != null) {
                            // TODO style will be getted from styleconverter
                            super.setStyle(String.format(STYLE_BACKGROUND, item.rgb()));
                        }
                    }
                };
                    
                return cell;
            }
        });
    }
    
    private void configureComboBoxValueProperty(final ComboBox<ColorMaterialDesign> comboBox, final String actionId) {
        LoggerFacade.getDefault().debug(this.getClass(), "ColorComboBox.configureComboBoxValueProperty(ComboBox<MaterialDesign>, String)"); // NOI18N
        
        comboBox.valueProperty().addListener(new ChangeListener<ColorMaterialDesign>() {
            @Override
            public void changed(ObservableValue<? extends ColorMaterialDesign> observable, ColorMaterialDesign oldValue, ColorMaterialDesign newValue) {
                ActionHandlerFacade.getDefault()
                        .handle(TransferDataBuilder.create()
                                .actionId(actionId)
//                                .objectValue(newValue) // TODO
                                .stringValue(newValue.rgb())
                                .build());
            }
        });
    }
    
}
