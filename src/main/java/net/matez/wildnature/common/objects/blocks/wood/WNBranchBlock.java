package net.matez.wildnature.common.objects.blocks.wood;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.data.block_models.WNBlockModel_Branch;
import net.matez.wildnature.data.blockstates.WNBlockstate_Branch;
import net.matez.wildnature.data.item_models.WNItemModel_BlockParent;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class WNBranchBlock extends WNBlock implements ILog, SimpleWaterloggedBlock {
    public static final BooleanProperty UP = BlockStateProperties.UP;
    public static final BooleanProperty DOWN = BlockStateProperties.DOWN;
    public static final BooleanProperty NORTH = BlockStateProperties.NORTH;
    public static final BooleanProperty SOUTH = BlockStateProperties.SOUTH;
    public static final BooleanProperty EAST = BlockStateProperties.EAST;
    public static final BooleanProperty WEST = BlockStateProperties.WEST;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty TWIG = BooleanProperty.create("twig");
    public static final BooleanProperty CAN_UPDATE = BooleanProperty.create("can_update");

    private static final int size = 8;


    private final LogType logType;

    public WNBranchBlock(ResourceLocation location, Properties properties, LogType logType) {
        super(location, properties);
        this.logType = logType;
    }

    public WNBranchBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, LogType logType) {
        super(location, properties, itemProperties);
        this.logType = logType;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(UP, DOWN, NORTH, SOUTH, EAST, WEST, WATERLOGGED, TWIG, CAN_UPDATE);
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.stateDefinition.any()
                .setValue(UP, false)
                .setValue(DOWN, false)
                .setValue(NORTH, false)
                .setValue(SOUTH, false)
                .setValue(EAST, false)
                .setValue(WEST, false)
                .setValue(WATERLOGGED, false)
                .setValue(TWIG, false)
                .setValue(CAN_UPDATE, true)
        );
    }

    public WNBlock getLog() {
        return WNBlocks.LOGS.get(this.logType);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Branch(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String path = getLog().getTextureName("trees/" + this.logType.getBaseOrParent());
        return new ModelList()
                .with(
                        new WNBlockModel_Branch(this.getRegName() + "_up")
                                .with("texture", path)
                                .with("side", "up"),
                        new WNBlockModel_Branch(this.getRegName() + "_down")
                                .with("texture", path)
                                .with("side", "down"),
                        new WNBlockModel_Branch(this.getRegName() + "_side")
                                .with("texture", path)
                                .with("side", "side"),
                        new WNBlockModel_Branch(this.getRegName() + "_inventory")
                                .with("texture", path)
                                .with("side", "inventory"),
                        new WNBlockModel_Branch(this.getRegName() + "_none")
                                .with("texture", path)
                                .with("side", "none")
                );
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        return new WNItemModel_BlockParent(getRegName()).with("parent", this.getRegName() + "_inventory");
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.WN_BRANCHES, WNTags.MINEABLE_AXE
        );
    }

    @Nullable
    @Override
    public DropList getDrops(BlockState state, ServerLevel level, float luck) {
        return new DropList()
                .with(getLog().getItem(), 1).with(new ItemStack(Items.STICK, WNUtil.rint(1, 3)), 2);
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

    public BlockState getState(BlockState blockstate, BlockPos blockpos, LevelAccessor level, @Nullable Player player, boolean canReset){
        if (!blockstate.getValue(CAN_UPDATE)) {
            return blockstate;
        }

        BlockState down = level.getBlockState(blockpos.below());
        BlockState up = level.getBlockState(blockpos.above());
        BlockState north = level.getBlockState(blockpos.north());
        BlockState south = level.getBlockState(blockpos.south());
        BlockState east = level.getBlockState(blockpos.east());
        BlockState west = level.getBlockState(blockpos.west());

        boolean playerPlacing = player != null;

        if (down.is(this) || down.is(BlockTags.DIRT) || down.is(BlockTags.LEAVES) || (playerPlacing && down.isCollisionShapeFullBlock(level, blockpos.below()))) {
            blockstate = blockstate.setValue(DOWN, true);
        } else{
            if(canReset){
                blockstate = blockstate.setValue(DOWN, false);
            }
        }
        if (up.is(this) || up.is(BlockTags.LEAVES) || (playerPlacing && up.isCollisionShapeFullBlock(level, blockpos.above()))) {
            blockstate = blockstate.setValue(UP, true);
        } else{
            if(canReset){
                blockstate = blockstate.setValue(UP, false);
            }
        }

        if (north.is(this) || north.is(BlockTags.LEAVES) || (playerPlacing && north.isCollisionShapeFullBlock(level, blockpos.north()))) {
            blockstate = blockstate.setValue(NORTH, true);
        } else{
            if(canReset){
                blockstate = blockstate.setValue(NORTH, false);
            }
        }
        if (south.is(this) || south.is(BlockTags.LEAVES) || (playerPlacing && south.isCollisionShapeFullBlock(level, blockpos.south()))) {
            blockstate = blockstate.setValue(SOUTH, true);
        } else{
            if(canReset){
                blockstate = blockstate.setValue(SOUTH, false);
            }
        }
        if (east.is(this) || east.is(BlockTags.LEAVES) || (playerPlacing && east.isCollisionShapeFullBlock(level, blockpos.east()))) {
            blockstate = blockstate.setValue(EAST, true);
        } else{
            if(canReset){
                blockstate = blockstate.setValue(EAST, false);
            }
        }
        if (west.is(this) || west.is(BlockTags.LEAVES) || (playerPlacing && west.isCollisionShapeFullBlock(level, blockpos.west()))) {
            blockstate = blockstate.setValue(WEST, true);
        } else{
            if(canReset){
                blockstate = blockstate.setValue(WEST, false);
            }
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

        return getState(blockstate,blockpos,context.getLevel(),context.getPlayer(),false);
    }

    @Override
    public BlockState updateShape(BlockState state, Direction direction, BlockState neighbour, LevelAccessor levelAccessor, BlockPos pos, BlockPos neighbourPos) {
        return getState(state,pos,levelAccessor,null,false);
    }

    public VoxelShape getShape(BlockState state) {
        int start = size / 2;
        VoxelShape shape = Block.box(start, start, start, 16 - start, 16 - start, 16 - start);

        if (state.getValue(UP)) {
            shape = Shapes.join(shape, Block.box(start, 16 - start, start, 16 - start, 16, 16 - start), BooleanOp.OR);
        }
        if (state.getValue(DOWN)) {
            shape = Shapes.join(shape, Block.box(start, 0, start, 16 - start, start, 16 - start), BooleanOp.OR);
        }
        if (state.getValue(NORTH)) {
            shape = Shapes.join(shape, Block.box(start, start, 0, 16 - start, 16 - start, start), BooleanOp.OR);
        }
        if (state.getValue(SOUTH)) {
            shape = Shapes.join(shape, Block.box(start, start, 16 - start, 16 - start, 16 - start, 16), BooleanOp.OR);
        }
        if (state.getValue(WEST)) {
            shape = Shapes.join(shape, Block.box(0, start, start, start, 16 - start, 16 - start), BooleanOp.OR);
        }
        if (state.getValue(EAST)) {
            shape = Shapes.join(shape, Block.box(16 - start, start, start, 16, 16 - start, 16 - start), BooleanOp.OR);
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
}
