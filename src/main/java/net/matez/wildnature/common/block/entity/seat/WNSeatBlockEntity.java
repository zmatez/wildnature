package net.matez.wildnature.common.block.entity.seat;

import net.matez.wildnature.common.entity.seat.WNSeatEntity;
import net.matez.wildnature.core.registry.WNBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class WNSeatBlockEntity extends BlockEntity {
    private WNSeatEntity seat = null;

    public WNSeatBlockEntity(BlockPos pos, BlockState state) {
        super(WNBlockEntities.SEAT, pos, state);
    }

    public boolean isOccupied() {
        return seat != null;
    }

    public void seat(Player player, float yOffset) {
        if (level == null) {
            return;
        }
        if (seat != null) {
            destroy();
        }

        seat = new WNSeatEntity(this, level);
        seat.setPos(this.getBlockPos().getX() + 0.5f, this.getBlockPos().getY() + yOffset, this.getBlockPos().getZ() + 0.5f);
        level.addFreshEntity(seat);
        seat.seat(player);
    }

    public void destroy() {
        if (seat != null) {
            seat.destroy();
            seat = null;
        }
    }
}
