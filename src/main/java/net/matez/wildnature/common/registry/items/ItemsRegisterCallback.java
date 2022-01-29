/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.registry.items;

import net.matez.wildnature.common.objects.items.setup.IWNItem;

public interface ItemsRegisterCallback<T,U extends IWNItem> {
    U[] register(T value);
}
