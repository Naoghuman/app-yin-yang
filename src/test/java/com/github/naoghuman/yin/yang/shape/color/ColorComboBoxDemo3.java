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
package com.github.naoghuman.yin.yang.shape.color;

import javafx.application.Application;
import static javafx.application.Application.launch;
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
 *
 * @author Naoghuman
 * @since 0.1.0
 */
public class ColorComboBoxDemo3 extends Application {
    
//    ObservableList<String> data = FXCollections.observableArrayList(
//            "255, 255, 255", // first row
//            "242, 242, 242",
//            "230, 230, 230",
//            "204, 204, 204",
//            "179, 179, 179",
//            "153, 153, 153",
//            "128, 128, 128",
//            "102, 102, 102",
//            "77, 77, 77",
//            "51, 51, 51",
//            "26, 26, 26",
//            "0, 0, 0",
//            
//            "0, 51, 51", // second row
//            "0, 26, 128",
//            "26, 0, 104",
//            "51, 0, 51",
//            "77, 0, 26",
//            "153, 0, 0",
//            "153, 51, 0",
//            "153, 77, 0",
//            "153, 102, 0",
//            "153, 153, 0",
//            "102, 102, 0",
//            "0, 51, 0",
//            
//            "26, 77, 77", // third row
//            "26, 51, 153",
//            "51, 26, 128",
//            "77, 26, 77",
//            "102, 26, 51",
//            "179, 26, 26",
//            "179, 77, 26",
//            "179, 102, 26",
//            "179, 128, 26",
//            "179, 179, 26",
//            "128, 128, 26",
//            "26, 77, 26",
//            
//            "51, 102, 102", // fourth row
//            "51, 77, 179",
//            "77, 51, 153",
//            "102, 51, 102",
//            "128, 51, 77",
//            "204, 51, 51",
//            "204, 102, 51",
//            "204, 128, 51",
//            "204, 153, 51",
//            "204, 204, 51",
//            "153, 153, 51",
//            "51, 102, 51",
//            
//            "77, 128, 128", // fifth row
//            "77, 102, 204",
//            "102, 77, 179",
//            "128, 77, 128",
//            "153, 77, 102",
//            "230, 77, 77",
//            "230, 128, 77",
//            "230, 153, 77",
//            "230, 179, 77",
//            "230, 230, 77",
//            "179, 179, 77",
//            "77, 128, 77",
//            
//            "102, 153, 153", // sixth row
//            "102, 128, 230",
//            "128, 102, 204",
//            "153, 102, 153",
//            "179, 102, 128",
//            "255, 102, 102",
//            "255, 153, 102",
//            "255, 179, 102",
//            "255, 204, 102",
//            "255, 255, 77",
//            "204, 204, 102",
//            "102, 153, 102",
//            
//            "128, 179, 179", // seventh row
//            "128, 153, 255",
//            "153, 128, 230",
//            "179, 128, 179",
//            "204, 128, 153",
//            "255, 128, 128",
//            "255, 153, 128",
//            "255, 204, 128",
//            "255, 230, 102",
//            "255, 255, 102",
//            "230, 230, 128",
//            "128, 179, 128",
//            
//            "153, 204, 204", // eigth row
//            "153, 179, 255",
//            "179, 153, 255",
//            "204, 153, 204",
//            "230, 153, 179",
//            "255, 153, 153",
//            "255, 179, 128",
//            "255, 204, 153",
//            "255, 230, 128",
//            "255, 255, 128",
//            "230, 230, 153",
//            "153, 204, 153",
//            
//            "179, 230, 230", // ninth row
//            "179, 204, 255",
//            "204, 179, 255",
//            "230, 179, 230",
//            "230, 179, 204",
//            "255, 179, 179",
//            "255, 179, 153",
//            "255, 230, 179",
//            "255, 230, 153",
//            "255, 255, 153",
//            "230, 230, 179",
//            "179, 230, 179",
//            
//            "204, 255, 255", // tenth row
//            "204, 230, 255",
//            "230, 204, 255",
//            "255, 204, 255",
//            "255, 204, 230",
//            "255, 204, 204",
//            "255, 204, 179",
//            "255, 230, 204",
//            "255, 255, 179",
//            "255, 255, 204",
//            "230, 230, 204",
//            "204, 255, 204"
//    );
    
    ObservableList<String> data = FXCollections.observableArrayList(
            "255, 255, 255",
            "242, 242, 242",
            "230, 230, 230",
            "204, 204, 204",
            "179, 179, 179",
            "153, 153, 153",
            "128, 128, 128",
            "102, 102, 102",
            "77, 77, 77",
            "51, 51, 51",
            "26, 26, 26",
            "0, 0, 0",
            
            "0, 51, 51",
            "26, 77, 77",
            "51, 102, 102",
            "77, 128, 128",
            "102, 153, 153",
            "128, 179, 179",
            "153, 204, 204",
            "179, 230, 230",
            "204, 255, 255",
            
            "0, 26, 128",
            "26, 51, 153",
            "51, 77, 179",
            "77, 102, 204",
            "102, 128, 230",
            "128, 153, 255",
            "153, 179, 255",
            "179, 204, 255",
            "204, 230, 255",
            
            "26, 0, 104",
            "51, 26, 128",
            "77, 51, 153",
            "102, 77, 179",
            "128, 102, 204",
            "153, 128, 230",
            "179, 153, 255",
            "204, 179, 255",
            "230, 204, 255",
            
            "51, 0, 51",
            "77, 26, 77",
            "102, 51, 102",
            "128, 77, 128",
            "153, 102, 153",
            "179, 128, 179",
            "204, 153, 204",
            "230, 179, 230",
            "255, 204, 255",
            
            "77, 0, 26",
            "102, 26, 51",
            "128, 51, 77",
            "153, 77, 102",
            "179, 102, 128",
            "204, 128, 153",
            "230, 153, 179",
            "230, 179, 204",
            "255, 204, 230",
            
            "153, 0, 0",
            "179, 26, 26",
            "204, 51, 51",
            "230, 77, 77",
            "255, 102, 102",
            "255, 128, 128",
            "255, 153, 153",
            "255, 179, 179",
            "255, 204, 204",
            
            "153, 51, 0",
            "179, 77, 26",
            "204, 102, 51",
            "230, 128, 77",
            "255, 153, 102",
            "255, 153, 128",
            "255, 179, 128",
            "255, 179, 153",
            "255, 204, 179",
            
            "153, 77, 0",
            "179, 102, 26",
            "204, 128, 51",
            "230, 153, 77",
            "255, 179, 102",
            "255, 204, 128",
            "255, 204, 153",
            "255, 230, 179",
            "255, 230, 204",
            
            "153, 102, 0",
            "179, 128, 26",
            "204, 153, 51",
            "230, 179, 77",
            "255, 204, 102",
            "255, 230, 102",
            "255, 230, 128",
            "255, 230, 153",
            "255, 255, 179",
            
            "153, 153, 0",
            "179, 179, 26",
            "204, 204, 51",
            "230, 230, 77",
            "255, 255, 77",
            "255, 255, 102",
            "255, 255, 128",
            "255, 255, 153",
            "255, 255, 204",
            
            "102, 102, 0",
            "128, 128, 26",
            "153, 153, 51",
            "179, 179, 77",
            "204, 204, 102",
            "230, 230, 128",
            "230, 230, 153",
            "230, 230, 179",
            "230, 230, 204",
            
            "0, 51, 0",
            "26, 77, 26",
            "51, 102, 51",
            "77, 128, 77",
            "102, 153, 102",
            "128, 179, 128",
            "153, 204, 153",
            "179, 230, 179",
            "204, 255, 204"
    );

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        ComboBox cb = new ComboBox();

        cb.setPrefSize(150, 20);
        root.getChildren().add(cb);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.show();

        cb.setItems(data);
        
        cb.setButtonCell(new ListCell<String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                setText(null);
                
                if (item != null) {
                    setStyle(String.format("-fx-background-color:rgb(%s); -fx-background-insets:2.0;", item));
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
                                setText(null);

                                if (item != null) {
                                    setStyle(String.format("-fx-background-color:rgb(%s); -fx-background-insets:2.0;", item));
                                }
                            }
                };
                    
                return cell;
            }
        });
        
        System.out.println("w  :" + cb.getWidth());
        System.out.println("p-w:" + cb.getPrefWidth());
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
