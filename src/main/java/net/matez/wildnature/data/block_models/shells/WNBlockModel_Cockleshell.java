/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.shells;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Cockleshell extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_Cockleshell(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                 	"textures": {
                 		"0": "%texture%",
                 		"particle": "%texture%"
                 	},
                 	"elements": [
                 		{
                 			"name": "cockleshell",
                 			"from": [4, 0, 13],
                 			"to": [7, 1, 14],
                 			"faces": {
                 				"north": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"east": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"south": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"west": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"up": {"uv": [4, 13, 7, 14], "texture": "#0"},
                 				"down": {"uv": [0, 0, 3, 1], "texture": "#0"}
                 			}
                 		},
                 		{
                 			"name": "cockleshell",
                 			"from": [7, 0, 3],
                 			"to": [9, 1, 4],
                 			"faces": {
                 				"north": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"east": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"south": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"west": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"up": {"uv": [7, 3, 9, 4], "texture": "#0"},
                 				"down": {"uv": [0, 0, 2, 1], "texture": "#0"}
                 			}
                 		},
                 		{
                 			"name": "cockleshell",
                 			"from": [3, 0, 10],
                 			"to": [10, 1, 13],
                 			"faces": {
                 				"north": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"east": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"south": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"west": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"up": {"uv": [3, 10, 10, 13], "texture": "#0"},
                 				"down": {"uv": [0, 0, 7, 3], "texture": "#0"}
                 			}
                 		},
                 		{
                 			"name": "cockleshell",
                 			"from": [4, 0, 7],
                 			"to": [12, 1, 10],
                 			"faces": {
                 				"north": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"east": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"south": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"west": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"up": {"uv": [4, 7, 12, 10], "texture": "#0"},
                 				"down": {"uv": [0, 0, 8, 3], "texture": "#0"}
                 			}
                 		},
                 		{
                 			"name": "cockleshell",
                 			"from": [5, 0, 5],
                 			"to": [12, 1, 7],
                 			"faces": {
                 				"north": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"east": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"south": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"west": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"up": {"uv": [5, 5, 12, 7], "texture": "#0"},
                 				"down": {"uv": [0, 0, 7, 2], "texture": "#0"}
                 			}
                 		},
                 		{
                 			"name": "cockleshell",
                 			"from": [6, 0, 4],
                 			"to": [11, 1, 5],
                 			"faces": {
                 				"north": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"east": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"south": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"west": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"up": {"uv": [6, 4, 11, 5], "texture": "#0"},
                 				"down": {"uv": [0, 0, 5, 1], "texture": "#0"}
                 			}
                 		},
                 		{
                 			"name": "cockleshell",
                 			"from": [10, 0, 10],
                 			"to": [12, 1, 12],
                 			"faces": {
                 				"north": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"east": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"south": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"west": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"up": {"uv": [10, 10, 12, 12], "texture": "#0"},
                 				"down": {"uv": [0, 0, 2, 2], "texture": "#0"}
                 			}
                 		},
                 		{
                 			"name": "cockleshell",
                 			"from": [12, 0, 6],
                 			"to": [13, 1, 11],
                 			"faces": {
                 				"north": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"east": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"south": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"west": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"up": {"uv": [12, 6, 13, 11], "texture": "#0"},
                 				"down": {"uv": [0, 0, 1, 5], "texture": "#0"}
                 			}
                 		},
                 		{
                 			"name": "cockleshell",
                 			"from": [13, 0, 8],
                 			"to": [14, 1, 10],
                 			"faces": {
                 				"north": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"east": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"south": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"west": {"uv": [7, 3, 8, 4], "texture": "#0"},
                 				"up": {"uv": [13, 8, 14, 10], "texture": "#0"},
                 				"down": {"uv": [0, 0, 1, 2], "texture": "#0"}
                 			}
                 		}
                 	]
                 }
                """;
    }
}
