/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blockentities.table;

import net.matez.wildnature.common.registry.blockentities.WNBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class WNTableBlockEntity extends BlockEntity {
    private ItemStack placedStack = ItemStack.EMPTY;
    private Direction facing = Direction.NORTH;
    private Player eatingPlayer;
    private int eatingTime = 0;
    private Random random = new Random();

    public WNTableBlockEntity(BlockPos pos, BlockState state) {
        super(WNBlockEntities.TABLE, pos, state);
    }

    public void place(ItemStack stack, Direction facing) {
        drop();
        this.placedStack = stack;
        this.facing = facing;
        setChanged();
    }

    public void drop() {
        if (!placedStack.isEmpty() && this.level != null) {
            Block.popResourceFromFace(this.level, this.worldPosition, Direction.UP, this.placedStack);
            this.placedStack = ItemStack.EMPTY;
            setChanged();
        }
    }

    public boolean hasPlacedStack() {
        return !placedStack.isEmpty();
    }

    public ItemStack getPlacedStack() {
        return placedStack;
    }

    public void setPlacedStack(ItemStack placedStack) {
        this.placedStack = placedStack;
        this.setChanged();
    }

    public Direction getFacing() {
        return facing;
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);

        if (!placedStack.isEmpty()) {
            tag.put("placed_stack", this.placedStack.save(new CompoundTag()));
        } else {
            tag.remove("placed_stack");
        }
        tag.putString("facing", facing.getName());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.loadAdditional(tag);
    }

    public void loadAdditional(CompoundTag tag) {
        if (tag.contains("placed_stack")) {
            this.placedStack = ItemStack.of(tag.getCompound("placed_stack"));
        } else {
            this.placedStack = ItemStack.EMPTY;
        }
        if (tag.contains("facing")) {
            this.facing = Direction.byName(tag.getString("facing"));
            if (this.facing == null) {
                this.facing = Direction.NORTH;
            }
        } else {
            this.facing = Direction.NORTH;
        }
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        super.getUpdatePacket();
        CompoundTag tag = getUpdateTag();
        return ClientboundBlockEntityDataPacket.create(this, (entity) -> tag);
    }

    @Override
    public void onDataPacket(Connection connection, ClientboundBlockEntityDataPacket pkt) {
        super.onDataPacket(connection, pkt);
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

    @Override
    public void setChanged() {
        super.setChanged();
        if (level != null) {
            level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 2);
        }
    }
}
