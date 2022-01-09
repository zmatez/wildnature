package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_WallInventory extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_WallInventory(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/wall_inventory",
                  "textures": {
                    "wall": "%texture%"
                  }
                }
                """;
    }
}
