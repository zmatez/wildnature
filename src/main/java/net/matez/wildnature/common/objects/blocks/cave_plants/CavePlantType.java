/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.cave_plants;

import net.matez.wildnature.common.objects.blocks.cave_plants.specific.*;
import net.matez.wildnature.common.objects.blocks.plant.BushConstructor;
import net.matez.wildnature.common.objects.blocks.plant.config.BushConfig;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.common.registry.particles.WNParticles;
import net.matez.wildnature.common.util.WNUtil;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraft.world.phys.Vec3;

import java.util.Random;

public enum CavePlantType {
    CAVE_LILY("cave_lily",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNFloweringCaveBushBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH_TINTED.get()),
    GLOW_VINE("glow_vine",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveVineBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    GLOWSHROOM("glowshroom",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNGlowshroomPlantBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get()),
    ICE_SHROOM("ice_shroom",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNIceshroomPlantBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get()),
    ICICLE("icicle",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNIcicleBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get()),
    LARGE_GLOWSHROOM("large_glowshroom",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveDoubleBushBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get()),
    LARGE_ICICLE("large_icicle",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveHangingDoubleBushBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get()),
    LARGE_ROOTS("large_roots",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveHangingDoubleBushBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get()),
    LARGE_STALACTITE("large_stalactite",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveHangingDoubleBushBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get()),
    LARGE_STALAGMITE("large_stalagmite",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveDoubleBushBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get()),
    ROOTS("roots",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNIcicleBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get()),
    STALACTITE("stalactite",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveHangingBushBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    STALAGMITE("stalagmite",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNStalagmiteBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get()),

    MAGMA_PAD("magma_pad",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNMagmaPadBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get()),

    STONE_GRASS("stone_grass","grass",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveBushBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    ICE_GRASS("ice_grass","grass",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveBushBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),

    DRAGON_SHROOM("dragon_shroom",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveBushBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    GLOWING_SHADOW_SHROOM("glowing_shadow_shroom",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveBushBlock(type.getLoc(),blockProp,itemProp,type) {
        @Override
        public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
            super.animateTick(state, level, pos, random);
            if(WNUtil.rint(0,1) == 0) {
                Vec3 offset = state.getOffset(level, pos);
                for (int i = 0; i < WNUtil.rint(1, 3); i++) {
                    level.addParticle(ParticleTypes.WITCH, pos.getX() + offset.x + WNUtil.rdoub(0.2, 0.8, random), pos.getY() + offset.y + WNUtil.rdoub(0.2, 0.6, random), pos.getZ() + offset.z + WNUtil.rdoub(0.2, 0.8, random), 0, 0, 0);
                }
            }
        }
    },BushConfig.CAVE_BUSH.get().makeSelfItem()),
    GRAVITY_SHROOM("gravity_shroom",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveBushBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    MAGMA_SHROOM("magma_shroom",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNMagmaShroomBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get()),
    POISON_SHROOM("poison_shroom",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveBushBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    SLIME_SHROOM_BLUE("slime_shroom_blue",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveBushBlock(type.getLoc(),blockProp,itemProp,type) {
        @Override
        public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
            super.animateTick(state, level, pos, random);
            if(WNUtil.rint(0,5) == 0) {
                Vec3 offset = state.getOffset(level, pos);
                for (int i = 0; i < WNUtil.rint(5, 25); i++) {
                    level.addParticle(WNParticles.SLIME_SHROOM_BLUE, pos.getX() + offset.x + WNUtil.rdoub(0.2, 0.8, random), pos.getY() + offset.y + WNUtil.rdoub(0.2, 0.6, random), pos.getZ() + offset.z + WNUtil.rdoub(0.2, 0.8, random), 0, 0, 0);
                }
            }
        }
    },BushConfig.CAVE_BUSH.get().makeSelfItem()),
    HANGING_SLIME_SHROOM_BLUE("hanging_slime_shroom_blue","slime_shroom_blue",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveHangingBushBlock(type.getLoc(),blockProp,itemProp,type) {
        @Override
        public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
            super.animateTick(state, level, pos, random);
            if(WNUtil.rint(0,5) == 0) {
                Vec3 offset = state.getOffset(level, pos);
                for (int i = 0; i < WNUtil.rint(5, 25); i++) {
                    level.addParticle(WNParticles.SLIME_SHROOM_BLUE, pos.getX() + offset.x + WNUtil.rdoub(0.2, 0.8, random), pos.getY() + offset.y + WNUtil.rdoub(0.2, 0.6, random), pos.getZ() + offset.z + WNUtil.rdoub(0.2, 0.8, random), 0, 0, 0);
                }
            }
        }
    },BushConfig.CAVE_BUSH.get().makeSelfItem()),
    SLIME_SHROOM_GREEN("slime_shroom_green",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveBushBlock(type.getLoc(),blockProp,itemProp,type) {
        @Override
        public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
            super.animateTick(state, level, pos, random);
            if(WNUtil.rint(0,6) == 0) {
                Vec3 offset = state.getOffset(level, pos);
                for (int i = 0; i < WNUtil.rint(5, 25); i++) {
                    level.addParticle(WNParticles.SLIME_SHROOM_GREEN, pos.getX() + offset.x + WNUtil.rdoub(0.2, 0.8, random), pos.getY() + offset.y + WNUtil.rdoub(0.2, 0.6, random), pos.getZ() + offset.z + WNUtil.rdoub(0.2, 0.8, random), 0, 0, 0);
                }
            }
        }
    },BushConfig.CAVE_BUSH.get().makeSelfItem()),
    HANGING_SLIME_SHROOM_GREEN("hanging_slime_shroom_green","slime_shroom_green",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveHangingBushBlock(type.getLoc(),blockProp,itemProp,type) {
        @Override
        public void animateTick(BlockState state, Level level, BlockPos pos, Random random) {
            super.animateTick(state, level, pos, random);
            if(WNUtil.rint(0,6) == 0) {
                Vec3 offset = state.getOffset(level, pos);
                for (int i = 0; i < WNUtil.rint(5, 25); i++) {
                    level.addParticle(WNParticles.SLIME_SHROOM_GREEN, pos.getX() + offset.x + WNUtil.rdoub(0.2, 0.8, random), pos.getY() + offset.y + WNUtil.rdoub(0.2, 0.6, random), pos.getZ() + offset.z + WNUtil.rdoub(0.2, 0.8, random), 0, 0, 0);
                }
            }
        }
    },BushConfig.CAVE_BUSH.get().makeSelfItem()),
    SULFUR_SHROOM("sulfur_shroom",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNCaveBushBlock(type.getLoc(),blockProp,itemProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    SUN_SHROOM("sun_shroom",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNSunShroomBlock(type.getLoc(),blockProp.randomTicks(),itemProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),
    TUBE_SHROOM("tube_shroom",MaterialColor.PLANT,(type, blockProp, itemProp) -> new WNTubeShroomBlock(type.getLoc(),blockProp.sound(SoundType.WET_GRASS),itemProp,type),BushConfig.CAVE_BUSH.get().makeSelfItem()),

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
        return WNBlocks.location(getId());
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
