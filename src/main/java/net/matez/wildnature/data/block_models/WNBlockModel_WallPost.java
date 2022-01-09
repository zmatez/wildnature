package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_WallPost extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_WallPost(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/template_wall_post",
                  "textures": {
                    "wall": "%texture%"
                  }
                }
                """;
    }
}
