/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.wood.vanilla.building;

import net.matez.wildnature.common.objects.blocks.wood.ILog;
import net.matez.wildnature.common.objects.blocks.wood.base.WNAbstractBranchBlock;
import net.matez.wildnature.common.objects.blocks.wood.vanilla.VanillaLogType;
import net.matez.wildnature.data.block_models.WNBlockModel_Branch;
import net.matez.wildnature.data.blockstates.WNBlockstate_Branch;
import net.matez.wildnature.data.item_models.WNItemModel_BlockParent;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class WNVanillaBranchBlock extends WNAbstractBranchBlock implements ILog{
    private final VanillaLogType logType;

    public WNVanillaBranchBlock(ResourceLocation location, Properties properties, VanillaLogType logType) {
        super(location, properties);
        this.logType = logType;
    }

    public WNVanillaBranchBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, VanillaLogType logType) {
        super(location, properties, itemProperties);
        this.logType = logType;
    }

    public Block getLog() {
        return this.logType.getLogBlock().get();
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Branch(this.getRegistryName());
    }

    @Override
    public String getTextureName() {
        return this.getRegistryName() == null ? "UNKNOWN" : ("minecraft:block/" + this.getRegistryName().getPath());
    }

    @Override
    public ModelList getBlockModels() {
        String path = "minecraft:block/"+getLog().getRegistryName().getPath();
        return new ModelList()
                .with(
                        new WNBlockModel_Branch(this.getRegName() + "_up")
                                .with("texture", path)
                                .with("side", "up"),
                        new WNBlockModel_Branch(this.getRegName() + "_down")
                                .with("texture", path)
                                .with("side", "down"),
                        new WNBlockModel_Branch(this.getRegName() + "_side")
                                .with("texture", path)
                                .with("side", "side"),
                        new WNBlockModel_Branch(this.getRegName() + "_inventory")
                                .with("texture", path)
                                .with("side", "inventory"),
                        new WNBlockModel_Branch(this.getRegName() + "_none")
                                .with("texture", path)
                                .with("side", "none")
                );
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        return new WNItemModel_BlockParent(getRegName()).with("parent", this.getRegName() + "_inventory");
    }
}
