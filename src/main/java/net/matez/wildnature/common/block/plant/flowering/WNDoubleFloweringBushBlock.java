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
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import org.jetbrains.annotations.Nullable;

public class WNDoubleFloweringBushBlock extends WNDoublePlantBlock implements BonemealableBlock {
    public static final BooleanProperty FLOWERING = WNBlockProperties.FLOWERING;

    public WNDoubleFloweringBushBlock(Properties properties, BushType type) {
        super(properties,type);
        registerDefaultState(this.stateDefinition.any().setValue(FLOWERING,false).setValue(HALF, DoubleBlockHalf.LOWER));

    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state != null && context.getPlayer() != null && context.getPlayer().isCreative()){
            return super.getStateForPlacement(context).setValue(FLOWERING,true);
        }
        return state;
    }


    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(FLOWERING) && state.getValue(HALF) == DoubleBlockHalf.LOWER;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(ExtraMath.rint(0,5, random) == 0 && state.getValue(HALF) == DoubleBlockHalf.LOWER){
            placeAt(level,state.setValue(FLOWERING,true),pos,2);
        }
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
        BlockPos blockpos = pos.above();
        level.setBlock(blockpos, copyWaterloggedFrom(level, blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(FLOWERING, state.getValue(FLOWERING))), 3);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> definition) {
        definition.add(FLOWERING);
        super.createBlockStateDefinition(definition);
    }

    @Override
    public boolean canBeReplaced(BlockState p_57313_, BlockPlaceContext p_57314_) {
        return false;
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader p_256559_, BlockPos p_50898_, BlockState p_50899_, boolean p_50900_) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level p_220878_, RandomSource p_220879_, BlockPos p_220880_, BlockState p_220881_) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel p_220874_, RandomSource p_220875_, BlockPos p_220876_, BlockState p_220877_) {
        if(ExtraMath.rint(0,2) == 0){
            popResource(p_220874_, p_220876_, new ItemStack(this));
        }
    }
}
