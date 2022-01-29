/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.templates;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_BenchMiddle extends WNBlockModel {
    public WNTBlockModel_BenchMiddle() {
        super("bench_middle");
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
                    			"from": [0, 2.8, 7],
                    			"to": [16, 4.8, 9],
                    			"faces": {
                    				"north": {"uv": [1, 0, 3, 16], "rotation": 90, "texture": "#material2"},
                    				"east": {"uv": [0, 0, 2, 2], "texture": "#material2"},
                    				"south": {"uv": [1, 0, 3, 16], "rotation": 90, "texture": "#material2"},
                    				"west": {"uv": [0, 0, 2, 2], "texture": "#material2"},
                    				"up": {"uv": [1, 0, 3, 16], "rotation": 90, "texture": "#material2"},
                    				"down": {"uv": [1, 0, 3, 16], "rotation": 90, "texture": "#material2"}
                    			}
                    		}
                    	],
                    	"display": {
                    		"thirdperson_righthand": {
                    			"scale": [0.5, 0.5, 0.5]
                    		},
                    		"thirdperson_lefthand": {
                    			"scale": [0.5, 0.5, 0.5]
                    		},
                    		"firstperson_righthand": {
                    			"translation": [3.5, -3.25, 0],
                    			"scale": [0.6, 0.6, 0.6]
                    		},
                    		"ground": {
                    			"translation": [0, 4.75, 0]
                    		},
                    		"gui": {
                    			"rotation": [30, -130, 0],
                    			"translation": [0, -0.75, 0],
                    			"scale": [0.7, 0.7, 0.7]
                    		}
                    	}
                    }
                """;
    }
}
