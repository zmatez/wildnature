/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Bench extends WNBlockModel {
    /**
     * Required: @texture, @beam, @side (side, middle, single)
     */
    public WNBlockModel_Bench(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "wildnature:block/bench_%side%",
                    "textures": {
                        "material": "%texture%",
                        "material2": "%beam%"
                    }
                }
                """;
    }
}
