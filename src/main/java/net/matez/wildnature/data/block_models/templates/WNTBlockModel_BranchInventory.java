package net.matez.wildnature.data.block_models.templates;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_BranchInventory extends WNBlockModel {
    public WNTBlockModel_BranchInventory() {
        super("branch_inventory");
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
                  			"name": "Cube",
                  			"from": [4, 0, 4],
                  			"to": [12, 16, 12],
                  			"faces": {
                  				"north": {"uv": [4, 0, 12, 16], "texture": "#log"},
                  				"east": {"uv": [4, 0, 12, 16], "texture": "#log"},
                  				"south": {"uv": [4, 0, 12, 16], "texture": "#log"},
                  				"west": {"uv": [4, 0, 12, 16], "texture": "#log"},
                  				"up": {"uv": [4, 4, 12, 12], "texture": "#inside"},
                  				"down": {"uv": [4, 4, 12, 12], "texture": "#inside"}
                  			}
                  		}
                  	],
                  	"display": {
                  		"thirdperson_righthand": {
                  			"rotation": [50, 0, 0],
                  			"translation": [0, 1, 0],
                  			"scale": [0.375, 0.375, 0.375]
                  		},
                  		"thirdperson_lefthand": {
                  			"rotation": [50, 0, 0],
                  			"translation": [0, 1, 0],
                  			"scale": [0.375, 0.375, 0.375]
                  		},
                  		"firstperson_righthand": {
                  			"translation": [0, 0.5, 0],
                  			"scale": [0.4, 0.4, 0.4]
                  		},
                  		"firstperson_lefthand": {
                  			"translation": [0, 0.5, 0],
                  			"scale": [0.4, 0.4, 0.4]
                  		},
                  		"ground": {
                  			"scale": [0.4, 0.4, 0.4]
                  		},
                  		"gui": {
                  			"rotation": [30, 45, 0],
                  			"scale": [0.625, 0.625, 0.625]
                  		},
                  		"head": {
                  			"rotation": [0, 180, 0]
                  		},
                  		"fixed": {
                  			"rotation": [0, 180, 0]
                  		}
                  	}
                  }
                """;
    }
}
