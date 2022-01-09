package net.matez.wildnature.common.objects.blocks.plant.plants;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import net.matez.wildnature.common.objects.blocks.plant.BushType;
import net.matez.wildnature.common.objects.blocks.plant.WNBushConfiguredBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Map;

public abstract class WNVerticalBushBlock extends WNBushConfiguredBlock {
    public static Map<Direction,VoxelShape> SHAPE = createFacingShape(1,3);
    public static Map<Direction, VoxelShape> createFacingShape(float thickness, float offset){
        return Maps.newEnumMap(ImmutableMap.of(
                Direction.NORTH, Block.box(offset, offset, 16 - thickness, 16.0D - offset, 16 - offset, 16.0D),
                Direction.SOUTH, Block.box(offset, offset, 0, 16.0D - offset, 16 - offset, thickness),
                Direction.EAST, Block.box(0, offset, offset, thickness, 16 - offset, 16.0D - offset),
                Direction.WEST, Block.box(16 - thickness, offset, offset, 16.0D, 16 - offset, 16.0D - offset),
                Direction.DOWN, Block.box(offset, 16 - thickness, offset, 16.0D - offset, 16.0D, 16.0D - offset),
                Direction.UP, Block.box(offset, 0.0D, offset, 16.0D - offset, thickness, 16.0D - offset)
        ));
    }

    public static final DirectionProperty FACING = BlockStateProperties.FACING;

    public WNVerticalBushBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNVerticalBushBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
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

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if (state == null) {
            return null;
        }
        Direction direction = context.getNearestLookingDirection().getOpposite();
        if (!isDirectionAllowed(context,direction)) {
            return null;
        }

        state = state.setValue(FACING, direction);

        return canSurvive(state, context.getLevel(), context.getClickedPos()) ? state : null;
    }

    public boolean canSurvive(BlockState state, LevelReader level, BlockPos pos) {
        return mayPlaceOn(state,level.getBlockState(pos.relative(state.getValue(FACING).getOpposite())),level,pos);
    }

    public VoxelShape getShape(BlockState p_58092_, BlockGetter p_58093_, BlockPos p_58094_, CollisionContext p_58095_) {
        return SHAPE.get(p_58092_.getValue(FACING));
    }

    public boolean isDirectionAllowed(BlockPlaceContext context, Direction direction){
        return true;
    }
}
