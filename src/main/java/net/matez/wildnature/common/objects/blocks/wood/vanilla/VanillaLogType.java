/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.wood.vanilla;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

public enum VanillaLogType {
    OAK("oak", MaterialColor.WOOD, () -> Blocks.OAK_LOG, () -> Blocks.STRIPPED_OAK_LOG),
    SPRUCE("spruce", MaterialColor.PODZOL, () -> Blocks.SPRUCE_LOG, () -> Blocks.STRIPPED_SPRUCE_LOG),
    BIRCH("birch", MaterialColor.SAND, () -> Blocks.BIRCH_LOG, () -> Blocks.STRIPPED_BIRCH_LOG),
    JUNGLE("jungle", MaterialColor.DIRT, () -> Blocks.JUNGLE_LOG, () -> Blocks.STRIPPED_JUNGLE_LOG),
    ACACIA("acacia", MaterialColor.COLOR_ORANGE, () -> Blocks.ACACIA_LOG, () -> Blocks.STRIPPED_ACACIA_LOG),
    DARK_DARK_OAK("dark_oak", MaterialColor.COLOR_BROWN, () -> Blocks.DARK_OAK_LOG, () -> Blocks.STRIPPED_DARK_OAK_LOG),
    ;
    private final String name;
    private final MaterialColor color;
    private final Supplier<Block> logBlock;
    private final Supplier<Block> strippedLogBlock;

    VanillaLogType(String name, MaterialColor color, Supplier<Block> logBlock, Supplier<Block> strippedLogBlock) {
        this.name = name;
        this.color = color;
        this.logBlock = logBlock;
        this.strippedLogBlock = strippedLogBlock;
    }

    public String getName() {
        return name;
    }

    public MaterialColor getColor() {
        return color;
    }

    public Supplier<Block> getLogBlock() {
        return logBlock;
    }

    public Supplier<Block> getStrippedLogBlock() {
        return strippedLogBlock;
    }
}
