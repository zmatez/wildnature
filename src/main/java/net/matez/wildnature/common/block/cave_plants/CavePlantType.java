/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.cave_plants;

import net.matez.wildnature.common.block.cave_plants.specific.*;
import net.matez.wildnature.common.block.plant.BushConstructor;
import net.matez.wildnature.common.block.plant.config.BushConfig;
import net.matez.wildnature.core.registry.WNBlocks;
import net.matez.wildnature.core.registry.WNParticles;
import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public enum CavePlantType {
    CAVE_LILY("cave_lily",MaterialColor.PLANT,(type, blockProp) -> new WNFloweringCaveBushBlock(blockProp,type),BushConfig.CAVE_BUSH_TINTED.get()),
    GLOW_VINE("glow_vine",MaterialColor.PLANT,(type, blockProp) -> new WNCaveVineBlock(blockProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    GLOWSHROOM("glowshroom",MaterialColor.PLANT,(type, blockProp) -> new WNCaveBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get()),
    ICE_SHROOM("ice_shroom",MaterialColor.PLANT,(type, blockProp) -> new WNCaveBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get()),
    ICICLE("icicle",MaterialColor.PLANT,(type, blockProp) -> new WNCaveHangingBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get()),
    LARGE_GLOWSHROOM("large_glowshroom",MaterialColor.PLANT,(type, blockProp) -> new WNCaveDoubleBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get()),
    LARGE_ICICLE("large_icicle",MaterialColor.PLANT,(type, blockProp) -> new WNCaveHangingDoubleBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get()),
    LARGE_ROOTS("large_roots",MaterialColor.PLANT,(type, blockProp) -> new WNCaveHangingDoubleBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get()),
    LARGE_STALACTITE("large_stalactite",MaterialColor.PLANT,(type, blockProp) -> new WNCaveHangingDoubleBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get()),
    LARGE_STALAGMITE("large_stalagmite",MaterialColor.PLANT,(type, blockProp) -> new WNCaveDoubleBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get()),
    ROOTS("roots",MaterialColor.PLANT,(type, blockProp) -> new WNCaveHangingBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get()),
    STALACTITE("stalactite",MaterialColor.PLANT,(type, blockProp) -> new WNCaveHangingBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    STALAGMITE("stalagmite",MaterialColor.PLANT,(type, blockProp) -> new WNCaveBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get()),

    MAGMA_PAD("magma_pad",MaterialColor.PLANT,(type, blockProp) -> new WNMagmaPadBlock(blockProp,type),BushConfig.CAVE_BUSH.get()),

    STONE_GRASS("stone_grass","grass",MaterialColor.PLANT,(type, blockProp) -> new WNCaveBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    ICE_GRASS("ice_grass","grass",MaterialColor.PLANT,(type, blockProp) -> new WNCaveBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),

    DRAGON_SHROOM("dragon_shroom",MaterialColor.PLANT,(type, blockProp) -> new WNCaveBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    GLOWING_SHADOW_SHROOM("glowing_shadow_shroom",MaterialColor.PLANT,(type, blockProp) -> new WNCaveBushBlock(blockProp,type) {
        @Override
        public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
            super.animateTick(state, level, pos, random);
            if(ExtraMath.rint(0,1) == 0) {
                Vec3 offset = state.getOffset(level, pos);
                for (int i = 0; i < ExtraMath.rint(1, 3); i++) {
                    level.addParticle(ParticleTypes.WITCH, pos.getX() + offset.x + ExtraMath.rdoub(0.2, 0.8, random), pos.getY() + offset.y + ExtraMath.rdoub(0.2, 0.6, random), pos.getZ() + offset.z + ExtraMath.rdoub(0.2, 0.8, random), 0, 0, 0);
                }
            }
        }
    },BushConfig.CAVE_BUSH.get().makeSelfItem()),
    GRAVITY_SHROOM("gravity_shroom",MaterialColor.PLANT,(type, blockProp) -> new WNCaveBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    MAGMA_SHROOM("magma_shroom",MaterialColor.PLANT,(type, blockProp) -> new WNCaveBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get()),
    POISON_SHROOM("poison_shroom",MaterialColor.PLANT,(type, blockProp) -> new WNCaveBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    SLIME_SHROOM_BLUE("slime_shroom_blue",MaterialColor.PLANT,(type, blockProp) -> new WNCaveBushBlock(blockProp,type) {
        @Override
        public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
            super.animateTick(state, level, pos, random);
            if(ExtraMath.rint(0,5) == 0) {
                Vec3 offset = state.getOffset(level, pos);
                for (int i = 0; i < ExtraMath.rint(5, 25); i++) {
                    level.addParticle(WNParticles.SLIME_SHROOM_BLUE, pos.getX() + offset.x + ExtraMath.rdoub(0.2, 0.8, random), pos.getY() + offset.y + ExtraMath.rdoub(0.2, 0.6, random), pos.getZ() + offset.z + ExtraMath.rdoub(0.2, 0.8, random), 0, 0, 0);
                }
            }
        }
    },BushConfig.CAVE_BUSH.get().makeSelfItem()),
    HANGING_SLIME_SHROOM_BLUE("hanging_slime_shroom_blue","slime_shroom_blue",MaterialColor.PLANT,(type, blockProp) -> new WNCaveHangingBushBlock(blockProp,type) {
        @Override
        public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
            super.animateTick(state, level, pos, random);
            if(ExtraMath.rint(0,5) == 0) {
                Vec3 offset = state.getOffset(level, pos);
                for (int i = 0; i < ExtraMath.rint(5, 25); i++) {
                    level.addParticle(WNParticles.SLIME_SHROOM_BLUE, pos.getX() + offset.x + ExtraMath.rdoub(0.2, 0.8, random), pos.getY() + offset.y + ExtraMath.rdoub(0.2, 0.6, random), pos.getZ() + offset.z + ExtraMath.rdoub(0.2, 0.8, random), 0, 0, 0);
                }
            }
        }
    },BushConfig.CAVE_BUSH.get().makeSelfItem()),
    SLIME_SHROOM_GREEN("slime_shroom_green",MaterialColor.PLANT,(type, blockProp) -> new WNCaveBushBlock(blockProp,type) {
        @Override
        public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
            super.animateTick(state, level, pos, random);
            if(ExtraMath.rint(0,6) == 0) {
                Vec3 offset = state.getOffset(level, pos);
                for (int i = 0; i < ExtraMath.rint(5, 25); i++) {
                    level.addParticle(WNParticles.SLIME_SHROOM_GREEN, pos.getX() + offset.x + ExtraMath.rdoub(0.2, 0.8, random), pos.getY() + offset.y + ExtraMath.rdoub(0.2, 0.6, random), pos.getZ() + offset.z + ExtraMath.rdoub(0.2, 0.8, random), 0, 0, 0);
                }
            }
        }
    },BushConfig.CAVE_BUSH.get().makeSelfItem()),
    HANGING_SLIME_SHROOM_GREEN("hanging_slime_shroom_green","slime_shroom_green",MaterialColor.PLANT,(type, blockProp) -> new WNCaveHangingBushBlock(blockProp,type) {
        @Override
        public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
            super.animateTick(state, level, pos, random);
            if(ExtraMath.rint(0,6) == 0) {
                Vec3 offset = state.getOffset(level, pos);
                for (int i = 0; i < ExtraMath.rint(5, 25); i++) {
                    level.addParticle(WNParticles.SLIME_SHROOM_GREEN, pos.getX() + offset.x + ExtraMath.rdoub(0.2, 0.8, random), pos.getY() + offset.y + ExtraMath.rdoub(0.2, 0.6, random), pos.getZ() + offset.z + ExtraMath.rdoub(0.2, 0.8, random), 0, 0, 0);
                }
            }
        }
    },BushConfig.CAVE_BUSH.get().makeSelfItem()),
    SULFUR_SHROOM("sulfur_shroom",MaterialColor.PLANT,(type, blockProp) -> new WNCaveBushBlock(blockProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    SUN_SHROOM("sun_shroom",MaterialColor.PLANT,(type, blockProp) -> new WNSunShroomBlock(blockProp.randomTicks(),type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    TUBE_SHROOM("tube_shroom",MaterialColor.PLANT,(type, blockProp) -> new WNTubeShroomBlock(blockProp.sound(SoundType.WET_GRASS),type),BushConfig.CAVE_BUSH.get().makeSelfItem()),

    ;
    private final String id;
    private final String folder;
    private final MaterialColor color;
    private final BushConstructor<CavePlantType> constructor;
    private final BushConfig config;

    CavePlantType(String id, String folder, MaterialColor color, BushConstructor<CavePlantType> constructor, BushConfig config) {
        this.id = id;
        this.folder = folder;
        this.color = color;
        this.constructor = constructor;
        this.config = config;
    }

    CavePlantType(String id, MaterialColor color, BushConstructor<CavePlantType> constructor, BushConfig config) {
        this(id,id,color,constructor, config);
    }

    public ResourceLocation getLoc(){
        return WildNature.location(getId());
    }

    public String getId() {
        return id;
    }

    public String getFolder() {
        return folder;
    }

    public MaterialColor getColor() {
        return color;
    }

    public BushConstructor<CavePlantType> getConstructor() {
        return constructor;
    }

    public BushConfig getConfig() {
        return config;
    }
}
