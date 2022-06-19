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
public class WNSteamParticle extends BaseAshSmokeParticle {
    private final boolean canChangeColor;
    private float quadSizeModifier;

    protected WNSteamParticle(ClientLevel p_107685_, double x, double y, double z, double p_107689_, double p_107690_, double p_107691_, float size, SpriteSet spriteSet) {
        super(p_107685_, x, y, z, 0.1F, 0.1F, 0.1F, p_107689_, p_107690_, p_107691_, size, spriteSet, 0.3F, 8, -3F, true);
        float shade = (float) WNUtil.rdoub(0.9, 1F);
        float shadeBlue = (float) WNUtil.rdoub(0.8, 1F);
        this.rCol = Math.min(shade, shadeBlue);
        this.gCol = Math.min(shade, shadeBlue);
        this.bCol = shade;
        //this.lifetime *= 0.6;
        this.canChangeColor = shadeBlue < 0.9f;
//      this.quadSizeModifier = 0.02F;
//      this.quadSize = this.quadSizeModifier;
    }

    @Override
    public void tick() {
        super.tick();
//      if(this.quadSizeModifier < 0.4F) {
//         this.quadSizeModifier = Math.max(0.4F,this.quadSizeModifier + 0.03f);
//         this.quadSize = this.quadSizeModifier;
//      }
        if (!onGround) {
            this.gravity = Math.min(0.7f, this.gravity + 0.20f);
            if (canChangeColor) {
                this.rCol -= 0.006;
                this.gCol -= 0.006;
                this.bCol -= 0.001;
                this.rCol = Math.max(0.5f, rCol);
                this.gCol = Math.max(0.5f, gCol);
                this.bCol = Math.max(0.4f, bCol);
            }
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class SteamProvider implements WNParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public SteamProvider(SpriteSet spriteSet) {
            this.sprite = spriteSet;
        }

        public static ResourceLocation getRegistryNameStatic() {
            return WNParticles.location("steam");
        }

        public Particle createParticle(@NotNull SimpleParticleType particleType, @NotNull ClientLevel level, double x, double y, double z, double dX, double dY, double dZ) {
            WNSteamParticle particle = new WNSteamParticle(level, x, y, z, dX, dY, dZ, 4f, this.sprite);
            return particle;
        }

        public ResourceLocation getRegistryName() {
            return getRegistryNameStatic();
        }

        public int getSheetAmount() {
            return 8;
        }
    }
}