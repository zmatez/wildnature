/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Lilypad extends WNBlockModel {
    /**
     * Required: texture
     */
    public WNBlockModel_Lilypad(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/lily_pad",
                  "textures": {
                    "texture": "%texture%",
                    "particle": "%texture%"
                  }
                }
                """;
    }
}
