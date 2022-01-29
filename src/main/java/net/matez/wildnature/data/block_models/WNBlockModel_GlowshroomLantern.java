/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_GlowshroomLantern extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_GlowshroomLantern(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                 	"textures": {
                 		"1": "%texture%",
                 		"particle": "%texture%"
                 	},
                 	"elements": [
                 		{
                 			"name": "base",
                 			"from": [5, 0, 5],
                 			"to": [11, 11, 11],
                 			"faces": {
                 				"north": {"uv": [0, 2, 6, 13], "texture": "#1"},
                 				"east": {"uv": [0, 2, 6, 13], "texture": "#1"},
                 				"south": {"uv": [0, 2, 6, 13], "texture": "#1"},
                 				"west": {"uv": [0, 2, 6, 13], "texture": "#1"},
                 				"up": {"uv": [7, 0, 13, 6], "texture": "#1"},
                 				"down": {"uv": [7, 0, 13, 6], "texture": "#1"}
                 			}
                 		},
                 		{
                 			"name": "top",
                 			"from": [6, 11, 6],
                 			"to": [10, 13, 10],
                 			"faces": {
                 				"north": {"uv": [1, 0, 5, 2], "texture": "#1"},
                 				"east": {"uv": [1, 0, 5, 2], "texture": "#1"},
                 				"south": {"uv": [1, 0, 5, 2], "texture": "#1"},
                 				"west": {"uv": [1, 0, 5, 2], "texture": "#1"},
                 				"up": {"uv": [8, 1, 12, 5], "texture": "#1"},
                 				"down": {"uv": [8, 1, 12, 5], "texture": "#1"}
                 			}
                 		},
                 		{
                 			"name": "chain",
                 			"from": [6.5, 13, 8],
                 			"to": [9.5, 15, 8],
                 			"rotation": {"angle": 45, "axis": "y", "origin": [8, 8, 8]},
                 			"faces": {
                 				"north": {"uv": [8, 12, 11, 14], "texture": "#1"},
                 				"east": {"uv": [0, 0, 0, 2], "texture": "#1"},
                 				"south": {"uv": [8, 12, 11, 14], "texture": "#1"},
                 				"west": {"uv": [0, 0, 0, 2], "texture": "#1"},
                 				"up": {"uv": [0, 0, 3, 0], "texture": "#1"},
                 				"down": {"uv": [0, 0, 3, 0], "texture": "#1"}
                 			}
                 		},
                 		{
                 			"name": "chain",
                 			"from": [6.5, 13, 8],
                 			"to": [9.5, 15, 8],
                 			"rotation": {"angle": -45, "axis": "y", "origin": [8, 8, 8]},
                 			"faces": {
                 				"north": {"uv": [8, 12, 11, 14], "texture": "#1"},
                 				"east": {"uv": [0, 0, 0, 2], "texture": "#1"},
                 				"south": {"uv": [8, 12, 11, 14], "texture": "#1"},
                 				"west": {"uv": [0, 0, 0, 2], "texture": "#1"},
                 				"up": {"uv": [0, 0, 3, 0], "texture": "#1"},
                 				"down": {"uv": [0, 0, 3, 0], "texture": "#1"}
                 			}
                 		}
                 	],
                 	"groups": [
                 		{
                 			"name": "lantern",
                 			"origin": [8, 8, 8],
                 			"children": [0, 1, 2, 3]
                 		}
                 	]
                 }
                """;
    }
}
