/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.templates;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_CrossLilypad extends WNBlockModel {
    public WNTBlockModel_CrossLilypad() {
        super("cross_lilypad");
    }

    @Override
    public String getJSON() {
        return """
                {
                    	"ambientocclusion": false,
                    	"textures": {
                    		"particle": "#cross"
                    	},
                    	"elements": [
                    		{
                    			"from": [0.8, 0.25, 8],
                    			"to": [15.2, 16.25, 8],
                    			"shade": false,
                    			"rotation": {"angle": 45, "axis": "y", "origin": [8, 8, 8], "rescale": true},
                    			"faces": {
                    				"north": {"uv": [0, 0, 16, 16], "texture": "#cross"},
                    				"south": {"uv": [0, 0, 16, 16], "texture": "#cross"}
                    			}
                    		},
                    		{
                    			"from": [8, 0.25, 0.8],
                    			"to": [8, 16.25, 15.2],
                    			"shade": false,
                    			"rotation": {"angle": 45, "axis": "y", "origin": [8, 8, 8], "rescale": true},
                    			"faces": {
                    				"east": {"uv": [0, 0, 16, 16], "texture": "#cross"},
                    				"west": {"uv": [0, 0, 16, 16], "texture": "#cross"}
                    			}
                    		},
                    		{
                    			"from": [0, 0.25, 0],
                    			"to": [16, 0.25, 16],
                    			"color": 5,
                    			"faces": {
                    				"north": {"uv": [0, 0, 16, 0], "texture": "#pad", "tintindex": 0},
                    				"east": {"uv": [0, 0, 16, 0], "texture": "#pad", "tintindex": 0},
                    				"south": {"uv": [0, 0, 16, 0], "texture": "#pad", "tintindex": 0},
                    				"west": {"uv": [0, 0, 16, 0], "texture": "#pad", "tintindex": 0},
                    				"up": {"uv": [0, 0, 16, 16], "texture": "#pad", "tintindex": 0},
                    				"down": {"uv": [0, 0, 16, 16], "texture": "#pad", "tintindex": 0}
                    			}
                    		}
                    	]
                    }
                """;
    }
}
