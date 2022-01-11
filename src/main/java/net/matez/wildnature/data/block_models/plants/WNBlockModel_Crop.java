package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Crop extends WNBlockModel {
    /**
     * Required: texture
     */
    public WNBlockModel_Crop(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/crop",
                  "textures": {
                    "crop": "%texture%"
                  }
                }
                """;
    }
}
