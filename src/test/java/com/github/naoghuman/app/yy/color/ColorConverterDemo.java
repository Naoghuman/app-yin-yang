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

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Naoghuman
 * @since  0.2.0
 */
public class ColorConverterDemo extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }
    
    @Override
    public void start(final Stage stage) throws Exception {
        // yang = 204, 255, 204
        // yin  = 0, 0, 0
        
        Color c = Color.web("rgb(204, 255, 204)");
        System.out.println("r:"+c.getRed()+", g:"+c.getGreen()+", b:"+c.getBlue()+", o:"+c.getOpacity());
        
        c = Color.color(c.getRed(), c.getGreen(), c.getBlue(), 0.875d);
        System.out.println("r:"+c.getRed()+", g:"+c.getGreen()+", b:"+c.getBlue()+", o:"+c.getOpacity());
        
        c = Color.web(String.format("rgba(%d,%d,%d,%s)",
                (int)(255 * c.getRed()),
                (int)(255 * c.getGreen()),
                (int)(255 * c.getBlue()),
                ("" + 0.875)
        ));
        System.out.println("r:"+c.getRed()+", g:"+c.getGreen()+", b:"+c.getBlue()+", o:"+c.getOpacity());
        
        
    }
    
}
