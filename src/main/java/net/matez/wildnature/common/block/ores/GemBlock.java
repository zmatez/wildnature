/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.ores;

import net.matez.wildnature.common.block.BlockBehaviourConsumer;
import net.matez.wildnature.common.item.ores.OreItem;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MaterialColor;

public enum GemBlock {
    AMBER_BLOCK("amber_block","amber",OreItem.AMBER,(properties) -> {
        return properties.color(MaterialColor.COLOR_ORANGE).strength(4F,5F);
    }),
    BRONZE_BLOCK("bronze_block","bronze",OreItem.BRONZE_INGOT,(properties) -> {
        return properties.color(MaterialColor.COLOR_ORANGE).strength(5F,6F);
    }),
    DARK_AMETHYST_BLOCK("dark_amethyst_block","dark_amethyst",OreItem.DARK_AMETHYST,(properties) -> {
        return properties.color(MaterialColor.COLOR_ORANGE).strength(7.5F,8F);
    }),
    RUBY_BLOCK("ruby_block","ruby",OreItem.RUBY,(properties) -> {
        return properties.color(MaterialColor.COLOR_ORANGE).strength(6F,7F);
    }),
    SAPPHIRE_BLOCK("sapphire_block","sapphire",OreItem.SAPPHIRE,(properties) -> {
        return properties.color(MaterialColor.COLOR_ORANGE).strength(6F,7F);
    }),
    SILVER_RAW_BLOCK("silver_raw_block","silver",OreItem.SILVER_RAW,(properties) -> {
        return properties.color(MaterialColor.COLOR_ORANGE).strength(5.5F,6F);
    }),
    SILVER_BLOCK("silver_block","silver",OreItem.SILVER_INGOT,(properties) -> {
        return properties.color(MaterialColor.COLOR_ORANGE).strength(3.5F,3F).sound(SoundType.STONE);
    }),
    STEEL_BLOCK("steel_block","steel",OreItem.STEEL_INGOT,(properties) -> {
        return properties.color(MaterialColor.COLOR_ORANGE).strength(5.5F,6F);
    }),
    TIN_RAW_BLOCK("tin_raw_block","tin",OreItem.TIN_RAW,(properties) -> {
        return properties.color(MaterialColor.COLOR_ORANGE).strength(3F,3F).sound(SoundType.STONE);
    }),
    TIN_BLOCK("tin_block","tin",OreItem.TIN_INGOT,(properties) -> {
        return properties.color(MaterialColor.COLOR_ORANGE).strength(5F,5F);
    }),
    TOPAZ_BLOCK("topaz_block","topaz",OreItem.TOPAZ,(properties) -> {
        return properties.color(MaterialColor.COLOR_ORANGE).strength(7F,7.5F);
    })
    
    ;
    private final String id;
    private final String folder;
    private final OreItem item;
    private final BlockBehaviourConsumer propertiesSupplier;

    GemBlock(String id, String folder, OreItem item, BlockBehaviourConsumer propertiesSupplier) {
        this.id = id;
        this.folder = folder;
        this.item = item;
        this.propertiesSupplier = propertiesSupplier;
    }

    public BlockBehaviourConsumer getPropertiesSupplier() {
        return propertiesSupplier;
    }

    public OreItem getItem() {
        return item;
    }

    public String getFolder() {
        return folder;
    }

    public String getId() {
        return id;
    }
}
