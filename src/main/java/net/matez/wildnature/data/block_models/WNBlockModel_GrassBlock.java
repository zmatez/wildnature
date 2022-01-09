package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_GrassBlock extends WNBlockModel {
    /**
     * Required: @texture, @dirt
     */
    public WNBlockModel_GrassBlock(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {   "parent": "block/block",
                    "textures": {
                        "particle": "%dirt%",
                        "bottom": "%dirt%",
                        "top": "%texture%_top",
                        "side": "%texture%_side",
                        "overlay": "%texture%_side_overlay"
                    },
                    "elements": [
                        {   "from": [ 0, 0, 0 ],
                            "to": [ 16, 16, 16 ],
                            "faces": {
                                "down":  { "uv": [ 0, 0, 16, 16 ], "texture": "#bottom", "cullface": "down" },
                                "up":    { "uv": [ 0, 0, 16, 16 ], "texture": "#top",    "cullface": "up", "tintindex": 0 },
                                "north": { "uv": [ 0, 0, 16, 16 ], "texture": "#side",   "cullface": "north" },
                                "south": { "uv": [ 0, 0, 16, 16 ], "texture": "#side",   "cullface": "south" },
                                "west":  { "uv": [ 0, 0, 16, 16 ], "texture": "#side",   "cullface": "west" },
                                "east":  { "uv": [ 0, 0, 16, 16 ], "texture": "#side",   "cullface": "east" }
                            }
                        },
                        {   "from": [ 0, 0, 0 ],
                            "to": [ 16, 16, 16 ],
                            "faces": {
                                "north": { "uv": [ 0, 0, 16, 16 ], "texture": "#overlay", "tintindex": 0, "cullface": "north" },
                                "south": { "uv": [ 0, 0, 16, 16 ], "texture": "#overlay", "tintindex": 0, "cullface": "south" },
                                "west":  { "uv": [ 0, 0, 16, 16 ], "texture": "#overlay", "tintindex": 0, "cullface": "west" },
                                "east":  { "uv": [ 0, 0, 16, 16 ], "texture": "#overlay", "tintindex": 0, "cullface": "east" }
                            }
                        }
                    ]
                }
                                
                """;
    }
}
