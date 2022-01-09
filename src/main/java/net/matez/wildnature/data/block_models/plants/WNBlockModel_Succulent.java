package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Succulent extends WNBlockModel {
    /**
     * Required: @texture, @type[tall, big, small, big_and_small
     */
    public WNBlockModel_Succulent(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "wildnature:block/succulent_%type%",
                    "textures": {
                        "texture": "%texture%"
                	}
                }
                """;
    }
}
