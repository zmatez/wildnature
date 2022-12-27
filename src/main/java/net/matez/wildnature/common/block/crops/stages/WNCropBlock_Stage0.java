package net.matez.wildnature.common.block.crops.stages;

import net.matez.wildnature.common.block.crops.CropType;
import net.matez.wildnature.common.block.crops.WNCropTypedBlock;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class WNCropBlock_Stage0 extends WNCropTypedBlock {
    public static IntegerProperty STAGE_ = null;

    public WNCropBlock_Stage0(ResourceLocation location, Properties properties, CropType cropType) {
        super(location, properties, cropType);
        this.STAGE = STAGE_;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        super.createBlockStateDefinition(state);
        if(STAGE_ != null){
            state.add(STAGE_);
        }
    }
}
