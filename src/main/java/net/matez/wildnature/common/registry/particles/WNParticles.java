/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.registry.particles;

import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.common.objects.particles.*;
import net.matez.wildnature.common.objects.particles.setup.WNParticleProvider;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.ParticleEngine;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.resources.ResourceLocation;

import java.util.LinkedHashMap;

@Initialize(InitStage.CLIENT)
public class WNParticles {
    //# --- ALL PARTICLES ---
    public static final LinkedHashMap<ResourceLocation, SimpleParticleType> PARTICLE_TYPES = new LinkedHashMap<>();
    public static final LinkedHashMap<ResourceLocation, ParticleEngine.SpriteParticleRegistration<SimpleParticleType>> PARTICLE_FACTORIES = new LinkedHashMap<>();
    public static final LinkedHashMap<ResourceLocation, WNParticleProvider<?>> PARTICLE_PROVIDERS = new LinkedHashMap<>();
    //#------------------

    public static final SimpleParticleType CRYSTAL = register(WNCrystalParticle.CrystalProvider.getRegistryNameStatic(), true, WNCrystalParticle.CrystalProvider::new);
    public static final SimpleParticleType PUFFBALL_EXPLOSION = register(WNPuffParticle.PuffballProvider.getRegistryNameStatic(), true, WNPuffParticle.PuffballProvider::new);
    public static final SimpleParticleType SLIME_SHROOM_BLUE = register(WNSlimeShroomParticle.SlimeShroomBlueProvider.getRegistryNameStatic(), true, WNSlimeShroomParticle.SlimeShroomBlueProvider::new);
    public static final SimpleParticleType SLIME_SHROOM_GREEN = register(WNSlimeShroomParticle.SlimeShroomGreenProvider.getRegistryNameStatic(), true, WNSlimeShroomParticle.SlimeShroomGreenProvider::new);
    public static final SimpleParticleType THERMAL_SMOKE = register(WNSmokeParticle.ThermalSmokeProvider.getRegistryNameStatic(), true, WNSmokeParticle.ThermalSmokeProvider::new);
    public static final SimpleParticleType WISTERIA_PINK = register(WNWisteriaParticle.WisteriaPinkProvider.getRegistryNameStatic(), true, WNWisteriaParticle.WisteriaPinkProvider::new);
    public static final SimpleParticleType STEAM = register(WNSteamParticle.SteamProvider.getRegistryNameStatic(), true, WNSteamParticle.SteamProvider::new);


    public static ResourceLocation location(String name) {
        return new ResourceLocation(WildNature.modid, name);
    }

    private static SimpleParticleType register(ResourceLocation registryName, boolean something, ParticleEngine.SpriteParticleRegistration<SimpleParticleType> factory) {
        if (!WildNature.instance.initializer.isInitialized(InitStage.CLIENT)) {
            return null;
        }
        SimpleParticleType particleType = new SimpleParticleType(something);
        particleType.setRegistryName(registryName);
        PARTICLE_TYPES.put(registryName, particleType);
        PARTICLE_FACTORIES.put(registryName, factory);

        return particleType;
    }

    public static void registerFactories(){
        PARTICLE_TYPES.forEach((registryName, particleType) -> {
            if(PARTICLE_FACTORIES.containsKey(registryName)) {
                Minecraft.getInstance().particleEngine.register(particleType, PARTICLE_FACTORIES.get(registryName));
//                if (((ParticleEngineMixin) Minecraft.getInstance().particleEngine).getProviders().get(registryName) instanceof WNParticleProvider<?> provider) {
//                    PARTICLE_PROVIDERS.put(registryName, provider);
//                }
            }
        });
    }
}