/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.geyser;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.data.block_models.WNBlockModel_Geyser;
import net.matez.wildnature.data.block_models.WNBlockModel_GeyserSingle;
import net.matez.wildnature.data.blockstates.WNBlockstate_Geyser;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

public class WNGeyserBlock extends WNBlock {
    public static final BooleanProperty SINGLE = WNBlockProperties.SINGLE;

    public WNGeyserBlock(ResourceLocation location, Properties properties) {
        super(location, properties);
    }

    public WNGeyserBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties) {
        super(location, properties, itemProperties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        super.createBlockStateDefinition(def);
        def.add(SINGLE);
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.defaultBlockState().setValue(SINGLE,true));
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Geyser(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new WNBlock.ModelList().with(
                new WNBlockModel_GeyserSingle(this.getRegName() + "_single").with("texture",this.getTextureName("misc/geyser")),
                new WNBlockModel_Geyser(this.getRegName()).with("texture",this.getTextureName("misc/geyser"))
        );
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state == null){
            return null;
        }
        return state.setValue(SINGLE,isSingle(context.getLevel(),context.getClickedPos()));
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor accessor, BlockPos pos, BlockPos pos2) {
        BlockState newState = super.updateShape(state, direction, state2, accessor, pos, pos2);
        if(newState.is(this)){
            return newState.setValue(SINGLE,isSingle(accessor,pos));
        }
        return newState;
    }

    public boolean isSingle(LevelAccessor accessor, BlockPos pos){
        for (Direction value : Direction.values()) {
            if(value.getAxis() != Direction.Axis.Y){
                BlockState offset = accessor.getBlockState(pos.relative(value));
                if(offset.is(this)){
                    return false;
                }
            }
        }
        return true;
    }

    @Nullable
    @Override
    public BlockColor getBlockColor() {
        return (state, getter, pos, num) -> {
            if(state.getValue(SINGLE)) {
                return getter != null && pos != null ? BiomeColors.getAverageWaterColor(getter, pos) : 0xFF000000;
            }
            return 0xFFFFFFFF;
        };
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.MINEABLE_PICKAXE
        );
    }
}
