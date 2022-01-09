package net.matez.wildnature.data.item_models;

import net.matez.wildnature.data.setup.base.WNItemModel;

public class WNItemModel_Generated extends WNItemModel {
    /**
     * Required: @texture
     */
    public WNItemModel_Generated(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:item/generated",
                  "textures": {
                    "layer0": "%texture%"
                  }
                }
                """;
    }
}
