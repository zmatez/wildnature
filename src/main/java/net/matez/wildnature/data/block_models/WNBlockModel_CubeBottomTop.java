package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_CubeBottomTop extends WNBlockModel {
    /**
     * Required: @texture_top, @texture_bottom, @texture_side
     */
    public WNBlockModel_CubeBottomTop(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/cube_bottom_top",
                  "textures": {
                    "top": "%texture_top%",
                    "bottom": "%texture_bottom%",
                    "side": "%texture_side%",
                    "particle": "%texture_bottom%"
                  }
                }
                """;
    }
}
