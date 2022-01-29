/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.item_models;

import net.matez.wildnature.data.setup.base.WNItemModel;

public class WNItemModel_Handheld extends WNItemModel {
    /**
     * Required: @texture
     */
    public WNItemModel_Handheld(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:item/handheld",
                  "textures": {
                    "layer0": "%texture%"
                  }
                }
                """;
    }
}
