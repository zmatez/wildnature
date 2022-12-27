/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.core.registry;

import net.matez.wildnature.api.util.log.SimpleLogger;
import net.matez.wildnature.common.block.entity.geyser.WNGeyserBlockEntity;
import net.matez.wildnature.common.block.entity.seat.WNSeatBlockEntity;
import net.matez.wildnature.common.block.entity.soil.WNSoilBlockEntity;
import net.matez.wildnature.common.block.entity.table.WNTableBlockEntity;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.function.Supplier;

@Initialize(InitStage.REG_BLOCK_ENTITIES)
public class WNBlockEntities {
    private static final SimpleLogger log = WildNature.getLogger();

    //# --- ALL BLOCK ENTITIES  ---
    public static final LinkedHashMap<ResourceLocation, BlockEntityType<?>> BLOCK_ENTITY_TYPES = new LinkedHashMap<>();
    //#------------------

    public static final BlockEntityType<WNTableBlockEntity> TABLE = register(location("table"), () -> {
        ArrayList<Block> list = new ArrayList<>();
        list.addAll(WNBlocks.TABLES.values());
        list.addAll(WNBlocks.VANILLA_TABLES.values());
        return BlockEntityType.Builder.of(WNTableBlockEntity::new, list.toArray(new Block[0]));
    });
    public static final BlockEntityType<WNGeyserBlockEntity> GEYSER = register(location("geyser"), () -> {
        return BlockEntityType.Builder.of(WNGeyserBlockEntity::new, WNBlocks.GEYSER);
    });
    public static final BlockEntityType<WNSeatBlockEntity> SEAT = register(location("seat"), () -> {
        ArrayList<Block> list = new ArrayList<>();
        list.addAll(WNBlocks.CHAIRS.values());
        list.addAll(WNBlocks.VANILLA_CHAIRS.values());
        list.addAll(WNBlocks.BENCHES.values());
        list.addAll(WNBlocks.VANILLA_BENCHES.values());
        return BlockEntityType.Builder.of(WNSeatBlockEntity::new, list.toArray(new Block[0]));
    });
    public static final BlockEntityType<WNSoilBlockEntity> SOIL = register(location("soil"), () -> {
        return BlockEntityType.Builder.of(WNSoilBlockEntity::new, WNBlocks.SOIL);
    });

    //#------------------
    public static ResourceLocation location(String name) {
        return new ResourceLocation(WildNature.modid, name);
    }

    private static <T extends BlockEntity> BlockEntityType<T> register(ResourceLocation registryName, Supplier<BlockEntityType.Builder<T>> builder) {
        if (!WildNature.instance.initializer.isInitialized(InitStage.REG_BLOCK_ENTITIES)) {
            return null;
        }
        BlockEntityType<T> blockEntityType = builder.get().build(null);
        blockEntityType.setRegistryName(registryName);
        BLOCK_ENTITY_TYPES.put(registryName, blockEntityType);

        return blockEntityType;
    }
}
