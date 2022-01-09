package net.matez.wildnature.data.block_models.templates;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_BranchSide extends WNBlockModel {
    public WNTBlockModel_BranchSide() {
        super("branch_side");
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
                 			"from": [4, 4, 0],
                 			"to": [12, 12, 4],
                 			"faces": {
                 				"north": {"uv": [4, 4, 12, 12], "texture": "#inside"},
                 				"east": {"uv": [4, 4, 8, 12], "texture": "#log"},
                 				"west": {"uv": [4, 4, 8, 12], "texture": "#log"},
                 				"up": {"uv": [4, 4, 12, 8], "texture": "#log"},
                 				"down": {"uv": [4, 4, 12, 8], "texture": "#log"}
                 			}
                 		}
                 	]
                 }
                """;
    }
}
