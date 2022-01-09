package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_FenceGate extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_FenceGate(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/template_fence_gate",
                  "textures": {
                    "texture": "%texture%"
                  }
                }
                """;
    }
}
