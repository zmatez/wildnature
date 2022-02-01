package net.matez.wildnature.common.objects.containers.backpack;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class WNBackpackContainer extends SimpleContainer {
    //private static final WNLogger log = WildNature.getLogger();

    public WNBackpackContainer(int size) {
        super(size);
    }

    public WNBackpackContainer(ItemStack... items) {
        super(items);
    }

    public ItemStack[] getItems() {
        ItemStack[] stacks = new ItemStack[getContainerSize()];
        for (int i = 0; i < getContainerSize(); i++) {
            stacks[i] = getItem(i);
        }
        return stacks;
    }

    public void save(Player player, ItemStack stack) {
        var tag = stack.getOrCreateTag();
        var itemsTag = new CompoundTag();
        ItemStack[] items = getItems();
        int count = 0;
        for (int i = 0; i < items.length; i++) {
            ItemStack item = items[i];
            var itemTag = new CompoundTag();
            item.save(itemTag);
            itemsTag.put(i + "", itemTag);
            if (!item.isEmpty()) {
                count++;
            }
        }

        tag.put("items", itemsTag);
        tag.putUUID("owner", player.getUUID());
        tag.putInt("count", count);
    }

    public static WNBackpackContainer load(int size, ItemStack stack) {
        var tag = stack.getOrCreateTag();
        if (!tag.contains("items")) {
            return new WNBackpackContainer(size);
        }

        var container = new WNBackpackContainer(size);
        for (int i = 0; i < size; i++) {
            ItemStack item = ItemStack.EMPTY;
            if (tag.getCompound("items").contains(i + "")) {
                item = ItemStack.of(tag.getCompound("items").getCompound(i + ""));
            }
            container.setItem(i, item);
        }
        container.setChanged();

        return container;
    }

}
