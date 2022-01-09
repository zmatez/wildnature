package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_ButtonInventory extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_ButtonInventory(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                   "parent": "minecraft:block/button_inventory",
                   "textures": {
                     "texture": "%texture%"
                   }
                 }
                """;
    }
}
