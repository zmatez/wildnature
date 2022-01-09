package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_DoorBottom extends WNBlockModel {
    /**
     * Required: @texture (_top & _bottom)
     */
    public WNBlockModel_DoorBottom(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/door_bottom",
                  "textures": {
                    "top": "%texture%_top",
                    "bottom": "%texture%_bottom"
                  }
                }
                """;
    }
}
