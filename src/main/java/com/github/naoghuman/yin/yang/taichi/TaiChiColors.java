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

import com.github.naoghuman.lib.action.core.RegisterActions;
import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.shape.Shape;

/**
 *
 * @author Naoghuman
 * @since  0.6.0
 */
public interface TaiChiColors extends RegisterActions {
    
    void initialize();

    public void register(final Labeled labeled, final TaiChiColorType type, final String actionId);
    public void register(final Node node, final String actionId);
    public void register(final Shape shape, final String actionId);

    @Override
    void register();
    
}
