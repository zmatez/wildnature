/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.cave_plants;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FloweringBush;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_FloweringBush;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WNFloweringCaveBushBlock extends WNCaveBushBlock {
    public static final BooleanProperty FLOWERING = WNBlockProperties.FLOWERING;

    public WNFloweringCaveBushBlock(ResourceLocation location, Properties properties, CavePlantType type) {
        super(location, properties, type);
    }

    public WNFloweringCaveBushBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, CavePlantType type) {
        super(location, properties, itemProperties, type);
    }


    @Override
    public void construct() {
        super.construct();
        registerDefaultState(this.stateDefinition.any().setValue(FLOWERING,false));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state != null && context.getPlayer() != null && context.getPlayer().isCreative()){
            return super.getStateForPlacement(context).setValue(FLOWERING,true);
        }
        return state;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(FLOWERING);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if(WNUtil.rint(0,5) == 0){
            level.setBlock(pos,state.setValue(FLOWERING,true),2);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> definition) {
        definition.add(FLOWERING);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_FloweringBush(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String stalk = this.getTextureName("plants/cave/"+this.cavePlantType.getFolder()) + "_stalk";
        return new WNBlock.ModelList().with(
                new WNBlockModel_TintedCross(this.getRegName()).with("texture",stalk),
                new WNBlockModel_FloweringBush(this.getRegName() + "_flowering")
                        .with("texture",this.getTextureName("plants/cave/"+this.cavePlantType.getFolder()))
                        .with("stalk",stalk)
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.FLOWERS, WNTags.SMALL_FLOWERS, WNTags.ENDERMAN_HOLDABLE, WNTags.WN_FLOWERING_PLANTS
        );
    }
}
