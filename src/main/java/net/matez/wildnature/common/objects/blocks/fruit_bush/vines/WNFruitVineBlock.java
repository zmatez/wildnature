/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.fruit_bush.vines;

import net.matez.wildnature.common.objects.blocks.plant.vines.WNAbstractVineBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.setup.WNRenderType;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_Vine;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_FruitVine;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WNFruitVineBlock extends WNAbstractVineBlock {
    private final FruitVineType fruitVineType;
    public static final IntegerProperty STAGE = WNBlockProperties.GRAPE_STAGE;

    public WNFruitVineBlock(ResourceLocation location, Properties properties, FruitVineType type) {
        super(location, properties);
        this.fruitVineType = type;
    }

    public WNFruitVineBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, FruitVineType type) {
        super(location, properties, itemProperties);
        this.fruitVineType = type;
    }


    @Override
    public void construct() {
        super.construct();
        registerDefaultState(this.defaultBlockState().setValue(STAGE,0));
    }

    @Override
    public WNRenderType getRenderType() {
        return WNRenderType.CUTOUT;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state != null && context.getPlayer() != null && context.getPlayer().isCreative()){
            return super.getStateForPlacement(context).setValue(STAGE,WNUtil.rint(1,3));
        }
        return state;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        super.randomTick(state,level,pos,random);
        if(WNUtil.rint(0,5) == 0 && state.getValue(STAGE) == 0){
            level.setBlock(pos,state.setValue(STAGE,WNUtil.rint(1,3)),2);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> definition) {
        super.createBlockStateDefinition(definition);
        definition.add(STAGE);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_FruitVine(this.getRegistryName()).with("leaf","grape_vine");
    }

    @Override
    public ModelList getBlockModels() {
        String base = this.getRegistryName().getNamespace() + ":blocks/fruit_bushes/" + fruitVineType.getFolder() + "/" + fruitVineType.getFolder();
        return new WNBlock.ModelList().with(
                new WNBlockModel_Vine(this.getRegName()).with("texture",base),
                new WNBlockModel_Vine(this.getRegName()+"_1").with("texture",this.getTextureName("fruit_bushes/"+fruitVineType.getFolder()) + "_1"),
                new WNBlockModel_Vine(this.getRegName()+"_2").with("texture",this.getTextureName("fruit_bushes/"+fruitVineType.getFolder()) + "_2"),
                new WNBlockModel_Vine(this.getRegName()+"_3").with("texture",this.getTextureName("fruit_bushes/"+fruitVineType.getFolder()) + "_3")
        );
    }

    @javax.annotation.Nullable
    public WNResource getItemModel() {
        return new WNItemModel_Generated(getRegName()).with("texture", this.getTextureName("fruit_bushes/"+fruitVineType.getFolder()) + "_1");
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.FLOWERS, WNTags.CLIMBABLE, WNTags.MINEABLE_AXE, WNTags.WN_FLOWERING_PLANTS
        );
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
