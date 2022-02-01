package net.matez.wildnature.common.objects.containers.backpack;

import net.matez.wildnature.common.objects.containers.AbstractBackpackMenu;
import net.matez.wildnature.common.registry.containers.WNContainers;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ShulkerBoxSlot;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class WNBackpackMenuBig extends AbstractBackpackMenu {
    public WNBackpackMenuBig(int id, Inventory inventory, ItemStack stack, Player player) {
        super(WNContainers.BACKPACK_BIG, id, inventory, stack, player);
    }

    public WNBackpackMenuBig(int i, Inventory inventory) {
        this(i, inventory, ItemStack.EMPTY, null);
    }

    @Override
    public void createSlots(Inventory inventory) {
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 11; ++j) {
                int xpos = 7 + j * 18;
                int ypos = 22 + i * 18;
                if (j == 0) {

                } else if (j == 10) {
                    xpos += 14;
                } else {
                    xpos += 7;
                }

                this.addSlot(new ShulkerBoxSlot(container, j + i * 11, xpos, ypos));
            }
        }


        for (int k = 0; k < 3; ++k) {
            for (int i1 = 0; i1 < 9; ++i1) {
                this.addSlot(new Slot(inventory, i1 + k * 9 + 9, 32 + i1 * 18, 114 + k * 18));
            }
        }

        for (int l = 0; l < 9; ++l) {
            this.addSlot(new Slot(inventory, l, 32 + l * 18, 172));
        }
    }

    @Override
    public int getSize() {
        return 44;
    }
}
