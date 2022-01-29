/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.templates;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_BenchSingle extends WNBlockModel {
    public WNTBlockModel_BenchSingle() {
        super("bench_single");
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
                     			"from": [13, 2, 3],
                     			"to": [15, 8, 13],
                     			"faces": {
                     				"north": {"uv": [3, 7, 5, 14], "texture": "#material"},
                     				"east": {"uv": [3, 8, 13, 14], "texture": "#material"},
                     				"south": {"uv": [9, 6, 11, 13], "texture": "#material"},
                     				"west": {"uv": [3, 7, 13, 14], "texture": "#material"},
                     				"down": {"uv": [0, 0, 4, 10], "texture": "#material"}
                     			}
                     		},
                     		{
                     			"from": [13, 0, 10],
                     			"to": [15, 2, 14],
                     			"faces": {
                     				"north": {"uv": [3, 14, 7, 16], "texture": "#material"},
                     				"east": {"uv": [2, 14, 6, 16], "texture": "#material"},
                     				"south": {"uv": [9, 14, 11, 16], "texture": "#material"},
                     				"west": {"uv": [10, 14, 14, 16], "texture": "#material"},
                     				"up": {"uv": [9, 10, 13, 14], "texture": "#material"},
                     				"down": {"uv": [0, 0, 4, 4], "texture": "#material"}
                     			}
                     		},
                     		{
                     			"from": [1, 2, 3],
                     			"to": [3, 8, 13],
                     			"faces": {
                     				"north": {"uv": [3, 7, 7, 14], "texture": "#material"},
                     				"east": {"uv": [3, 7, 13, 14], "texture": "#material"},
                     				"south": {"uv": [9, 6, 13, 13], "texture": "#material"},
                     				"west": {"uv": [3, 8, 13, 14], "texture": "#material"},
                     				"down": {"uv": [0, 0, 4, 10], "texture": "#material"}
                     			}
                     		},
                     		{
                     			"from": [1, 0, 2],
                     			"to": [3, 2, 6],
                     			"faces": {
                     				"north": {"uv": [3, 14, 5, 16], "texture": "#material"},
                     				"east": {"uv": [10, 14, 14, 16], "texture": "#material"},
                     				"south": {"uv": [9, 14, 13, 16], "texture": "#material"},
                     				"west": {"uv": [2, 14, 6, 16], "texture": "#material"},
                     				"up": {"uv": [3, 10, 7, 14], "rotation": 180, "texture": "#material"},
                     				"down": {"uv": [0, 0, 4, 4], "texture": "#material"}
                     			}
                     		},
                     		{
                     			"from": [1, 0, 10],
                     			"to": [3, 2, 14],
                     			"faces": {
                     				"north": {"uv": [3, 14, 7, 16], "texture": "#material"},
                     				"east": {"uv": [2, 14, 6, 16], "texture": "#material"},
                     				"south": {"uv": [9, 14, 11, 16], "texture": "#material"},
                     				"west": {"uv": [10, 14, 14, 16], "texture": "#material"},
                     				"up": {"uv": [9, 10, 13, 14], "texture": "#material"},
                     				"down": {"uv": [0, 0, 4, 4], "texture": "#material"}
                     			}
                     		},
                     		{
                     			"from": [13, 0, 2],
                     			"to": [15, 2, 6],
                     			"faces": {
                     				"north": {"uv": [3, 14, 7, 16], "texture": "#material"},
                     				"east": {"uv": [10, 14, 14, 16], "texture": "#material"},
                     				"south": {"uv": [9, 14, 13, 16], "texture": "#material"},
                     				"west": {"uv": [10, 14, 14, 16], "texture": "#material"},
                     				"up": {"uv": [3, 10, 7, 14], "rotation": 180, "texture": "#material"},
                     				"down": {"uv": [0, 0, 4, 4], "texture": "#material"}
                     			}
                     		},
                     		{
                     			"from": [0, 2.5, 7],
                     			"to": [16, 4.5, 9],
                     			"faces": {
                     				"north": {"uv": [0, 0, 2, 16], "rotation": 90, "texture": "#material2"},
                     				"east": {"uv": [0, 0, 2, 2], "texture": "#material2"},
                     				"south": {"uv": [0, 0, 2, 16], "rotation": 90, "texture": "#material2"},
                     				"west": {"uv": [0, 0, 2, 2], "texture": "#material2"},
                     				"up": {"uv": [0, 0, 2, 16], "rotation": 90, "texture": "#material2"},
                     				"down": {"uv": [0, 0, 2, 16], "rotation": 90, "texture": "#material2"}
                     			}
                     		}
                     	],
                       	"display": {
                       		"thirdperson_righthand": {
                       			"rotation": [40, 0, 0],
                       			"translation": [0, 1, -1],
                       			"scale": [0.3, 0.3, 0.3]
                       		},
                       		"thirdperson_lefthand": {
                       			"rotation": [40, 0, 0],
                       			"translation": [0, 1, -1],
                       			"scale": [0.3, 0.3, 0.3]
                       		},
                       		"firstperson_righthand": {
                       			"translation": [0, -1.25, 0],
                       			"scale": [0.45, 0.45, 0.45]
                       		},
                       		"firstperson_lefthand": {
                       			"translation": [0, -1.25, 0],
                       			"scale": [0.45, 0.45, 0.45]
                       		},
                       		"ground": {
                       			"scale": [0.3, 0.3, 0.3]
                       		},
                       		"gui": {
                       			"rotation": [20, 40, 0],
                       			"scale": [0.6, 0.6, 0.6]
                       		},
                       		"head": {
                       			"translation": [0, 6.25, 0]
                       		},
                       		"fixed": {
                       			"scale": [0.5, 0.5, 0.5]
                       		}
                       	}
                     }
                """;
    }
}
