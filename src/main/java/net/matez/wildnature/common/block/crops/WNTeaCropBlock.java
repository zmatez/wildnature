/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.crops;

import net.matez.wildnature.common.block.crops.stages.WNCropBlock_Stage1;
import net.matez.wildnature.common.item.vegetables.WNVeggieBlockItem;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.core.registry.WNBlocks;
import net.matez.wildnature.core.registry.WNItems;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FloweringBush;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class WNTeaCropBlock extends WNCropBlock_Stage1 {
    public WNTeaCropBlock(ResourceLocation location, Properties properties, CropType cropType) {
        super(location, properties, cropType);
    }

    public WNTeaCropBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, CropType cropType) {
        super(location, properties, cropType);

        this.item = new WNVeggieBlockItem(this, itemProperties, cropType.getVeggie());
        this.item.setRegistryName(WNItems.location(cropType.getVeggie().getId()));
        WNBlocks.BLOCK_ITEMS.put(location, this.item);
    }

    @Override
    public void onItemConstruct() {
        super.onItemConstruct();
        WNItems.VEGGIES.put(cropType.getVeggie(), this.item);
    }

    @Override
    public ModelList getBlockModels() {
        String stalk = this.getRegistryName().getNamespace() + ":blocks/crops/" + cropType.getFolder() + "/" + (this.cropType == CropType.MELISSA_TEA_LEAF ? "melissa_tea" : "tea") + "_stalk";
        return new ModelList().with(
                new WNBlockModel_TintedCross(this.getRegName() + "_stage_1")
                        .with("texture", stalk),
                new WNBlockModel_FloweringBush(this.getRegName() + "_stage_2")
                        .with("texture", this.getTextureName("crops/" + cropType.getFolder()))
                        .with("stalk", stalk)
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.CROPS_BLOCKS
        );
    }


    @Override
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }
}
