/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_TableInventory extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_TableInventory(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "wildnature:block/table_inventory",
                    "textures": {
                        "texture": "%texture%"
                    }
                }
                """;
    }
}
