/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_CrossLilypad extends WNBlockModel {
    /**
     * Required: texture, pad
     */
    public WNBlockModel_CrossLilypad(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "wildnature:block/cross_lilypad",
                  "textures": {
                    "pad": "%pad%",
                    "cross": "%texture%"
                  }
                }
                """;
    }
}
