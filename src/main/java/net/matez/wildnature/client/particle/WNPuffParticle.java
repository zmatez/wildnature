/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.client.particle;

import net.matez.wildnature.client.particle.setup.WNParticleProvider;
import net.matez.wildnature.core.registry.WNParticles;
import net.matez.wildnature.api.util.ExtraMath;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.BaseAshSmokeParticle;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class WNPuffParticle extends BaseAshSmokeParticle {
    protected WNPuffParticle(ClientLevel p_107685_, double x, double y, double z, double p_107689_, double p_107690_, double p_107691_, float size, SpriteSet spriteSet) {
        super(p_107685_, x, y, z, 0.1F, 0.1F, 0.1F, p_107689_, p_107690_, p_107691_, size, spriteSet, 0.3F, 8, -0.1F, true);
        float shade = (float) ExtraMath.rdoub(0.8, 1F);
        this.rCol = shade;
        this.gCol = shade;
        this.bCol = shade;
        this.lifetime *= 1.4;
    }

    @Override
    public void tick() {
        super.tick();
        this.gravity = Math.min(0.15f, this.gravity + 0.012f);
    }

    @OnlyIn(Dist.CLIENT)
    public static class PuffballProvider implements WNParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public PuffballProvider(SpriteSet spriteSet) {
            this.sprite = spriteSet;
        }

      public Particle createParticle(@NotNull SimpleParticleType particleType, @NotNull ClientLevel level, double x, double y, double z, double dX, double dY, double dZ) {
         WNPuffParticle particle = new WNPuffParticle(level, x, y, z, dX,dY,dZ,1.5F,this.sprite);
         return particle;
      }

      public static ResourceLocation getRegistryNameStatic(){
         return WNParticles.location("puffball_explosion");
      }

      public ResourceLocation getRegistryName(){
         return getRegistryNameStatic();
      }

      public int getSheetAmount() {
         return 6;
      }
   }
}