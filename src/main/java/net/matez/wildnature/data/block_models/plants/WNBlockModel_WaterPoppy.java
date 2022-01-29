/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_WaterPoppy extends WNBlockModel {
    /**
     * Required: texture
     */
    public WNBlockModel_WaterPoppy(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                   	"textures": {
                   		"2": "%texture%_pad",
                   		"3": "%texture%_roots",
                   		"particle": "%texture%_pad"
                   	},
                   	"elements": [
                   		{
                   			"from": [0, 0, 0],
                   			"to": [16, 0, 16],
                   			"faces": {
                   				"north": {"uv": [0, 0, 16, 0], "texture": "#2"},
                   				"east": {"uv": [0, 0, 16, 0], "texture": "#2"},
                   				"south": {"uv": [0, 0, 16, 0], "texture": "#2"},
                   				"west": {"uv": [0, 0, 16, 0], "texture": "#2"},
                   				"up": {"uv": [0, 0, 16, 16], "texture": "#2"},
                   				"down": {"uv": [0, 0, 16, 16], "texture": "#2"}
                   			}
                   		},
                   		{
                   			"from": [8, -14, 0],
                   			"to": [8, 2, 16],
                   			"faces": {
                   				"north": {"uv": [0, 0, 0, 16], "texture": "#3"},
                   				"east": {"uv": [0, 0, 16, 16], "texture": "#3"},
                   				"south": {"uv": [0, 0, 0, 16], "texture": "#3"},
                   				"west": {"uv": [0, 0, 16, 16], "texture": "#3"},
                   				"up": {"uv": [0, 0, 0, 16], "texture": "#3"},
                   				"down": {"uv": [0, 0, 0, 16], "texture": "#3"}
                   			}
                   		}
                   	]
                   }
                """;
    }
}
