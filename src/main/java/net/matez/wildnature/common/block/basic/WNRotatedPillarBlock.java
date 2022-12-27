package net.matez.wildnature.common.block.basic;

import net.matez.wildnature.data.block_models.WNBlockModel_CubeColumn;
import net.matez.wildnature.data.blockstates.WNBlockstate_Pillar;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

public class WNRotatedPillarBlock extends WNBlock {
    public static final EnumProperty<Direction.Axis> AXIS = BlockStateProperties.AXIS;

    public WNRotatedPillarBlock(ResourceLocation location, Properties properties) {
        super(location, properties);
    }

    public WNRotatedPillarBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties) {
        super(location, properties, itemProperties);
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.defaultBlockState().setValue(AXIS, Direction.Axis.Y));
    }

    @Override
    public BlockState rotate(BlockState state, Rotation rotation) {
        return rotatePillar(state, rotation);
    }

    public static BlockState rotatePillar(BlockState state, Rotation rotation) {
        switch(rotation) {
            case COUNTERCLOCKWISE_90:
            case CLOCKWISE_90:
                switch(state.getValue(AXIS)) {
                    case X:
                        return state.setValue(AXIS, Direction.Axis.Z);
                    case Z:
                        return state.setValue(AXIS, Direction.Axis.X);
                    default:
                        return state;
                }
            default:
                return state;
        }
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> definition) {
        definition.add(AXIS);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(AXIS, context.getClickedFace().getAxis());
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Pillar(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList()
                .with(
                        new WNBlockModel_CubeColumn(this.getRegName())
                                .with("texture",this.getTextureName())
                                .with("texture_top",this.getTextureName() + "_top")
                );
    }
}
