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
package com.github.naoghuman.app.yy.color;

import static java.lang.System.err;
import java.lang.reflect.Field;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.stage.Stage;

/**
 * Simple JavaFX 2 application that prints out values of standardly available
 * Color fields.
 * 
 * https://dzone.com/articles/viewing-javafx-2-standard
 * 
 * @author Dustin
 */
public class JavaFxColorDemo extends Application
{
   /** Width of label for colorn name. */
   private final static int COLOR_NAME_WIDTH = 150;
   /** Width of rectangle that displays color. */
   private final static int COLOR_RECT_WIDTH = 50;
   /** Height of rectangle that displays color. */
   private final static int COLOR_RECT_HEIGHT = 25;

   private final TextField redField = TextFieldBuilder.create()
      .text("Red Value").build();
   private final TextField greenField = TextFieldBuilder.create()
      .text("Green Value").build();
   private final TextField blueField = TextFieldBuilder.create()
      .text("Blue Value").build();
   private final Rectangle customColorRectangle = RectangleBuilder.create()
      .width(COLOR_RECT_WIDTH).height(COLOR_RECT_HEIGHT)
      .fill(Color.WHITE).stroke(Color.BLACK).build();

   /**
    * Build a pane containing details about the instance of Color provided.
    * 
    * @param color Instance of Color about which generated Pane should describe.
    * @return Pane representing information on provided Color instance.
    */
   private Pane buildColorBox(final Color color, final String colorName)
   {
      final HBox colorBox = new HBox();
      final Label colorNameLabel = new Label(colorName);
      colorNameLabel.setMinWidth(COLOR_NAME_WIDTH);
      colorBox.getChildren().add(colorNameLabel);
      final Rectangle colorRectangle = new Rectangle(COLOR_RECT_WIDTH, COLOR_RECT_HEIGHT);
      colorRectangle.setFill(color);
      colorRectangle.setStroke(Color.BLACK);
      colorBox.getChildren().add(colorRectangle);
      final String rgbString =
           String.valueOf(color.getRed())
         + " / " + String.valueOf(color.getGreen())
         + " / " + String.valueOf(color.getBlue())
         + " // " + String.valueOf(color.getOpacity());
      final Label rgbLabel = new Label(rgbString);
      rgbLabel.setTooltip(new Tooltip("Red / Green / Blue // Opacity"));
      colorBox.getChildren().add(rgbLabel);
      return colorBox;
   }

   /**
    * Extracts a double between 0.0 and 1.0 inclusive from the provided String.
    * 
    * @param colorString String from which a double is extracted.
    * @return Double between 0.0 and 1.0 inclusive based on provided String;
    *    will be 0.0 if provided String cannot be parsed.
    */
   private double extractValidColor(final String colorString)
   {
      double colorValue = 0.0;
      try
      {
         colorValue = Double.valueOf(colorString);
      }
      catch (Exception exception)
      {
         colorValue = 0.0;
         err.println("Treating '" + colorString + "' as " + colorValue);
      }
      finally
      {
         if (colorValue < 0)
         {
            colorValue = 0.0;
            err.println("Treating '" + colorString + "' as " + colorValue);
         }
         else if (colorValue > 1)
         {
            colorValue = 1.0;
            err.println("Treating '" + colorString + "' as " + colorValue);
         }
      }
      return colorValue;
   }

   /**
    * Build pane with ability to specify own RGB values and see color.
    * 
    * @return Pane with ability to specify colors.
    */
   private Pane buildCustomColorPane()
   {
      final HBox customBox = new HBox();
      final Button button = new Button("Display Color");
      button.setPrefWidth(COLOR_NAME_WIDTH);
      button.setOnMouseClicked(new EventHandler<MouseEvent>()
      {
         @Override
         public void handle(MouseEvent t)
         {
            final Color customColor =
               new Color(extractValidColor(redField.getText()),
                         extractValidColor(greenField.getText()),
                         extractValidColor(blueField.getText()),
                         1.0);
            customColorRectangle.setFill(customColor);
         }
      });
      customBox.getChildren().add(button);
      customBox.getChildren().add(this.customColorRectangle);
      customBox.getChildren().add(this.redField);
      customBox.getChildren().add(this.greenField);
      customBox.getChildren().add(this.blueField);
      return customBox;
   }

   /**
    * Build the main pane indicating JavaFX 2's pre-defined Color instances.
    * 
    * @return Pane containing JavaFX 2's pre-defined Color instances.
    */
   private Pane buildColorsPane()
   {
      final VBox colorsPane = new VBox();
      final Field[] fields = Color.class.getFields(); // only want public
      for (final Field field : fields)
      {
         if (field.getType() == Color.class)
         {
            try
            {
               final Color color = (Color) field.get(null);
               final String colorName = field.getName();
               colorsPane.getChildren().add(buildColorBox(color, colorName));
            }
            catch (IllegalAccessException illegalAccessEx)
            {
               err.println(
                  "Securty Manager does not allow access of field '"
                  + field.getName() + "'.");
            }
         }
      }
      colorsPane.getChildren().add(buildCustomColorPane());
      return colorsPane;
   }

   /**
    * Start method overridden from parent Application class.
    * 
    * @param stage Primary stage.
    * @throws Exception JavaFX application exception.
    */
   @Override
   public void start(final Stage stage) throws Exception
   {
      final Group rootGroup = new Group();
      final Scene scene = new Scene(rootGroup, 700, 725, Color.WHITE);
      final ScrollPane scrollPane = new ScrollPane();
      scrollPane.setPrefWidth(scene.getWidth());
      scrollPane.setPrefHeight(scene.getHeight());
      scrollPane.setContent(buildColorsPane());
      rootGroup.getChildren().add(scrollPane);
      stage.setScene(scene);
      stage.setTitle("JavaFX Standard Colors Demonstration");
      stage.show();
   }

   /**
    * Main function for running JavaFX application.
    * 
    * @param arguments Command-line arguments; none expected.
    */
   public static void main(final String[] arguments)
   {
      Application.launch(arguments);
   }
}
