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
import com.github.naoghuman.yin.yang.configuration.EventConfiguration;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public final class ColorComboBox implements EventConfiguration {
    
    private static final int INDEX_TO_REMOVE__YANG_SYMBOL = 11;
    private static final int INDEX_TO_REMOVE__YIN_SYMBOL  = 0;
    
    public ColorComboBox() {
        
    }
    
    public void configure(final ComboBox<String> comboBox, final ColorType type, final String selectedColor) {
        LoggerFacade.getDefault().debug(this.getClass(), "ColorComboBox.configure(ComboBox<String>, ColorType, String)"); // NOI18N
        
        this.configureComboBoxColors(comboBox, type);
        this.configureComboBoxButtonCell(comboBox);
        this.configureComboBoxCellFactory(comboBox);
        this.configureComboBoxValueProperty(comboBox, type);
        
        comboBox.getSelectionModel().select(selectedColor);
    }
    
    private void configureComboBoxColors(final ComboBox<String> comboBox, final ColorType type) {
        LoggerFacade.getDefault().debug(this.getClass(), "ColorComboBox.configureComboBoxColors(ComboBox<String>, ColorType)"); // NOI18N
        
        // TODO removes the color in COLORS, so both are removed.
        switch(type) {
            case YANG_SYMBOL: { Colors.getColors().remove(INDEX_TO_REMOVE__YANG_SYMBOL); break; }
            case YIN_SYMBOL:  { Colors.getColors().remove(INDEX_TO_REMOVE__YIN_SYMBOL);  break; }
        }
        
        comboBox.setItems(Colors.getColors());
    }
    
    private void configureComboBoxButtonCell(final ComboBox<String> comboBox) {
        LoggerFacade.getDefault().debug(this.getClass(), "ColorComboBox.configureComboBoxButtonCell(ComboBox<String>)"); // NOI18N
        
        comboBox.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                super.setText(null);
                
                if (item != null) {
                    super.setStyle(String.format("-fx-background-color:rgb(%s); -fx-background-insets:2.0;", item));
                }
            }
        });
    }
    
    private void configureComboBoxCellFactory(final ComboBox<String> comboBox) {
        LoggerFacade.getDefault().debug(this.getClass(), "ColorComboBox.configureComboBoxCellFactory(ComboBox<String>)"); // NOI18N
        
        comboBox.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                final ListCell<String> cell = new ListCell<String>() { 
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        super.setText(null);

                        if (item != null) {
                            super.setStyle(String.format("-fx-background-color:rgb(%s); -fx-background-insets:2.0;", item));
                        }
                    }
                };
                    
                return cell;
            }
        });
    }
    
    private void configureComboBoxValueProperty(final ComboBox<String> comboBox, final ColorType type) {
        LoggerFacade.getDefault().debug(this.getClass(), "ColorComboBox.configureComboBoxValueProperty(ComboBox<String>, ColorType)"); // NOI18N
        
        comboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Update yin, yang color
                String actionId = ON_ACTION__UNKNOWN_ACTION;
                switch(type) {
                    // TODO better is not enum.type, instead use actionId from configure(...) here
                    case YANG_SYMBOL: { actionId = ON_ACTION__UPDATE__YANG_COLOR; break; }
                    case YIN_SYMBOL:  { actionId = ON_ACTION__UPDATE__YIN_COLOR;  break; }
                }
                
                ActionHandlerFacade.getDefault()
                        .handle(TransferDataBuilder.create()
                                .actionId(actionId)
                                .stringValue(newValue)
                                .build());
            }
        });
    }
    
}
