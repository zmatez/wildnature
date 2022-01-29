/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.wood.base;

import net.matez.wildnature.common.objects.blockentities.table.WNTableBlockEntity;
import net.matez.wildnature.common.objects.blocks.basic.WNBaseEntityBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.data.blockstates.WNBlockstate_Table;
import net.matez.wildnature.data.item_models.WNItemModel_BlockParent;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class WNAbstractTableBlock extends WNBaseEntityBlock implements SimpleWaterloggedBlock {
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    private static final int size = 2;

    public WNAbstractTableBlock(ResourceLocation location, Properties properties) {
        super(location, properties);
    }

    public WNAbstractTableBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties) {
        super(location, properties, itemProperties);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(NORTH, SOUTH, EAST, WEST, WATERLOGGED);
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(NORTH, true)
                .setValue(SOUTH, true)
                .setValue(EAST, true)
                .setValue(WEST, true)
                .setValue(WATERLOGGED, false)
        );
    }

    public abstract Block getLog();

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Table(this.getRegistryName());
    }

    @Override
    public abstract ModelList getBlockModels();

    @Nullable
    @Override
    public WNResource getItemModel() {
        return new WNItemModel_BlockParent(getRegName()).with("parent", this.getRegName() + "_inventory");
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.WN_TABLES, WNTags.MINEABLE_AXE
        );
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 10;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 10;
    }


    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public boolean propagatesSkylightDown(BlockState state, BlockGetter getter, BlockPos pos) {
        return !state.getValue(WATERLOGGED);
    }

    public BlockState getState(BlockState blockstate, BlockPos blockpos, LevelAccessor level, @Nullable Player player){
        boolean changed = false;
        BlockState north = level.getBlockState(blockpos.north());
        BlockState south = level.getBlockState(blockpos.south());
        BlockState east = level.getBlockState(blockpos.east());
        BlockState west = level.getBlockState(blockpos.west());
        BlockState down = level.getBlockState(blockpos.below());

        ArrayList<Direction> directions = new ArrayList<>(Arrays.asList(Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST));

        if(down.isCollisionShapeFullBlock(level,blockpos.below())) {
            ArrayList<Direction> tablesNearby = new ArrayList<>();
            ArrayList<Direction> solidNearby = new ArrayList<>();


            if (north.isCollisionShapeFullBlock(level,blockpos.north())) {
                solidNearby.add(Direction.NORTH);
            }
            if (north.is(this)) {
                tablesNearby.add(Direction.NORTH);
            }
            if (south.isCollisionShapeFullBlock(level,blockpos.south())) {
                solidNearby.add(Direction.SOUTH);
            }
            if (south.is(this)) {
                tablesNearby.add(Direction.SOUTH);
            }
            if (east.isCollisionShapeFullBlock(level,blockpos.east())) {
                solidNearby.add(Direction.EAST);
            }
            if (east.is(this)) {
                tablesNearby.add(Direction.EAST);
            }
            if (west.isCollisionShapeFullBlock(level,blockpos.west())) {
                solidNearby.add(Direction.WEST);
            }
            if (west.is(this)) {
                tablesNearby.add(Direction.WEST);
            }


            if (tablesNearby.size() == 4) {
                directions.clear();
            } else {
                for (Direction direction : tablesNearby) {
                    directions.remove(direction);
                    directions.remove(direction.getClockWise());
                }
            }

            if(solidNearby.size() <= 3){
                for (Direction direction : solidNearby) {
                    directions.remove(direction);
                    directions.remove(direction.getClockWise());
                }
            }


        }else{
            directions.clear();
        }

        //
        if(directions.contains(Direction.NORTH)){
            if(!blockstate.getValue(NORTH)){
                blockstate = blockstate.setValue(NORTH,true);
                changed = true;
            }
        }else{
            if(blockstate.getValue(NORTH)){
                blockstate = blockstate.setValue(NORTH,false);
                changed = true;
            }
        }
        if(directions.contains(Direction.SOUTH)){
            if(!blockstate.getValue(SOUTH)){
                blockstate = blockstate.setValue(SOUTH,true);
                changed = true;
            }
        }else{
            if(blockstate.getValue(SOUTH)){
                blockstate = blockstate.setValue(SOUTH,false);
                changed = true;
            }
        }
        if(directions.contains(Direction.EAST)){
            if(!blockstate.getValue(EAST)){
                blockstate = blockstate.setValue(EAST,true);
                changed = true;
            }
        }else{
            if(blockstate.getValue(EAST)){
                blockstate = blockstate.setValue(EAST,false);
                changed = true;
            }
        }
        if(directions.contains(Direction.WEST)){
            if(!blockstate.getValue(WEST)){
                blockstate = blockstate.setValue(WEST,true);
                changed = true;
            }
        }else{
            if(blockstate.getValue(WEST)){
                blockstate = blockstate.setValue(WEST,false);
                changed = true;
            }
        }
        
        if(changed){
            level.blockUpdated(blockpos,blockstate.getBlock());
        }
        return blockstate;
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(blockpos);
        BlockState blockstate = super.getStateForPlacement(context);
        if (blockstate == null) {
            return null;
        }
        blockstate = blockstate.setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);

        return getState(blockstate,blockpos,context.getLevel(),context.getPlayer());
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        if(!super.canSurvive(state, reader, pos)){
            return false;
        }

        if(!reader.getBlockState(pos.below()).isCollisionShapeFullBlock(reader,pos.below())) {
            for (Direction value : Direction.values()) {
                if (value.getAxis() != Direction.Axis.Y) {
                    BlockState nearby = reader.getBlockState(pos.relative(value));
                    if (nearby.isCollisionShapeFullBlock(reader,pos)) {
                        return true;
                    }
                }
            }

            return false;
        }else{
            return true;
        }
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighbour, LevelAccessor levelAccessor, BlockPos pos, BlockPos neighbourPos) {
        if(!canSurvive(state,levelAccessor,pos)){
            return Blocks.AIR.defaultBlockState();
        }
        return getState(state,pos,levelAccessor,null);
    }

    public VoxelShape getShape(BlockState state) {
        VoxelShape shape = Block.box(0, 13, 0, 16, 16,16);

        if (state.getValue(NORTH)) {
            shape = Shapes.join(shape, Block.box(0, 0, 0, size, 13, size), BooleanOp.OR);
        }
        if (state.getValue(SOUTH)) {
            shape = Shapes.join(shape, Block.box(16 - size, 0, 16 - size, 16,16,16), BooleanOp.OR);
        }
        if (state.getValue(WEST)) {
            shape = Shapes.join(shape, Block.box(0, 0, 16 - size, size, 16, 16), BooleanOp.OR);
        }
        if (state.getValue(EAST)) {
            shape = Shapes.join(shape, Block.box(16 - size, 0, 0, 16, 16, size), BooleanOp.OR);
        }

        return shape;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter p_60556_, BlockPos p_60557_, CollisionContext p_60558_) {
        return getShape(state);
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter p_60573_, BlockPos p_60574_, CollisionContext p_60575_) {
        return getShape(state);
    }

    //todo mirror and rotate


    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new WNTableBlockEntity(pos,state);
    }

    public RenderShape getRenderShape(BlockState p_54296_) {
        return RenderShape.MODEL;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        BlockEntity entity = level.getBlockEntity(pos);
        if(entity instanceof WNTableBlockEntity table) {
            ItemStack held = player.getItemInHand(hand);
            if (held.isEmpty() && table.hasPlacedStack()) {
                table.drop();
                level.playLocalSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.ITEM_FRAME_REMOVE_ITEM, SoundSource.BLOCKS,0.6f,0.8f,false);
                return InteractionResult.SUCCESS;
            }else if(!held.isEmpty()){
                if(!table.hasPlacedStack()){
                    table.place(held,player.getDirection());
                    player.setItemInHand(hand,ItemStack.EMPTY);
                    level.playLocalSound(pos.getX(),pos.getY(),pos.getZ(), SoundEvents.ITEM_FRAME_ADD_ITEM, SoundSource.BLOCKS,0.6f,0.8f,false);
                    return InteractionResult.SUCCESS;
                }
            }
        }

        return super.use(state, level, pos, player, hand, result);
    }

    @Override
    public void destroy(LevelAccessor accessor, BlockPos pos, BlockState state) {
        BlockEntity entity = accessor.getBlockEntity(pos);
        if(entity instanceof WNTableBlockEntity table) {
            table.drop();
        }
        super.destroy(accessor, pos, state);
    }

    @Override
    public boolean onDestroyedByPlayer(BlockState state, Level world, BlockPos pos, Player player, boolean willHarvest, FluidState fluid) {
        BlockEntity entity = world.getBlockEntity(pos);
        if(entity instanceof WNTableBlockEntity table) {
            table.drop();
        }
        return super.onDestroyedByPlayer(state, world, pos, player, willHarvest, fluid);
    }
}
