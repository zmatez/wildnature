/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.client.registry.setup;

import net.matez.wildnature.client.registry.blockentities.WNBlockEntityRenderers;
import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.registry.particles.WNParticles;
import net.matez.wildnature.setup.WildNature;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD,value=Dist.CLIENT)
public class WNClientRegistry {
    private static final WNLogger log = WildNature.getLogger();

    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event){
        log.progress("Registering particle factories");
        WildNature.instance.initializer.init(InitStage.PARTICLE);
        WNParticles.registerFactories();
        WildNature.instance.dataGenerator.generateParticles();
        log.success("Registered " + WNParticles.PARTICLE_PROVIDERS.size() + " particle factories");
    }
    public static void registerBlockEntityRenderers(final EntityRenderersEvent.RegisterRenderers event){
        log.progress("Registering entity renderers");
        WildNature.instance.initializer.init(InitStage.ENTITY_RENDERER);
        WNBlockEntityRenderers.BLOCK_ENTITY_RENDERER_PROVIDERS.forEach((type, provider) -> {
            log.debug("Registered renderer for " + type.getRegistryName());
            event.registerBlockEntityRenderer(type,provider);
        });
        log.success("Registered " + WNBlockEntityRenderers.BLOCK_ENTITY_RENDERER_PROVIDERS.size() + " BlockEntity renderers");
    }
}
