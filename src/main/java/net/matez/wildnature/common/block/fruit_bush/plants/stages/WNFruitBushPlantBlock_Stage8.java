package net.matez.wildnature.common.block.fruit_bush.plants.stages;

import net.matez.wildnature.common.block.fruit_bush.plants.FruitPlantType;
import net.matez.wildnature.common.block.fruit_bush.plants.WNFruitBushPlantTypedBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class WNFruitBushPlantBlock_Stage8 extends WNFruitBushPlantTypedBlock {
    public static IntegerProperty STAGE = IntegerProperty.create("stage", 0, 8);

    public WNFruitBushPlantBlock_Stage8(Properties properties, FruitPlantType fruitType) {
        super(properties, fruitType);
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
