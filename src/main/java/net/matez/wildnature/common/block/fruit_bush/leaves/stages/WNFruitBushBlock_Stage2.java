package net.matez.wildnature.common.block.fruit_bush.leaves.stages;

import net.matez.wildnature.common.block.fruit_bush.leaves.FruitBushType;
import net.matez.wildnature.common.block.fruit_bush.leaves.WNFruitBushTypedBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class WNFruitBushBlock_Stage2 extends WNFruitBushTypedBlock {
    public static IntegerProperty STAGE = IntegerProperty.create("stage", 0, 2);

    public WNFruitBushBlock_Stage2(Properties properties, FruitBushType leafType) {
        super(properties, leafType);
    }

    @Override
    public @Nullable IntegerProperty getLeafStageProperty() {
        return STAGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        super.createBlockStateDefinition(state);
        if(STAGE != null){
            state.add(STAGE);
        }
    }
}
