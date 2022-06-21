/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.plant.vines;

import net.matez.wildnature.common.objects.blocks.plant.BushType;
import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.setup.WNRenderType;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_Vine;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_FloweringVine;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
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

public class WNFloweringVineBlock extends WNAbstractVineBlock{
    private BushType type;
    public static final BooleanProperty FLOWERING = WNBlockProperties.FLOWERING;

    public WNFloweringVineBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties);
        this.type = type;
    }

    public WNFloweringVineBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties);
        this.type = type;
    }


    @Override
    public void construct() {
        super.construct();
        registerDefaultState(this.defaultBlockState().setValue(FLOWERING,false));
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
            return super.getStateForPlacement(context).setValue(FLOWERING,true);
        }
        return state;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        super.randomTick(state,level,pos,random);
        if(WNUtil.rint(0,5) == 0){
            level.setBlock(pos,state.setValue(FLOWERING,true),2);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> definition) {
        super.createBlockStateDefinition(definition);
        definition.add(FLOWERING);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_FloweringVine(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String base = this.getRegistryName().getNamespace() + ":blocks/" + getType().getVariant().getPath() + "/" + getType().getVariant().getBaseName();
        return new WNBlock.ModelList().with(
                new WNBlockModel_Vine(this.getRegName()).with("texture",base),
                new WNBlockModel_Vine(this.getRegName()+"_flowering").with("texture",this.getTextureName(this.getType().getVariant().getPath()))
        );
    }

    @javax.annotation.Nullable
    public WNResource getItemModel() {
        if(getType().hasConfig() && getType().getConfig().isItemAsSelf()){
            return new WNItemModel_Generated(getRegName()).with("texture", this.getTextureName(getType().getVariant().getPath()));
        }
        if (getType().getItem() == null) {
            return new WNItemModel_Generated(getRegName()).with("texture", this.getTextureName(getType().getVariant().getPath()) + "_item");
        }

        return new WNItemModel_Generated(getRegName()).with("texture", this.getRegistryName().getNamespace() + ":blocks/" + getType().getVariant().getPath() + "/" + getType().getItem());
    }

    public BushType getType() {
        return type;
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.FLOWERS, WNTags.CLIMBABLE, WNTags.MINEABLE_AXE, WNTags.WN_FLOWERING_PLANTS
        );
    }
}
