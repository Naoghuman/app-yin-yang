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

import com.github.naoghuman.yin.yang.taichi.TaiChiYangColors;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
public class TaiChiYangColorsDemo extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("##############################################");
        TaiChiYangColors.getColors()
                .forEach((materialDesign) -> {
                    System.out.println(materialDesign.name());
                });
        System.out.println("##############################################");
    }
    
    public static void main(final String[] arguments) {
       Application.launch(arguments);
    }
}
