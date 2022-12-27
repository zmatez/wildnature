/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.sand;

import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeAll;
import net.matez.wildnature.data.blockstates.WNBlockstate_RandomlyRotatedCube;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

//todo improve mud
public class WNMudBlock extends WNBlock {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 12.0D, 16.0D);

    public WNMudBlock(ResourceLocation location, Properties properties) {
        super(location, properties);
    }

    public WNMudBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties) {
        super(location, properties, itemProperties);
    }

    @Override
    public WNResource getBlockstate(){
        return new WNBlockstate_RandomlyRotatedCube(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels(){
        return new ModelList()
                .with(new WNBlockModel_CubeAll(this.getRegName()).with("texture",this.getTextureName("sands")));
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.ENDERMAN_HOLDABLE, WNTags.AZALEA_GROWS_ON, WNTags.AZALEA_ROOT_REPLACEABLE, WNTags.LUSH_GROUND_REPLACEABLE, WNTags.MINEABLE_SHOVEL
        );
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        entity.makeStuckInBlock(state, new Vec3(0.3D, (double)0.05F, 0.3D));
    }

    public VoxelShape getCollisionShape(BlockState p_56702_, BlockGetter p_56703_, BlockPos p_56704_, CollisionContext p_56705_) {
        return SHAPE;
    }

    public VoxelShape getBlockSupportShape(BlockState p_56707_, BlockGetter p_56708_, BlockPos p_56709_) {
        return Shapes.block();
    }

    public VoxelShape getVisualShape(BlockState p_56684_, BlockGetter p_56685_, BlockPos p_56686_, CollisionContext p_56687_) {
        return Shapes.block();
    }

    @Override
    public boolean isPathfindable(BlockState p_60475_, BlockGetter p_60476_, BlockPos p_60477_, PathComputationType p_60478_) {
        return false;
    }
}
