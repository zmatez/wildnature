package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_WallSideTall extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_WallSideTall(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/template_wall_side_tall",
                  "textures": {
                    "wall": "%texture%"
                  }
                }
                """;
    }
}
