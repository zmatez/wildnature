/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.wood.furniture;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.blocks.wood.ILog;
import net.matez.wildnature.common.objects.blocks.wood.LogType;
import net.matez.wildnature.common.objects.blocks.wood.base.WNAbstractBenchBlock;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_Bench;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNBenchBlock extends WNAbstractBenchBlock implements ILog{
    private final LogType logType;

    public WNBenchBlock(ResourceLocation location, Properties properties, LogType logType) {
        super(location, properties);
        this.logType = logType;
    }

    public WNBenchBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, LogType logType) {
        super(location, properties, itemProperties);
        this.logType = logType;
    }

    public WNBlock getLog() {
        return WNBlocks.STRIPPED_LOGS.get(this.logType);
    }
    public WNBlock getPlanks() {
        return WNBlocks.PLANKS.get(this.logType);
    }

    @Override
    public ModelList getBlockModels() {
        String log = getLog().getTextureName("trees/" + this.logType.getBaseOrParent());
        String planks = getPlanks().getTextureName("trees/" + this.logType.getBaseOrParent());

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
