/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.wood.furniture;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.blocks.wood.ILog;
import net.matez.wildnature.common.objects.blocks.wood.LogType;
import net.matez.wildnature.common.objects.blocks.wood.base.WNAbstractTableBlock;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_TableInventory;
import net.matez.wildnature.data.block_models.WNBlockModel_TableLeg;
import net.matez.wildnature.data.block_models.WNBlockModel_TableTop;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class WNTableBlock extends WNAbstractTableBlock implements ILog{
    private final LogType logType;

    public WNTableBlock(ResourceLocation location, Properties properties, LogType logType) {
        super(location, properties);
        this.logType = logType;
    }

    public WNTableBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, LogType logType) {
        super(location, properties, itemProperties);
        this.logType = logType;
    }

    public WNBlock getLog() {
        return WNBlocks.STRIPPED_LOGS.get(this.logType);
    }

    @Override
    public ModelList getBlockModels() {
        String path = getLog().getTextureName("trees/" + this.logType.getBaseOrParent());
        return new ModelList()
                .with(
                        new WNBlockModel_TableTop(this.getRegName() + "_top")
                                .with("texture", path),
                        new WNBlockModel_TableLeg(this.getRegName() + "_leg")
                                .with("texture", path),
                        new WNBlockModel_TableInventory(this.getRegName() + "_inventory")
                                .with("texture", path)
                );
    }
}
