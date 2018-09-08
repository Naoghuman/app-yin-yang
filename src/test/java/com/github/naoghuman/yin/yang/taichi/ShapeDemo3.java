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
package com.github.naoghuman.yin.yang.taichi;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Naoghuman
 */
public class ShapeDemo3 extends Application {

    @Override
    public void start(Stage primaryStage) {
        
        Arc arc = new Arc();
        arc.setCenterX(150.0f);
        arc.setCenterY(150.0f);
        arc.setRadiusX(90.0f);
        arc.setRadiusY(90.0f);
        arc.setStartAngle(0.0f);
        arc.setLength(180.0f);
        arc.setType(ArcType.CHORD);
//        arc.setFill(Color.LIGHTGREEN);
//        arc.setStroke(Color.BLACK);
        arc.setStrokeWidth(4.0d);
        
        Circle cAdd = new Circle();
        cAdd.setRadius(45.0d);
        cAdd.setCenterX(150.0d + 45.0d);
        cAdd.setCenterY(150.0d);
//        c.setFill(Color.LIGHTCORAL);
//        c.setStroke(Color.BLUE);
        cAdd.setStrokeWidth(4.0d);
        
        Shape shape = Shape.union(arc, cAdd);
        
        Circle cMinus = new Circle();
        cMinus.setRadius(45.0d);
        cMinus.setCenterX(150.0d - 45.0d);
        cMinus.setCenterY(150.0d);
        cMinus.setStrokeWidth(4.0d);
        
        Shape shape2 = Shape.subtract(shape, cMinus);
        shape2.setFill(Color.LIGHTCORAL);
        shape2.setStroke(Color.BLUE);
        
        Rotate rotation = new Rotate();
        rotation.pivotXProperty().bind(arc.centerXProperty());
        rotation.pivotYProperty().bind(arc.centerYProperty());

        shape2.getTransforms().add(rotation);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.ZERO,       new KeyValue(rotation.angleProperty(), 0)),
                new KeyFrame(Duration.seconds(4), new KeyValue(rotation.angleProperty(), -360)));
        timeline.setCycleCount(Animation.INDEFINITE);
        
        Button button = new Button("Rotate");
        button.setOnAction(evt -> timeline.play());
        button.disableProperty().bind(
                timeline.statusProperty().isEqualTo(Animation.Status.RUNNING));

        HBox controls = new HBox(button);
        controls.setAlignment(Pos.CENTER);
        controls.setPadding(new Insets(12));

        Pane pane = new Pane(shape2);
        BorderPane root = new BorderPane(pane, null, null, controls, null);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
