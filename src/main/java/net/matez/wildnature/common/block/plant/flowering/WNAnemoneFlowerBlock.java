package net.matez.wildnature.common.block.plant.flowering;

import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.common.block.WNBlockProperties;
import net.matez.wildnature.common.block.plant.BushType;
import net.matez.wildnature.common.block.plant.WNBushConfiguredBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class WNAnemoneFlowerBlock extends WNBushConfiguredBlock {
    public static final IntegerProperty STAGE = WNBlockProperties.ANEMONE_STAGE;

    public WNAnemoneFlowerBlock(Properties properties, BushType type) {
        super(properties, type);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        def.add(STAGE);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state != null && context.getPlayer() != null && context.getPlayer().isCreative()){
            return state.setValue(STAGE,getStage(context.getLevel()));
        }
        return state;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if(state.getValue(STAGE) == 0){
            if(ExtraMath.rint(0,5) == 0){
                level.setBlock(pos,state.setValue(STAGE,getStage(level)),2);
            }
        }else{
            int stage = getStage(level);
            if(state.getValue(STAGE) != stage){
                level.setBlock(pos,state.setValue(STAGE,stage),2);
            }
        }
    }

    public int getStage(Level level){
        long time = level.getDayTime();
        if(time >= 0 && time < 2000){
            return 2;
        }else if(time >= 2000 && time < 9000){
            return 3;
        }else if(time >= 10000 && time < 13000){
            return 2;
        }else{
            return 1;
        }
    }
}
