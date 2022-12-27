/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.structure;

import net.matez.wildnature.core.registry.WNBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

import java.util.ArrayList;


public abstract class WNDevStructureSelection {
    private final Player owner;
    private final Level level;
    private final ArrayList<BlockPos> centers = new ArrayList<>();
    private BlockPos pos1, pos2;

    public WNDevStructureSelection(Player owner) {
        this.owner = owner;
        this.level = owner.getLevel();
    }

    public Level getLevel() {
        return level;
    }

    public Player getOwner() {
        return owner;
    }

    public BlockPos getPos1() {
        return pos1;
    }

    public void setPos1(BlockPos pos1) {
        this.pos1 = pos1;
    }

    public BlockPos getPos2() {
        return pos2;
    }

    public void setPos2(BlockPos pos2) {
        this.pos2 = pos2;
    }

    public boolean isComplete() {
        return pos1 != null && pos2 != null;
    }

    public ArrayList<BlockPos> getCenters() {
        return centers;
    }

    /**
     * Only if isComplete()
     *
     * @return min pos between pos1 and pos2
     */
    public BlockPos getMinPos() {
        if (!isComplete()) {
            return null;
        }

        return new BlockPos(Math.min(pos1.getX(), pos2.getX()), Math.min(pos1.getY(), pos2.getY()), Math.min(pos1.getZ(), pos2.getZ()));
    }

    /**
     * Only if isComplete()
     *
     * @return max pos between pos1 and pos2
     */
    public BlockPos getMaxPos() {
        if (!isComplete()) {
            return null;
        }

        return new BlockPos(Math.max(pos1.getX(), pos2.getX()), Math.max(pos1.getY(), pos2.getY()), Math.max(pos1.getZ(), pos2.getZ()));
    }

    public int getSize() {
        if (!isComplete()) {
            return 0;
        }

        BlockPos min = getMinPos();
        BlockPos max = getMaxPos();

        int xd = Math.max(1, max.getX() - min.getX());
        int yd = Math.max(1, max.getY() - min.getY());
        int zd = Math.max(1, max.getZ() - min.getZ());

        return xd * yd * zd;
    }

    public ArrayList<BlockPos> stream() {
        if (!isComplete()) {
            return null;
        }

        BlockPos min = getMinPos();
        BlockPos max = getMaxPos();

        ArrayList<BlockPos> pos = new ArrayList<>();

        for (int x = min.getX(); x <= max.getX(); x++) {
            for (int y = min.getY(); y <= max.getY(); y++) {
                for (int z = min.getZ(); z <= max.getZ(); z++) {
                    pos.add(new BlockPos(x, y, z));
                }
            }
        }
        return pos;
    }

    public void findCenters() {
        if (!isComplete()) {
            return;
        }

        this.centers.clear();
        for (BlockPos blockPos : stream()) {
            BlockState state = level.getBlockState(blockPos);
            if (state.is(WNBlocks.DEV_STRUCTURE_CENTER)) {
                centers.add(blockPos);
            }
        }
    }


    //#-------------------------
    public void tick() {
        if (level.isClientSide()) {
            findCenters();
        }
    }

}
