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

import com.github.naoghuman.lib.logger.core.LoggerFacade;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.scene.paint.Color;

/**
 * TODO separate the enum values/names/javafx-color.
 *  - outside from the package only name/javafx-color is available.
 *  - inside package all.
 * 
 * @author Naoghuman
 * @since  0.6.0
 */
public enum ColorMaterialDesign {
    
    // RED
    /**
     * The color RED with an RGB value of rgb(244, 67, 54).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(244, 67, 54);float:right;margin: 0 10px 0 0"></div>
     */
    RED(244, 67, 54),

    /**
     * The color RED 50 with an RGB value of rgb(255, 235, 238).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 235, 238);float:right;margin: 0 10px 0 0"></div>
     */
    RED_050(255, 235, 238),

    /**
     * The color RED 100 with an RGB value of rgb(255, 205, 210).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 205, 210);float:right;margin: 0 10px 0 0"></div>
     */
    RED_100(255, 205, 210),

    /**
     * The color RED 200 with an RGB value of rgb(239, 154, 154).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(239, 154, 154);float:right;margin: 0 10px 0 0"></div>
     */
    RED_200(239, 154, 154),

    /**
     * The color RED 300 with an RGB value of rgb(229, 115, 115).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(229, 115, 115);float:right;margin: 0 10px 0 0"></div>
     */
    RED_300(229, 115, 115),

    /**
     * The color RED 400 with an RGB value of rgb(239, 83, 80).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(239, 83, 80);float:right;margin: 0 10px 0 0"></div>
     */
    RED_400(239, 83, 80),

    /**
     * The color RED 500 with an RGB value of rgb(244, 67, 54).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(244, 67, 54);float:right;margin: 0 10px 0 0"></div>
     */
    RED_500(244, 67, 54),

    /**
     * The color RED 600 with an RGB value of rgb(229, 57, 53).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(229, 57, 53);float:right;margin: 0 10px 0 0"></div>
     */
    RED_600(229, 57, 53),

    /**
     * The color RED 700 with an RGB value of rgb(211, 47, 47).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(211, 47, 47);float:right;margin: 0 10px 0 0"></div>
     */
    RED_700(211, 47, 47),

    /**
     * The color RED 800 with an RGB value of rgb(198, 40, 40).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(198, 40, 40);float:right;margin: 0 10px 0 0"></div>
     */
    RED_800(198, 40, 40),

    /**
     * The color RED 900 with an RGB value of rgb(183, 28, 28).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(183, 28, 28);float:right;margin: 0 10px 0 0"></div>
     */
    RED_900(183, 28, 28),

    /**
     * The color RED A100 with an RGB value of rgb(255, 138, 128).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 138, 128);float:right;margin: 0 10px 0 0"></div>
     */
    RED_A100(255, 138, 128),

    /**
     * The color RED A200 with an RGB value of rgb(255, 82, 82).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 82, 82);float:right;margin: 0 10px 0 0"></div>
     */
    RED_A200(255, 82, 82),

    /**
     * The color RED A400 with an RGB value of rgb(255, 23, 68).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 23, 68);float:right;margin: 0 10px 0 0"></div>
     */
    RED_A400(255, 23, 68),

    /**
     * The color RED A700 with an RGB value of rgb(213, 0, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(213, 0, 0);float:right;margin: 0 10px 0 0"></div>
     */
    RED_A700(213, 0, 0),

    // PINK
    /**
     * The color PINK with an RGB value of rgb(233, 30, 99).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(233, 30, 99);float:right;margin: 0 10px 0 0"></div>
     */
    PINK(233, 30, 99),

    /**
     * The color PINK 50 with an RGB value of rgb(252, 228, 236).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(252, 228, 236);float:right;margin: 0 10px 0 0"></div>
     */
    PINK_050(252, 228, 236),

    /**
     * The color PINK 100 with an RGB value of rgb(248, 187, 208).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(248, 187, 208);float:right;margin: 0 10px 0 0"></div>
     */
    PINK_100(248, 187, 208),

    /**
     * The color PINK 200 with an RGB value of rgb(244, 143, 177).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(244, 143, 177);float:right;margin: 0 10px 0 0"></div>
     */
    PINK_200(244, 143, 177),

    /**
     * The color PINK 300 with an RGB value of rgb(240, 98, 146).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(240, 98, 146);float:right;margin: 0 10px 0 0"></div>
     */
    PINK_300(240, 98, 146),

    /**
     * The color PINK 400 with an RGB value of rgb(236, 64, 122).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(236, 64, 122);float:right;margin: 0 10px 0 0"></div>
     */
    PINK_400(236, 64, 122),

    /**
     * The color PINK 500 with an RGB value of rgb(233, 30, 99).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(233, 30, 99);float:right;margin: 0 10px 0 0"></div>
     */
    PINK_500(233, 30, 99),

    /**
     * The color PINK 600 with an RGB value of rgb(216, 27, 96).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(216, 27, 96);float:right;margin: 0 10px 0 0"></div>
     */
    PINK_600(216, 27, 96),

    /**
     * The color PINK 700 with an RGB value of rgb(194, 24, 91).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(194, 24, 91);float:right;margin: 0 10px 0 0"></div>
     */
    PINK_700(194, 24, 91),

    /**
     * The color PINK 800 with an RGB value of rgb(173, 20, 87).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(173, 20, 87);float:right;margin: 0 10px 0 0"></div>
     */
    PINK_800(173, 20, 87),

    /**
     * The color PINK 900 with an RGB value of rgb(136, 14, 79).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(136, 14, 79);float:right;margin: 0 10px 0 0"></div>
     */
    PINK_900(136, 14, 79),

    /**
     * The color PINK A100 with an RGB value of rgb(255, 128, 171).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 128, 171);float:right;margin: 0 10px 0 0"></div>
     */
    PINK_A100(255, 128, 171),

    /**
     * The color PINK A200 with an RGB value of rgb(255, 64, 129).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 64, 129);float:right;margin: 0 10px 0 0"></div>
     */
    PINK_A200(255, 64, 129),

    /**
     * The color PINK A400 with an RGB value of rgb(245, 0, 87).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(245, 0, 87);float:right;margin: 0 10px 0 0"></div>
     */
    PINK_A400(245, 0, 87),

    /**
     * The color PINK A700 with an RGB value of rgb(197, 17, 98).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(197, 17, 98);float:right;margin: 0 10px 0 0"></div>
     */
    PINK_A700(197, 17, 98),

    // PURPLE
    /**
     * The color PURPLE with an RGB value of rgb(156, 39, 176).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(156, 39, 176);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE(156, 39, 176),

    /**
     * The color PURPLE 50 with an RGB value of rgb(243, 229, 245).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(243, 229, 245);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE_050(243, 229, 245),

    /**
     * The color PURPLE 100 with an RGB value of rgb(225, 190, 231).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(225, 190, 231);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE_100(225, 190, 231),

    /**
     * The color PURPLE 200 with an RGB value of rgb(206, 147, 216).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(206, 147, 216);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE_200(206, 147, 216),

    /**
     * The color PURPLE 300 with an RGB value of rgb(186, 104, 200).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(186, 104, 200);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE_300(186, 104, 200),

    /**
     * The color PURPLE 400 with an RGB value of rgb(171, 71, 188).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(171, 71, 188);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE_400(171, 71, 188),

    /**
     * The color PURPLE 500 with an RGB value of rgb(156, 39, 176).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(156, 39, 176);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE_500(156, 39, 176),

    /**
     * The color PURPLE 600 with an RGB value of rgb(142, 36, 170).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(142, 36, 170);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE_600(142, 36, 170),

    /**
     * The color PURPLE 700 with an RGB value of rgb(123, 31, 162).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(123, 31, 162);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE_700(123, 31, 162),

    /**
     * The color PURPLE 800 with an RGB value of rgb(106, 27, 154).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(106, 27, 154);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE_800(106, 27, 154),

    /**
     * The color PURPLE 900 with an RGB value of rgb(74, 20, 140).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(74, 20, 140);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE_900(74, 20, 140),

    /**
     * The color PURPLE A100 with an RGB value of rgb(234, 128, 252).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(234, 128, 252);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE_A100(234, 128, 252),

    /**
     * The color PURPLE A200 with an RGB value of rgb(224, 64, 251).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(224, 64, 251);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE_A200(224, 64, 251),

    /**
     * The color PURPLE A400 with an RGB value of rgb(213, 0, 249).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(213, 0, 249);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE_A400(213, 0, 249),

    /**
     * The color PURPLE A700 with an RGB value of rgb(170, 0, 255).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(170, 0, 255);float:right;margin: 0 10px 0 0"></div>
     */
    PURPLE_A700(170, 0, 255),

    // DEEP PURPLE
    /**
     * The color DEEP PURPLE with an RGB value of rgb(103, 58, 183).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(103, 58, 183);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE(103, 58, 183),

    /**
     * The color DEEP PURPLE 50 with an RGB value of rgb(237, 231, 246).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(237, 231, 246);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE_050(237, 231, 246),

    /**
     * The color DEEP PURPLE 100 with an RGB value of rgb(209, 196, 233).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(209, 196, 233);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE_100(209, 196, 233),

    /**
     * The color DEEP PURPLE 200 with an RGB value of rgb(179, 157, 219).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(179, 157, 219);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE_200(179, 157, 219),

    /**
     * The color DEEP PURPLE 300 with an RGB value of rgb(149, 117, 205).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(149, 117, 205);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE_300(149, 117, 205),

    /**
     * The color DEEP PURPLE 400 with an RGB value of rgb(126, 87, 194).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(126, 87, 194);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE_400(126, 87, 194),

    /**
     * The color DEEP PURPLE 500 with an RGB value of rgb(103, 58, 183).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(103, 58, 183);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE_500(103, 58, 183),

    /**
     * The color DEEP PURPLE 600 with an RGB value of rgb(94, 53, 177).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(94, 53, 177);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE_600(94, 53, 177),

    /**
     * The color DEEP PURPLE 700 with an RGB value of rgb(81, 45, 168).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(81, 45, 168);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE_700(81, 45, 168),

    /**
     * The color DEEP PURPLE 800 with an RGB value of rgb(69, 39, 160).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(69, 39, 160);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE_800(69, 39, 160),

    /**
     * The color DEEP PURPLE 900 with an RGB value of rgb(49, 27, 146).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(49, 27, 146);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE_900(49, 27, 146),

    /**
     * The color DEEP PURPLE A100 with an RGB value of rgb(179, 136, 255).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(179, 136, 255);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE_A100(179, 136, 255),

    /**
     * The color DEEP PURPLE A200 with an RGB value of rgb(124, 77, 255).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(124, 77, 255);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE_A200(124, 77, 255),

    /**
     * The color DEEP PURPLE A400 with an RGB value of rgb(101, 31, 255).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(101, 31, 255);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE_A400(101, 31, 255),

    /**
     * The color DEEP PURPLE A700 with an RGB value of rgb(98, 0, 234).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(98, 0, 234);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_PURPLE_A700(98, 0, 234),

    // INDIGO
    /**
     * The color INDIGO with an RGB value of rgb(63, 81, 181).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(63, 81, 181);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO(63, 81, 181),

    /**
     * The color INDIGO 50 with an RGB value of rgb(232, 234, 246).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(232, 234, 246);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO_050(232, 234, 246),

    /**
     * The color INDIGO 100 with an RGB value of rgb(197, 202, 233).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(197, 202, 233);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO_100(197, 202, 233),

    /**
     * The color INDIGO 200 with an RGB value of rgb(159, 168, 218).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(159, 168, 218);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO_200(159, 168, 218),

    /**
     * The color INDIGO 300 with an RGB value of rgb(121, 134, 203).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(121, 134, 203);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO_300(121, 134, 203),

    /**
     * The color INDIGO 400 with an RGB value of rgb(92, 107, 192).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(92, 107, 192);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO_400(92, 107, 192),

    /**
     * The color INDIGO 500 with an RGB value of rgb(63, 81, 181).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(63, 81, 181);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO_500(63, 81, 181),

    /**
     * The color INDIGO 600 with an RGB value of rgb(57, 73, 171).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(57, 73, 171);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO_600(57, 73, 171),

    /**
     * The color INDIGO 700 with an RGB value of rgb(48, 63, 159).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(48, 63, 159);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO_700(48, 63, 159),

    /**
     * The color INDIGO 800 with an RGB value of rgb(40, 53, 147).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(40, 53, 147);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO_800(40, 53, 147),

    /**
     * The color INDIGO 900 with an RGB value of rgb(26, 35, 126).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(26, 35, 126);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO_900(26, 35, 126),

    /**
     * The color INDIGO A100 with an RGB value of rgb(140, 158, 255).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(140, 158, 255);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO_A100(140, 158, 255),

    /**
     * The color INDIGO A200 with an RGB value of rgb(83, 109, 254).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(83, 109, 254);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO_A200(83, 109, 254),

    /**
     * The color INDIGO A400 with an RGB value of rgb(61, 90, 254).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(61, 90, 254);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO_A400(61, 90, 254),

    /**
     * The color INDIGO A700 with an RGB value of rgb(48, 79, 254).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(48, 79, 254);float:right;margin: 0 10px 0 0"></div>
     */
    INDIGO_A700(48, 79, 254),

    // BLUE
    /**
     * The color BLUE with an RGB value of rgb(33, 150, 243).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(33, 150, 243);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE(33, 150, 243),

    /**
     * The color BLUE 50 with an RGB value of rgb(227, 242, 253).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(227, 242, 253);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_050(227, 242, 253),

    /**
     * The color BLUE 100 with an RGB value of rgb(187, 222, 251).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(187, 222, 251);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_100(187, 222, 251),

    /**
     * The color BLUE 200 with an RGB value of rgb(144, 202, 249).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(144, 202, 249);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_200(144, 202, 249),

    /**
     * The color BLUE 300 with an RGB value of rgb(100, 181, 246).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(100, 181, 246);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_300(100, 181, 246),

    /**
     * The color BLUE 400 with an RGB value of rgb(66, 165, 245).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(66, 165, 245);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_400(66, 165, 245),

    /**
     * The color BLUE 500 with an RGB value of rgb(33, 150, 243).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(33, 150, 243);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_500(33, 150, 243),

    /**
     * The color BLUE 600 with an RGB value of rgb(30, 136, 229).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(30, 136, 229);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_600(30, 136, 229),

    /**
     * The color BLUE 700 with an RGB value of rgb(25, 118, 210).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(25, 118, 210);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_700(25, 118, 210),

    /**
     * The color BLUE 800 with an RGB value of rgb(21, 101, 192).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(21, 101, 192);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_800(21, 101, 192),

    /**
     * The color BLUE 900 with an RGB value of rgb(13, 71, 161).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(13, 71, 161);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_900(13, 71, 161),

    /**
     * The color BLUE A100 with an RGB value of rgb(130, 177, 255).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(130, 177, 255);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_A100(130, 177, 255),

    /**
     * The color BLUE A200 with an RGB value of rgb(68, 138, 255).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(68, 138, 255);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_A200(68, 138, 255),

    /**
     * The color BLUE A400 with an RGB value of rgb(41, 121, 255).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(41, 121, 255);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_A400(41, 121, 255),

    /**
     * The color BLUE A700 with an RGB value of rgb(41, 98, 255).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(41, 98, 255);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_A700(41, 98, 255),

    // LIGHT_BLUE
    /**
     * The color LIGHT BLUE with an RGB value of rgb(3, 169, 244).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(3, 169, 244);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE(3, 169, 244),

    /**
     * The color LIGHT BLUE 50 with an RGB value of rgb(225, 245, 254).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(225, 245, 254);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE_050(225, 245, 254),

    /**
     * The color LIGHT BLUE 100 with an RGB value of rgb(179, 229, 252).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(179, 229, 252);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE_100(179, 229, 252),

    /**
     * The color LIGHT BLUE 200 with an RGB value of rgb(129, 212, 250).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(129, 212, 250);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE_200(129, 212, 250),

    /**
     * The color LIGHT BLUE 300 with an RGB value of rgb(79, 195, 247).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(79, 195, 247);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE_300(79, 195, 247),

    /**
     * The color LIGHT BLUE 400 with an RGB value of rgb(41, 182, 246).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(41, 182, 246);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE_400(41, 182, 246),

    /**
     * The color LIGHT BLUE 500 with an RGB value of rgb(3, 169, 244).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(3, 169, 244);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE_500(3, 169, 244),

    /**
     * The color LIGHT BLUE 600 with an RGB value of rgb(3, 155, 229).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(3, 155, 229);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE_600(3, 155, 229),

    /**
     * The color LIGHT BLUE 700 with an RGB value of rgb(2, 136, 209).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(2, 136, 209);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE_700(2, 136, 209),

    /**
     * The color LIGHT BLUE 800 with an RGB value of rgb(2, 119, 189).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(2, 119, 189);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE_800(2, 119, 189),

    /**
     * The color LIGHT BLUE 900 with an RGB value of rgb(1, 87, 155).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(1, 87, 155);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE_900(1, 87, 155),

    /**
     * The color LIGHT BLUE A100 with an RGB value of rgb(128, 216, 255).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(128, 216, 255);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE_A100(128, 216, 255),

    /**
     * The color LIGHT BLUE A200 with an RGB value of rgb(64, 196, 255).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(64, 196, 255);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE_A200(64, 196, 255),

    /**
     * The color LIGHT BLUE A400 with an RGB value of rgb(0, 176, 255).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 176, 255);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE_A400(0, 176, 255),

    /**
     * The color LIGHT BLUE A700 with an RGB value of rgb(0, 145, 234).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 145, 234);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_BLUE_A700(0, 145, 234),

    // CYAN
    /**
     * The color CYAN with an RGB value of rgb(0, 188, 212).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 188, 212);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN(0, 188, 212),

    /**
     * The color CYAN 50 with an RGB value of rgb(224, 247, 250).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(224, 247, 250);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN_050(224, 247, 250),

    /**
     * The color CYAN 100 with an RGB value of rgb(178, 235, 242).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(178, 235, 242);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN_100(178, 235, 242),

    /**
     * The color CYAN 200 with an RGB value of rgb(128, 222, 234).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(128, 222, 234);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN_200(128, 222, 234),

    /**
     * The color CYAN 300 with an RGB value of rgb(77, 208, 225).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(77, 208, 225);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN_300(77, 208, 225),

    /**
     * The color CYAN 400 with an RGB value of rgb(38, 198, 218).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(38, 198, 218);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN_400(38, 198, 218),

    /**
     * The color CYAN 500 with an RGB value of rgb(0, 188, 212).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 188, 212);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN_500(0, 188, 212),

    /**
     * The color CYAN 600 with an RGB value of rgb(0, 172, 193).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 172, 193);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN_600(0, 172, 193),

    /**
     * The color CYAN 700 with an RGB value of rgb(0, 151, 167).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 151, 167);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN_700(0, 151, 167),

    /**
     * The color CYAN 800 with an RGB value of rgb(0, 131, 143).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 131, 143);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN_800(0, 131, 143),

    /**
     * The color CYAN 900 with an RGB value of rgb(0, 96, 100).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 96, 100);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN_900(0, 96, 100),

    /**
     * The color CYAN A100 with an RGB value of rgb(132, 255, 255).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(132, 255, 255);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN_A100(132, 255, 255),

    /**
     * The color CYAN A200 with an RGB value of rgb(24, 255, 25).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(24, 255, 25);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN_A200(24, 255, 255),

    /**
     * The color CYAN A400 with an RGB value of rgb(0, 229, 255).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 229, 255);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN_A400(0, 229, 255),

    /**
     * The color CYAN A700 with an RGB value of rgb(0, 184, 212).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 184, 212);float:right;margin: 0 10px 0 0"></div>
     */
    CYAN_A700(0, 184, 212),

    // TEAL
    /**
     * The color TEAL with an RGB value of rgb(0, 150, 136).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 150, 136);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL(0, 150, 136),

    /**
     * The color TEAL 50 with an RGB value of rgb(224, 242, 241).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(224, 242, 241);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL_050(224, 242, 241),

    /**
     * The color TEAL 100 with an RGB value of rgb(178, 223, 219).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(178, 223, 219);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL_100(178, 223, 219),

    /**
     * The color TEAL 200 with an RGB value of rgb(128, 203, 196).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(128, 203, 196);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL_200(128, 203, 196),

    /**
     * The color TEAL 300 with an RGB value of rgb(77, 182, 172).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(77, 182, 172);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL_300(77, 182, 172),

    /**
     * The color TEAL 400 with an RGB value of rgb(38, 166, 154).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(38, 166, 154);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL_400(38, 166, 154),

    /**
     * The color TEAL 500 with an RGB value of rgb(0, 150, 136).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 150, 136);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL_500(0, 150, 136),

    /**
     * The color TEAL 600 with an RGB value of rgb(0, 137, 123).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 137, 123);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL_600(0, 137, 123),

    /**
     * The color TEAL 700 with an RGB value of rgb(0, 121, 107).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 121, 107);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL_700(0, 121, 107),

    /**
     * The color TEAL 800 with an RGB value of rgb(0, 105, 92).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 105, 92);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL_800(0, 105, 92),

    /**
     * The color TEAL 900 with an RGB value of rgb(0, 77, 64).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 77, 64);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL_900(0, 77, 64),

    /**
     * The color TEAL A100 with an RGB value of rgb(167, 255, 235).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(167, 255, 235);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL_A100(167, 255, 235),

    /**
     * The color TEAL A200 with an RGB value of rgb(100, 255, 218).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(100, 255, 218);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL_A200(100, 255, 218),

    /**
     * The color TEAL A400 with an RGB value of rgb(29, 233, 182).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(29, 233, 182);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL_A400(29, 233, 182),

    /**
     * The color TEAL A700 with an RGB value of rgb(0, 191, 165).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 191, 165);float:right;margin: 0 10px 0 0"></div>
     */
    TEAL_A700(0, 191, 165),

    // GREEN
    /**
     * The color GREEN with an RGB value of rgb(76, 175, 80).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(76, 175, 80);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN(76, 175, 80),

    /**
     * The color GREEN 50 with an RGB value of rgb(232, 245, 233).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(232, 245, 233);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN_050(232, 245, 233),

    /**
     * The color GREEN 100 with an RGB value of rgb(200, 230, 201).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(200, 230, 201);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN_100(200, 230, 201),

    /**
     * The color GREEN 200 with an RGB value of rgb(165, 214, 167).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(165, 214, 167);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN_200(165, 214, 167),

    /**
     * The color GREEN 300 with an RGB value of rgb(129, 199, 132).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(129, 199, 132);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN_300(129, 199, 132),

    /**
     * The color GREEN 400 with an RGB value of rgb(102, 187, 106).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(102, 187, 106);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN_400(102, 187, 106),

    /**
     * The color GREEN 500 with an RGB value of rgb(76, 175, 80).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(76, 175, 80);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN_500(76, 175, 80),

    /**
     * The color GREEN 600 with an RGB value of rgb(67, 160, 71).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(67, 160, 71);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN_600(67, 160, 71),

    /**
     * The color GREEN 700 with an RGB value of rgb(56, 142, 60).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(56, 142, 60);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN_700(56, 142, 60),

    /**
     * The color GREEN 800 with an RGB value of rgb(46, 125, 50).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(46, 125, 50);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN_800(46, 125, 50),

    /**
     * The color GREEN 900 with an RGB value of rgb(27, 94, 32).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(27, 94, 32);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN_900(27, 94, 32),

    /**
     * The color GREEN A100 with an RGB value of rgb(185, 246, 202).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(185, 246, 202);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN_A100(185, 246, 202),

    /**
     * The color GREEN A200 with an RGB value of rgb(105, 240, 174).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(105, 240, 174);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN_A200(105, 240, 174),

    /**
     * The color GREEN A400 with an RGB value of rgb(0, 230, 118).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 230, 118);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN_A400(0, 230, 118),

    /**
     * The color GREEN A700 with an RGB value of rgb(0, 200, 83).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(0, 200, 83);float:right;margin: 0 10px 0 0"></div>
     */
    GREEN_A700(0, 200, 83),

    // LIGHT_GREEN
    /**
     * The color LIGHT GREEN with an RGB value of rgb(139, 195, 74).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(139, 195, 74);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN(139, 195, 74),

    /**
     * The color LIGHT GREEN 50 with an RGB value of rgb(241, 248, 233).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(241, 248, 233);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN_050(241, 248, 233),

    /**
     * The color LIGHT GREEN 100 with an RGB value of rgb(220, 237, 200).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(220, 237, 200);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN_100(220, 237, 200),

    /**
     * The color LIGHT GREEN 200 with an RGB value of rgb(197, 225, 165).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(197, 225, 165);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN_200(197, 225, 165),

    /**
     * The color LIGHT GREEN 300 with an RGB value of rgb(174, 213, 129).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(174, 213, 129);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN_300(174, 213, 129),

    /**
     * The color LIGHT GREEN 400 with an RGB value of rgb(156, 204, 101).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(156, 204, 101);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN_400(156, 204, 101),

    /**
     * The color LIGHT GREEN 500 with an RGB value of rgb(139, 195, 74).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(139, 195, 74);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN_500(139, 195, 74),

    /**
     * The color LIGHT GREEN 600 with an RGB value of rgb(124, 179, 66).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(124, 179, 66);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN_600(124, 179, 66),

    /**
     * The color LIGHT GREEN 700 with an RGB value of rgb(104, 159, 56).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(104, 159, 56);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN_700(104, 159, 56),

    /**
     * The color LIGHT GREEN 800 with an RGB value of rgb(85, 139, 47).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(85, 139, 47);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN_800(85, 139, 47),

    /**
     * The color LIGHT GREEN 900 with an RGB value of rgb(51, 105, 30).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(51, 105, 30);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN_900(51, 105, 30),

    /**
     * The color LIGHT GREEN A100 with an RGB value of rgb(204, 255, 144).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(204, 255, 144);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN_A100(204, 255, 144),

    /**
     * The color LIGHT GREEN A200 with an RGB value of rgb(178, 255, 89).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(178, 255, 89);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN_A200(178, 255, 89),

    /**
     * The color LIGHT GREEN A400 with an RGB value of rgb(118, 255, 3).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(118, 255, 3);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN_A400(118, 255, 3),

    /**
     * The color LIGHT GREEN A700 with an RGB value of rgb(100, 221, 23).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(100, 221, 23);float:right;margin: 0 10px 0 0"></div>
     */
    LIGHT_GREEN_A700(100, 221, 23),

    //LIME
    /**
     * The color LIME with an RGB value of rgb(205, 220, 57).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(205, 220, 57);float:right;margin: 0 10px 0 0"></div>
     */
    LIME(205, 220, 57),

    /**
     * The color LIME 50 with an RGB value of rgb(249, 251, 231).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(249, 251, 231);float:right;margin: 0 10px 0 0"></div>
     */
    LIME_050(249, 251, 231),

    /**
     * The color LIME 100 with an RGB value of rgb(240, 244, 195).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(240, 244, 195);float:right;margin: 0 10px 0 0"></div>
     */
    LIME_100(240, 244, 195),

    /**
     * The color LIME 200 with an RGB value of rgb(230, 238, 156).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(230, 238, 156);float:right;margin: 0 10px 0 0"></div>
     */
    LIME_200(230, 238, 156),

    /**
     * The color LIME 300 with an RGB value of rgb(220, 231, 117).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(220, 231, 117);float:right;margin: 0 10px 0 0"></div>
     */
    LIME_300(220, 231, 117),

    /**
     * The color LIME 400 with an RGB value of rgb(212, 225, 87).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(212, 225, 87);float:right;margin: 0 10px 0 0"></div>
     */
    LIME_400(212, 225, 87),

    /**
     * The color LIME 500 with an RGB value of rgb(205, 220, 57).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(205, 220, 57);float:right;margin: 0 10px 0 0"></div>
     */
    LIME_500(205, 220, 57),

    /**
     * The color LIME 600 with an RGB value of rgb(192, 202, 51).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(192, 202, 51);float:right;margin: 0 10px 0 0"></div>
     */
    LIME_600(192, 202, 51),

    /**
     * The color LIME 700 with an RGB value of rgb(175, 180, 43).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(175, 180, 43);float:right;margin: 0 10px 0 0"></div>
     */
    LIME_700(175, 180, 43),

    /**
     * The color LIME 800 with an RGB value of rgb(158, 157, 36).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(158, 157, 36);float:right;margin: 0 10px 0 0"></div>
     */
    LIME_800(158, 157, 36),

    /**
     * The color LIME 900 with an RGB value of rgb(130, 119, 23).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(130, 119, 23);float:right;margin: 0 10px 0 0"></div>
     */
    LIME_900(130, 119, 23),

    /**
     * The color LIME A100 with an RGB value of rgb(244, 255, 129).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(244, 255, 129);float:right;margin: 0 10px 0 0"></div>
     */
    LIME_A100(244, 255, 129),

    /**
     * The color LIME A200 with an RGB value of rgb(238, 255, 65).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(238, 255, 65);float:right;margin: 0 10px 0 0"></div>
     */
    LIME_A200(238, 255, 65),

    /**
     * The color LIME A400 with an RGB value of rgb(198, 255, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(198, 255, 0);float:right;margin: 0 10px 0 0"></div>
     */
    LIME_A400(198, 255, 0),

    /**
     * The color LIME A700 with an RGB value of rgb(174, 234, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(174, 234, 0);float:right;margin: 0 10px 0 0"></div>
     */
    LIME_A700(174, 234, 0),

    // YELLOW
    /**
     * The color YELLOW with an RGB value of rgb(255, 235, 59).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 235, 59);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW(255, 235, 59),

    /**
     * The color YELLOW 50 with an RGB value of rgb(255, 253, 231).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 253, 231);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW_050(255, 253, 231),

    /**
     * The color YELLOW 100 with an RGB value of rgb(255, 249, 196).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 249, 196);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW_100(255, 249, 196),

    /**
     * The color YELLOW 200 with an RGB value of rgb(255, 245, 157).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 245, 157);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW_200(255, 245, 157),

    /**
     * The color YELLOW 300 with an RGB value of rgb(255, 241, 118).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 241, 118);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW_300(255, 241, 118),

    /**
     * The color YELLOW 400 with an RGB value of rgb(255, 238, 88).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 238, 88);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW_400(255, 238, 88),

    /**
     * The color YELLOW 500 with an RGB value of rgb(255, 235, 59).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 235, 59);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW_500(255, 235, 59),

    /**
     * The color YELLOW 600 with an RGB value of rgb(253, 216, 53).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(253, 216, 53);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW_600(253, 216, 53),

    /**
     * The color YELLOW 700 with an RGB value of rgb(251, 192, 45).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(251, 192, 45);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW_700(251, 192, 45),

    /**
     * The color YELLOW 800 with an RGB value of rgb(249, 168, 37).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(249, 168, 37);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW_800(249, 168, 37),

    /**
     * The color YELLOW 900 with an RGB value of rgb(245, 127, 23).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(245, 127, 23);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW_900(245, 127, 23),

    /**
     * The color YELLOW A100 with an RGB value of rgb(255, 255, 141).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 255, 141);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW_A100(255, 255, 141),

    /**
     * The color YELLOW A200 with an RGB value of rgb(255, 255, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 255, 0);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW_A200(255, 255, 0),

    /**
     * The color YELLOW A400 with an RGB value of rgb(255, 234, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 234, 0);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW_A400(255, 234, 0),

    /**
     * The color YELLOW A700 with an RGB value of rgb(255, 214, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 214, 0);float:right;margin: 0 10px 0 0"></div>
     */
    YELLOW_A700(255, 214, 0),

    // AMBER
    /**
     * The color AMBER with an RGB value of rgb(255, 193, 7).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 193, 7);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER(255, 193, 7),

    /**
     * The color AMBER 50 with an RGB value of rgb(255, 248, 225).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 248, 225);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER_050(255, 248, 225),

    /**
     * The color AMBER 100 with an RGB value of rgb(255, 249, 196).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 249, 196);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER_100(255, 249, 196),

    /**
     * The color AMBER 200 with an RGB value of rgb(255, 224, 130).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 224, 130);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER_200(255, 224, 130),

    /**
     * The color AMBER 300 with an RGB value of rgb(255, 213, 79).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 213, 79);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER_300(255, 213, 79),

    /**
     * The color AMBER 400 with an RGB value of rgb(255, 202, 40).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 202, 40);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER_400(255, 202, 40),

    /**
     * The color AMBER 500 with an RGB value of rgb(255, 193, 7).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 193, 7);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER_500(255, 193, 7),

    /**
     * The color AMBER 600 with an RGB value of rgb(255, 179, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 179, 0);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER_600(255, 179, 0),

    /**
     * The color AMBER 700 with an RGB value of rgb(255, 160, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 160, 0);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER_700(255, 160, 0),

    /**
     * The color AMBER 800 with an RGB value of rgb(255, 143, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 143, 0);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER_800(255, 143, 0),

    /**
     * The color AMBER 900 with an RGB value of rgb(255, 111, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 111, 0);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER_900(255, 111, 0),

    /**
     * The color AMBER A100 with an RGB value of rgb(255, 229, 127).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 229, 127);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER_A100(255, 229, 127),

    /**
     * The color AMBER A200 with an RGB value of rgb(255, 215, 64).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 215, 64);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER_A200(255, 215, 64),

    /**
     * The color AMBER A400 with an RGB value of rgb(255, 196, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 196, 0);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER_A400(255, 196, 0),

    /**
     * The color AMBER A700 with an RGB value of rgb(255, 171, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 171, 0);float:right;margin: 0 10px 0 0"></div>
     */
    AMBER_A700(255, 171, 0),

    // ORANGE
    /**
     * The color ORANGE with an RGB value of rgb(255, 152, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 152, 0);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE(255, 152, 0),

    /**
     * The color ORANGE 50 with an RGB value of rgb(255, 243, 224).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 243, 224);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE_050(255, 243, 224),

    /**
     * The color ORANGE 100 with an RGB value of rgb(255, 224, 178).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 224, 178);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE_100(255, 224, 178),

    /**
     * The color ORANGE 200 with an RGB value of rgb(255, 204, 128).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 204, 128);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE_200(255, 204, 128),

    /**
     * The color ORANGE 300 with an RGB value of rgb(255, 183, 77).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 183, 77);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE_300(255, 183, 77),

    /**
     * The color ORANGE 400 with an RGB value of rgb(255, 167, 38).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 167, 38);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE_400(255, 167, 38),

    /**
     * The color ORANGE 500 with an RGB value of rgb(255, 152, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 152, 0);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE_500(255, 152, 0),

    /**
     * The color ORANGE 600 with an RGB value of rgb(251, 140, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(251, 140, 0);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE_600(251, 140, 0),

    /**
     * The color ORANGE 700 with an RGB value of rgb(245, 124, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(245, 124, 0);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE_700(245, 124, 0),

    /**
     * The color ORANGE 800 with an RGB value of rgb(239, 108, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(239, 108, 0);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE_800(239, 108, 0),

    /**
     * The color ORANGE 900 with an RGB value of rgb(230, 81, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(230, 81, 0);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE_900(230, 81, 0),

    /**
     * The color ORANGE A100 with an RGB value of rgb(255, 209, 128).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 209, 128);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE_A100(255, 209, 128),

    /**
     * The color ORANGE A200 with an RGB value of rgb(255, 171, 64).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 171, 64);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE_A200(255, 171, 64),

    /**
     * The color ORANGE A400 with an RGB value of rgb(255, 145, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 145, 0);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE_A400(255, 145, 0),

    /**
     * The color ORANGE A700 with an RGB value of rgb(255, 109, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 109, 0);float:right;margin: 0 10px 0 0"></div>
     */
    ORANGE_A700(255, 109, 0),

    // DEEP_ORANGE
    /**
     * The color DEEP ORANGE with an RGB value of rgb(255, 87, 34).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 87, 34);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE(255, 87, 34),

    /**
     * The color DEEP ORANGE 50 with an RGB value of rgb(251, 233, 231).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(251, 233, 231);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE_050(251, 233, 231),

    /**
     * The color DEEP ORANGE 100 with an RGB value of rgb(255, 204, 188).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 204, 188);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE_100(255, 204, 188),

    /**
     * The color DEEP ORANGE 200 with an RGB value of rgb(255, 171, 145).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 171, 145);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE_200(255, 171, 145),

    /**
     * The color DEEP ORANGE 300 with an RGB value of rgb(255, 138, 101).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 138, 101);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE_300(255, 138, 101),

    /**
     * The color DEEP ORANGE 400 with an RGB value of rgb(255, 112, 67).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 112, 67);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE_400(255, 112, 67),

    /**
     * The color DEEP ORANGE 500 with an RGB value of rgb(255, 87, 34).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 87, 34);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE_500(255, 87, 34),

    /**
     * The color DEEP ORANGE 600 with an RGB value of rgb(244, 81, 30).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(244, 81, 30);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE_600(244, 81, 30),

    /**
     * The color DEEP ORANGE 700 with an RGB value of rgb(230, 74, 25).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(230, 74, 25);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE_700(230, 74, 25),

    /**
     * The color DEEP ORANGE 800 with an RGB value of rgb(216, 67, 21).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(216, 67, 21);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE_800(216, 67, 21),

    /**
     * The color DEEP ORANGE 900 with an RGB value of rgb(191, 54, 12).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(191, 54, 12);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE_900(191, 54, 12),

    /**
     * The color DEEP ORANGE A100 with an RGB value of rgb(255, 158, 128).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 158, 128);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE_A100(255, 158, 128),

    /**
     * The color DEEP ORANGE A200 with an RGB value of rgb(255, 110, 64).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 110, 64);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE_A200(255, 110, 64),

    /**
     * The color DEEP ORANGE A400 with an RGB value of rgb(255, 61, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(255, 61, 0);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE_A400(255, 61, 0),

    /**
     * The color DEEP ORANGE A700 with an RGB value of rgb(221, 44, 0).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(221, 44, 0);float:right;margin: 0 10px 0 0"></div>
     */
    DEEP_ORANGE_A700(221, 44, 0),

    // BROWN
    /**
     * The color BROWN with an RGB value of rgb(121, 85, 72).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(121, 85, 72);float:right;margin: 0 10px 0 0"></div>
     */
    BROWN(121, 85, 72),

    /**
     * The color BROWN 50 with an RGB value of rgb(239, 235, 233).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(239, 235, 233);float:right;margin: 0 10px 0 0"></div>
     */
    BROWN_050(239, 235, 233),

    /**
     * The color BROWN 100 with an RGB value of rgb(215, 204, 200).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(215, 204, 200);float:right;margin: 0 10px 0 0"></div>
     */
    BROWN_100(215, 204, 200),

    /**
     * The color BROWN 200 with an RGB value of rgb(188, 170, 164).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(188, 170, 164);float:right;margin: 0 10px 0 0"></div>
     */
    BROWN_200(188, 170, 164),

    /**
     * The color BROWN 300 with an RGB value of rgb(161, 136, 127).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(161, 136, 127);float:right;margin: 0 10px 0 0"></div>
     */
    BROWN_300(161, 136, 127),

    /**
     * The color BROWN 400 with an RGB value of rgb(141, 110, 99).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(141, 110, 99);float:right;margin: 0 10px 0 0"></div>
     */
    BROWN_400(141, 110, 99),

    /**
     * The color BROWN 500 with an RGB value of rgb(121, 85, 72).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(121, 85, 72);float:right;margin: 0 10px 0 0"></div>
     */
    BROWN_500(121, 85, 72),

    /**
     * The color BROWN 600 with an RGB value of rgb(109, 76, 65).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(109, 76, 65);float:right;margin: 0 10px 0 0"></div>
     */
    BROWN_600(109, 76, 65),

    /**
     * The color BROWN 700 with an RGB value of rgb(93, 64, 55).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(93, 64, 55);float:right;margin: 0 10px 0 0"></div>
     */
    BROWN_700(93, 64, 55),

    /**
     * The color BROWN 800 with an RGB value of rgb(78, 52, 46).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(78, 52, 46);float:right;margin: 0 10px 0 0"></div>
     */
    BROWN_800(78, 52, 46),

    /**
     * The color BROWN 900 with an RGB value of rgb(62, 39, 35).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(62, 39, 35);float:right;margin: 0 10px 0 0"></div>
     */
    BROWN_900(62, 39, 35),

    // GREY
    /**
     * The color GREY with an RGB value of rgb(158, 158, 158).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(158, 158, 158);float:right;margin: 0 10px 0 0"></div>
     */
    GREY(158, 158, 158),

    /**
     * The color GREY 50 with an RGB value of rgb(250, 250, 250).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(250, 250, 250);float:right;margin: 0 10px 0 0"></div>
     */
    GREY_050(250, 250, 250),

    /**
     * The color GREY 100 with an RGB value of rgb(245, 245, 245).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(245, 245, 245);float:right;margin: 0 10px 0 0"></div>
     */
    GREY_100(245, 245, 245),

    /**
     * The color GREY 200 with an RGB value of rgb(238, 238, 238).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(238, 238, 238);float:right;margin: 0 10px 0 0"></div>
     */
    GREY_200(238, 238, 238),

    /**
     * The color GREY 300 with an RGB value of rgb(224, 224, 224).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(224, 224, 224);float:right;margin: 0 10px 0 0"></div>
     */
    GREY_300(224, 224, 224),

    /**
     * The color GREY 400 with an RGB value of rgb(189, 189, 189).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(189, 189, 189);float:right;margin: 0 10px 0 0"></div>
     */
    GREY_400(189, 189, 189),

    /**
     * The color GREY 500 with an RGB value of rgb(158, 158, 158).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(158, 158, 158);float:right;margin: 0 10px 0 0"></div>
     */
    GREY_500(158, 158, 158),

    /**
     * The color GREY 600 with an RGB value of rgb(117, 117, 117).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(117, 117, 117);float:right;margin: 0 10px 0 0"></div>
     */
    GREY_600(117, 117, 117),

    /**
     * The color GREY 700 with an RGB value of rgb(97, 97, 97).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(97, 97, 97);float:right;margin: 0 10px 0 0"></div>
     */
    GREY_700(97, 97, 97),

    /**
     * The color GREY 800 with an RGB value of rgb(66, 66, 66).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(66, 66, 66);float:right;margin: 0 10px 0 0"></div>
     */
    GREY_800(66, 66, 66),

    /**
     * The color GREY 900 with an RGB value of rgb(33, 33, 33).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(33, 33, 33);float:right;margin: 0 10px 0 0"></div>
     */
    GREY_900(33, 33, 33),

    // BLUE GREY
    /**
     * The color BLUE GREY with an RGB value of rgb(96, 125, 139).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(96, 125, 139);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_GREY(96, 125, 139),

    /**
     * The color BLUE GREY 50 with an RGB value of rgb(236, 239, 241).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(236, 239, 241);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_GREY_050(236, 239, 241),

    /**
     * The color BLUE GREY 100 with an RGB value of rgb(207, 216, 220).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(207, 216, 220);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_GREY_100(207, 216, 220),

    /**
     * The color BLUE GREY 200 with an RGB value of rgb(176, 190, 197).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(176, 190, 197);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_GREY_200(176, 190, 197),

    /**
     * The color BLUE GREY 300 with an RGB value of rgb(144, 164, 174).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(144, 164, 174);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_GREY_300(144, 164, 174),

    /**
     * The color BLUE GREY 400 with an RGB value of rgb(120, 144, 156).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(120, 144, 156);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_GREY_400(120, 144, 156),

    /**
     * The color BLUE GREY 500 with an RGB value of rgb(96, 125, 139).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(96, 125, 139);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_GREY_500(96, 125, 139),

    /**
     * The color BLUE GREY 600 with an RGB value of rgb(84, 110, 122).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(84, 110, 122);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_GREY_600(84, 110, 122),

    /**
     * The color BLUE GREY 700 with an RGB value of rgb(69, 90, 100).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(69, 90, 100);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_GREY_700(69, 90, 100),

    /**
     * The color BLUE GREY 800 with an RGB value of rgb(55, 71, 79).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(55, 71, 79);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_GREY_800(55, 71, 79),

    /**
     * The color BLUE GREY 900 with an RGB value of rgb(38, 50, 56).
     * <div style="border:1px solid black;width:40px;height:20px;background-color:rgb(38, 50, 56);float:right;margin: 0 10px 0 0"></div>
     */
    BLUE_GREY_900(38, 50, 56);
    
    /**
     * Return the given MaterialDesign constant for 'name' or 'mdDefault' if 'name' 
     * can't parsed to a MaterialDesign constant.
     * <p>
     * The idea is to persist the MaterialDesign.XY.name() to the file Preferences.properties 
     * and restored it with this method.
     * 
     * @param name
     * @param colorMaterialDesign
     * @return
     */
    public static ColorMaterialDesign get(final String name, final ColorMaterialDesign colorMaterialDesign) {
        ColorMaterialDesign cmd;
        try {
            cmd = valueOf(name);
        } catch (IllegalArgumentException iae) {
            LoggerFacade.getDefault().warn(ColorMaterialDesign.class, "ColorMaterialDesign.get(String, ColorMaterialDesign)"); // NOI18N
            LoggerFacade.getDefault().warn(ColorMaterialDesign.class, String.format(
                    " - Can't convert %s to MaterialDesign constant, use default instead", name)); // NOI18N
        
            cmd = colorMaterialDesign;
        }
        
        return cmd;
    }
    
    public static ColorMaterialDesign get(final Color color) {
        final List<ColorMaterialDesign> colors = FXCollections.observableArrayList();
        colors.addAll(Arrays.asList(values()));
        
        ColorMaterialDesign colorMaterialDesign = null;
        for(ColorMaterialDesign cmd : colors) {
            final Color color2 = cmd.color();
            if (color.equals(color2)) {
                colorMaterialDesign = cmd;
                break;
            }
        }
        
        return colorMaterialDesign;
    }

    private final int red;
    private final int green;
    private final int blue;
    
    private final Color color;

    ColorMaterialDesign(final int red, final int green, final int blue) {
        this.red   = red;
        this.green = green;
        this.blue  = blue;
        
        color = Color.rgb(red, green, blue);
    }

    /**
     * Returns the JavaFX color for the given MaterialDesign constant.
     * 
     * @return
     */
    public Color color() {
        return color;
    }
    
    /**
     * Returns the 'red', 'green' and 'blue' values from this JavaFX color as
     * String with the format: '%s,%s,%s'
     * 
     * @return 
     */
    public String rgb() {
        return String.format("%s,%s,%s", red, green, blue);
    }
    
}
