package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Leaves extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_Leaves(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/leaves",
                  "textures": {
                    "all": "%texture%"
                  }
                }
                """;
    }
}
