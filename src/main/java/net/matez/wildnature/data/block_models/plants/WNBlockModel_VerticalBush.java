package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_VerticalBush extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_VerticalBush(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                   "parent": "wildnature:block/vertical_bush",
                   "textures": {
                     "bush": "%texture%"
                   }
                 }
                 
                """;
    }
}
