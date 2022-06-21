/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.initializer;

public enum InitStage {
    START,
    CONSTRUCT,
    REG_BLOCKS,
    REG_ITEMS,
    REG_BLOCK_ENTITIES,
    REG_ENTITIES,
    REG_MENUS,
    REG_BIOMES,
    REG_FEATURES,
    CLIENT,
    PARTICLE,
    ENTITY_RENDERER,
    SCREEN,
    SETUP,
    FINISH
}
