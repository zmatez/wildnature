/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.shells;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_LionsPawShell extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_LionsPawShell(String name) {
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
                   			"name": "shell",
                   			"from": [6, 0, 6],
                   			"to": [12, 1, 12],
                   			"faces": {
                   				"north": {"uv": [4, 9, 10, 10], "texture": "#0"},
                   				"east": {"uv": [4, 4, 10, 5], "texture": "#0"},
                   				"south": {"uv": [4, 4, 10, 5], "texture": "#0"},
                   				"west": {"uv": [4, 4, 10, 5], "texture": "#0"},
                   				"up": {"uv": [4, 4, 10, 10], "texture": "#0"},
                   				"down": {"uv": [0, 0, 6, 6], "texture": "#0"}
                   			}
                   		},
                   		{
                   			"name": "shell",
                   			"from": [12, 0, 7],
                   			"to": [13, 1, 10],
                   			"faces": {
                   				"north": {"uv": [6, 3, 7, 4], "texture": "#0"},
                   				"east": {"uv": [6, 3, 9, 4], "texture": "#0"},
                   				"south": {"uv": [6, 3, 7, 4], "texture": "#0"},
                   				"west": {"uv": [6, 3, 9, 4], "texture": "#0"},
                   				"up": {"uv": [3, 6, 4, 9], "texture": "#0"},
                   				"down": {"uv": [0, 0, 1, 3], "texture": "#0"}
                   			}
                   		},
                   		{
                   			"name": "shell",
                   			"from": [5, 0, 8],
                   			"to": [6, 1, 10],
                   			"faces": {
                   				"north": {"uv": [9, 5, 10, 6], "texture": "#0"},
                   				"east": {"uv": [9, 6, 11, 7], "texture": "#0"},
                   				"south": {"uv": [6, 3, 7, 4], "texture": "#0"},
                   				"west": {"uv": [8, 6, 10, 7], "texture": "#0"},
                   				"up": {"uv": [10, 6, 11, 8], "texture": "#0"},
                   				"down": {"uv": [0, 0, 1, 2], "texture": "#0"}
                   			}
                   		},
                   		{
                   			"name": "shell",
                   			"from": [8, 0, 5],
                   			"to": [10, 1, 6],
                   			"faces": {
                   				"north": {"uv": [6, 10, 8, 11], "texture": "#0"},
                   				"east": {"uv": [7, 10, 8, 11], "texture": "#0"},
                   				"south": {"uv": [6, 10, 8, 11], "texture": "#0"},
                   				"west": {"uv": [6, 10, 7, 11], "texture": "#0"},
                   				"up": {"uv": [6, 10, 8, 11], "texture": "#0"},
                   				"down": {"uv": [0, 0, 2, 1], "texture": "#0"}
                   			}
                   		},
                   		{
                   			"name": "shell",
                   			"from": [7, 0, 12],
                   			"to": [10, 1, 13],
                   			"faces": {
                   				"north": {"uv": [6, 3, 9, 4], "texture": "#0"},
                   				"east": {"uv": [6, 3, 7, 4], "texture": "#0"},
                   				"south": {"uv": [6, 3, 9, 4], "texture": "#0"},
                   				"west": {"uv": [6, 3, 7, 4], "texture": "#0"},
                   				"up": {"uv": [6, 3, 9, 4], "texture": "#0"},
                   				"down": {"uv": [0, 0, 3, 1], "texture": "#0"}
                   			}
                   		},
                   		{
                   			"name": "shell",
                   			"from": [6, 0, 5],
                   			"to": [7, 1, 6],
                   			"faces": {
                   				"north": {"uv": [9, 9, 10, 10], "texture": "#0"},
                   				"east": {"uv": [9, 10, 10, 11], "texture": "#0"},
                   				"south": {"uv": [10, 9, 11, 10], "texture": "#0"},
                   				"west": {"uv": [9, 10, 10, 11], "texture": "#0"},
                   				"up": {"uv": [9, 10, 10, 11], "texture": "#0"},
                   				"down": {"uv": [0, 0, 1, 1], "texture": "#0"}
                   			}
                   		},
                   		{
                   			"name": "shell",
                   			"from": [5, 0, 6],
                   			"to": [6, 1, 7],
                   			"faces": {
                   				"north": {"uv": [9, 9, 10, 10], "texture": "#0"},
                   				"east": {"uv": [9, 9, 10, 10], "texture": "#0"},
                   				"south": {"uv": [9, 9, 10, 10], "texture": "#0"},
                   				"west": {"uv": [9, 9, 10, 10], "texture": "#0"},
                   				"up": {"uv": [10, 9, 11, 10], "texture": "#0"},
                   				"down": {"uv": [0, 0, 1, 1], "texture": "#0"}
                   			}
                   		}
                   	]
                   }
                """;
    }
}
