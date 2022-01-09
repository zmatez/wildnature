package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_FenceInventory extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_FenceInventory(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/fence_inventory",
                  "textures": {
                    "texture": "%texture%"
                  }
                }
                """;
    }
}
