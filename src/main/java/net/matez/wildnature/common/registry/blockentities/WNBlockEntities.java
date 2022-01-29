/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.registry.blockentities;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.objects.blockentities.table.WNTableBlockEntity;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.function.Supplier;

@Initialize(InitStage.CONSTRUCT)
public class WNBlockEntities {
    private static final WNLogger log = WildNature.getLogger();

    //# --- ALL PARTICLES ---
    public static final LinkedHashMap<ResourceLocation, BlockEntityType<?>> BLOCK_ENTITY_TYPES = new LinkedHashMap<>();
    //#------------------

    public static final BlockEntityType<WNTableBlockEntity> TABLE = register(location("table"), () -> {
        ArrayList<Block> list = new ArrayList<>();
        list.addAll(WNBlocks.TABLES.values());
        list.addAll(WNBlocks.VANILLA_TABLES.values());
        return BlockEntityType.Builder.of(WNTableBlockEntity::new, list.toArray(new Block[0]));
    });

    //#------------------
    public static ResourceLocation location(String name) {
        return new ResourceLocation(WildNature.modid, name);
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(ResourceLocation registryName, Supplier<BlockEntityType.Builder<T>> builder){
        BlockEntityType<T> blockEntityType = builder.get().build(null);
        blockEntityType.setRegistryName(registryName);
        BLOCK_ENTITY_TYPES.put(registryName,blockEntityType);

        return blockEntityType;
    }
}
