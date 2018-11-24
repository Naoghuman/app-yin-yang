/*
 * Copyright (C) 2018 Naoghuman's dream
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
package com.github.naoghuman.app.yy.i18n;

import com.github.naoghuman.lib.i18n.core.I18NBindingBuilder;
import java.util.Optional;
import javafx.beans.binding.StringBinding;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Naoghuman
 */
public final class DefaultI18NBinding implements I18NBinding {

    @Override
    public void bindTo(final StringProperty stringProperty, final String key) {
        final Optional<StringBinding> stringBinding = I18NBindingBuilder.bind()
                .key(key)
                .build();
                
        if (stringBinding.isPresent()) {
            stringProperty.bind(stringBinding.get());
        }
    }
    
}
