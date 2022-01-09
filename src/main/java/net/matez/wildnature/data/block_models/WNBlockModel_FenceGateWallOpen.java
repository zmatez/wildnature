package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_FenceGateWallOpen extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_FenceGateWallOpen(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "parent": "minecraft:block/template_fence_gate_wall_open",
                  "textures": {
                    "texture": "%texture%"
                  }
                }
                """;
    }
}
