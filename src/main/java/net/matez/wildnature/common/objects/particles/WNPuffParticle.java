/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.particles;

import net.matez.wildnature.common.objects.particles.setup.WNParticleProvider;
import net.matez.wildnature.common.registry.particles.WNParticles;
import net.matez.wildnature.common.util.WNUtil;
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
   protected WNPuffParticle(ClientLevel p_107685_, double p_107686_, double p_107687_, double p_107688_, double p_107689_, double p_107690_, double p_107691_, float p_107692_, SpriteSet p_107693_) {
      super(p_107685_, p_107686_, p_107687_, p_107688_, 0.1F, 0.1F, 0.1F, p_107689_, p_107690_, p_107691_, p_107692_, p_107693_, 0.3F, 8, -0.1F, true);
      float shade = (float)WNUtil.rdoub(0.8,1F);
      this.rCol = shade;
      this.gCol = shade;
      this.bCol = shade;
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