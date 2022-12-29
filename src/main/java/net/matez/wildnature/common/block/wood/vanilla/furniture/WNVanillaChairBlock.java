/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.wood.vanilla.furniture;

import net.matez.wildnature.common.block.wood.base.WNAbstractChairBlock;
import net.matez.wildnature.common.block.wood.vanilla.VanillaLogType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public class WNVanillaChairBlock extends WNAbstractChairBlock {
    private final VanillaLogType logType;

    public WNVanillaChairBlock(Properties properties, VanillaLogType logType) {
        super(properties);
        this.logType = logType;
    }

    public Supplier<Block> getLog() {
        return this.logType.getStrippedLogBlock();
    }
    public Supplier<Block> getPlanks() {
        return switch (logType) {
            case OAK -> () ->Blocks.OAK_PLANKS;
            case SPRUCE -> () -> Blocks.SPRUCE_PLANKS;
            case BIRCH -> () -> Blocks.BIRCH_PLANKS;
            case JUNGLE -> () -> Blocks.JUNGLE_PLANKS;
            case ACACIA -> () -> Blocks.ACACIA_PLANKS;
            case DARK_DARK_OAK -> () -> Blocks.DARK_OAK_PLANKS;
        };
    }
}
