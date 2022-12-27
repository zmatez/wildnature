/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.client.particle;

import net.matez.wildnature.client.particle.setup.WNParticleProvider;
import net.matez.wildnature.core.registry.WNParticles;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class WNSmokeParticle extends TextureSheetParticle {
   WNSmokeParticle(ClientLevel p_105856_, double p_105857_, double p_105858_, double p_105859_, double p_105860_, double p_105861_, double p_105862_, boolean p_105863_) {
      super(p_105856_, p_105857_, p_105858_, p_105859_);
      this.scale(3.0F);
      this.setSize(0.25F, 0.25F);
      if (p_105863_) {
         this.lifetime = this.random.nextInt(50) + 280;
      } else {
         this.lifetime = this.random.nextInt(50) + 80;
      }

      this.gravity = 3.0E-6F;
      this.xd = p_105860_;
      this.yd = p_105861_ + (double)(this.random.nextFloat() / 500.0F);
      this.zd = p_105862_;
   }

   public void tick() {
      this.xo = this.x;
      this.yo = this.y;
      this.zo = this.z;
      if (this.age++ < this.lifetime && !(this.alpha <= 0.0F)) {
         this.xd += (double)(this.random.nextFloat() / 5000.0F * (float)(this.random.nextBoolean() ? 1 : -1));
         this.zd += (double)(this.random.nextFloat() / 5000.0F * (float)(this.random.nextBoolean() ? 1 : -1));
         this.yd -= (double)this.gravity;
         this.move(this.xd, this.yd, this.zd);
         if (this.age >= this.lifetime - 60 && this.alpha > 0.01F) {
            this.alpha -= 0.015F;
         }

      } else {
         this.remove();
      }
   }

   public ParticleRenderType getRenderType() {
      return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
   }

   @OnlyIn(Dist.CLIENT)
   public static class ThermalSmokeProvider implements WNParticleProvider<SimpleParticleType> {
      private final SpriteSet sprite;

      public ThermalSmokeProvider(SpriteSet spriteSet) {
         this.sprite = spriteSet;
      }

      public Particle createParticle(@NotNull SimpleParticleType particleType, @NotNull ClientLevel level, double x, double y, double z, double dX, double dY, double dZ) {
         WNSmokeParticle particle = new WNSmokeParticle(level, x, y, z, dX,dY,dZ,false);
         particle.setAlpha(0.9F);
         particle.pickSprite(this.sprite);
         return particle;
      }

      public static ResourceLocation getRegistryNameStatic(){
         return WNParticles.location("thermal_smoke");
      }

      public ResourceLocation getRegistryName(){
         return getRegistryNameStatic();
      }

      public int getSheetAmount() {
         return 11;
      }
   }
}