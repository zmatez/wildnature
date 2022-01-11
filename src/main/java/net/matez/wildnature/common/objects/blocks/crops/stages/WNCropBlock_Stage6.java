package net.matez.wildnature.common.objects.blocks.crops.stages;

import net.matez.wildnature.common.objects.blocks.crops.CropType;
import net.matez.wildnature.common.objects.blocks.crops.WNCropTypedBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class WNCropBlock_Stage6 extends WNCropTypedBlock {
    public static IntegerProperty STAGE_ = IntegerProperty.create("stage", 0, 6);

    private static final VoxelShape[] SHAPE_BY_AGE = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 3.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 11.0D, 16.0D)
    };

    public WNCropBlock_Stage6(ResourceLocation location, Properties properties, CropType cropType) {
        super(location, properties, cropType);
        this.STAGE = STAGE_;
    }

    public WNCropBlock_Stage6(ResourceLocation location, Properties properties, Item.Properties itemProperties, CropType cropType) {
        super(location, properties, itemProperties, cropType);
        this.STAGE = STAGE_;
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> state) {
        super.createBlockStateDefinition(state);
        if(STAGE_ != null){
            state.add(STAGE_);
        }
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return SHAPE_BY_AGE[state.getValue(STAGE)];
    }
}
