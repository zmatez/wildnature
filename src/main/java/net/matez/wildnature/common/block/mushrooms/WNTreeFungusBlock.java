/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.mushrooms;

import net.matez.wildnature.common.block.plant.BushPlacement;
import net.matez.wildnature.common.block.plant.plants.WNVerticalBushBlock;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TreeFungus;
import net.matez.wildnature.data.blockstates.WNBlockstate_FacedHorizCube;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
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

public class WNTreeFungusBlock extends WNMushroomBlock{
    public static Map<Direction, VoxelShape> SHAPE = WNVerticalBushBlock.createFacingShape(8,4);
    public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

    public WNTreeFungusBlock(ResourceLocation location, Properties properties, Mushroom mushroom) {
        super(location, properties, mushroom);
    }

    public WNTreeFungusBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, Mushroom mushroom) {
        super(location, properties, itemProperties, mushroom);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        def.add(FACING);
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_FacedHorizCube(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_TreeFungus(this.getRegName()).with("texture",this.getTextureName("plants/surface/mushrooms"))
        );
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state == null) {
            return null;
        }
        Direction direction = context.getClickedFace();
        if (!isDirectionAllowed(context, direction)) {
            return null;
        }

        state = state.setValue(FACING, direction);

        return canSurvive(state, context.getLevel(), context.getClickedPos()) ? state : null;
    }

    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        return mayPlaceOn(state, reader.getBlockState(pos.relative(state.getValue(FACING).getOpposite())), reader, pos);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockState stateOn, BlockGetter getter, BlockPos pos) {
        return BushPlacement.LOGS.getSupplier().canPlace( stateOn, getter, pos);
    }

    public VoxelShape getShape(BlockState p_58092_, BlockGetter p_58093_, BlockPos p_58094_, CollisionContext p_58095_) {
        return SHAPE.get(p_58092_.getValue(FACING));
    }

    public boolean isDirectionAllowed(BlockPlaceContext context, Direction direction){
        return direction.getAxis() != Direction.Axis.Y;
    }

    public BlockState rotate(BlockState p_154354_, Rotation p_154355_) {
        return p_154354_.setValue(FACING, p_154355_.rotate(p_154354_.getValue(FACING)));
    }

    public BlockState mirror(BlockState p_154351_, Mirror p_154352_) {
        return p_154351_.setValue(FACING, p_154352_.mirror(p_154351_.getValue(FACING)));
    }
}
