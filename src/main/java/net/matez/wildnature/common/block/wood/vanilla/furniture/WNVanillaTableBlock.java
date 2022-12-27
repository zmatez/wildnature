/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.wood.vanilla.furniture;

import net.matez.wildnature.common.block.wood.ILog;
import net.matez.wildnature.common.block.wood.base.WNAbstractTableBlock;
import net.matez.wildnature.common.block.wood.vanilla.VanillaLogType;
import net.matez.wildnature.data.block_models.WNBlockModel_TableInventory;
import net.matez.wildnature.data.block_models.WNBlockModel_TableLeg;
import net.matez.wildnature.data.block_models.WNBlockModel_TableTop;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class WNVanillaTableBlock extends WNAbstractTableBlock implements ILog {
    private final VanillaLogType logType;

    public WNVanillaTableBlock(ResourceLocation location, Properties properties, VanillaLogType logType) {
        super(location, properties);
        this.logType = logType;
    }

    public WNVanillaTableBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, VanillaLogType logType) {
        super(location, properties, itemProperties);
        this.logType = logType;
    }

    public Block getLog() {
        return this.logType.getStrippedLogBlock().get();
    }

    @Override
    public ModelList getBlockModels() {
        String path = "minecraft:block/" + getLog().getRegistryName().getPath();
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
