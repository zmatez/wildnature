/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.mushrooms;

import net.matez.wildnature.common.block.WNBlockProperties;
import net.matez.wildnature.core.registry.WNParticles;
import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.blockstates.WNBlockstate_Puffball;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public class WNPuffballBlock extends WNMushroomBlock{
    public static final BooleanProperty BROKEN = WNBlockProperties.BROKEN;

    public WNPuffballBlock(Properties properties, Mushroom mushroom) {
        super(properties, mushroom);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        super.createBlockStateDefinition(def);
        def.add(BROKEN);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);
        if(!state.getValue(BROKEN) && !level.isClientSide() && level instanceof ServerLevel server){
            Vec3 offset = state.getOffset(level,pos);
            server.sendParticles(WNParticles.PUFFBALL_EXPLOSION, pos.getX() + offset.x + 0.5F, pos.getY() + offset.y + 0.25F, pos.getZ() + offset.z + 0.5F, 100, 0.05,0.05,0.05, 0.04F);
            level.setBlockAndUpdate(pos,state.setValue(BROKEN,true));
            // not works :/
            // entity.setDeltaMovement(entity.getDeltaMovement().x, 0.3F, entity.getDeltaMovement().z);
        }
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        if(state.getValue(BROKEN) && ExtraMath.rint(0,5) == 0){
            level.setBlock(pos,state.setValue(BROKEN,false),2);
        }
    }
}
