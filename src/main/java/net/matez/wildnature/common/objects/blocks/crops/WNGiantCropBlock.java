/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.crops;

import net.matez.wildnature.common.objects.blocks.crops.stages.WNCropBlock_Stage2;
import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.common.objects.items.vegetables.WNVeggieBlockItem;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.items.WNItems;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WNGiantCropBlock extends WNCropBlock_Stage2 {
    public static BooleanProperty GROWING = WNBlockProperties.GROWING;
    public static VoxelShape[] SHAPE_CORN = new VoxelShape[]{
            Block.box(7D, 0.0D, 7D, 16.0D, 5.0D, 16.0D),
            Block.box(3D, 0.0D, 3D, 16.0D, 16.0D, 16.0D),
            Block.box(3D, 0.0D, 3D, 16.0D, 16.0D, 16.0D)
    };
    public static VoxelShape[] SHAPE = new VoxelShape[]{
            Block.box(4.5D, 0.0D, 4.5D, 16.0D, 16.0D, 16.0D),
            Block.box(3D, 0.0D, 3D, 16.0D, 16.0D, 16.0D),
            Block.box(3D, 0.0D, 3D, 16.0D, 16.0D, 16.0D)
    };

    public WNGiantCropBlock(ResourceLocation location, Properties properties, CropType cropType) {
        super(location, properties, cropType);
    }

    public WNGiantCropBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, CropType cropType) {
        super(location, properties, cropType);

        this.item = new WNVeggieBlockItem(this, itemProperties, cropType.getVeggie());
        this.item.setRegistryName(WNItems.location(cropType.getVeggie().getId()));
        WNItems.BLOCK_ITEMS.put(location, this.item);
        WNItems.VEGGIES.put(cropType.getVeggie(), this.item);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        super.createBlockStateDefinition(state);
        state.add(GROWING);
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.defaultBlockState().setValue(GROWING, true));
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockState stateOn, BlockGetter getter, BlockPos pos) {
        return super.mayPlaceOn(state, stateOn, getter, pos) || (stateOn.is(this) && stateOn.getValue(STAGE) > 0);
    }

    public BlockState updateShape(BlockState state, Direction direction, BlockState state2, LevelAccessor level, BlockPos pos, BlockPos pos2) {
        if (!state.canSurvive(level, pos)) {
            level.scheduleTick(pos, this, 1);
        }

        return super.updateShape(state, direction, state2, level, pos, pos2);
    }

    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if (!state.canSurvive(level, pos)) {
            level.destroyBlock(pos, true);
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(GROWING) && super.isRandomlyTicking(state);
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if (level.isEmptyBlock(pos.above())) {
            int i;
            for (i = 1; level.getBlockState(pos.below(i)).is(this); ++i) {
            }

            if (i < 5) {
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, true)) {
                    if(level.getBlockState(pos).getValue(STAGE) > 0) {
                        level.setBlockAndUpdate(pos.above(), this.defaultBlockState());
                    }else{
                        level.setBlockAndUpdate(pos,state.setValue(STAGE,state.getValue(STAGE) + 1));
                        if(i < 4 || this.cropType == CropType.CORN) {
                            level.setBlockAndUpdate(pos.above(), this.defaultBlockState());
                        }
                    }
                }
            }
        }else{
            level.setBlockAndUpdate(pos,state.setValue(STAGE,state.getValue(STAGE) + 1));
        }
    }

    @Override
    public ModelList getBlockModels() {
        ModelList list = new ModelList();
        if (this.cropType.getStages() > 1) {
            for (int i = 0; i < this.cropType.getStages(); i++) {
                int j = i + 1;
                WNResource model = new WNBlockModel_TintedCross(this.getRegName() + "_stage_" + j)
                        .with("texture", this.getTextureName("crops/" + cropType.getFolder()) + "_plant_stage_" + j);
                list.with(model);
            }
        } else {
            WNResource model = new WNBlockModel_TintedCross(this.getRegName())
                    .with("texture", this.getTextureName("crops/" + cropType.getFolder()));
            list.with(model);
        }
        return list;
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.CROPS
        );
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        if(cropType == CropType.CORN){
            return SHAPE_CORN[state.getValue(STAGE)].move(vec3.x, vec3.y, vec3.z);
        }
        return SHAPE[state.getValue(STAGE)].move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    public void entityInside(BlockState state, Level p_60496_, BlockPos p_60497_, Entity entity) {
        super.entityInside(state, p_60496_, p_60497_, entity);
        entity.makeStuckInBlock(state,new Vec3(0.5,0.5,0.5));
    }
}
