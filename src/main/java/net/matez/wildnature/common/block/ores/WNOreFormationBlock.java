/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.ores;

import net.matez.wildnature.common.block.plant.plants.WNVerticalBushBlock;
import net.matez.wildnature.common.block.ModelSupplier;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.data.blockstates.WNBlockstate_FacedCube;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public class WNOreFormationBlock extends WNOreBlock{
    public static final DirectionProperty FACING = BlockStateProperties.FACING;
    private static Map<Direction,VoxelShape> SHAPES = WNVerticalBushBlock.createFacingShape(10,2);

    public WNOreFormationBlock(ResourceLocation location, Properties properties, Ore ore) {
        super(location, properties, ore);
    }

    public WNOreFormationBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, Ore ore) {
        super(location, properties, itemProperties, ore);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        super.createBlockStateDefinition(def);
        def.add(FACING);
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return level.getBlockState(pos.relative(state.getValue(FACING).getOpposite())).isCollisionShapeFullBlock(level, pos.relative(state.getValue(FACING).getOpposite()));
    }

    public VoxelShape getShape(BlockState state, BlockGetter p_58093_, BlockPos p_58094_, CollisionContext p_58095_) {
        return SHAPES.get(state.getValue(FACING));
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_FacedCube(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        if(this.ore.getModels() == null){
            return null;
        }
        ModelList list = new ModelList();
        for (ModelSupplier model : this.ore.getModels()) {
            list.with(model.getModel(this).with("texture",this.getTextureName("ores/" + this.ore.getFolder())));
        }

        return list;
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("ores/" + this.ore.getFolder()) + "_item");
    }

    public BlockState rotate(BlockState p_154354_, Rotation p_154355_) {
        return p_154354_.setValue(FACING, p_154355_.rotate(p_154354_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_154351_, Mirror p_154352_) {
        return p_154351_.setValue(FACING, p_154352_.mirror(p_154351_.getValue(FACING)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state == null) {
            return null;
        }
        Direction direction = context.getClickedFace();
        if (!isDirectionAllowed(context,direction)) {
            return null;
        }

        state = state.setValue(FACING, direction);

        return canSurvive(state, context.getLevel(), context.getClickedPos()) ? state : null;
    }

    public BlockState updateShape(BlockState p_51032_, Direction p_51033_, BlockState p_51034_, LevelAccessor p_51035_, BlockPos p_51036_, BlockPos p_51037_) {
        return !p_51032_.canSurvive(p_51035_, p_51036_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_51032_, p_51033_, p_51034_, p_51035_, p_51036_, p_51037_);
    }

    public boolean isDirectionAllowed(BlockPlaceContext context, Direction direction){
        return true;
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        if(this.ore == Ore.DARK_AMETHYST_FORMATION || this.ore == Ore.TOPAZ_FORMATION){
            return super.getWNTags().with(WNTags.NEEDS_DIAMOND_TOOL);
        }
        return super.getWNTags().with(WNTags.NEEDS_IRON_TOOL);
    }
}
