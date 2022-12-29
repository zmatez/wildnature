/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.plant.plants;

import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.core.registry.WNParticles;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;
import java.util.Random;

public class WNWisteriaBlock extends WNVerticalBushBlock{
    public static Map<Direction, VoxelShape> SHAPE = createFacingShape(16,3);

    public WNWisteriaBlock(Properties properties, BushType type) {
        super(properties, type);
    }

    @Override
    public boolean isDirectionAllowed(BlockPlaceContext context, Direction direction) {
        return direction != Direction.UP;
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.NONE;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        super.animateTick(state, level, pos, random);
        if(ExtraMath.rint(0,6,random) == 0){
            double delta = 0.05;
            level.addParticle(WNParticles.WISTERIA_PINK, pos.getX() + 0.5 + ExtraMath.rdoub(-0.3,0.3), pos.getY() + ExtraMath.rdoub(-1,1), pos.getZ() + 0.5 + ExtraMath.rdoub(-0.3,0.3), ExtraMath.rdoub(-delta,delta), 0.01, ExtraMath.rdoub(-delta,delta));
        }
    }
}
