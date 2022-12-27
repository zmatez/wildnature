/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.crops;

import net.matez.wildnature.common.block.crops.stages.WNCropBlock_Stage0;
import net.matez.wildnature.common.tags.WNTags;
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

public class WNSpreadingCropBlock extends WNCropBlock_Stage0 {
    public WNSpreadingCropBlock(ResourceLocation location, Properties properties, CropType cropType) {
        super(location, properties, cropType);
    }

    public WNSpreadingCropBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, CropType cropType) {
        super(location, properties, itemProperties, cropType);
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_TintedCross(this.getRegName() + "_stage_1")
                        .with("texture", this.getTextureName("crops/" + this.cropType.getFolder()))
        );
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.CROPS
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }
}
