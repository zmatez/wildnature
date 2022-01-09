package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_DoorTopHinge extends WNBlockModel {
    /**
     * Required: @texture (_top & _bottom)
     */
    public WNBlockModel_DoorTopHinge(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/door_top_rh",
                  "textures": {
                    "top": "%texture%_top",
                    "bottom": "%texture%_bottom"
                  }
                }
                """;
    }
}
