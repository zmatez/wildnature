package net.matez.wildnature.common.objects.entities.seat;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.objects.blockentities.seat.WNSeatBlockEntity;
import net.matez.wildnature.common.registry.entities.WNEntities;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class WNSeatEntity extends Entity {
    private WNSeatBlockEntity blockEntity;
    private static final WNLogger log = WildNature.getLogger();

    public WNSeatEntity(WNSeatBlockEntity blockEntity, Level level) {
        super(WNEntities.SEAT, level);
        this.blockEntity = blockEntity;
        this.setNoGravity(true);
        this.noCulling = true;
    }

    public WNSeatEntity(EntityType<WNSeatEntity> entityType, Level level) {
        super(entityType, level);
        this.setNoGravity(true);
        this.noCulling = true;
    }

    public void seat(Player player) {
        player.startRiding(this);
    }

    public void destroy() {
        this.ejectPassengers();
        this.remove(RemovalReason.KILLED);
    }

    @Override
    protected void removePassenger(Entity entity) {
        super.removePassenger(entity);
        if (this.blockEntity != null) {
            this.blockEntity.destroy();
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (!this.level.isClientSide()) {
            if (this.getPassengers().isEmpty()) {
                if (this.blockEntity != null) {
                    this.blockEntity.destroy();
                } else {
                    this.destroy();
                }
            }
        }
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag p_20052_) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag p_20139_) {

    }

    @Override
    public Packet<?> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this);
    }
}
