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

package me.shedaniel.rei.impl.filtering;

import com.mojang.serialization.Lifecycle;
import me.shedaniel.rei.gui.config.entry.FilteringEntry;
import me.shedaniel.rei.impl.filtering.rules.ManualFilteringRule;
import me.shedaniel.rei.impl.filtering.rules.SearchFilteringRule;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.util.registry.SimpleRegistry;
import org.jetbrains.annotations.ApiStatus;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;

@ApiStatus.Internal
@ApiStatus.Experimental
@Environment(EnvType.CLIENT)
public interface FilteringRule<T extends FilteringRule<?>> {
    RegistryKey<Registry<FilteringRule<?>>> REGISTRY_KEY = RegistryKey.ofRegistry(new Identifier("roughlyenoughitems", "filtering_rule"));
    Registry<FilteringRule<?>> REGISTRY = createRegistry();
    
    @ApiStatus.Internal
    static Registry<FilteringRule<?>> createRegistry() {
        SimpleRegistry<FilteringRule<?>> registry = new SimpleRegistry<>(REGISTRY_KEY, Lifecycle.stable());
        Registry.register(registry, new Identifier("roughlyenoughitems", "search"), new SearchFilteringRule());
        Registry.register(registry, new Identifier("roughlyenoughitems", "manual"), new ManualFilteringRule());
        return registry;
    }
    
    static CompoundTag toTag(FilteringRule<?> rule, CompoundTag tag) {
        tag.putString("id", REGISTRY.getId(rule).toString());
        tag.put("rule", rule.toTag(new CompoundTag()));
        return tag;
    }
    
    static FilteringRule<?> fromTag(CompoundTag tag) {
        return REGISTRY.get(Identifier.tryParse(tag.getString("id"))).createFromTag(tag.getCompound("rule"));
    }
    
    CompoundTag toTag(CompoundTag tag);
    
    T createFromTag(CompoundTag tag);
    
    @NotNull
    FilteringResult processFilteredStacks(@NotNull FilteringContext context);
    
    @ApiStatus.Internal
    default Optional<BiFunction<FilteringEntry, Screen, Screen>> createEntryScreen() {
        return Optional.empty();
    }
    
    default Text getTitle() {
        return Text.method_30163(FilteringRule.REGISTRY.getId(this).toString());
    }
    
    default Text getSubtitle() {
        return Text.method_30163(null);
    }
    
    T createNew();
}
