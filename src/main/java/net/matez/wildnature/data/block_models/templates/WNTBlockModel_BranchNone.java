package net.matez.wildnature.data.block_models.templates;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_BranchNone extends WNBlockModel {
    public WNTBlockModel_BranchNone() {
        super("branch_none");
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
                 			"from": [4, 4, 4],
                 			"to": [12, 12, 12],
                 			"faces": {
                 				"north": {"uv": [4, 4, 12, 12], "texture": "#log"},
                 				"east": {"uv": [4, 4, 12, 12], "texture": "#log"},
                 				"south": {"uv": [4, 4, 12, 12], "texture": "#log"},
                 				"west": {"uv": [4, 4, 12, 12], "texture": "#log"},
                 				"up": {"uv": [4, 4, 12, 12], "texture": "#log"},
                 				"down": {"uv": [4, 4, 12, 12], "texture": "#log"}
                 			}
                 		}
                 	]
                 }
                """;
    }
}
