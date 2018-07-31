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
package com.github.naoghuman.yin.yang.colorchooser;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * https://stackoverflow.com/questions/17447544/javafx-2-display-color-in-combobox
 * https://stackoverflow.com/questions/26319040/javafx-combobox-disappearing-items-after-select
 * https://docs.oracle.com/javafx/2/ui_controls/combo-box.htm
 *
 * @author Naoghuman
 * @since 0.1.0
 */
public class ColorComboBoxDemo2 extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        ComboBox cb = new ComboBox();

        cb.setPrefSize(150, 20);
        root.getChildren().add(cb);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();

        ObservableList<String> data = FXCollections.observableArrayList(
                "chocolate", "salmon", "Gold", "Coral", "darkorchid",
                "darkgoldenrod", "lightsalmon", "Black", "rosybrown", "blue",
                "blueviolet", "brown");
        cb.setItems(data);
        
        cb.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null) {
                    setText(item);
//                    setTextFill(Color.web(item));
                    setStyle(String.format("-fx-background-color:%s;", item));
                }
                else {
                    setText(null);
                }
            }
        });
        
        cb.setCellFactory(
            new Callback<ListView<String>, ListCell<String>>() {
                @Override public ListCell<String> call(ListView<String> param) {
                    final ListCell<String> cell = new ListCell<String>() {
                        {
                            super.setPrefWidth(100);
                        }    
                        @Override public void updateItem(String item, 
                            boolean empty) {
                                super.updateItem(item, empty);
                                if (item != null) {
                                    setText(item);
//                                    setTextFill(Color.web(item));
                                    setStyle(String.format("-fx-background-color:%s;", item));
                                }
                                else {
                                    setText(null);
                                }
                            }
                };
                    
                return cell;
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
