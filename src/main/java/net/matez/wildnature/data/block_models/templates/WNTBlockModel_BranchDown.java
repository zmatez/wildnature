package net.matez.wildnature.data.block_models.templates;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_BranchDown extends WNBlockModel {
    public WNTBlockModel_BranchDown() {
        super("branch_down");
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
                  			"to": [12, 4, 12],
                  			"faces": {
                  				"north": {"uv": [4, 12, 12, 16], "texture": "#log"},
                  				"east": {"uv": [4, 12, 12, 16], "texture": "#log"},
                  				"south": {"uv": [4, 12, 12, 16], "texture": "#log"},
                  				"west": {"uv": [4, 12, 12, 16], "texture": "#log"},
                  				"down": {"uv": [4, 4, 12, 12], "texture": "#inside"}
                  			}
                  		}
                  	]
                  }
                """;
    }
}
