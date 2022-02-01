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

    public void place(ItemStack stack, Direction facing){
        drop();
        this.placedStack = stack;
        this.facing = facing;
        setChanged();
    }

    public void drop(){
        if(!placedStack.isEmpty() && this.level != null){
            Block.popResourceFromFace(this.level,this.worldPosition,Direction.UP,this.placedStack);
            this.placedStack = ItemStack.EMPTY;
            setChanged();
        }
    }

    public boolean hasPlacedStack(){
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

        if(!placedStack.isEmpty()){
            tag.put("placed_stack",this.placedStack.save(new CompoundTag()));
        }else{
            tag.remove("placed_stack");
        }
        tag.putString("facing",facing.getName());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);

        if(tag.contains("placed_stack")){
            this.placedStack = ItemStack.of(tag.getCompound("placed_stack"));
        }else{
            this.placedStack = ItemStack.EMPTY;
        }
        if(tag.contains("facing")){
            this.facing = Direction.byName(tag.getString("facing"));
            if(this.facing == null){
                this.facing = Direction.NORTH;
            }
        }else{
            this.facing = Direction.NORTH;
        }
    }
}
