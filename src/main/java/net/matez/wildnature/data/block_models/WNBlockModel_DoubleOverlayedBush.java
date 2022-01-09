package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_DoubleOverlayedBush extends WNBlockModel {
    /**
     * Required: @colored, @greyscale
     */
    public WNBlockModel_DoubleOverlayedBush(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "wildnature:block/doubled_cross_with_overlay",
                    "textures": {
                        "colored": "%colored%",
                        "greyscale": "%greyscale%"
                    }
                }
                                
                """;
    }
}
