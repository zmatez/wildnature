/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block;

import net.matez.wildnature.data.setup.base.WNResource;

public interface ModelSupplier {
    WNResource getModel(WNBlock block);
}
