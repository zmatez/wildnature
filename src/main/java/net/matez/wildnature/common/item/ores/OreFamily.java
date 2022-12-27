/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.item.ores;

import net.matez.wildnature.common.item.tools.WNTier;
import net.matez.wildnature.core.registry.WNItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;

import javax.annotation.Nullable;

public enum OreFamily {
    AMBER("amber"),
    BRONZE("bronze", new WNTier(2, 350, 6.5f, 1F, -2.7f, 20, BlockTags.ANVIL, () -> Ingredient.of(WNItems.ORE_ITEMS.get(OreItem.BRONZE_INGOT)))),
    DARK_AMETHYST("dark_amethyst", new WNTier(6, 2200, 12f, 7F, -3f, 20, BlockTags.ANVIL, () -> Ingredient.of(WNItems.ORE_ITEMS.get(OreItem.DARK_AMETHYST)))),
    RUBY("ruby", new WNTier(4, 1200, 8.5f, 4.5F, -3f, 13, BlockTags.ANVIL, () -> Ingredient.of(WNItems.ORE_ITEMS.get(OreItem.RUBY)))),
    SAPPHIRE("sapphire", new WNTier(4, 1200, 8.5f, 4.5F, -3f, 13, BlockTags.ANVIL, () -> Ingredient.of(WNItems.ORE_ITEMS.get(OreItem.SAPPHIRE)))),
    SILVER("silver", new WNTier(2, 500, 7f, 2.5F, -2.9f, 20, BlockTags.ANVIL, () -> Ingredient.of(WNItems.ORE_ITEMS.get(OreItem.SILVER_INGOT)))),
    STEEL("steel", new WNTier(2, 825, 6f, 2.5F, -2.8f, 6, BlockTags.ANVIL, () -> Ingredient.of(WNItems.ORE_ITEMS.get(OreItem.STEEL_INGOT)))),
    TIN("tin"),
    TOPAZ("topaz", new WNTier(5, 1800, 9.5f, 5.5F, -2.9f, 16, BlockTags.ANVIL, () -> Ingredient.of(WNItems.ORE_ITEMS.get(OreItem.TOPAZ)))),

    ;

    private String name;
    @Nullable
    private WNTier tier;

    OreFamily(String name) {
        this.name = name;
    }

    OreFamily(String name, @Nullable WNTier tier) {
        this.name = name;
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    @Nullable
    public WNTier getTier() {
        return tier;
    }
}
