package net.matez.wildnature.common.objects.containers.backpack;

import net.matez.wildnature.common.objects.containers.AbstractBackpackMenu;
import net.matez.wildnature.common.registry.containers.WNContainers;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ShulkerBoxSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class WNBackpackMenuSmall extends AbstractBackpackMenu {
    public WNBackpackMenuSmall(int id, Inventory inventory, ItemStack stack, Player player) {
        super(WNContainers.BACKPACK_SMALL, id, inventory, stack, player);
    }

    public WNBackpackMenuSmall(int i, Inventory inventory) {
        this(i, inventory, ItemStack.EMPTY, null);
    }

    @Override
    public void createSlots(Inventory inventory) {
        for (int i = 0; i < 2; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new ShulkerBoxSlot(container, j + i * 9, 7 + j * 18, 22 + i * 18));
            }
        }

        for (int k = 0; k < 3; ++k) {
            for (int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(inventory, i1 + k * 9 + 9, 7 + i1 * 18, 78 + k * 18));
            }
        }

        for (int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(inventory, l, 7 + l * 18, 136));
        }
    }

    @Override
    public int getSize() {
        return 18;
    }
}
