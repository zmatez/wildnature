/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_ParrotsFeatherPlant extends WNBlockModel {
    /**
     * Required: texture
     */
    public WNBlockModel_ParrotsFeatherPlant(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                 	"textures": {
                 		"0": "%texture%_leaves",
                 		"1": "%texture%",
                 		"particle": "%texture%_leaves"
                 	},
                 	"elements": [
                 		{
                 			"from": [0, 2.025, 0.5],
                 			"to": [16, 2.025, 16.5],
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
                 			"from": [0, 3.025, 0.5],
                 			"to": [16, 3.025, 16.5],
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
                 			"from": [0, 4.025, 0.5],
                 			"to": [16, 4.025, 16.5],
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
                 			"from": [0, -9, 8],
                 			"to": [16, 7, 8],
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
                 			"from": [7.5, -9, 0.5],
                 			"to": [7.5, 7, 16.5],
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
