/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blockentities.soil;

import net.matez.wildnature.common.objects.structures.WNStructure;
import net.matez.wildnature.common.objects.structures.WNStructureConfig;
import net.matez.wildnature.common.objects.structures.types.WNTreeStructure;
import net.matez.wildnature.common.registry.blockentities.WNBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class WNSoilBlockEntity extends BlockEntity {
    private BlockPos min, max;
    private Block leaf;

    public WNSoilBlockEntity(BlockPos pos, BlockState state) {
        super(WNBlockEntities.SOIL, pos, state);
    }

    public void set(WNStructure structure, @org.jetbrains.annotations.Nullable Rotation rotation, @org.jetbrains.annotations.Nullable WNStructureConfig config) {
        if (structure instanceof WNTreeStructure treeStructure && level != null) {
            var min = treeStructure.getMinLeaf();
            var max = treeStructure.getMaxLeaf();
            if (rotation != null) {
                min = min.rotate(rotation);
                max = max.rotate(rotation);
            }

            this.min = new BlockPos(Math.min(min.getX(), max.getX()), Math.min(min.getY(), max.getY()), Math.min(min.getZ(), max.getZ()));
            this.max = new BlockPos(Math.max(min.getX(), max.getX()), Math.max(min.getY(), max.getY()), Math.max(min.getZ(), max.getZ()));

            var state = treeStructure.getLeafBlock();
            if (config != null) {
                state = config.processState(level, state, getBlockPos(), level.getRandom(), rotation);
            }

            if (state != null) {
                leaf = state.getBlock();
            }
        }
    }

    public void destroy() {
        if (level != null && leaf != null && min != null && max != null) {
            var thread = new Thread(() -> {
                for (int x = min.getX(); x <= max.getX(); x++) {
                    for (int y = min.getY(); y <= max.getY(); y++) {
                        for (int z = min.getZ(); z <= max.getZ(); z++) {
                            BlockPos pos = new BlockPos(x, y, z).offset(getBlockPos());
                            BlockState state = level.getBlockState(pos);
                            if (state.is(this.leaf) && state.hasProperty(BlockStateProperties.PERSISTENT)) {
                                level.setBlock(pos, state.setValue(BlockStateProperties.PERSISTENT, false), 2);
                            }
                        }
                    }
                }
            });
            thread.setName("SoilDestroyThread");
            thread.start();
        }
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);

        if (min != null) {
            tag.putLong("min", min.asLong());
        }
        if (max != null) {
            tag.putLong("max", max.asLong());
        }

        if (leaf != null) {
            tag.putString("leaf", leaf.getRegistryName().toString());
        }
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.loadAdditional(tag);
    }

    public void loadAdditional(CompoundTag tag) {
        if (tag.contains("min")) {
            this.min = BlockPos.of(tag.getLong("min"));
        }
        if (tag.contains("max")) {
            this.max = BlockPos.of(tag.getLong("max"));
        }

        if (tag.contains("leaf")) {
            var leafReg = new ResourceLocation(tag.getString("leaf"));
            var opt = Registry.BLOCK.getOptional(leafReg);
            opt.ifPresent(block -> this.leaf = block);
        }
    }

    /*
    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        super.getUpdatePacket();
        CompoundTag tag = getUpdateTag();
        return ClientboundBlockEntityDataPacket.create(this, (entity) -> tag);
    }

    @Override
    public void onDataPacket(Connection connection, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(connection,pkt);
        CompoundTag tag = pkt.getTag();
        assert tag != null;
        this.loadAdditional(tag);
    }

    @Override
    public CompoundTag getUpdateTag() {
        var tag = super.getUpdateTag();
        saveAdditional(tag);
        return tag;
    }

    @Override
    public void handleUpdateTag(CompoundTag tag) {
        super.handleUpdateTag(tag);
        loadAdditional(tag);
    }
    */

    @Override
    public void setChanged() {
        super.setChanged();
        if (level != null) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 2);
        }
    }
}
