/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.plant.plants;

import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.common.block.plant.WNBushConfiguredBlock;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FloweringBushRetinted;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WNStranglingVineBlock extends WNBushConfiguredBlock {
    private static final double OFFSET = 3D;
    protected static final VoxelShape SHAPE = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 16.0D, 16.0D - OFFSET);

    public WNStranglingVineBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNStranglingVineBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockState stateOn, BlockGetter getter, BlockPos pos) {
        return super.mayPlaceOn(state, stateOn, getter, pos) || stateOn.is(this);
    }

    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        BlockState soil = reader.getBlockState(pos.below());
        if (soil.canSustainPlant(reader, pos.below(), Direction.UP, this)) return true;
        BlockState blockstate = reader.getBlockState(pos.below());
        if (blockstate.is(this)) {
            return true;
        } else {
            if (mayPlaceOn(state,blockstate,reader,pos)) {
                if(reader.isWaterAt(pos) && reader.isEmptyBlock(pos.above(5))){
                    return true;
                }

                BlockPos blockpos = pos.below();

                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockState blockstate1 = reader.getBlockState(blockpos.relative(direction));
                    FluidState fluidstate = reader.getFluidState(blockpos.relative(direction));
                    if (fluidstate.is(FluidTags.WATER) || blockstate1.is(Blocks.FROSTED_ICE)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
        if (!state.canSurvive(level, pos)) {
            level.scheduleTick(pos, this, 1);
        }

        return super.updateShape(state, direction, state2, level, pos, pos2);
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if (!state.canSurvive(level, pos)) {
            level.destroyBlock(pos, true);
        }
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        boolean water = level.getBlockState(pos.above()).is(Blocks.WATER);
        if (level.isEmptyBlock(pos.above()) || water) {
            int i;
            for(i = 1; level.getBlockState(pos.below(i)).is(this); ++i) {
            }

            if (i < 12) {
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, true)) {
                    level.setBlockAndUpdate(pos.above(), this.defaultBlockState());
                }
            }
        }

    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_FloweringBushRetinted(this.getRegName())
                        .with("texture",this.getTextureName(this.getType().getVariant().getPath()) + "_overlay")
                        .with("stalk",this.getTextureName(this.getType().getVariant().getPath()) + "_stem")
        );
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.NONE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);
        if(ExtraMath.rint(0,20) == 0) {
            entity.setDeltaMovement(entity.getDeltaMovement().x, 1F, entity.getDeltaMovement().z);
        }
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.CLIMBABLE, WNTags.MINEABLE_AXE
        );
    }
}
