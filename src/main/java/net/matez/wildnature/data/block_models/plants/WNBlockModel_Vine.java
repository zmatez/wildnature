package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Vine extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_Vine(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "ambientocclusion": false,
                    "textures": {
                        "particle": "%texture%",
                        "vine": "%texture%"
                    },
                    "elements": [
                        {   "from": [ 0, 0, 0.8 ],
                            "to": [ 16, 16, 0.8 ],
                            "shade": false,
                            "faces": {
                                "north": { "uv": [ 16, 0, 0, 16 ], "texture": "#vine", "tintindex": 0 },
                                "south": { "uv": [ 0, 0, 16, 16 ], "texture": "#vine", "tintindex": 0 }
                            }
                        }
                    ]
                }
                """;
    }
}
