package net.matez.wildnature.common.block.plant.flowering;

import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.common.block.WNBlockProperties;
import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.common.block.plant.WNDoublePlantBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class WNChineseLanternFlowerBlock extends WNDoublePlantBlock {
    public static final IntegerProperty STAGE = WNBlockProperties.CHINESE_LANTERN_STAGE;

    public WNChineseLanternFlowerBlock(Properties properties, BushType type) {
        super(properties, type);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(STAGE,0));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        super.createBlockStateDefinition(def);
        def.add(STAGE);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state != null && context.getPlayer() != null && context.getPlayer().isCreative()){
            return state.setValue(STAGE,3);
        }
        return state;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(STAGE) != 3 && state.getValue(HALF) == DoubleBlockHalf.LOWER;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
        BlockPos blockpos = pos.above();
        level.setBlock(blockpos, copyWaterloggedFrom(level, blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(STAGE, state.getValue(STAGE))), 3);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(state.getValue(STAGE) != 3){
            if(ExtraMath.rint(0,5) == 0){
                placeAt(level,state.setValue(STAGE,state.getValue(STAGE) + 1),pos,2);
            }
        }
    }
}
