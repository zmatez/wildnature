package net.matez.wildnature.common.objects.blocks.leaves.stages;

import net.matez.wildnature.common.objects.blocks.leaves.LeafType;
import net.matez.wildnature.common.objects.blocks.leaves.WNLeavesTypedBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class WNLeavesTypedBlock_Stage6 extends WNLeavesTypedBlock {
    public static IntegerProperty STAGE = IntegerProperty.create("stage", 0, 6);

    public WNLeavesTypedBlock_Stage6(ResourceLocation location, Properties properties, LeafType leafType) {
        super(location, properties, leafType);
        this.LEAF_STAGE = STAGE;
    }

    public WNLeavesTypedBlock_Stage6(ResourceLocation location, Properties properties, Item.Properties itemProperties, LeafType leafType) {
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
