/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_TreeFungus extends WNBlockModel {
    /**
     * Required: texture
     */
    public WNBlockModel_TreeFungus(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                 	"textures": {
                 		"0": "%texture%",
                 		"1": "%texture%_left",
                 		"2": "%texture%_right",
                 		"particle": "%texture%"
                 	},
                 	"elements": [
                 		{
                 			"from": [8, 0, 0],
                 			"to": [8, 16, 16],
                 			"faces": {
                 				"east": {"uv": [0, 0, 16, 16], "texture": "#1"},
                 				"west": {"uv": [0, 0, 16, 16], "texture": "#2"}
                 			}
                 		},
                 		{
                 			"from": [0, 9, 0],
                 			"to": [16, 9, 16],
                 			"faces": {
                 				"north": {"uv": [0, 0, 16, 0], "texture": "#0"},
                 				"east": {"uv": [0, 0, 16, 0], "texture": "#0"},
                 				"south": {"uv": [0, 0, 16, 0], "texture": "#0"},
                 				"west": {"uv": [0, 0, 16, 0], "texture": "#0"},
                 				"up": {"uv": [0, 0, 16, 16], "rotation": 90, "texture": "#0"},
                 				"down": {"uv": [0, 0, 16, 16], "rotation": 270, "texture": "#0"}
                 			}
                 		}
                 	]
                 }
                """;
    }
}
