/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.entity.geyser;

import net.matez.wildnature.api.util.log.SimpleLogger;
import net.matez.wildnature.common.block.geyser.WNGeyserBlock;
import net.matez.wildnature.core.registry.WNBlockEntities;
import net.matez.wildnature.core.registry.WNParticles;
import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

import java.util.LinkedHashMap;

public class WNGeyserBlockEntity extends BlockEntity {
    private static final SimpleLogger log = WildNature.getLogger();
    private final LinkedHashMap<BlockPos, BlockState> CONNECTED_GEYSERS = new LinkedHashMap<>();
    private boolean isLocalLeader = true;
    private int statePercentage = 0; // 0 - 100(explosion)
    private int explosionTicks = 0;

    public WNGeyserBlockEntity(BlockPos pos, BlockState state) {
        super(WNBlockEntities.GEYSER, pos, state);
    }

    public boolean isLocalLeader() {
        return isLocalLeader;
    }

    public int getStatePercentage() {
        return statePercentage;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, WNGeyserBlockEntity entity) {
        if (state.getBlock() instanceof WNGeyserBlock block) {
            if (block.isValid(state, level, pos)) {
                Player nearest = level.getNearestPlayer(TargetingConditions.forNonCombat(), pos.getX(), pos.getY(), pos.getZ());
                if ((nearest != null && ExtraMath.blockDistance(pos, nearest.getOnPos()) < 20) || entity.isExploding()) {
                    entity.tick();
                }
            }
        }
    }

    public void setStatePercentage(int percentage) {
        this.statePercentage = percentage;
        if (this.level != null) {
            this.level.setBlock(this.getBlockPos(), this.getBlockState().setValue(WNGeyserBlock.LOAD, (int) Math.floor(this.statePercentage / 25D)), 2);
        }
    }

    public void connectGeyser(BlockPos pos, BlockState state) {
        CONNECTED_GEYSERS.put(pos, state);
    }

    public boolean isExploding() {
        return explosionTicks > 0;
    }

    public void randomTick() {
        if (!isLocalLeader() || level == null) {
            return;
        }
        if (statePercentage >= 100) {
            if (explosionTicks <= 0) {
                int ticks = ExtraMath.rint(40, 60);
                explode(ticks);
                CONNECTED_GEYSERS.forEach((pos, state) -> {
                    BlockEntity entity = level.getBlockEntity(pos);
                    if (entity instanceof WNGeyserBlockEntity geyser) {
                        geyser.explode(ticks);
                    }
                });
            }
        } else {
            setStatePercentage(Math.min(100, statePercentage + ExtraMath.rint(5, 20)));
            CONNECTED_GEYSERS.forEach((pos, state) -> {
                BlockEntity entity = level.getBlockEntity(pos);
                if (entity instanceof WNGeyserBlockEntity geyser) {
                    geyser.setStatePercentage(statePercentage);
                }
            });
        }
    }

    public void tick() {
        if (this.level != null) {
            Vec3 center = new Vec3(this.getBlockPos().getX() + 0.5F, this.getBlockPos().getY(), this.getBlockPos().getZ() + 0.5F);
            double xzSize = 1;
            double ySize = 15;

            boolean goingUp = false;
            for (Entity entity : this.level.getEntitiesOfClass(Entity.class, new AABB(center.x - xzSize, center.y, center.z - xzSize, center.x + xzSize, center.y + ySize, center.z + xzSize))) {
                if (level.getBlockState(entity.getOnPos()).getFluidState().is(Fluids.WATER) || level.getBlockState(entity.getOnPos().above()).getFluidState().is(Fluids.WATER)) {
                    if (level.getBlockState(entity.getOnPos().above(2)).isAir()) {
                        entity.onAboveBubbleCol(false);
                        if (level instanceof ServerLevel serverLevel) {
                            for (int i = 0; i < 2; ++i) {
                                serverLevel.sendParticles(ParticleTypes.SPLASH, (double) entity.getX() + serverLevel.random.nextDouble(), (double) (entity.getY()), (double) entity.getZ() + serverLevel.random.nextDouble(), 1, 0.0D, 0.0D, 0.0D, 1.0D);
                                serverLevel.sendParticles(ParticleTypes.BUBBLE, (double) entity.getX() + serverLevel.random.nextDouble(), (double) (entity.getY()), (double) entity.getZ() + serverLevel.random.nextDouble(), 1, 0.0D, 0.01D, 0.0D, 0.2D);
                            }
                        }
                    } else {
                        Vec3 vec3 = entity.getDeltaMovement();
                        double amount = Math.min(0.4D, vec3.y + 0.06D);

                        entity.setDeltaMovement(vec3.x, amount, vec3.z);
                        entity.resetFallDistance();

                        if (ExtraMath.rint(0, 5) == 0) {
                            entity.hurt(DamageSource.HOT_FLOOR, 0.5f);
                        }
                    }
                    goingUp = true;
                }
            }
            if (goingUp) {
                if (level.random.nextInt(20) == 0) {
                    level.playLocalSound(center.x, center.y, center.z, SoundEvents.BUBBLE_COLUMN_UPWARDS_AMBIENT, SoundSource.BLOCKS, 0.2F + level.random.nextFloat() * 0.2F, 0.9F + level.random.nextFloat() * 0.15F, false);
                }
            }

            if (explosionTicks > 0) {
                explosionTicks--;

                double xzESize = 1.5;
                double yESize = 20;

                if (level instanceof ServerLevel serverLevel) {
                    for (int i = 0; i < ExtraMath.rint(1, 2); ++i) {
                        serverLevel.sendParticles(WNParticles.STEAM, center.x + ExtraMath.rdoub(-0.2, 0.2), center.y + 1, center.z + ExtraMath.rdoub(-0.2, 0.2), 20, ExtraMath.rdoub(-0.2, 0.2), ExtraMath.rdoub(0, 0.1), ExtraMath.rdoub(-0.2, 0.2), ExtraMath.rdoub(0.015D, 0.035D));
                    }
                    if (ExtraMath.rint(0, 3) == 0) {
                        serverLevel.sendParticles(WNParticles.THERMAL_SMOKE, center.x + ExtraMath.rdoub(-0.2, 0.2), center.y + 1, center.z + ExtraMath.rdoub(-0.2, 0.2), ExtraMath.rint(5, 10), 0.0D, ExtraMath.rdoub(0, 0.1), 0.0D, 0.06D);
                        serverLevel.sendParticles(ParticleTypes.CLOUD, center.x + ExtraMath.rdoub(-0.2, 0.2), center.y + 1, center.z + ExtraMath.rdoub(-0.2, 0.2), ExtraMath.rint(5, 10), 0.0D, ExtraMath.rdoub(0, 0.1), 0.0D, 0.1D);
                    }
                }

                for (Entity entity : this.level.getEntitiesOfClass(Entity.class, new AABB(center.x - xzESize, center.y - 0.2, center.z - xzESize, center.x + xzESize, center.y + yESize, center.z + xzESize))) {
                    double yDistance = entity.getY() - center.y;
                    double xzDistance = ExtraMath.xzDistance(new Vec3(entity.getX(), entity.getY(), entity.getZ()), center);

                    double yMod = Math.min(1, 2 / yDistance);
                    double xzMod = Math.min(1, 4 / xzDistance);

                    Vec3 delta = entity.getDeltaMovement();
                    double amount = Math.min(0.3D, delta.y + 0.1D) * yMod * xzMod;
                    if (entity.isUnderWater()) {
                        amount *= 1.6;
                    }

                    entity.hurtMarked = true;
                    entity.setDeltaMovement(entity.getDeltaMovement().add(0.0D, amount, 0.0D));
                    entity.resetFallDistance();
                }

                if (explosionTicks <= 0) {
                    statePercentage = 0;
                    CONNECTED_GEYSERS.forEach((pos, state) -> {
                        BlockEntity entity = level.getBlockEntity(pos);
                        if (entity instanceof WNGeyserBlockEntity geyser) {
                            geyser.statePercentage = 0;
                        }
                    });
                }
            }

            boilingParticles();
        }
    }

    public void explode(int ticks) {
        explosionTicks = ticks;
    }

    private void boilingParticles() {
        if (level == null) {
            return;
        }
        BlockState state = getBlockState();
        BlockPos pos = getBlockPos();
        int load = state.getValue(WNGeyserBlock.LOAD);

        for (int i = 1; i < 10; i++) {
            BlockState above = level.getBlockState(pos.above(i));
            if (!above.is(Blocks.WATER)) {
                break;
            }

            BlockState above2 = level.getBlockState(pos.above(i + 1));
            Vec3 abovePoint = new Vec3(pos.getX() + 0.5, pos.getY() + i + 1, pos.getZ() + 0.5);
            if (above2.isAir()) {
                int posCount = 3;
                LinkedHashMap<BlockPos, Boolean> cache = new LinkedHashMap<>();
                double radius = 2;
                for (int j = 0; j < posCount; j++) {
                    Vec3 point = randomParticlePoint(abovePoint, radius);
                    BlockPos avgPos = new BlockPos(point);
                    boolean canBePlaced;
                    if (cache.containsKey(avgPos)) {
                        canBePlaced = cache.get(avgPos);
                    } else {
                        canBePlaced = level.getBlockState(pos.above(i)).is(Blocks.WATER);
                        cache.put(avgPos, canBePlaced);
                    }

                    if (canBePlaced) {
                        for (int k = 0; k < ExtraMath.rint(1, 4) * load; k++) {
                            Vec3 newVec = new Vec3(point.x + ExtraMath.rdoub(-0.4, 0.4), point.y, point.z + ExtraMath.rdoub(-0.4, 0.4));
                            if (cache.containsKey(new BlockPos(newVec))) {
                                level.addParticle(ParticleTypes.BUBBLE_COLUMN_UP, true, newVec.x, newVec.y - ExtraMath.rdoub(0.5, 1.5), newVec.z, 0.0D, 0.0D, 0.0D);
                                level.addParticle(ParticleTypes.BUBBLE_POP, true, newVec.x, newVec.y - 0.1, newVec.z, 0.0D, 0.0D, 0.0D);
                            }
                        }
                    }

                    level.playLocalSound(point.x, point.y, point.z, SoundEvents.BUBBLE_COLUMN_BUBBLE_POP, SoundSource.BLOCKS, 1.5f, (float) ExtraMath.rdoub(0.5, 1.5), false);
                }

                break;
            }
        }
    }

    private Vec3 randomParticlePoint(Vec3 aboveWaterPos, double radius) {
        double ang = Math.random() * 2 * Math.PI,
                hyp = Math.sqrt(Math.random()) * radius,
                adj = Math.cos(ang) * hyp,
                opp = Math.sin(ang) * hyp;
        return new Vec3(aboveWaterPos.x + adj, aboveWaterPos.y, aboveWaterPos.z + opp);
    }
}
