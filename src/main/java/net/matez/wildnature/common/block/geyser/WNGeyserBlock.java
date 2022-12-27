/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.geyser;

import net.matez.wildnature.api.util.log.SimpleLogger;
import net.matez.wildnature.common.block.entity.geyser.WNGeyserBlockEntity;
import net.matez.wildnature.common.block.basic.WNBaseEntityBlock;
import net.matez.wildnature.common.block.WNBlockProperties;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.core.registry.WNBlockEntities;
import net.matez.wildnature.core.registry.WNParticles;
import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.data.block_models.WNBlockModel_Geyser;
import net.matez.wildnature.data.block_models.WNBlockModel_GeyserSingle;
import net.matez.wildnature.data.blockstates.WNBlockstate_Geyser;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WNGeyserBlock extends WNBaseEntityBlock {
    public static final IntegerProperty LOAD = WNBlockProperties.LOAD;

    public static final BooleanProperty SINGLE = WNBlockProperties.SINGLE;
    public static final BooleanProperty HYDROTHERMAL = WNBlockProperties.HYDROTHERMAL;
    private static final SimpleLogger log = WildNature.getLogger();

    public WNGeyserBlock(ResourceLocation location, Properties properties) {
        super(location, properties);
    }

    public WNGeyserBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties) {
        super(location, properties, itemProperties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        super.createBlockStateDefinition(def);
        def.add(SINGLE, HYDROTHERMAL, LOAD);
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.defaultBlockState().setValue(SINGLE, true).setValue(HYDROTHERMAL, false).setValue(LOAD, 0));
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

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WNGeyserBlockEntity(pos, state);
    }

    @Override
    public RenderShape getRenderShape(BlockState p_49232_) {
        return RenderShape.MODEL;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        super.randomTick(state, level, pos, random);
        if (isValid(state, level, pos)) {
            BlockEntity blockEntity = level.getBlockEntity(pos);
            if (blockEntity instanceof WNGeyserBlockEntity geyserBlockEntity) {
                geyserBlockEntity.randomTick();
            }
        }
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level p_153212_, BlockState p_153213_, BlockEntityType<T> p_153214_) {
        return createTickerHelper(p_153214_, WNBlockEntities.GEYSER, WNGeyserBlockEntity::tick);
    }

    public boolean isValid(BlockState state, Level level, BlockPos pos) {
        return level.getBlockState(pos.above()).is(Blocks.WATER);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
        super.animateTick(state, level, pos, random);
        if (isValid(state, level, pos)) {
            int load = state.getValue(LOAD);
            int loadChance = Math.abs(load - 4);
            if (load != 0 && ExtraMath.rint(0, loadChance) == 0) {
                if (state.getValue(SINGLE)) {
                    level.playLocalSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 0.5D, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 0.5F + random.nextFloat(), random.nextFloat() * 0.7F + 0.6F, false);
                    if (ExtraMath.rint(0, 4) == 0) {
                        level.addAlwaysVisibleParticle(WNParticles.THERMAL_SMOKE, true, (double) pos.getX() + 0.5D, (double) pos.getY() + 1D, (double) pos.getZ() + 0.5D, ExtraMath.rdoub(-0.1, 0.1), ExtraMath.rdoub(0, 0.05), ExtraMath.rdoub(-0.1, 0.1));
                    }
                } else if (ExtraMath.rint(0, 4) == 0) {
                    level.playLocalSound((double) pos.getX() + 0.5D, (double) pos.getY() + 0.5D, (double) pos.getZ() + 1D, SoundEvents.LAVA_EXTINGUISH, SoundSource.BLOCKS, 0.5F + random.nextFloat(), random.nextFloat() * 0.7F + 0.6F, false);
                    level.addAlwaysVisibleParticle(WNParticles.THERMAL_SMOKE, true, (double) pos.getX() + 0.5D, (double) pos.getY() + 1D, (double) pos.getZ() + 0.5D, ExtraMath.rdoub(-0.1, 0.1), ExtraMath.rdoub(0, 0.05), ExtraMath.rdoub(-0.1, 0.1));
                }
                level.addAlwaysVisibleParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, true, (double) pos.getX() + 0.5D, (double) pos.getY() + 1D, (double) pos.getZ() + 0.5D, 0.0D, 0.07D, 0.0D);
            }

            for (int i = 0; i < load; i++) {
                level.addParticle(ParticleTypes.BUBBLE_COLUMN_UP, true, (double) pos.getX() + ExtraMath.rdoub(0.1, 0.9), (double) pos.getY() + 1D, (double) pos.getZ() + ExtraMath.rdoub(0.1, 0.9), 0.0D, 0.07D, 0.0D);
            }
        }
    }

}
