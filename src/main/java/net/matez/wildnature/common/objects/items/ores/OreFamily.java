/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.items.ores;

import net.matez.wildnature.common.registry.items.WNItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

import javax.annotation.Nullable;

public enum OreFamily {
    AMBER("amber"),
    BRONZE("bronze",new ForgeTier(2,350, 6.5f,1F,20, BlockTags.ANVIL,() -> Ingredient.of(WNItems.ORE_ITEMS.get(OreItem.BRONZE_INGOT)))),
    DARK_AMETHYST("dark_amethyst",new ForgeTier(6,2200, 12f,7F,20, BlockTags.ANVIL,() -> Ingredient.of(WNItems.ORE_ITEMS.get(OreItem.DARK_AMETHYST)))),
    RUBY("ruby",new ForgeTier(4,1200, 8.5f,4.5F,13, BlockTags.ANVIL,() -> Ingredient.of(WNItems.ORE_ITEMS.get(OreItem.RUBY)))),
    SAPPHIRE("sapphire",new ForgeTier(4,1200, 8.5f,4.5F,13, BlockTags.ANVIL,() -> Ingredient.of(WNItems.ORE_ITEMS.get(OreItem.SAPPHIRE)))),
    SILVER("silver",new ForgeTier(2,500, 7f,2.5F,20, BlockTags.ANVIL,() -> Ingredient.of(WNItems.ORE_ITEMS.get(OreItem.SILVER_INGOT)))),
    STEEL("steel",new ForgeTier(2,825, 6f,2.5F,6, BlockTags.ANVIL,() -> Ingredient.of(WNItems.ORE_ITEMS.get(OreItem.STEEL_INGOT)))),
    TIN("tin"),
    TOPAZ("topaz",new ForgeTier(5,1800, 9.5f,5.5F,16, BlockTags.ANVIL,() -> Ingredient.of(WNItems.ORE_ITEMS.get(OreItem.TOPAZ)))),

    ;

    private String name;
    @Nullable
    private Tier tier;

    OreFamily(String name){
        this.name = name;
    }
    OreFamily(String name, @Nullable Tier tier){
        this.name = name;
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    @Nullable
    public Tier getTier() {
        return tier;
    }
}
