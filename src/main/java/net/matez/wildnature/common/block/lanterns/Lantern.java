/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.lanterns;

import net.matez.wildnature.common.item.dust.DustItem;
import net.matez.wildnature.core.registry.WNItems;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public enum Lantern {
    GLOWSHROOM_LANTERN("glowshroom_lantern",12,() -> WNItems.DUSTS.get(DustItem.GLOWSHROOM_DUST).asItem()),
    ICESHROOM_LANTERN("iceshroom_lantern",8,() -> WNItems.DUSTS.get(DustItem.ICESHROOM_DUST).asItem());

    private final String id;
    private final int light;
    private final Supplier<Item> itemSupplier;

    Lantern(String id, int light, Supplier<Item> itemSupplier) {
        this.id = id;
        this.light = light;
        this.itemSupplier = itemSupplier;
    }

    public String getId() {
        return id;
    }

    public int getLight() {
        return light;
    }

    public Supplier<Item> getItemSupplier() {
        return itemSupplier;
    }
}
