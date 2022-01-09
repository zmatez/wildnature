package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_TrapdoorTop extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_TrapdoorTop(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                   "parent": "minecraft:block/template_orientable_trapdoor_top",
                   "textures": {
                     "texture": "%texture%"
                   }
                 }
                """;
    }
}
