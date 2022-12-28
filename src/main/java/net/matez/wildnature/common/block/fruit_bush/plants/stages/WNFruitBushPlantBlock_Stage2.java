package net.matez.wildnature.common.block.fruit_bush.plants.stages;

import net.matez.wildnature.common.block.fruit_bush.plants.FruitPlantType;
import net.matez.wildnature.common.block.fruit_bush.plants.WNFruitBushPlantTypedBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class WNFruitBushPlantBlock_Stage2 extends WNFruitBushPlantTypedBlock {
    public static IntegerProperty STAGE = IntegerProperty.create("stage", 0, 2);

    public WNFruitBushPlantBlock_Stage2(Properties properties, FruitPlantType fruitType) {
        super(location, properties, fruitType);
        this.LEAF_STAGE = STAGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        super.createBlockStateDefinition(state);
        if(STAGE != null){
            state.add(STAGE);
        }
    }
}
