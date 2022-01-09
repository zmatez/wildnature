package net.matez.wildnature.common.objects.blocks.fruit_bush.leaves.stages;

import net.matez.wildnature.common.objects.blocks.fruit_bush.leaves.FruitBushType;
import net.matez.wildnature.common.objects.blocks.fruit_bush.leaves.WNFruitBushTypedBlock;
import net.matez.wildnature.common.objects.blocks.leaves.LeafType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class WNFruitBushBlock_Stage1 extends WNFruitBushTypedBlock {
    public static IntegerProperty STAGE = IntegerProperty.create("stage", 0, 1);

    public WNFruitBushBlock_Stage1(ResourceLocation location, Properties properties, FruitBushType leafType) {
        super(location, properties, leafType);
        this.LEAF_STAGE = STAGE;
    }

    public WNFruitBushBlock_Stage1(ResourceLocation location, Properties properties, Item.Properties itemProperties, FruitBushType leafType) {
        super(location, properties, itemProperties, leafType);
        this.LEAF_STAGE = STAGE;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        super.createBlockStateDefinition(state);
        if(STAGE != null){
            state.add(STAGE);
        }
    }
}
