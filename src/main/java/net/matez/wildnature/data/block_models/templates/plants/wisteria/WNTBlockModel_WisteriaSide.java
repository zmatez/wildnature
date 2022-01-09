package net.matez.wildnature.data.block_models.templates.plants.wisteria;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_WisteriaSide extends WNBlockModel {
    public WNTBlockModel_WisteriaSide() {
        super("wisteria_side");
    }

    @Override
    public String getJSON() {
        return """
                {
                	"ambientocclusion": false,
                	"elements": [
                		{
                			"shade": false,
                			"from": [0, -16, 8],
                			"to": [16, 0, 8],
                			"faces": {
                				"north": {"uv": [0, 0, 16, 16], "texture": "#4"},
                				"east": {"uv": [0, 0, 0, 16], "texture": "#4"},
                				"south": {"uv": [0, 0, 16, 16], "texture": "#4"},
                				"west": {"uv": [0, 0, 0, 16], "texture": "#4"},
                				"up": {"uv": [0, 0, 16, 0], "texture": "#4"},
                				"down": {"uv": [0, 0, 16, 0], "texture": "#4"}
                			}
                		},
                		{
                			"shade": false,
                			"from": [8, -16, 0],
                			"to": [8, 0, 16],
                			"faces": {
                				"east": {"uv": [0, 0, 16, 16], "texture": "#2"},
                				"west": {"uv": [0, 0, 16, 16], "texture": "#3"}
                			}
                		},
                		{
                			"shade": false,
                			"from": [0, 0, 8],
                			"to": [16, 16, 8],
                			"faces": {
                				"north": {"uv": [0, 0, 16, 16], "texture": "#5"},
                				"east": {"uv": [0, 0, 0, 16], "texture": "#5"},
                				"south": {"uv": [0, 0, 16, 16], "texture": "#5"},
                				"west": {"uv": [0, 0, 0, 16], "texture": "#5"},
                				"up": {"uv": [0, 0, 16, 0], "texture": "#5"},
                				"down": {"uv": [0, 0, 16, 0], "texture": "#5"}
                			}
                		},
                		{
                			"shade": false,
                			"from": [8, 0, 0],
                			"to": [8, 16, 16],
                			"faces": {
                				"north": {"uv": [0, 0, 0, 16], "texture": "#0"},
                				"east": {"uv": [0, 0, 16, 16], "texture": "#0"},
                				"south": {"uv": [0, 0, 0, 16], "texture": "#0"},
                				"west": {"uv": [0, 0, 16, 16], "texture": "#1"},
                				"up": {"uv": [0, 0, 0, 16], "texture": "#0"},
                				"down": {"uv": [0, 0, 0, 16], "texture": "#0"}
                			}
                		}
                	]
                }
                """;
    }
}
