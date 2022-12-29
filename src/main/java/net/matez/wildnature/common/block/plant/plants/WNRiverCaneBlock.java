package net.matez.wildnature.common.block.plant.plants;

import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.common.block.plant.WNBushConfiguredBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WNRiverCaneBlock extends WNBushConfiguredBlock {
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final double OFFSET = 3D;
    protected static final VoxelShape SHAPE = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 16.0D, 16.0D - OFFSET);

    public WNRiverCaneBlock(Properties properties, BushType type) {
        super(properties, type);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> context) {
        super.createBlockStateDefinition(context);
        context.add(WATERLOGGED);
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected boolean mayPlaceOn(BlockState stateOn, BlockGetter getter, BlockPos pos) {
        return super.mayPlaceOn(stateOn, getter, pos) || stateOn.is(this);
    }

    public boolean canSurvive(BlockState state, LevelReader reader, BlockPos pos) {
        BlockState soil = reader.getBlockState(pos.below());
        if (soil.canSustainPlant(reader, pos.below(), Direction.UP, this)) return true;
        BlockState blockstate = reader.getBlockState(pos.below());
        if (blockstate.is(this)) {
            return true;
        } else {
            if (mayPlaceOn(blockstate,reader,pos)) {
                if(reader.isWaterAt(pos) && reader.isEmptyBlock(pos.above(5))){
                    return true;
                }

                BlockPos blockpos = pos.below();

                for(Direction direction : Direction.Plane.HORIZONTAL) {
                    BlockState blockstate1 = reader.getBlockState(blockpos.relative(direction));
                    FluidState fluidstate = reader.getFluidState(blockpos.relative(direction));
                    if (fluidstate.is(FluidTags.WATER) || blockstate1.is(Blocks.FROSTED_ICE)) {
                        return true;
                    }
                }
            }

            return false;
        }
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
        return blockstate;
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

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        boolean water = level.getBlockState(pos.above()).is(Blocks.WATER);
        if (level.isEmptyBlock(pos.above()) || water) {
            int i;
            for(i = 1; level.getBlockState(pos.below(i)).is(this); ++i) {
            }

            if (i < 3) {
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, true)) {
                    level.setBlockAndUpdate(pos.above(), this.defaultBlockState().setValue(WATERLOGGED,water));
                }
            }
        }

    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.NONE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
