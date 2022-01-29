/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.templates;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_BenchSide extends WNBlockModel {
    public WNTBlockModel_BenchSide() {
        super("bench_side");
    }

    @Override
    public String getJSON() {
        return """
                {
                   	"textures": {
                   		"particle": "#material"
                   	},
                   	"elements": [
                   		{
                   			"from": [0, 8, 0],
                   			"to": [16, 11, 16],
                   			"faces": {
                   				"north": {"uv": [0, 0, 3, 16], "rotation": 90, "texture": "#material"},
                   				"east": {"uv": [0, 0, 16, 3], "rotation": 180, "texture": "#material"},
                   				"south": {"uv": [0, 0, 3, 16], "rotation": 90, "texture": "#material"},
                   				"west": {"uv": [0, 0, 16, 3], "texture": "#material"},
                   				"up": {"uv": [0, 0, 16, 16], "rotation": 90, "texture": "#material"},
                   				"down": {"uv": [0, 0, 16, 16], "rotation": 90, "texture": "#material"}
                   			}
                   		},
                   		{
                   			"from": [10, 2, 3],
                   			"to": [13, 8, 13],
                   			"faces": {
                   				"north": {"uv": [3, 7, 6, 13], "texture": "#material"},
                   				"east": {"uv": [3, 7, 13, 14], "texture": "#material"},
                   				"south": {"uv": [9, 6, 12, 12], "texture": "#material"},
                   				"west": {"uv": [3, 7, 13, 13], "texture": "#material"},
                   				"down": {"uv": [0, 0, 4, 10], "texture": "#material"}
                   			}
                   		},
                   		{
                   			"from": [10, 0, 10],
                   			"to": [13, 2, 14],
                   			"faces": {
                   				"north": {"uv": [3, 14, 7, 16], "texture": "#material"},
                   				"east": {"uv": [2, 14, 6, 16], "texture": "#material"},
                   				"south": {"uv": [9, 14, 12, 16], "texture": "#material"},
                   				"west": {"uv": [10, 14, 14, 16], "texture": "#material"},
                   				"up": {"uv": [9, 10, 12, 14], "texture": "#material"},
                   				"down": {"uv": [0, 0, 4, 4], "texture": "#material"}
                   			}
                   		},
                   		{
                   			"from": [10, 0, 2],
                   			"to": [13, 2, 6],
                   			"faces": {
                   				"north": {"uv": [3, 14, 6, 16], "texture": "#material"},
                   				"east": {"uv": [10, 14, 14, 16], "texture": "#material"},
                   				"south": {"uv": [10, 14, 13, 16], "texture": "#material"},
                   				"west": {"uv": [2, 14, 6, 16], "texture": "#material"},
                   				"up": {"uv": [3, 10, 6, 14], "rotation": 180, "texture": "#material"},
                   				"down": {"uv": [0, 0, 4, 4], "texture": "#material"}
                   			}
                   		},
                   		{
                   			"from": [0, 2.8, 7],
                   			"to": [15, 4.8, 9],
                   			"faces": {
                   				"north": {"uv": [1, 1, 3, 16], "rotation": 90, "texture": "#material2"},
                   				"east": {"uv": [0, 0, 2, 2], "texture": "#material2"},
                   				"south": {"uv": [1, 1, 3, 16], "rotation": 90, "texture": "#material2"},
                   				"west": {"uv": [0, 0, 2, 2], "texture": "#material2"},
                   				"up": {"uv": [1, 1, 3, 16], "rotation": 90, "texture": "#material2"},
                   				"down": {"uv": [1, 1, 3, 16], "rotation": 90, "texture": "#material2"}
                   			}
                   		}
                   	],
                   	"display": {
                   		"thirdperson_righthand": {
                   			"scale": [0.35, 0.35, 0.35]
                   		},
                   		"thirdperson_lefthand": {
                   			"scale": [0.35, 0.35, 0.35]
                   		},
                   		"firstperson_righthand": {
                   			"translation": [3.5, 1.25, 0],
                   			"scale": [0.35, 0.35, 0.35]
                   		},
                   		"firstperson_lefthand": {
                   			"translation": [3.5, 1.25, 0],
                   			"scale": [0.35, 0.35, 0.35]
                   		},
                   		"ground": {
                   			"scale": [0.35, 0.35, 0.35]
                   		},
                   		"gui": {
                   			"rotation": [30, -130, 0],
                   			"translation": [0, -0.75, 0],
                   			"scale": [0.6, 0.6, 0.6]
                   		},
                   		"fixed": {
                   			"scale": [0.5, 0.5, 0.5]
                   		}
                   	}
                   }
                """;
    }
}
