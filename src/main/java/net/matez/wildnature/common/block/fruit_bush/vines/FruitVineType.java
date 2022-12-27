/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.fruit_bush.vines;

import net.matez.wildnature.common.item.fruits.Fruit;
import net.matez.wildnature.core.registry.WNItems;
import net.matez.wildnature.core.other.WNTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

public enum FruitVineType {
    GRAPE_VINE_PURPLE("grape_vine_purple","grape_vine", MaterialColor.PLANT, () -> new ItemStack(WNItems.FRUITS.get(Fruit.PURPLE_GRAPES))),
    GRAPE_VINE_YELLOW("grape_vine_yellow","grape_vine", MaterialColor.PLANT, () -> new ItemStack(WNItems.FRUITS.get(Fruit.YELLOW_GRAPES)))

    ;
    //?------------------------------

    private final String idBase;
    private final String folder;
    private final MaterialColor color;
    private CreativeModeTab tab = WNTabs.TAB_SURFACE_PLANTS;
    private Supplier<ItemStack> drop;

    FruitVineType(String idBase, String folder, MaterialColor color, Supplier<ItemStack> drop){
        this.idBase = idBase;
        this.folder = folder;
        this.color = color;
        this.drop = drop;
    }

    public String getIdBase() {
        return idBase;
    }

    public String getFolder() {
        return folder;
    }

    public MaterialColor getColor() {
        return color;
    }

    public Supplier<ItemStack> getDrop() {
        return drop;
    }

    public CreativeModeTab getTab() {
        return tab;
    }
}
