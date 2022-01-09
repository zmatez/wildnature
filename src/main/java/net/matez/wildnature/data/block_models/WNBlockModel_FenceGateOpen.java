package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_FenceGateOpen extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_FenceGateOpen(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/template_fence_gate_open",
                  "textures": {
                    "texture": "%texture%"
                  }
                }
                """;
    }
}
