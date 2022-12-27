/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.mixin;

import net.matez.wildnature.client.particle.setup.WNParticleProvider;
import net.matez.wildnature.core.registry.WNParticles;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(ParticleEngine.class)
public class ParticleEngineMixin {
    @Final
    @Shadow
    private Map<ResourceLocation, ParticleProvider<?>> providers;

    @Inject(method = "register(Lnet/minecraft/core/particles/ParticleType;Lnet/minecraft/client/particle/ParticleEngine$SpriteParticleRegistration;)V", at = @At("TAIL"))
    public <T extends ParticleOptions> void register(ParticleType<T> type, ParticleEngine.SpriteParticleRegistration<T> registration, CallbackInfo info) {
        if (providers.get(type.getRegistryName()) instanceof WNParticleProvider<?> provider) {
            WNParticles.PARTICLE_PROVIDERS.put(type.getRegistryName(), provider);
        }
    }
}
