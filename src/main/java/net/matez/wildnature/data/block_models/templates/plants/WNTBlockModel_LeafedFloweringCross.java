package net.matez.wildnature.data.block_models.templates.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_LeafedFloweringCross extends WNBlockModel {
    public WNTBlockModel_LeafedFloweringCross() {
        super("flowering_cross_leaf");
    }

    @Override
    public String getJSON() {
        return """
                {
                       	"ambientocclusion": false,
                       	"elements": [
                       		{
                       			"from": [0.8, 0, 8],
                       			"to": [15.2, 16, 8],
                       			"shade": false,
                       			"rotation": {"angle": 45, "axis": "y", "origin": [8, 8, 8], "rescale": true},
                       			"faces": {
                       				"north": {"uv": [0, 0, 16, 16], "texture": "#leaves", "tintindex": 0},
                       				"south": {"uv": [0, 0, 16, 16], "texture": "#leaves", "tintindex": 0}
                       			}
                       		},
                       		{
                       			"from": [8, 0, 0.8],
                       			"to": [8, 16, 15.2],
                       			"shade": false,
                       			"rotation": {"angle": 45, "axis": "y", "origin": [8, 8, 8], "rescale": true},
                       			"faces": {
                       				"east": {"uv": [0, 0, 16, 16], "texture": "#leaves", "tintindex": 0},
                       				"west": {"uv": [0, 0, 16, 16], "texture": "#leaves", "tintindex": 0}
                       			}
                       		},
                       		{
                       			"from": [0.8, 0, 8],
                       			"to": [15.2, 16, 8],
                       			"shade": false,
                       			"rotation": {"angle": 45, "axis": "y", "origin": [8, 8, 8], "rescale": true},
                       			"faces": {
                       				"north": {"uv": [0, 0, 16, 16], "texture": "#colored"},
                       				"south": {"uv": [0, 0, 16, 16], "texture": "#colored"}
                       			}
                       		},
                       		{
                       			"from": [8, 0, 0.8],
                       			"to": [8, 16, 15.2],
                       			"shade": false,
                       			"rotation": {"angle": 45, "axis": "y", "origin": [8, 8, 8], "rescale": true},
                       			"faces": {
                       				"east": {"uv": [0, 0, 16, 16], "texture": "#colored"},
                       				"west": {"uv": [0, 0, 16, 16], "texture": "#colored"}
                       			}
                       		},
                       		{
                       			"from": [0.8, 0, 8],
                       			"to": [15.2, 16, 8],
                       			"shade": false,
                       			"rotation": {"angle": 45, "axis": "y", "origin": [8, 8, 8], "rescale": true},
                       			"faces": {
                       				"north": {"uv": [0, 0, 16, 16], "texture": "#stalk"},
                       				"east": {"uv": [0, 0, 16, 16], "texture": "#stalk"},
                       				"south": {"uv": [0, 0, 16, 16], "texture": "#stalk"},
                       				"west": {"uv": [0, 0, 16, 16], "texture": "#stalk"},
                       				"up": {"uv": [0, 0, 16, 16], "texture": "#stalk"},
                       				"down": {"uv": [0, 0, 16, 16], "texture": "#stalk"}
                       			}
                       		},
                       		{
                       			"from": [8, 0, 0.8],
                       			"to": [8, 16, 15.2],
                       			"shade": false,
                       			"rotation": {"angle": 45, "axis": "y", "origin": [8, 8, 8], "rescale": true},
                       			"faces": {
                       				"north": {"uv": [0, 0, 16, 16], "texture": "#stalk"},
                       				"east": {"uv": [0, 0, 16, 16], "texture": "#stalk"},
                       				"south": {"uv": [0, 0, 16, 16], "texture": "#stalk"},
                       				"west": {"uv": [0, 0, 16, 16], "texture": "#stalk"},
                       				"up": {"uv": [0, 0, 16, 16], "texture": "#stalk"},
                       				"down": {"uv": [0, 0, 16, 16], "texture": "#stalk"}
                       			}
                       		}
                       	]
                }
                """;
    }
}
