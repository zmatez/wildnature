/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.wood.vanilla.furniture;

import net.matez.wildnature.common.block.wood.base.WNAbstractBenchBlock;
import net.matez.wildnature.common.block.wood.vanilla.VanillaLogType;
import net.matez.wildnature.data.block_models.WNBlockModel_Bench;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class WNVanillaBenchBlock extends WNAbstractBenchBlock {
    private final VanillaLogType logType;

    public WNVanillaBenchBlock(ResourceLocation location, Properties properties, VanillaLogType logType) {
        super(location, properties);
        this.logType = logType;
    }

    public WNVanillaBenchBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, VanillaLogType logType) {
        super(location, properties, itemProperties);
        this.logType = logType;
    }

    public Block getLog() {
        return this.logType.getStrippedLogBlock().get();
    }
    public Block getPlanks() {
        return switch (logType) {
            case OAK -> Blocks.OAK_PLANKS;
            case SPRUCE -> Blocks.SPRUCE_PLANKS;
            case BIRCH -> Blocks.BIRCH_PLANKS;
            case JUNGLE -> Blocks.JUNGLE_PLANKS;
            case ACACIA -> Blocks.ACACIA_PLANKS;
            case DARK_DARK_OAK -> Blocks.DARK_OAK_PLANKS;
        };
    }

    @Override
    public ModelList getBlockModels() {
        String log = "minecraft:block/" + getLog().getRegistryName().getPath();
        String planks = "minecraft:block/" + getPlanks().getRegistryName().getPath();
        return new ModelList().with(
                new WNBlockModel_Bench(this.getRegName() + "_single")
                        .with("beam",log)
                        .with("texture",planks)
                        .with("side","single"),
                new WNBlockModel_Bench(this.getRegName() + "_middle")
                        .with("beam",log)
                        .with("texture",planks)
                        .with("side","middle"),
                new WNBlockModel_Bench(this.getRegName() + "_side")
                        .with("beam",log)
                        .with("texture",planks)
                        .with("side","side")
        );
    }
}
