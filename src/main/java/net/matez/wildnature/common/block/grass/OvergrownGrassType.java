/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.grass;

import net.matez.wildnature.common.block.rocks.RockType;
import net.matez.wildnature.core.registry.WNBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Supplier;

public enum OvergrownGrassType {
    OVERGROWN_STONE("overgrown_stone", false, () -> Blocks.STONE, () -> "minecraft:block/stone", () -> Blocks.COBBLESTONE),
    OVERGROWN_MARBLE("overgrown_marble", false, WNBlocks.ROCKS.get(RockType.MARBLE), () -> "wildnature:block/rocks/marble/marble", WNBlocks.ROCKS.get(RockType.MARBLE));
    private final String idBase;
    private final boolean tinted;
    private final Supplier<Block> baseBlock;
    private final Supplier<String> baseBlockTexture;
    private final Supplier<Block> dropBlock;

    OvergrownGrassType(String idBase, boolean tinted, Supplier<Block> baseBlock, Supplier<String> baseBlockTexture, Supplier<Block> dropBlock) {
        this.idBase = idBase;
        this.tinted = tinted;
        this.baseBlock = baseBlock;
        this.baseBlockTexture = baseBlockTexture;
        this.dropBlock = dropBlock;
    }

    public String getIdBase() {
        return idBase;
    }

    public Supplier<Block> getBaseBlock() {
        return baseBlock;
    }

    public Supplier<String> getBaseBlockTexture() {
        return baseBlockTexture;
    }

    public Supplier<Block> getDropBlock() {
        return dropBlock;
    }

    public boolean isTinted() {
        return tinted;
    }
}
