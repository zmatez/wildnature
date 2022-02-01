/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.registry.entities;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.objects.entities.seat.WNSeatEntity;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

import java.util.LinkedHashMap;
import java.util.function.Supplier;

@Initialize(InitStage.CONSTRUCT)
public class WNEntities {
    private static final WNLogger log = WildNature.getLogger();

    //# --- ALL BLOCK ENTITIES  ---
    public static final LinkedHashMap<ResourceLocation, EntityType<?>> ENTITY_TYPES = new LinkedHashMap<>();
    //#------------------

    public static final EntityType<WNSeatEntity> SEAT = register(location("seat"), () -> {
        return EntityType.Builder.<WNSeatEntity>of(WNSeatEntity::new, MobCategory.MISC).sized(0.25F, 0.25F).clientTrackingRange(4).noSummon().noSave();
    });

    //#------------------
    public static ResourceLocation location(String name) {
        return new ResourceLocation(WildNature.modid, name);
    }

    private static <T extends Entity> EntityType<T> register(ResourceLocation registryName, Supplier<EntityType.Builder<T>> builder) {
        EntityType<T> entityType = builder.get().build(null);
        entityType.setRegistryName(registryName);
        ENTITY_TYPES.put(registryName, entityType);

        return entityType;
    }
}
