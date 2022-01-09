package net.matez.wildnature.common.registry.items;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.items.setup.IWNItem;
import net.matez.wildnature.common.objects.items.setup.WNItem;

public interface ItemRegisterCallback<T,U extends IWNItem> {
    U register(T value);
}
