/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Sapling extends WNBlockModel {
    /**
     * Required: @log, @leaves
     */
    public WNBlockModel_Sapling(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                   "parent": "wildnature:block/sapling",
                   "textures": {
                     "particle": "%leaves%",
                     "leaves": "%leaves%",
                     "log": "%log%"
                   }
                 }
                """;
    }
}
