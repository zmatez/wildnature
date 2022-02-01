package net.matez.wildnature.common.objects.blockentities.geyser;

import net.matez.wildnature.common.registry.blockentities.WNBlockEntities;
import net.matez.wildnature.common.util.WNUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.LinkedHashMap;

public class WNGeyserBlockEntity extends BlockEntity {
    private final LinkedHashMap<BlockPos, BlockState> CONNECTED_GEYSERS = new LinkedHashMap<>();
    private boolean isLocalLeader = true;
    private int statePercentage = 0; // 0 - 100(explosion)

    public WNGeyserBlockEntity(BlockPos pos, BlockState state) {
        super(WNBlockEntities.GEYSER, pos, state);
    }

    public boolean isLocalLeader() {
        return isLocalLeader;
    }

    public int getStatePercentage() {
        return statePercentage;
    }

    public void connectGeyser(BlockPos pos, BlockState state) {
        CONNECTED_GEYSERS.put(pos, state);
    }

    public void randomTick() {
        if (!isLocalLeader() || level == null) {
            return;
        }
        if (statePercentage >= 100) {
            explode();
            CONNECTED_GEYSERS.forEach((pos, state) -> {
                BlockEntity entity = level.getBlockEntity(pos);
                if (entity instanceof WNGeyserBlockEntity geyser) {
                    geyser.explode();
                }
            });
        } else {
            statePercentage = Math.min(100, statePercentage + WNUtil.rint(5, 20));
            CONNECTED_GEYSERS.forEach((pos, state) -> {
                BlockEntity entity = level.getBlockEntity(pos);
                if (entity instanceof WNGeyserBlockEntity geyser) {
                    geyser.statePercentage = statePercentage;
                }
            });
        }
    }

    public void tick() {

    }

    public static void tick(Level level, BlockPos pos, BlockState state, WNGeyserBlockEntity entity) {
        entity.tick();
    }

    public void explode() {

    }
}
