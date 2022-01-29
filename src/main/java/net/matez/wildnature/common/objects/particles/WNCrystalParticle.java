/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.particles;

import net.matez.wildnature.common.objects.particles.setup.WNParticle;
import net.matez.wildnature.common.objects.particles.setup.WNParticleProvider;
import net.matez.wildnature.common.registry.particles.WNParticles;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

public class WNCrystalParticle extends WNParticle {
    protected WNCrystalParticle(ClientLevel level, SpriteSet spriTeSet, double x, double y, double z) {
        super(level, x, y, z);
        this.setSize(0.01F, 0.01F);
        this.pickSprite(spriTeSet);
        this.quadSize *= this.random.nextFloat() * 0.6F + 0.2F;
        this.lifetime = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
        this.hasPhysics = false;
        this.friction = 1.0F;
        this.gravity = 0.0F;
    }

    protected WNCrystalParticle(ClientLevel level, SpriteSet spriTeSet, double x, double y, double z, double dX, double dY, double dZ) {
        super(level, x, y, z, dX, dY, dZ);
        this.setSize(0.01F, 0.01F);
        this.pickSprite(spriTeSet);
        this.quadSize *= this.random.nextFloat() * 0.6F + 0.6F;
        this.lifetime = (int)(16.0D / (Math.random() * 0.8D + 0.2D));
        this.hasPhysics = false;
        this.friction = 1.0F;
        this.gravity = 0.0F;
    }


    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    @OnlyIn(Dist.CLIENT)
    public static class CrystalProvider implements WNParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public CrystalProvider(SpriteSet spriteSet) {
            this.sprite = spriteSet;
        }

        public Particle createParticle(@NotNull SimpleParticleType particleType, @NotNull ClientLevel level, double x, double y, double z, double dX, double dY, double dZ) {
            WNCrystalParticle particle = new WNCrystalParticle(level, this.sprite, x, y, z, 0.0D, (double)-0.8F, 0.0D);
            particle.lifetime = Mth.randomBetweenInclusive(level.random, 500, 1000);
            particle.gravity = 0.01F;
            return particle;
        }

        public static ResourceLocation getRegistryNameStatic(){
            return WNParticles.location("crystal");
        }

        public ResourceLocation getRegistryName(){
            return getRegistryNameStatic();
        }

        public int getSheetAmount() {
            return 8;
        }
    }
}
