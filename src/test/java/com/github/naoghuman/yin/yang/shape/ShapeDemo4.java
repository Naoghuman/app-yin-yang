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

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Naoghuman
 */
public class ShapeDemo4 extends Application {
    

    public static void main(String[] args) {
        launch(args);
    }
    
  @Override
  public void start(Stage primaryStage) {
        Bounce bouncePane = new Bounce();
        bouncePane.setOnMousePressed(e -> bouncePane.increaseSpeed());

        Scene scene = new Scene(bouncePane, 250, 150);
        primaryStage.setTitle("Bouncing Ball");
        primaryStage.setScene(scene);
        primaryStage.show();
        bouncePane.requestFocus();
   }
}

class Bounce extends Pane {
  public final double rad = 25;
  private double x = rad, y = rad;
  private double dx = 1, dy = 1;
  private Circle ball = new Circle(x, y, rad);
  private Timeline anim;

  public Bounce() {
    ball.setFill(Color.BLUE);
    getChildren().add(ball);

    anim = new Timeline(
       new KeyFrame(Duration.millis(1000), e -> moveBall()));
    anim.setCycleCount(Timeline.INDEFINITE);
    anim.play();
  }

    public void increaseSpeed() {
      anim.setRate(anim.getRate() + 0.5);
      System.out.println(anim.getRate());
    }

    protected void moveBall() {

      if (x < rad || x > getWidth() - rad) {
        dx *= -1;
      }
      if (y < rad || y > getHeight() - rad) {
        dy *= -1;
      }

      x += dx;
      y += dy;
      ball.setCenterX(x);
      ball.setCenterY(y);
      increaseSpeed();
    }
    
}
