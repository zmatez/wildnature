/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.templates;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_Chair extends WNBlockModel {
    public WNTBlockModel_Chair() {
        super("chair");
    }

    @Override
    public String getJSON() {
        return """
                {
                    	"textures": {
                    		"particle": "#log"
                    	},
                    	"elements": [
                    		{
                    			"from": [13, 0, 12],
                    			"to": [14, 16, 14],
                    			"faces": {
                    				"north": {"uv": [0, 0, 1, 16], "texture": "#log"},
                    				"east": {"uv": [0, 0, 2, 16], "texture": "#log"},
                    				"south": {"uv": [0, 0, 1, 16], "texture": "#log"},
                    				"west": {"uv": [0, 0, 2, 16], "texture": "#log"},
                    				"down": {"uv": [0, 6, 1, 8], "rotation": 180, "texture": "#log"}
                    			}
                    		},
                    		{
                    			"from": [13, 0, 2],
                    			"to": [14, 10, 4],
                    			"faces": {
                    				"north": {"uv": [1, 0, 2, 7], "texture": "#log"},
                    				"east": {"uv": [0, 0, 2, 7], "texture": "#log"},
                    				"south": {"uv": [1, 0, 2, 7], "texture": "#log"},
                    				"west": {"uv": [2, 0, 4, 7], "texture": "#log"},
                    				"up": {"uv": [0, 6, 1, 8], "rotation": 180, "texture": "#log"},
                    				"down": {"uv": [0, 6, 1, 8], "rotation": 180, "texture": "#log"}
                    			}
                    		},
                    		{
                    			"from": [13, 8, 4],
                    			"to": [14, 10, 12],
                    			"faces": {
                    				"east": {"uv": [0, 0, 2, 8], "rotation": 90, "texture": "#log"},
                    				"west": {"uv": [0, 0, 2, 8], "rotation": 90, "texture": "#log"},
                    				"up": {"uv": [0, 0, 1, 8], "rotation": 180, "texture": "#log"},
                    				"down": {"uv": [0, 0, 1, 8], "rotation": 180, "texture": "#log"}
                    			}
                    		},
                    		{
                    			"from": [2, 8, 4],
                    			"to": [3, 10, 12],
                    			"faces": {
                    				"east": {"uv": [0, 0, 2, 8], "rotation": 90, "texture": "#log"},
                    				"west": {"uv": [0, 0, 2, 8], "rotation": 90, "texture": "#log"},
                    				"up": {"uv": [0, 0, 1, 8], "rotation": 180, "texture": "#log"},
                    				"down": {"uv": [0, 0, 1, 8], "rotation": 180, "texture": "#log"}
                    			}
                    		},
                    		{
                    			"from": [2, 0, 12],
                    			"to": [3, 16, 14],
                    			"faces": {
                    				"north": {"uv": [0, 0, 1, 16], "texture": "#log"},
                    				"east": {"uv": [0, 0, 2, 16], "texture": "#log"},
                    				"south": {"uv": [0, 0, 1, 16], "texture": "#log"},
                    				"west": {"uv": [0, 0, 2, 16], "texture": "#log"},
                    				"down": {"uv": [0, 6, 1, 8], "rotation": 180, "texture": "#log"}
                    			}
                    		},
                    		{
                    			"from": [2, 16, 12],
                    			"to": [3, 22, 14],
                    			"faces": {
                    				"north": {"uv": [0, 10, 1, 16], "texture": "#log"},
                    				"east": {"uv": [0, 10, 2, 16], "texture": "#log"},
                    				"south": {"uv": [0, 10, 1, 16], "texture": "#log"},
                    				"west": {"uv": [0, 10, 2, 16], "texture": "#log"},
                    				"up": {"uv": [0, 0, 1, 2], "rotation": 180, "texture": "#log"}
                    			}
                    		},
                    		{
                    			"from": [13, 16, 12],
                    			"to": [14, 22, 14],
                    			"faces": {
                    				"north": {"uv": [0, 10, 1, 16], "texture": "#log"},
                    				"east": {"uv": [0, 10, 2, 16], "texture": "#log"},
                    				"south": {"uv": [0, 10, 1, 16], "texture": "#log"},
                    				"west": {"uv": [0, 10, 2, 16], "texture": "#log"},
                    				"up": {"uv": [0, 0, 1, 2], "rotation": 180, "texture": "#log"}
                    			}
                    		},
                    		{
                    			"from": [2, 0, 2],
                    			"to": [3, 10, 4],
                    			"faces": {
                    				"north": {"uv": [1, 0, 2, 7], "texture": "#log"},
                    				"east": {"uv": [0, 0, 2, 7], "texture": "#log"},
                    				"south": {"uv": [1, 0, 2, 7], "texture": "#log"},
                    				"west": {"uv": [2, 0, 4, 7], "texture": "#log"},
                    				"up": {"uv": [0, 6, 1, 8], "rotation": 180, "texture": "#log"},
                    				"down": {"uv": [0, 6, 1, 8], "rotation": 180, "texture": "#log"}
                    			}
                    		},
                    		{
                    			"from": [3, 8, 2],
                    			"to": [13, 10, 3],
                    			"faces": {
                    				"north": {"uv": [1, 0, 3, 10], "rotation": 90, "texture": "#log"},
                    				"south": {"uv": [1, 0, 3, 10], "rotation": 90, "texture": "#log"},
                    				"up": {"uv": [1, 0, 2, 10], "rotation": 90, "texture": "#log"},
                    				"down": {"uv": [1, 0, 2, 10], "rotation": 90, "texture": "#log"}
                    			}
                    		},
                    		{
                    			"from": [3, 8, 13],
                    			"to": [13, 10, 14],
                    			"faces": {
                    				"north": {"uv": [1, 0, 3, 10], "rotation": 90, "texture": "#log"},
                    				"south": {"uv": [1, 0, 3, 10], "rotation": 90, "texture": "#log"},
                    				"up": {"uv": [1, 0, 2, 10], "rotation": 90, "texture": "#log"},
                    				"down": {"uv": [1, 0, 2, 10], "rotation": 90, "texture": "#log"}
                    			}
                    		},
                    		{
                    			"from": [3, 8, 3],
                    			"to": [13, 9.5, 13],
                    			"faces": {
                    				"up": {"uv": [3, 3, 13, 13], "rotation": 180, "texture": "#planks"},
                    				"down": {"uv": [3, 3, 13, 13], "rotation": 180, "texture": "#planks"}
                    			}
                    		},
                    		{
                    			"from": [3, 12.5, 12.5],
                    			"to": [13, 20.5, 13.5],
                    			"faces": {
                    				"north": {"uv": [2, 2, 13, 13], "rotation": 90, "texture": "#planks"},
                    				"south": {"uv": [2, 2, 13, 13], "rotation": 90, "texture": "#planks"},
                    				"up": {"uv": [11.8, 2, 12.8, 13], "rotation": 90, "texture": "#planks"},
                    				"down": {"uv": [1.8, 2, 2.8, 13], "rotation": 90, "texture": "#planks"}
                    			}
                    		}
                    	],
                        	"display": {
                        		"thirdperson_righthand": {
                        			"rotation": [0, 90, 90],
                        			"translation": [1, 0, 0],
                        			"scale": [0.35, 0.35, 0.35]
                        		},
                        		"thirdperson_lefthand": {
                        			"rotation": [0, 90, 90],
                        			"translation": [1, 0, 0],
                        			"scale": [0.35, 0.35, 0.35]
                        		},
                        		"firstperson_righthand": {
                        			"rotation": [0, 90, 0],
                        			"scale": [0.35, 0.35, 0.35]
                        		},
                        		"firstperson_lefthand": {
                        			"rotation": [0, 90, 0],
                        			"scale": [0.35, 0.35, 0.35]
                        		},
                        		"ground": {
                        			"scale": [0.35, 0.35, 0.35]
                        		},
                        		"gui": {
                        			"rotation": [20, -141, 0],
                        			"translation": [0, -1.25, 0],
                        			"scale": [0.55, 0.55, 0.55]
                        		},
                        		"head": {
                        			"translation": [0, 14, 0]
                        		},
                        		"fixed": {
                        			"rotation": [0, 90, 0],
                        			"translation": [0, -1, 2.5],
                        			"scale": [0.5, 0.5, 0.5]
                        		}
                        	}
                    }
                """;
    }
}
