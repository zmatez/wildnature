/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_BushLeavesFlower extends WNBlockModel {
    /**
     * Required: @texture, @branch, @flower
     */
    public WNBlockModel_BushLeavesFlower(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "wildnature:block/branch_leaves_flower",
                    "textures": {
                        "branch": "%branch%",
                        "leaves": "%texture%",
                        "flower": "%flower%"
                    }
                }
                """;
    }
}
