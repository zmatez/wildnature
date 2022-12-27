/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.core.registry;

import net.matez.wildnature.client.render.block.entity.WNTableBlockEntityRenderer;
import net.matez.wildnature.common.block.entity.table.WNTableBlockEntity;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.LinkedHashMap;

@Initialize(InitStage.ENTITY_RENDERER)
public class WNBlockEntityRenderers {
    //# --- ALL PARTICLES ---
    public static final LinkedHashMap<BlockEntityType, BlockEntityRendererProvider<?>> BLOCK_ENTITY_RENDERER_PROVIDERS = new LinkedHashMap<>();
    //#------------------

    public static final BlockEntityRendererProvider<WNTableBlockEntity> TABLE = register(WNBlockEntities.TABLE, WNTableBlockEntityRenderer::new);

    private static <T extends BlockEntity> BlockEntityRendererProvider<T> register(BlockEntityType<? extends T> type, BlockEntityRendererProvider<T> provider) {
        if (!WildNature.instance.initializer.isInitialized(InitStage.ENTITY_RENDERER)) {
            return null;
        }
        BLOCK_ENTITY_RENDERER_PROVIDERS.put(type, provider);
        return provider;
    }
}
