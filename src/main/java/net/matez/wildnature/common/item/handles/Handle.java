/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.item.handles;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.function.Supplier;

public enum Handle {
    LEATHER_HANDLE("leather_handle",() -> Items.LEATHER),
    GOLDEN_HANDLE("golden_handle",() -> Items.GOLD_INGOT),
    STEEL_HANDLE("steel_handle",() -> Items.NETHERITE_INGOT);

    private String id;
    private Supplier<Item> item;

    Handle(String id, Supplier<Item> item) {
        this.id = id;
        this.item = item;
    }

    public String getId() {
        return id;
    }

    public Supplier<Item> getItem() {
        return item;
    }
}
