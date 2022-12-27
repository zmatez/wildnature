/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.wood.furniture;

import net.matez.wildnature.common.block.wood.ILog;
import net.matez.wildnature.common.block.wood.LogType;
import net.matez.wildnature.common.block.wood.base.WNAbstractChairBlock;
import net.matez.wildnature.core.registry.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_Chair;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNChairBlock extends WNAbstractChairBlock implements ILog{
    private final LogType logType;

    public WNChairBlock(ResourceLocation location, Properties properties, LogType logType) {
        super(location, properties);
        this.logType = logType;
    }

    public WNChairBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, LogType logType) {
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
                new WNBlockModel_Chair(this.getRegName())
                        .with("log",log)
                        .with("planks",planks)
        );
    }
}
