/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.cave_plants;

import net.matez.wildnature.common.block.plant.WNBushBlock;

public class WNCaveBushBlock extends WNBushBlock {
    protected final CavePlantType cavePlantType;
    public WNCaveBushBlock(Properties properties, CavePlantType type) {
        super(properties, type.getConfig());
        this.cavePlantType = type;
    }

    public CavePlantType getCavePlantType() {
        return cavePlantType;
    }
}
