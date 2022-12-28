package net.matez.wildnature.common.block.sand;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;

public class WNSandBlock extends FallingBlock {
    private final SandType sandType;

    public WNSandBlock( Properties properties, SandType sandType) {
        super(properties);
        this.sandType = sandType;
    }

    @Override
    public int getDustColor(BlockState state, BlockGetter getter, BlockPos pos) {
        return sandType.getDustColor();
    }
}
