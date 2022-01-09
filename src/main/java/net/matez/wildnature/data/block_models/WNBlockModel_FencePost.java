package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_FencePost extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_FencePost(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/fence_post",
                  "textures": {
                    "texture": "%texture%"
                  }
                }
                """;
    }
}
