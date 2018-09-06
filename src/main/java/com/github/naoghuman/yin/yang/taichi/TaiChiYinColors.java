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

import com.github.naoghuman.yin.yang.color.ColorMaterialDesign;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
public class TaiChiYinColors {
    
    private static final String SUFFIX_500 = "_500"; // NOI18N
    private static final String SUFFIX_600 = "_600"; // NOI18N
    private static final String SUFFIX_700 = "_700"; // NOI18N
    private static final String SUFFIX_800 = "_800"; // NOI18N
    private static final String SUFFIX_900 = "_900"; // NOI18N
    
    private static final ObservableList<ColorMaterialDesign> YIN_COLORS = FXCollections.observableArrayList();
    
    static {
        /*
        * Yin colors are all constants from MaterialDesign
        * with '_500', '_600', '_700', '_800' and '_900' in name().
        */
        for(final ColorMaterialDesign md : ColorMaterialDesign.values()) {
            if (
                       md.name().contains(SUFFIX_500)
                    || md.name().contains(SUFFIX_600)
                    || md.name().contains(SUFFIX_700)
                    || md.name().contains(SUFFIX_800)
                    || md.name().contains(SUFFIX_900)
            ) {
                YIN_COLORS.add(md);
            }
        }
    }
    
    public static ObservableList<ColorMaterialDesign> getColors() {
        return YIN_COLORS;
    }
    
}
