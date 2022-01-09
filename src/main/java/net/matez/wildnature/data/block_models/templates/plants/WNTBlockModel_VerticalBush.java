package net.matez.wildnature.data.block_models.templates.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_VerticalBush extends WNBlockModel {
    public WNTBlockModel_VerticalBush() {
        super("vertical_bush");
    }

    @Override
    public String getJSON() {
        return """
                {
                 	"textures": {
                 		"particle": "#bush"
                 	},
                 	"elements": [
                 		{
                 			"from": [0, 0, 1],
                 			"to": [16, 16, 1],
                 			"faces": {
                 				"north": {"uv": [0, 0, 16, 16], "texture": "#bush"},
                 				"east": {"uv": [0, 0, 0, 16], "texture": "#bush"},
                 				"south": {"uv": [0, 0, 16, 16], "texture": "#bush"},
                 				"west": {"uv": [0, 0, 0, 16], "texture": "#bush"},
                 				"up": {"uv": [0, 0, 16, 0], "texture": "#bush"},
                 				"down": {"uv": [0, 0, 16, 0], "texture": "#bush"}
                 			}
                 		}
                 	]
                 }
                """;
    }
}
