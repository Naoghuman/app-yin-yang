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

import javafx.scene.paint.Color;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Naoghuman
 * @since  0.1.0
 */
public class ColorConverterTest {
    
    public ColorConverterTest() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testConvertToBrighter() {
        final StringBuilder sb = new StringBuilder();
        
        double opacity = 0.25d;
        Color c = Color.BLACK;
              c = Color.color(c.getRed(), c.getGreen(), c.getBlue(), opacity);
        double brightness = c.getBrightness();
               brightness = (brightness <= 0.8d) ? brightness + 0.1d : brightness - 0.1d;
                        c = Color.hsb(c.getHue(), c.getSaturation(), brightness, opacity);
        sb.append("rgba("); // NOI18N
        sb.append((int)(255 * c.getRed()));
        sb.append(","); // NOI18N
        sb.append((int)(255 * c.getGreen()));
        sb.append(","); // NOI18N
        sb.append((int)(255 * c.getBlue()));
        sb.append(","); // NOI18N
        sb.append(opacity);
        sb.append(")"); // NOI18N
        
        String color = "0, 0, 0";
        String result = ColorConverter.convertToBrighter(color, opacity);
        
        String expResult = sb.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertToBrighter2() {
        final StringBuilder sb = new StringBuilder();
        
        double opacity = 0.75d;
        Color c = Color.WHITE;
              c = Color.color(c.getRed(), c.getGreen(), c.getBlue(), opacity);
        double brightness = c.getBrightness();
               brightness = (brightness <= 0.8d) ? brightness + 0.1d : brightness - 0.1d;
                        c = Color.hsb(c.getHue(), c.getSaturation(), brightness, opacity);
        sb.append("rgba("); // NOI18N
        sb.append((int)(255 * c.getRed()));
        sb.append(","); // NOI18N
        sb.append((int)(255 * c.getGreen()));
        sb.append(","); // NOI18N
        sb.append((int)(255 * c.getBlue()));
        sb.append(","); // NOI18N
        sb.append(opacity);
        sb.append(")"); // NOI18N
        
        String color = "255, 255, 255";
        String result = ColorConverter.convertToBrighter(color, opacity);
        
        String expResult = sb.toString();
        assertEquals(expResult, result);
    }

    @Test
    public void testConvertToBrighter3() {
        final StringBuilder sb = new StringBuilder();
        
        double opacity = 0.55d;
        Color c = Color.rgb(255, 200, 155);
              c = Color.color(c.getRed(), c.getGreen(), c.getBlue(), opacity);
        double brightness = c.getBrightness();
               brightness = (brightness <= 0.8d) ? brightness + 0.1d : brightness - 0.1d;
                        c = Color.hsb(c.getHue(), c.getSaturation(), brightness, opacity);
        sb.append("rgba("); // NOI18N
        sb.append((int)(255 * c.getRed()));
        sb.append(","); // NOI18N
        sb.append((int)(255 * c.getGreen()));
        sb.append(","); // NOI18N
        sb.append((int)(255 * c.getBlue()));
        sb.append(","); // NOI18N
        sb.append(opacity);
        sb.append(")"); // NOI18N
        
        String color = "255, 200, 155";
        String result = ColorConverter.convertToBrighter(color, opacity);
        
        String expResult = sb.toString();
        assertEquals(expResult, result);
    }
    
}
