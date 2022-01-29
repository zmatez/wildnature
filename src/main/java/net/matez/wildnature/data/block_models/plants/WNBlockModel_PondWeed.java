/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_PondWeed extends WNBlockModel {
    /**
     * Required: texture
     */
    public WNBlockModel_PondWeed(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                  	"textures": {
                  		"0": "%texture%_leaves",
                  		"1": "%texture%_roots",
                  		"particle": "%texture%_leaves"
                  	},
                  	"elements": [
                  		{
                  			"from": [0, 0.025, 0],
                  			"to": [16, 0.025, 16],
                  			"faces": {
                  				"north": {"uv": [0, 0, 16, 0], "texture": "#0"},
                  				"east": {"uv": [0, 0, 16, 0], "texture": "#0"},
                  				"south": {"uv": [0, 0, 16, 0], "texture": "#0"},
                  				"west": {"uv": [0, 0, 16, 0], "texture": "#0"},
                  				"up": {"uv": [0, 0, 16, 16], "texture": "#0"},
                  				"down": {"uv": [0, 0, 16, 16], "texture": "#0"}
                  			}
                  		},
                  		{
                  			"from": [0, -12, 8],
                  			"to": [16, 4, 8],
                  			"faces": {
                  				"north": {"uv": [0, 0, 16, 16], "texture": "#1"},
                  				"east": {"uv": [0, 0, 0, 16], "texture": "#1"},
                  				"south": {"uv": [0, 0, 16, 16], "texture": "#1"},
                  				"west": {"uv": [0, 0, 0, 16], "texture": "#1"},
                  				"up": {"uv": [0, 0, 16, 0], "texture": "#1"},
                  				"down": {"uv": [0, 0, 16, 0], "texture": "#1"}
                  			}
                  		},
                  		{
                  			"from": [8, -12, 0],
                  			"to": [8, 4, 16],
                  			"faces": {
                  				"north": {"uv": [0, 0, 0, 16], "texture": "#1"},
                  				"east": {"uv": [0, 0, 16, 16], "texture": "#1"},
                  				"south": {"uv": [0, 0, 0, 16], "texture": "#1"},
                  				"west": {"uv": [0, 0, 16, 16], "texture": "#1"},
                  				"up": {"uv": [0, 0, 0, 16], "texture": "#1"},
                  				"down": {"uv": [0, 0, 0, 16], "texture": "#1"}
                  			}
                  		}
                  	]
                  }
                """;
    }
}
