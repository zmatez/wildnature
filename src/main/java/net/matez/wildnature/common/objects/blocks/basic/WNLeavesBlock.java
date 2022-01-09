package net.matez.wildnature.common.objects.blocks.basic;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.common.objects.items.setup.WNBlockItem;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.setup.WNRenderType;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IForgeShearable;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public abstract class WNLeavesBlock extends WNBlock implements IForgeShearable, SimpleWaterloggedBlock {
    protected static final VoxelShape SHAPE = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 13.0D, 16.0D);

    public static final BooleanProperty HYDRATED = WNBlockProperties.LEAVES_HYDRATED;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;

    public WNLeavesBlock(ResourceLocation location, Properties properties) {
        super(location, properties);
    }

    public WNLeavesBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties) {
        super(location, properties, itemProperties);
    }

    public WNLeavesBlock(ResourceLocation location, Properties properties, WNBlockItem item) {
        super(location, properties, item);
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.stateDefinition.any().setValue(HYDRATED, true).setValue(WATERLOGGED, false));
    }

    @Override
    public WNRenderType getRenderType() {
        return WNRenderType.CUTOUT;
    }

    public FluidState getFluidState(BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    public boolean propagatesSkylightDown(BlockState state, BlockGetter getter, BlockPos pos) {
        return !state.getValue(WATERLOGGED);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_54447_) {
        p_54447_.add(HYDRATED, WATERLOGGED);
    }

    public int getLightBlock(BlockState state, BlockGetter getter, BlockPos pos) {
        return 1;
    }

    public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
        if (level.isRainingAt(pos.above())) {
            if (random.nextInt(15) == 1) {
                BlockPos blockpos = pos.below();
                BlockState blockstate = level.getBlockState(blockpos);
                if (!blockstate.canOcclude() || !blockstate.isFaceSturdy(level, blockpos, Direction.UP)) {
                    double d0 = (double)pos.getX() + random.nextDouble();
                    double d1 = (double)pos.getY() - 0.05D;
                    double d2 = (double)pos.getZ() + random.nextDouble();
                    level.addParticle(ParticleTypes.DRIPPING_WATER, d0, d1, d2, 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }

    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(HYDRATED);
    }

    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if (!state.getValue(HYDRATED)) {
            dropResources(state, level, pos);
            level.removeBlock(pos, false);
        }
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockPos blockpos = context.getClickedPos();
        FluidState fluidstate = context.getLevel().getFluidState(blockpos);
        BlockState blockstate = super.getStateForPlacement(context);
        if(blockstate == null){
            return null;
        }
        blockstate = blockstate.setValue(WATERLOGGED, fluidstate.getType() == Fluids.WATER);
        if(context.getPlayer() != null){
            if(!context.getPlayer().isCreative()){
                blockstate = blockstate.setValue(HYDRATED,true);
            }
        }else{
            blockstate = blockstate.setValue(HYDRATED,true);
        }
        return blockstate;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 30;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return 60;
    }

    public VoxelShape getCollisionShape(BlockState p_56702_, BlockGetter p_56703_, BlockPos p_56704_, CollisionContext p_56705_) {
        return SHAPE;
    }

    public VoxelShape getBlockSupportShape(BlockState p_56707_, BlockGetter p_56708_, BlockPos p_56709_) {
        return Shapes.block();
    }

    public VoxelShape getVisualShape(BlockState p_56684_, BlockGetter p_56685_, BlockPos p_56686_, CollisionContext p_56687_) {
        return Shapes.block();
    }

    public BlockState updateShape(BlockState state, Direction p_56926_, BlockState p_56927_, LevelAccessor accessor, BlockPos pos, BlockPos p_56930_) {
        if (state.getValue(WATERLOGGED)) {
            accessor.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(accessor));
        }

        return state;
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.LEAVES, WNTags.MINEABLE_HOE, WNTags.PARROTS_SPAWNABLE_ON, WNTags.LAVA_POOL_STONE_CANNOT_REPLACE
        );
    }
}
