/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.item_models.crossbow;

import net.matez.wildnature.data.setup.base.WNItemModel;

public class WNItemModel_CrossbowPredicate extends WNItemModel {
    /**
     * Required: @texture
     */
    public WNItemModel_CrossbowPredicate(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "item/crossbow",
                    "textures": {
                        "layer0": "%texture%"
                    }
                }
                """;
    }
}
