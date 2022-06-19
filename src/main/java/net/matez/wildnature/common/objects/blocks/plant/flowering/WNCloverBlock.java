/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.plant.flowering;

import net.matez.wildnature.common.objects.blocks.plant.BushType;
import net.matez.wildnature.common.objects.blocks.plant.WNBushConfiguredBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_CloverMedium;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_CloverShort;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_CloverTall;
import net.matez.wildnature.data.blockstates.WNBlockstate_Clover;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class WNCloverBlock extends WNBushConfiguredBlock {
    public static final IntegerProperty CLOVER_STAGE = WNBlockProperties.CLOVER_STAGE;
    private static final double OFFSET = 1.5D;
    protected static final VoxelShape SHAPE_STAGE_0 = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 3.0D, 16.0D - OFFSET);
    protected static final VoxelShape SHAPE_STAGE_1 = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 6.0D, 16.0D - OFFSET);
    protected static final VoxelShape SHAPE_STAGE_2 = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 9.0D, 16.0D - OFFSET);

    public WNCloverBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNCloverBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public void place(BlockState state, LevelAccessor reader, BlockPos pos, int data) {
        reader.setBlock(pos, state.setValue(CLOVER_STAGE, WNUtil.rint(0, 2, reader.getRandom())), data);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(CLOVER_STAGE) < 2;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        super.randomTick(state, level, pos, random);

        int stage = state.getValue(CLOVER_STAGE);
        if (stage < 2) {
            level.setBlock(pos, state.setValue(CLOVER_STAGE, stage + 1), 3);
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        def.add(CLOVER_STAGE);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Clover(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String texture = this.getTextureName("plants/surface/clover");
        return new ModelList().with(
                new WNBlockModel_CloverShort(getRegName() + "_short_purple")
                    .with("texture",texture)
                    .with("color","purple"),
                new WNBlockModel_CloverShort(getRegName() + "_short_pink")
                    .with("texture",texture)
                    .with("color","pink"),
                new WNBlockModel_CloverShort(getRegName() + "_short_white")
                    .with("texture",texture)
                    .with("color","white"),
                new WNBlockModel_CloverShort(getRegName() + "_short_empty")
                    .with("texture",texture)
                    .with("color","empty"),
                new WNBlockModel_CloverMedium(getRegName() + "_medium_purple")
                    .with("texture",texture)
                    .with("color","purple"),
                new WNBlockModel_CloverMedium(getRegName() + "_medium_pink")
                    .with("texture",texture)
                    .with("color","pink"),
                new WNBlockModel_CloverMedium(getRegName() + "_medium_white")
                    .with("texture",texture)
                    .with("color","white"),
                new WNBlockModel_CloverMedium(getRegName() + "_medium_empty")
                    .with("texture",texture)
                    .with("color","empty"),
                new WNBlockModel_CloverTall(getRegName() + "_tall_purple")
                    .with("texture",texture)
                    .with("color","purple"),
                new WNBlockModel_CloverTall(getRegName() + "_tall_pink")
                    .with("texture",texture)
                    .with("color","pink"),
                new WNBlockModel_CloverTall(getRegName() + "_tall_white")
                    .with("texture",texture)
                    .with("color","white"),
                new WNBlockModel_CloverTall(getRegName() + "_tall_empty")
                    .with("texture",texture)
                    .with("color","empty")
        );
    }

    @javax.annotation.Nullable
    public WNResource getItemModel(){
        return new WNItemModel_Generated(getRegName()).with("texture", this.getTextureName("plants/surface/clover") + "_item");
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);

        int stage = state.getValue(CLOVER_STAGE);
        switch (stage){
            case 0 -> {
                return SHAPE_STAGE_0.move(vec3.x, vec3.y, vec3.z);
            }
            case 1 -> {
                return SHAPE_STAGE_1.move(vec3.x, vec3.y, vec3.z);
            }
            case 2 -> {
                return SHAPE_STAGE_2.move(vec3.x, vec3.y, vec3.z);
            }
        }

        return SHAPE_STAGE_0.move(vec3.x, vec3.y, vec3.z);
    }
}
