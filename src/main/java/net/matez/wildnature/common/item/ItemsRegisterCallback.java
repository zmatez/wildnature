/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.item;

public interface ItemsRegisterCallback<T,U extends IWNItem> {
    U[] register(T value);
}
