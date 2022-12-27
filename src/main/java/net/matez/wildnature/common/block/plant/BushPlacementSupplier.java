package net.matez.wildnature.common.block.plant;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public interface BushPlacementSupplier {
    boolean canPlace(BlockState stateOn, BlockGetter getter, BlockPos pos);
}
