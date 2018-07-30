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
package com.github.naoghuman.yin.yang.shape;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Naoghuman
 */
public class ShapeDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override 
   public void start(Stage stage) { 
        //Drawing an arc 
        Arc arc = new Arc();
        arc.setCenterX(300.0f);
        arc.setCenterY(150.0f);
        arc.setRadiusX(90.0f);
        arc.setRadiusY(90.0f);
        arc.setStartAngle(0.0f);
        arc.setLength(180.0f);
        arc.setType(ArcType.CHORD);
        arc.setFill(Color.LIGHTGREEN);
        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(4.0d);

        //Creating a Group object  
        Group root = new Group(arc);
        Scene scene = new Scene(root, 600, 300);  
        stage.setTitle("Drawing an Arc"); 
        stage.setScene(scene); 

        stage.show();
      
        // Rotate it
        RotateTransition  rotateTransition = new RotateTransition(
                Duration.millis(5000), arc);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
//        rotateTransition.setAutoReverse(false);

        rotateTransition.play();
   }
}