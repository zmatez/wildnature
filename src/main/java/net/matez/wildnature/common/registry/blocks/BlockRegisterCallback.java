package net.matez.wildnature.common.registry.blocks;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;

public interface BlockRegisterCallback<T,U extends WNBlock> {
    U register(T value);
}
