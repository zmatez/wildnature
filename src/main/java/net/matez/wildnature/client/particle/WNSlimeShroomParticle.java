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
public class WNSlimeShroomParticle extends TextureSheetParticle {
   private final float uo;
   private final float vo;

   WNSlimeShroomParticle(ClientLevel p_105646_, double p_105647_, double p_105648_, double p_105649_, double p_105650_, double p_105651_, double p_105652_, SpriteSet spriteSet) {
      this(p_105646_, p_105647_, p_105648_, p_105649_, spriteSet);
      this.xd *= (double)0.1F;
      this.yd *= (double)0.1F;
      this.zd *= (double)0.1F;
      this.xd += p_105650_;
      this.yd += p_105651_;
      this.zd += p_105652_;
      this.setLifetime((int)(5.0F / (this.random.nextFloat() * 1.5F + 0.1F)));
      this.gravity = 0.8F;
   }

   public ParticleRenderType getRenderType() {
      return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
   }

   protected WNSlimeShroomParticle(ClientLevel p_105665_, double p_105666_, double p_105667_, double p_105668_, SpriteSet spriteSet) {
      super(p_105665_, p_105666_, p_105667_, p_105668_, 0.0D, 0.0D, 0.0D);
      this.pickSprite(spriteSet);
      this.gravity = 0.8F;
      this.quadSize /= 2.0F;
      this.uo = this.random.nextFloat() * 1.2F;
      this.vo = this.random.nextFloat() * 1.2F;
      this.setLifetime((int)(5.0F / (this.random.nextFloat() * 1.5F + 0.1F)));
   }

   protected float getU0() {
      return this.sprite.getU((double)((this.uo + 1.0F) / 4.0F * 16.0F));
   }

   protected float getU1() {
      return this.sprite.getU((double)(this.uo / 4.0F * 16.0F));
   }

   protected float getV0() {
      return this.sprite.getV((double)(this.vo / 4.0F * 16.0F));
   }

   protected float getV1() {
      return this.sprite.getV((double)((this.vo + 1.0F) / 4.0F * 16.0F));
   }


   @OnlyIn(Dist.CLIENT)
   public static class SlimeShroomBlueProvider implements WNParticleProvider<SimpleParticleType> {
      private final SpriteSet sprite;

      public SlimeShroomBlueProvider(SpriteSet spriteSet) {
         this.sprite = spriteSet;
      }

      public Particle createParticle(@NotNull SimpleParticleType particleType, @NotNull ClientLevel level, double x, double y, double z, double dX, double dY, double dZ) {
         WNSlimeShroomParticle particle = new WNSlimeShroomParticle(level, x, y, z,this.sprite);
         return particle;
      }

      public static ResourceLocation getRegistryNameStatic(){
         return WNParticles.location("slime_shroom_blue");
      }

      public ResourceLocation getRegistryName(){
         return getRegistryNameStatic();
      }

      public int getSheetAmount() {
         return 3;
      }
   }
   @OnlyIn(Dist.CLIENT)
   public static class SlimeShroomGreenProvider implements WNParticleProvider<SimpleParticleType> {
      private final SpriteSet sprite;

      public SlimeShroomGreenProvider(SpriteSet spriteSet) {
         this.sprite = spriteSet;
      }

      public Particle createParticle(@NotNull SimpleParticleType particleType, @NotNull ClientLevel level, double x, double y, double z, double dX, double dY, double dZ) {
         WNSlimeShroomParticle particle = new WNSlimeShroomParticle(level, x, y, z,this.sprite);
         return particle;
      }

      public static ResourceLocation getRegistryNameStatic(){
         return WNParticles.location("slime_shroom_green");
      }

      public ResourceLocation getRegistryName(){
         return getRegistryNameStatic();
      }

      public int getSheetAmount() {
         return 3;
      }
   }
}
