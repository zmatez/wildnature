package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Slab extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_Slab(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/slab",
                  "textures": {
                    "bottom": "%texture%",
                    "top": "%texture%",
                    "side": "%texture%"
                  }
                }
                """;
    }
}
