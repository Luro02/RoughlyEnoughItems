/*
 * This file is licensed under the MIT License, part of Roughly Enough Items.
 * Copyright (c) 2018, 2019, 2020 shedaniel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package me.shedaniel.rei.api.widgets;

import me.shedaniel.rei.api.REIHelper;
import me.shedaniel.rei.gui.widget.WidgetWithBounds;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.function.Predicate;

public abstract class Panel extends WidgetWithBounds {
    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public abstract int getInnerColor();
    
    @Deprecated
    @ApiStatus.ScheduledForRemoval
    public abstract void setInnerColor(int innerColor);
    
    @Deprecated
    @ApiStatus.ScheduledForRemoval
    @NotNull
    public final Panel innerColor(int innerColor) {
        setInnerColor(innerColor);
        return this;
    }
    
    @Deprecated
    @ApiStatus.ScheduledForRemoval
    @NotNull
    public final Panel innerColor(int lightColor, int darkColor) {
        return innerColor(REIHelper.getInstance().isDarkThemeEnabled() ? darkColor : lightColor);
    }
    
    public abstract int getXTextureOffset();
    
    public abstract void setXTextureOffset(int xTextureOffset);
    
    @NotNull
    public final Panel xTextureOffset(int xTextureOffset) {
        setXTextureOffset(xTextureOffset);
        return this;
    }
    
    public abstract int getYTextureOffset();
    
    public abstract void setYTextureOffset(int yTextureOffset);
    
    @NotNull
    public final Panel yTextureOffset(int yTextureOffset) {
        setYTextureOffset(yTextureOffset);
        return this;
    }
    
    public abstract int getColor();
    
    public abstract void setColor(int color);
    
    @NotNull
    public final Panel color(int color) {
        setColor(color);
        return this;
    }
    
    @NotNull
    public final Panel color(int lightColor, int darkColor) {
        return color(REIHelper.getInstance().isDarkThemeEnabled() ? darkColor : lightColor);
    }
    
    @NotNull
    public abstract Predicate<Panel> getRendering();
    
    public abstract void setRendering(@NotNull Predicate<Panel> rendering);
    
    @NotNull
    public final Panel rendering(@NotNull Predicate<Panel> rendering) {
        setRendering(rendering);
        return this;
    }
}
