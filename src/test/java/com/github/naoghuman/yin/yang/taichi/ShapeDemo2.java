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

import javafx.animation.RotateTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Naoghuman
 */
public class ShapeDemo2 extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        primaryStage.setScene(new Scene(root, 240, 240));

        Rectangle rect = new Rectangle(1, 1, 40, 40);
        rect.setFill(Color.BLUE);

        // comment movePivot to get the default rotation
        movePivot(rect, -20, -20);

        RotateTransition rt = new RotateTransition(Duration.seconds(4), rect);
        rt.setToAngle(720);
        rt.setCycleCount(Timeline.INDEFINITE);
        rt.setAutoReverse(true);

        primaryStage.show();
        
        rt.play();
    }

    // this is the function you want
    private void movePivot(Node node, double x, double y){
        node.getTransforms().add(new Translate(-x,-y));
        node.setTranslateX(x); node.setTranslateY(y);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
