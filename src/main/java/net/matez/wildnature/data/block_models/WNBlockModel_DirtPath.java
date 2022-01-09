package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_DirtPath extends WNBlockModel {
    /**
     * Required: @texture_top, @texture_bottom, @texture_side
     */
    public WNBlockModel_DirtPath(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {   
                    "parent": "block/block",
                    "textures": {
                        "top": "%texture_top%",
                        "bottom": "%texture_bottom%",
                        "side": "%texture_side%",
                        "particle": "%texture_bottom%"
                    },
                    "elements": [
                        {   "from": [ 0, 0, 0 ],
                            "to": [ 16, 15, 16 ],
                            "faces": {
                                "down":  { "uv": [ 0, 0, 16, 16 ], "texture": "#bottom", "cullface": "down" },
                                "up":    { "uv": [ 0, 0, 16, 16 ], "texture": "#top" },
                                "north": { "uv": [ 0, 1, 16, 16 ], "texture": "#side", "cullface": "north" },
                                "south": { "uv": [ 0, 1, 16, 16 ], "texture": "#side", "cullface": "south" },
                                "west":  { "uv": [ 0, 1, 16, 16 ], "texture": "#side", "cullface": "west" },
                                "east":  { "uv": [ 0, 1, 16, 16 ], "texture": "#side", "cullface": "east" }
                            }
                        }
                    ]
                }
                                
                """;
    }
}
