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
package com.github.naoghuman.app.yy.taichi;

import com.github.naoghuman.app.yy.color.ColorMaterialDesign;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
public class TaiChiYangColors {
    
    private static final String SUFFIX_050 = "_050"; // NOI18N
    private static final String SUFFIX_100 = "_100"; // NOI18N
    private static final String SUFFIX_200 = "_200"; // NOI18N
    private static final String SUFFIX_300 = "_300"; // NOI18N
    private static final String SUFFIX_400 = "_400"; // NOI18N
    
    private static final ObservableList<ColorMaterialDesign> YANG_COLORS = FXCollections.observableArrayList();
    
    static {
        /*
         * Yang colors are all constants from MaterialDesign
         * with '_050', '_100', '_200', '_300' and '_400' in name().
         */
        for(final ColorMaterialDesign md : ColorMaterialDesign.values()) {
            if (
                       md.name().contains(SUFFIX_050)
                    || md.name().contains(SUFFIX_100)
                    || md.name().contains(SUFFIX_200)
                    || md.name().contains(SUFFIX_300)
                    || md.name().contains(SUFFIX_400)
            ) {
                YANG_COLORS.add(md);
            }
        }
    }
    
    public static ObservableList<ColorMaterialDesign> getColors() {
        return YANG_COLORS;
    }

}
