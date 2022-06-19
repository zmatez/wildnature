/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.saplings;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.blocks.wood.LogType;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_Sapling;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class WNSaplingBlock extends WNAbstractSaplingBlock {
    private final WNSaplingType saplingType;

    public WNSaplingBlock(ResourceLocation location, Properties properties, WNSaplingType type) {
        super(location, properties, type.getPlacement(), type.getBigPlacement(), type.getBushPlacement());
        this.saplingType = type;
    }

    public WNSaplingBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, WNSaplingType type) {
        super(location, properties, itemProperties, type.getPlacement(), type.getBigPlacement(), type.getBushPlacement());
        this.saplingType = type;
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        return new WNItemModel_Generated(this.getRegName())
                .with("texture", this.getTextureName("trees/" + saplingType.getFolder()) + "_item");
    }

    @Override
    public ModelList getBlockModels() {
        Block logType = saplingType.getLogType().get();
        LogType type = null;
        if (logType instanceof WNBlock block) {
            for (Map.Entry<LogType, WNBlock> entries : WNBlocks.LOGS.entrySet()) {
                if (entries.getValue() == block) {
                    type = entries.getKey();
                    break;
                }
            }
        }
        String texture = this.getRegistryName().getNamespace() + ":blocks/trees/" + saplingType.getFolder() + "/" + saplingType.getIdBase();
        if (!saplingType.getLeafType().getConfig().getCustomModels().isEmpty()) {
            texture += "_sapling";
        } else {
            texture += "_leaves";
        }
        return new ModelList().with(
                new WNBlockModel_Sapling(this.getRegName())
                        .with("log", (type == null ? ("minecraft:block/" + logType.getRegistryName().getPath()) : ((WNBlock) logType).getTextureName("trees/" + type.getIdBase())))
                        .with("leaves", texture)
        );
    }

    @Nullable
    @Override
    public BlockColor getBlockColor() {
        if (this.saplingType.getLeafType().isTinted() && this.saplingType != WNSaplingType.MAGNOLIA) {
            return (a, b, c, d) -> {
                return b != null && c != null ? BiomeColors.getAverageFoliageColor(b, c) : FoliageColor.getDefaultColor();
            };
        }
        return null;
    }

}
