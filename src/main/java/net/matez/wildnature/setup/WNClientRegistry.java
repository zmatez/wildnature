/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.setup;

import net.matez.wildnature.core.registry.WNBlockEntityRenderers;
import net.matez.wildnature.core.registry.WNEntityRenderers;
import net.matez.wildnature.api.util.log.SimpleLogger;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.core.registry.WNParticles;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD,value=Dist.CLIENT)
public class WNClientRegistry {
    private static final SimpleLogger log = WildNature.getLogger();

    public static void registerParticleFactories(final ParticleFactoryRegisterEvent event) {
        log.progress("Registering particle factories");
        WildNature.instance.initializer.init(InitStage.PARTICLE);
        WNParticles.registerFactories();
        if (WildNature.instance.dataGenerator != null) {
            WildNature.instance.dataGenerator.generateParticles();
        }
        log.success("Registered " + WNParticles.PARTICLE_PROVIDERS.size() + " particle factories");
    }

    public static void registerBlockEntityRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        log.progress("Registering entity renderers");
        WNEntityRenderers.ENTITY_RENDERER_PROVIDERS.forEach(event::registerEntityRenderer);
        WNBlockEntityRenderers.BLOCK_ENTITY_RENDERER_PROVIDERS.forEach(event::registerBlockEntityRenderer);
        log.success("Registered " + WNEntityRenderers.ENTITY_RENDERER_PROVIDERS.size() + " Entity renderers and " + WNBlockEntityRenderers.BLOCK_ENTITY_RENDERER_PROVIDERS.size() + " BlockEntity renderers");
    }
}
