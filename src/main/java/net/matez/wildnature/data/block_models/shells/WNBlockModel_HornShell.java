/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.shells;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_HornShell extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_HornShell(String name) {
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
                  			"name": "hornshell",
                  			"from": [13, 0, 1],
                  			"to": [14, 1, 3],
                  			"faces": {
                  				"north": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"east": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"south": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"west": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"up": {"uv": [13, 1, 14, 3], "texture": "#0"},
                  				"down": {"uv": [0, 0, 1, 2], "texture": "#0"}
                  			}
                  		},
                  		{
                  			"name": "hornshell",
                  			"from": [12, 0, 1],
                  			"to": [13, 1, 6],
                  			"faces": {
                  				"north": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"east": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"south": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"west": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"up": {"uv": [12, 1, 13, 6], "texture": "#0"},
                  				"down": {"uv": [0, 0, 1, 5], "texture": "#0"}
                  			}
                  		},
                  		{
                  			"name": "hornshell",
                  			"from": [11, 0, 2],
                  			"to": [12, 1, 8],
                  			"faces": {
                  				"north": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"east": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"south": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"west": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"up": {"uv": [11, 2, 12, 8], "texture": "#0"},
                  				"down": {"uv": [0, 0, 1, 6], "texture": "#0"}
                  			}
                  		},
                  		{
                  			"name": "hornshell",
                  			"from": [10, 0, 3],
                  			"to": [11, 1, 10],
                  			"faces": {
                  				"north": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"east": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"south": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"west": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"up": {"uv": [10, 3, 11, 10], "texture": "#0"},
                  				"down": {"uv": [0, 0, 1, 7], "texture": "#0"}
                  			}
                  		},
                  		{
                  			"name": "hornshell",
                  			"from": [9, 0, 4],
                  			"to": [10, 1, 12],
                  			"faces": {
                  				"north": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"east": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"south": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"west": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"up": {"uv": [9, 4, 10, 12], "texture": "#0"},
                  				"down": {"uv": [0, 0, 1, 8], "texture": "#0"}
                  			}
                  		},
                  		{
                  			"name": "hornshell",
                  			"from": [8, 0, 5],
                  			"to": [9, 1, 13],
                  			"faces": {
                  				"north": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"east": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"south": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"west": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"up": {"uv": [8, 5, 9, 13], "texture": "#0"},
                  				"down": {"uv": [0, 0, 1, 8], "texture": "#0"}
                  			}
                  		},
                  		{
                  			"name": "hornshell",
                  			"from": [7, 0, 6],
                  			"to": [8, 1, 13],
                  			"faces": {
                  				"north": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"east": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"south": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"west": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"up": {"uv": [7, 6, 8, 13], "texture": "#0"},
                  				"down": {"uv": [0, 0, 1, 7], "texture": "#0"}
                  			}
                  		},
                  		{
                  			"name": "hornshell",
                  			"from": [6, 0, 7],
                  			"to": [7, 1, 14],
                  			"faces": {
                  				"north": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"east": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"south": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"west": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"up": {"uv": [6, 7, 7, 14], "texture": "#0"},
                  				"down": {"uv": [0, 0, 1, 7], "texture": "#0"}
                  			}
                  		},
                  		{
                  			"name": "hornshell",
                  			"from": [4, 0, 8],
                  			"to": [6, 1, 14],
                  			"faces": {
                  				"north": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"east": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"south": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"west": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"up": {"uv": [4, 8, 6, 14], "texture": "#0"},
                  				"down": {"uv": [0, 0, 2, 6], "texture": "#0"}
                  			}
                  		},
                  		{
                  			"name": "hornshell",
                  			"from": [3, 0, 10],
                  			"to": [4, 1, 13],
                  			"faces": {
                  				"north": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"east": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"south": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"west": {"uv": [12, 1, 13, 2], "texture": "#0"},
                  				"up": {"uv": [3, 10, 4, 13], "texture": "#0"},
                  				"down": {"uv": [0, 0, 1, 3], "texture": "#0"}
                  			}
                  		}
                  	]
                  }
                """;
    }
}
