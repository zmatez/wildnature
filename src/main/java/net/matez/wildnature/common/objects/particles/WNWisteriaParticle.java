/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.particles;

import net.matez.wildnature.common.objects.particles.setup.WNParticleProvider;
import net.matez.wildnature.common.registry.particles.WNParticles;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class WNWisteriaParticle extends TextureSheetParticle {
   private final float rotSpeed;
   private final SpriteSet sprites;

   public WNWisteriaParticle(ClientLevel level, double x, double y, double z, double dX, double dY, double dZ, SpriteSet sprites) {
      super(level, x, y, z);
      this.sprites = sprites;
      this.quadSize *= 1.5F;
      int i = (int)(32.0D / (Math.random() * 0.8D + 0.2D));
      this.lifetime = (int)Math.max((float)i * 1.15F, 1.5F);
      this.setSpriteFromAge(sprites);
      this.rotSpeed = ((float)Math.random() - 0.5F) * 0.1F;
      this.roll = (float)Math.random() * ((float)Math.PI * 2F);
      this.gravity = 0.07f;
      //this.friction = 0.5f;
   }

   public ParticleRenderType getRenderType() {
      return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
   }

   public float getQuadSize(float p_106631_) {
      return this.quadSize * Mth.clamp(((float)this.age + p_106631_) / (float)this.lifetime * 32.0F, 0.0F, 1.0F);
   }



   public void tick() {
      this.xo = this.x;
      this.yo = this.y;
      this.zo = this.z;
      if (this.age++ >= this.lifetime) {
         this.remove();
      } else {
         this.setSpriteFromAge(this.sprites);
         this.oRoll = this.roll;
         this.roll += (float)Math.PI * this.rotSpeed * 2.0F;
         if (this.onGround) {
            this.oRoll = this.roll = 0.0F;
         }

         this.yd -= 0.04D * (double)this.gravity;
         this.move(this.xd, this.yd, this.zd);
         this.yd *= (double)this.friction;
      }
   }

//   @OnlyIn(Dist.CLIENT)
//   public static class Provider implements ParticleProvider<BlockParticleOption> {
//      private final SpriteSet sprite;
//
//      public Provider(SpriteSet p_106634_) {
//         this.sprite = p_106634_;
//      }
//
//      @Nullable
//      public Particle createParticle(BlockParticleOption p_106636_, ClientLevel p_106637_, double p_106638_, double p_106639_, double p_106640_, double p_106641_, double p_106642_, double p_106643_) {
//         BlockState blockstate = p_106636_.getState();
//         if (!blockstate.isAir() && blockstate.getRenderShape() == RenderShape.INVISIBLE) {
//            return null;
//         } else {
//            BlockPos blockpos = new BlockPos(p_106638_, p_106639_, p_106640_);
//            int i = Minecraft.getInstance().getBlockColors().getColor(blockstate, p_106637_, blockpos);
//            if (blockstate.getBlock() instanceof FallingBlock) {
//               i = ((FallingBlock)blockstate.getBlock()).getDustColor(blockstate, p_106637_, blockpos);
//            }
//
//            float f = (float)(i >> 16 & 255) / 255.0F;
//            float f1 = (float)(i >> 8 & 255) / 255.0F;
//            float f2 = (float)(i & 255) / 255.0F;
//            return new FallingDustParticle(p_106637_, p_106638_, p_106639_, p_106640_, f, f1, f2, this.sprite);
//         }
//      }
//   }

   @OnlyIn(Dist.CLIENT)
   public static class WisteriaPinkProvider implements WNParticleProvider<SimpleParticleType> {
      private final SpriteSet sprite;

      public WisteriaPinkProvider(SpriteSet spriteSet) {
         this.sprite = spriteSet;
      }

      public Particle createParticle(@NotNull SimpleParticleType particleType, @NotNull ClientLevel level, double x, double y, double z, double dX, double dY, double dZ) {
         WNWisteriaParticle particle = new WNWisteriaParticle(level, x, y, z, dX,dY,dZ,sprite);
         particle.pickSprite(this.sprite);
         return particle;
      }

      public static ResourceLocation getRegistryNameStatic(){
         return WNParticles.location("wisteria_pink");
      }

      public ResourceLocation getRegistryName(){
         return getRegistryNameStatic();
      }

      public int getSheetAmount() {
         return 4;
      }
   }
}