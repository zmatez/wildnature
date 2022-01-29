/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.water_plants;

import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_CrossLilypad;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_Lilypad;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_FloweringLilypad;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WNFloweringWaterlilyBlock extends WNWaterlilyBlock {
    public static final BooleanProperty FLOWERING = WNBlockProperties.FLOWERING;

    public WNFloweringWaterlilyBlock(ResourceLocation location, Properties properties, WaterPlant waterPlant) {
        super(location, properties, waterPlant);
    }

    public WNFloweringWaterlilyBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, WaterPlant waterPlant) {
        super(location, properties, itemProperties, waterPlant);
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
        return new WNBlockstate_FloweringLilypad(this.getRegistryName());
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("plants/water/" + this.waterPlant.getFolder()) + "_item");
    }

    @Override
    public ModelList getBlockModels(){
        return new ModelList().with(
                new WNBlockModel_Lilypad(this.getRegName()).with("texture",this.getTextureName("plants/water/" + this.waterPlant.getFolder()) + "_pad"),
                new WNBlockModel_CrossLilypad(this.getRegName() + "_flowering")
                        .with("pad",this.getTextureName("plants/water/" + this.waterPlant.getFolder()) + "_pad")
                        .with("texture",this.getTextureName("plants/water/" + this.waterPlant.getFolder()))
        );
    }

    @Override
    public @Nullable BlockColor getBlockColor() {
        if(this.waterPlant == WaterPlant.WATERLILY_YELLOW || this.waterPlant == WaterPlant.WATERLILY_WHITE) {
            return (state, getter, pos, num) -> {
                return getter != null && pos != null ? BiomeColors.getAverageFoliageColor(getter, pos) : FoliageColor.get(0.5D, 1.0D);
            };
        }
        return null;
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.FLOWERS, WNTags.SMALL_FLOWERS, WNTags.WN_FLOWERING_PLANTS
        );
    }
}
