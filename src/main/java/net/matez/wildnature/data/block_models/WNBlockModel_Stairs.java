package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Stairs extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_Stairs(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/stairs",
                  "textures": {
                    "bottom": "%texture%",
                    "top": "%texture%",
                    "side": "%texture%"
                  }
                }
                """;
    }
}
