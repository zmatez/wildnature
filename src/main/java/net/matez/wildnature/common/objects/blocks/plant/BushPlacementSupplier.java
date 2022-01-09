package net.matez.wildnature.common.objects.blocks.plant;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public interface BushPlacementSupplier {
    boolean canPlace(BlockState state, BlockState stateOn, BlockGetter getter, BlockPos pos);
}
