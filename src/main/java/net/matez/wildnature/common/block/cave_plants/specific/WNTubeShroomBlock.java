/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.cave_plants.specific;

import net.matez.wildnature.common.block.cave_plants.CavePlantType;
import net.matez.wildnature.common.block.cave_plants.WNCaveBushBlock;
import net.matez.wildnature.api.util.ExtraMath;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.LiquidBlockContainer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;
import java.util.Random;

public class WNTubeShroomBlock extends WNCaveBushBlock implements LiquidBlockContainer {
    public WNTubeShroomBlock(ResourceLocation location, Properties properties, CavePlantType type) {
        super(location, properties, type);
    }

    public WNTubeShroomBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, CavePlantType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
        if (ExtraMath.rint(0, 3, random) == 0) {
            Vec3 vec3 = state.getOffset(level, pos);
            level.addAlwaysVisibleParticle(ParticleTypes.BUBBLE_COLUMN_UP, pos.getX() + vec3.x + ExtraMath.rdoub(0.3D, 0.8D), pos.getY() + vec3.y + ExtraMath.rdoub(0.3D, 0.4D), pos.getZ() + vec3.z + ExtraMath.rdoub(0.3D, 0.8D), 0, 0.2, 0);
        }
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_154503_) {
        FluidState fluidstate = p_154503_.getLevel().getFluidState(p_154503_.getClickedPos());
        return fluidstate.is(FluidTags.WATER) && fluidstate.getAmount() == 8 ? super.getStateForPlacement(p_154503_) : null;
    }

    public BlockState updateShape(BlockState p_154530_, Direction p_154531_, BlockState p_154532_, LevelAccessor p_154533_, BlockPos p_154534_, BlockPos p_154535_) {
        BlockState blockstate = super.updateShape(p_154530_, p_154531_, p_154532_, p_154533_, p_154534_, p_154535_);
        if (!blockstate.isAir()) {
            p_154533_.scheduleTick(p_154534_, Fluids.WATER, Fluids.WATER.getTickDelay(p_154533_));
        }

        return blockstate;
    }

    public FluidState getFluidState(BlockState p_154537_) {
        return Fluids.WATER.getSource(false);
    }

    public boolean canPlaceLiquid(BlockGetter p_154505_, BlockPos p_154506_, BlockState p_154507_, Fluid p_154508_) {
        return false;
    }

    public boolean placeLiquid(LevelAccessor p_154520_, BlockPos p_154521_, BlockState p_154522_, FluidState p_154523_) {
        return false;
    }
}
