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
import static com.github.naoghuman.yin.yang.configuration.EventConfiguration.ON_ACTION__UPDATE__COLOR_IN_TERMS;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    
    // From ColorPicker (new ordered)
    private final ObservableList<String> COLORS = FXCollections.observableArrayList(
            "255, 255, 255", // White / Yang // NOI18N
            "242, 242, 242", // NOI18N
            "230, 230, 230", // NOI18N
            "204, 204, 204", // NOI18N
            "179, 179, 179", // NOI18N
            "153, 153, 153", // NOI18N
            "128, 128, 128", // NOI18N
            "102, 102, 102", // NOI18N
            "77, 77, 77", // NOI18N
            "51, 51, 51", // NOI18N
            "26, 26, 26", // NOI18N
            "0, 0, 0", // Black / Yin // NOI18N
            
            "0, 51, 51", // NOI18N
            "26, 77, 77", // NOI18N
            "51, 102, 102", // NOI18N
            "77, 128, 128", // NOI18N
            "102, 153, 153", // NOI18N
            "128, 179, 179", // NOI18N
            "153, 204, 204", // NOI18N
            "179, 230, 230", // NOI18N
            "204, 255, 255", // NOI18N
            
            "0, 26, 128", // NOI18N
            "26, 51, 153", // NOI18N
            "51, 77, 179", // NOI18N
            "77, 102, 204", // NOI18N
            "102, 128, 230", // NOI18N
            "128, 153, 255", // NOI18N
            "153, 179, 255", // NOI18N
            "179, 204, 255", // NOI18N
            "204, 230, 255", // NOI18N
            
            "26, 0, 104", // NOI18N
            "51, 26, 128", // NOI18N
            "77, 51, 153", // NOI18N
            "102, 77, 179", // NOI18N
            "128, 102, 204", // NOI18N
            "153, 128, 230", // NOI18N
            "179, 153, 255", // NOI18N
            "204, 179, 255", // NOI18N
            "230, 204, 255", // NOI18N
            
            "51, 0, 51", // NOI18N
            "77, 26, 77", // NOI18N
            "102, 51, 102", // NOI18N
            "128, 77, 128", // NOI18N
            "153, 102, 153", // NOI18N
            "179, 128, 179", // NOI18N
            "204, 153, 204", // NOI18N
            "230, 179, 230", // NOI18N
            "255, 204, 255", // NOI18N
            
            "77, 0, 26", // NOI18N
            "102, 26, 51", // NOI18N
            "128, 51, 77", // NOI18N
            "153, 77, 102", // NOI18N
            "179, 102, 128", // NOI18N
            "204, 128, 153", // NOI18N
            "230, 153, 179", // NOI18N
            "230, 179, 204", // NOI18N
            "255, 204, 230", // NOI18N
            
            "153, 0, 0", // NOI18N
            "179, 26, 26", // NOI18N
            "204, 51, 51", // NOI18N
            "230, 77, 77", // NOI18N
            "255, 102, 102", // NOI18N
            "255, 128, 128", // NOI18N
            "255, 153, 153", // NOI18N
            "255, 179, 179", // NOI18N
            "255, 204, 204", // NOI18N
            
            "153, 51, 0", // NOI18N
            "179, 77, 26", // NOI18N
            "204, 102, 51", // NOI18N
            "230, 128, 77", // NOI18N
            "255, 153, 102", // NOI18N
            "255, 153, 128", // NOI18N
            "255, 179, 128", // NOI18N
            "255, 179, 153", // NOI18N
            "255, 204, 179", // NOI18N
            
            "153, 77, 0", // NOI18N
            "179, 102, 26", // NOI18N
            "204, 128, 51", // NOI18N
            "230, 153, 77", // NOI18N
            "255, 179, 102", // NOI18N
            "255, 204, 128", // NOI18N
            "255, 204, 153", // NOI18N
            "255, 230, 179", // NOI18N
            "255, 230, 204", // NOI18N
            
            "153, 102, 0", // NOI18N
            "179, 128, 26", // NOI18N
            "204, 153, 51", // NOI18N
            "230, 179, 77", // NOI18N
            "255, 204, 102", // NOI18N
            "255, 230, 102", // NOI18N
            "255, 230, 128", // NOI18N
            "255, 230, 153", // NOI18N
            "255, 255, 179", // NOI18N
            
            "153, 153, 0", // NOI18N
            "179, 179, 26", // NOI18N
            "204, 204, 51", // NOI18N
            "230, 230, 77", // NOI18N
            "255, 255, 77", // NOI18N
            "255, 255, 102", // NOI18N
            "255, 255, 128", // NOI18N
            "255, 255, 153", // NOI18N
            "255, 255, 204", // NOI18N
            
            "102, 102, 0", // NOI18N
            "128, 128, 26", // NOI18N
            "153, 153, 51", // NOI18N
            "179, 179, 77", // NOI18N
            "204, 204, 102", // NOI18N
            "230, 230, 128", // NOI18N
            "230, 230, 153", // NOI18N
            "230, 230, 179", // NOI18N
            "230, 230, 204", // NOI18N
            
            "0, 51, 0", // NOI18N
            "26, 77, 26", // NOI18N
            "51, 102, 51", // NOI18N
            "77, 128, 77", // NOI18N
            "102, 153, 102", // NOI18N
            "128, 179, 128", // NOI18N
            "153, 204, 153", // NOI18N
            "179, 230, 179", // NOI18N
            "204, 255, 204" // NOI18N
    );
    
    public ColorComboBox() {
        this.initialize();
    }
    
    private void initialize() {
       LoggerFacade.getDefault().info(this.getClass(), "ColorComboBox.initialize()"); // NOI18N
       
    }
    
    public void configure(final ComboBox<String> comboBox, final Type type, final String selectedColor) {
        LoggerFacade.getDefault().debug(this.getClass(), "ColorComboBox.configure(ComboBox<String>, Type, String)"); // NOI18N
        
        this.configureComboBoxColors(comboBox, type);
        this.configureComboBoxButtonCell(comboBox);
        this.configureComboBoxCellFactory(comboBox);
        this.configureComboBoxValueProperty(comboBox, type);
        
        comboBox.getSelectionModel().select(selectedColor);
    }
    
    private void configureComboBoxColors(final ComboBox<String> comboBox, final Type type) {
        LoggerFacade.getDefault().debug(this.getClass(), "ColorComboBox.configureComboBoxColors(ComboBox<String>, Type)"); // NOI18N
        
        switch(type) {
            case YANG_SYMBOL: { COLORS.remove(INDEX_TO_REMOVE__YANG_SYMBOL); break; }
            case YIN_SYMBOL:  { COLORS.remove(INDEX_TO_REMOVE__YIN_SYMBOL);  break; }
        }
        
        comboBox.setItems(COLORS);
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
    
    private void configureComboBoxValueProperty(final ComboBox<String> comboBox, final Type type) {
        LoggerFacade.getDefault().debug(this.getClass(), "ColorComboBox.configureComboBoxValueProperty(ComboBox<String>, ColorType)"); // NOI18N
        
        comboBox.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                // Update yin, yang color
                String actionId = ON_ACTION__UNKNOWN_ACTION;
                switch(type) {
                    case YANG_SYMBOL: { actionId = ON_ACTION__UPDATE__COLOR_IN_YANG_SYMBOL; break; }
                    case YIN_SYMBOL:  { actionId = ON_ACTION__UPDATE__COLOR_IN_YIN_SYMBOL;  break;}
                }
                
                ActionHandlerFacade.getDefault()
                        .handle(TransferDataBuilder.create()
                                .actionId(actionId)
                                .stringValue(newValue)
                                .build());
                
                // Update colors
                ActionHandlerFacade.getDefault().handle(ON_ACTION__UPDATE__COLOR_IN_APPLICATION_OPTIONS);
                ActionHandlerFacade.getDefault().handle(ON_ACTION__UPDATE__COLOR_IN_TERMS);
            }
        });
    }
    
    public enum Type {
        
        YANG_SYMBOL,
        YIN_SYMBOL;
        
    }
    
}
