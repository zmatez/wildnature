/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.fruit_bush.vines;

import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.common.block.WNBlockProperties;
import net.matez.wildnature.common.block.plant.vines.WNAbstractVineBlock;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public class WNFruitVineBlock extends WNAbstractVineBlock {
    private final FruitVineType fruitVineType;
    public static final IntegerProperty STAGE = WNBlockProperties.GRAPE_STAGE;

    public WNFruitVineBlock(Properties properties, FruitVineType type) {
        super(properties);
        this.fruitVineType = type;
        registerDefaultState(this.defaultBlockState().setValue(STAGE,0));
    }

    @Override
    public RenderType getRenderType() {
        return RenderType.cutout();
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state != null && context.getPlayer() != null && context.getPlayer().isCreative()){
            return super.getStateForPlacement(context).setValue(STAGE, ExtraMath.rint(1,3));
        }
        return state;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state,level,pos,random);
        if(ExtraMath.rint(0,5) == 0 && state.getValue(STAGE) == 0){
            level.setBlock(pos,state.setValue(STAGE, ExtraMath.rint(1,3)),2);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> definition) {
        super.createBlockStateDefinition(definition);
        definition.add(STAGE);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        int stage = state.getValue(STAGE);
        if(stage > 0){
            int count = 4 - stage;
            ItemStack stack = this.fruitVineType.getDrop().get();
            stack.setCount(stack.getCount() * count);
            popResourceFromFace(level,pos,result.getDirection(),stack);
            level.setBlockAndUpdate(pos,state.setValue(STAGE,0));
            return InteractionResult.SUCCESS;
        }

        return super.use(state, level, pos, player, hand, result);
    }
}
