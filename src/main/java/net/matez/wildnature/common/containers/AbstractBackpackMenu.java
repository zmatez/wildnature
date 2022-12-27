/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.containers;

import net.matez.wildnature.common.containers.backpack.WNBackpackContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public abstract class AbstractBackpackMenu extends AbstractContainerMenu {
    protected final WNBackpackContainer container;
    protected final ItemStack stack;
    protected final int openedSlot;

    public AbstractBackpackMenu(MenuType<? extends AbstractBackpackMenu> type, int id, Inventory inventory, ItemStack stack, Player player) {
        super(type, id);
        this.stack = stack;
        this.openedSlot = inventory.findSlotMatchingItem(stack);
        this.container = WNBackpackContainer.load(getSize(), stack);
        this.container.startOpen(inventory.player);
        this.container.addListener((container) -> {
            if (!stack.isEmpty() && player != null) {
                this.container.save(player, stack);
            }
        });
        checkContainerSize(container, getSize());

        createSlots(inventory);
    }

    public abstract void createSlots(Inventory inventory);

    public abstract int getSize();

    public boolean stillValid(Player player) {
        return this.container.stillValid(player) && player.getInventory().getItem(this.openedSlot).equals(this.stack);
    }

    public ItemStack quickMoveStack(Player player, int slotId) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(slotId);
        if (slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();
            if (slotId < this.container.getContainerSize()) {
                if (!this.moveItemStackTo(itemstack1, this.container.getContainerSize(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, this.container.getContainerSize(), false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    public void removed(Player player) {
        super.removed(player);
        this.container.stopOpen(player);
    }
}