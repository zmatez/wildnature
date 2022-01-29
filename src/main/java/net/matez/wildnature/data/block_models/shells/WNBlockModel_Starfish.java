/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.shells;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Starfish extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_Starfish(String name) {
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
                     			"name": "starfish",
                     			"from": [4, 0, 2],
                     			"to": [6, 1, 4],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [4, 2, 6, 4], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 1], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [6, 0, 3],
                     			"to": [7, 1, 12],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [6, 3, 7, 12], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 9], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [5, 0, 4],
                     			"to": [6, 1, 6],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [5, 4, 6, 6], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 2], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [10, 0, 3],
                     			"to": [11, 1, 6],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [10, 3, 11, 6], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 3], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [10, 0, 8],
                     			"to": [11, 1, 11],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [10, 8, 11, 11], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 3], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [4, 0, 6],
                     			"to": [5, 1, 9],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [4, 6, 5, 9], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 3], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [3, 0, 5],
                     			"to": [4, 1, 8],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [3, 5, 4, 8], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 3], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [11, 0, 10],
                     			"to": [12, 1, 12],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [11, 10, 12, 12], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 2], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [7, 0, 9],
                     			"to": [8, 1, 11],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [7, 9, 8, 11], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 2], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [5, 0, 10],
                     			"to": [6, 1, 13],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [5, 10, 6, 13], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 3], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [5, 0, 7],
                     			"to": [6, 1, 9],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [5, 7, 6, 9], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 2], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [2, 0, 5],
                     			"to": [3, 1, 7],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [2, 5, 3, 7], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 2], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [4, 0, 11],
                     			"to": [5, 1, 13],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [4, 11, 5, 13], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 2], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [11, 0, 3],
                     			"to": [12, 1, 5],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [11, 3, 12, 5], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 2], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [7, 0, 5],
                     			"to": [9, 1, 9],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [7, 5, 9, 9], "texture": "#0"},
                     				"down": {"uv": [0, 0, 2, 4], "texture": "#0"}
                     			}
                     		},
                     		{
                     			"name": "starfish",
                     			"from": [9, 0, 4],
                     			"to": [10, 1, 10],
                     			"faces": {
                     				"north": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"east": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"south": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"west": {"uv": [4, 3, 5, 4], "texture": "#0"},
                     				"up": {"uv": [9, 4, 10, 10], "texture": "#0"},
                     				"down": {"uv": [0, 0, 1, 6], "texture": "#0"}
                     			}
                     		}
                     	]
                     }
                """;
    }
}
