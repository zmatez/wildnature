/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.mushrooms;

import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.common.registry.particles.WNParticles;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.blockstates.WNBlockstate_Puffball;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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

    public WNPuffballBlock(ResourceLocation location, Properties properties, Mushroom mushroom) {
        super(location, properties, mushroom);
    }

    public WNPuffballBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, Mushroom mushroom) {
        super(location, properties, itemProperties, mushroom);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        super.createBlockStateDefinition(def);
        def.add(BROKEN);
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.defaultBlockState().setValue(BROKEN,false));
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Puffball(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_TintedCross(this.getRegName()).with("texture",this.getTextureName("plants/surface/mushrooms")),
                new WNBlockModel_TintedCross(this.getRegName() + "_broken").with("texture",this.getTextureName("plants/surface/mushrooms") + "_broken")
        );
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
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        super.randomTick(state, level, pos, random);
        if(state.getValue(BROKEN) && WNUtil.rint(0,5) == 0){
            level.setBlock(pos,state.setValue(BROKEN,false),2);
        }
    }
}
