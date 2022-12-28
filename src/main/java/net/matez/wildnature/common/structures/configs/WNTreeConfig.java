/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.structures.configs;

import net.matez.wildnature.common.block.leaves.LeafType;
import net.matez.wildnature.common.block.wood.LogType;
import net.matez.wildnature.common.block.wood.building.WNBranchBlock;
import net.matez.wildnature.common.structures.WNStructureConfig;
import net.matez.wildnature.core.registry.WNBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Random;
import java.util.function.Supplier;

public class WNTreeConfig implements WNStructureConfig {
    public static final WNTreeConfig PURPLE_BEECH = new WNTreeConfig(WNBlocks.LEAVES.get(LeafType.PURPLE_BEECH));
    public static final WNTreeConfig CHERRY = new WNTreeConfig(() -> WNBlocks.LEAVES.get(LeafType.CHERRY));
    public static final WNTreeConfig CHERRY_PINK = new WNTreeConfig(() -> WNBlocks.LEAVES.get(LeafType.CHERRY_PINK));
    public static final WNTreeConfig CHERRY_WHITE = new WNTreeConfig(() -> WNBlocks.LEAVES.get(LeafType.CHERRY_WHITE));
    public static final WNTreeConfig RAINBOW_EUCALYPTUS = new WNTreeConfig(null, () -> WNBlocks.LOGS.get(LogType.RAINBOW_EUCALYPTUS), () -> WNBlocks.BRANCHES.get(LogType.RAINBOW_EUCALYPTUS));
    public static final WNTreeConfig MAPLE_RED = new WNTreeConfig(() -> WNBlocks.LEAVES.get(LeafType.MAPLE_RED));
    public static final WNTreeConfig MAPLE_ORANGE = new WNTreeConfig(() -> WNBlocks.LEAVES.get(LeafType.MAPLE_ORANGE));
    public static final WNTreeConfig MAPLE_YELLOW = new WNTreeConfig(() -> WNBlocks.LEAVES.get(LeafType.MAPLE_YELLOW));
    public static final WNTreeConfig MAPLE_BROWN = new WNTreeConfig(() -> WNBlocks.LEAVES.get(LeafType.MAPLE_BROWN));
    public static final WNTreeConfig METASEQUOIA_GREEN = new WNTreeConfig(() -> WNBlocks.LEAVES.get(LeafType.METASEQUOIA_GREEN), () -> WNBlocks.LOGS.get(LogType.REDWOOD), () -> WNBlocks.BRANCHES.get(LogType.REDWOOD));
    public static final WNTreeConfig METASEQUOIA_ORANGE = new WNTreeConfig(() -> WNBlocks.LEAVES.get(LeafType.METASEQUOIA_ORANGE), () -> WNBlocks.LOGS.get(LogType.REDWOOD), () -> WNBlocks.BRANCHES.get(LogType.REDWOOD));
    public static final WNTreeConfig METASEQUOIA_YELLOW = new WNTreeConfig(() -> WNBlocks.LEAVES.get(LeafType.METASEQUOIA_YELLOW), () -> WNBlocks.LOGS.get(LogType.REDWOOD), () -> WNBlocks.BRANCHES.get(LogType.REDWOOD));
    public static final WNTreeConfig METASEQUOIA_BROWN = new WNTreeConfig(() -> WNBlocks.LEAVES.get(LeafType.METASEQUOIA_BROWN), () -> WNBlocks.LOGS.get(LogType.REDWOOD), () -> WNBlocks.BRANCHES.get(LogType.REDWOOD));
    public static final WNTreeConfig METASEQUOIA_RED = new WNTreeConfig(() -> WNBlocks.LEAVES.get(LeafType.METASEQUOIA_RED), () -> WNBlocks.LOGS.get(LogType.REDWOOD), () -> WNBlocks.BRANCHES.get(LogType.REDWOOD));


    //# ---------------------------------------------

    private final Supplier<Block> log, leaves, branch;

    public WNTreeConfig(Supplier<Block> leaves) {
        this.log = null;
        this.branch = null;
        this.leaves = leaves;
    }

    public WNTreeConfig(Supplier<Block> leaves, Supplier<Block> log, Supplier<Block> branch) {
        this.log = log;
        this.branch = branch;
        this.leaves = leaves;
    }

    @Override
    public BlockState processState(LevelAccessor level, BlockState state, BlockPos pos, RandomSource random, @Nullable Rotation rotation) {
        BlockState newState = state;
        if (newState.is(BlockTags.LOGS)) {
            if (log != null) {
                newState = WNStructureConfig.changeState(state, log.get());
            }
        } else if (newState.is(BlockTags.LEAVES)) {
            if (leaves != null) {
                newState = WNStructureConfig.changeState(state, leaves.get());
            }
        } else if (newState.getBlock() instanceof WNBranchBlock) {
            if (branch != null) {
                newState = WNStructureConfig.changeState(state, branch.get());
            }
        }
        return newState;
    }
}
