/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.fruit_bush.leaves;

import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.common.WNBlock;
import net.matez.wildnature.common.block.fruit_bush.leaves.stages.WNFruitBushBlock_Stage0;
import net.matez.wildnature.common.block.fruit_bush.leaves.stages.WNFruitBushBlock_Stage1;
import net.matez.wildnature.common.block.fruit_bush.leaves.stages.WNFruitBushBlock_Stage2;
import net.matez.wildnature.common.block.leaves.LeafConfig;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public abstract class WNFruitBushTypedBlock extends LeavesBlock implements WNBlock {
    private final FruitBushType leafType;

    public WNFruitBushTypedBlock(Properties properties, FruitBushType leafType) {
        super(properties);
        this.leafType = leafType;
        if(this.getLeafStageProperty() != null)
            this.registerDefaultState(this.defaultBlockState().setValue(this.getLeafStageProperty(),0));
    }

    @Nullable
    public abstract IntegerProperty getLeafStageProperty();

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return this.getLeafStageProperty() != null && ((state.getValue(this.getLeafStageProperty()) == 0) || (this.leafType.getConfig().isFlowering() && state.getValue(this.getLeafStageProperty()) == 1));
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        if (state.getValue(PERSISTENT)) {
            if (this.getLeafStageProperty() != null && this.leafType.getConfig().isFlowering() && state.getValue(this.getLeafStageProperty()) == 0) {
                level.setBlock(pos, state.setValue(this.getLeafStageProperty(), ExtraMath.rint(2, 1)), 2);
            } else if (this.getLeafStageProperty() != null && ((this.leafType.getConfig().isFlowering() && state.getValue(this.getLeafStageProperty()) == 1) || state.getValue(this.getLeafStageProperty()) == 0)) {
                level.setBlock(pos, state.setValue(this.getLeafStageProperty(), ExtraMath.rint(2, leafType.getConfig().getStages())), 2);
            }
        }
    }

    @Nullable
    @Override
    public BlockColor getBlockColor() {
        if(this.leafType.isTinted()) {
            return (a, b, c, d) -> {
                return b != null && c != null ? BiomeColors.getAverageFoliageColor(b, c) : FoliageColor.getDefaultColor();
            };
        }
        return null;
    }

    @Nullable
    @Override
    public ItemColor getItemColor(BlockColors colors) {
        if(!this.leafType.isTinted()){
            return null;
        }
        return (stack, num) -> {
            BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
            return colors.getColor(blockstate, null, null, num);
        };
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(this.getLeafStageProperty() != null) {
            ItemStack fruit = getFruit(state);
             {
                if (fruit != null) {
                    level.setBlock(pos, state.setValue(this.getLeafStageProperty(), 0), 2);
                    Block.popResourceFromFace(level, pos, result.getDirection(), fruit);
                    return InteractionResult.SUCCESS;
                }
            }
        }

        return super.use(state, level, pos, player, hand, result);
    }

    @Nullable
    public ItemStack getFruit(BlockState state){
        if(this.getLeafStageProperty() != null) {
            int stage = state.getValue(this.getLeafStageProperty());
            if(leafType.getConfig().getStageDrops().containsKey(stage)){
                LeafConfig.ItemConfig config = leafType.getConfig().getStageDrops().get(stage);
                Item item = config.getItem().get();
                if(item != Items.AIR) {
                    return new ItemStack(item,config.getMin() == config.getMax() ? config.getMin() : (ExtraMath.rint(config.getMin(), config.getMax())));
                }
            }
        }
        return null;
    }

    public static IntegerProperty getStage(BlockState state){
        if(state.getBlock() instanceof WNFruitBushTypedBlock block){
            if(block instanceof WNFruitBushBlock_Stage0){
                return WNFruitBushBlock_Stage0.STAGE;
            }else if(block instanceof WNFruitBushBlock_Stage1){
                return WNFruitBushBlock_Stage1.STAGE;
            }else if(block instanceof WNFruitBushBlock_Stage2){
                return WNFruitBushBlock_Stage2.STAGE;
            }
        }
        return null;
    }

    public static WNFruitBushTypedBlock create(Properties properties, FruitBushType leafType){
        switch (leafType.getConfig().getStages()) {
            case 0 -> {
                return new WNFruitBushBlock_Stage0(properties, leafType);
            }
            case 1 -> {
                return new WNFruitBushBlock_Stage1(properties, leafType);
            }
            case 2 -> {
                return new WNFruitBushBlock_Stage2(properties, leafType);
            }
        }
        return null;
    }
}
