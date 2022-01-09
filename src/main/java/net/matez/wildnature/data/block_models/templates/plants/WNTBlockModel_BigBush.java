package net.matez.wildnature.data.block_models.templates.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_BigBush extends WNBlockModel {
    public WNTBlockModel_BigBush() {
        super("big_bush");
    }

    @Override
    public String getJSON() {
        return """
                {
                	"ambientocclusion": false,
                	"elements": [
                		{
                			"shade": false,
                			"from": [-8, 0, 8],
                			"to": [8, 16, 8],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 16, 16], "texture": "#stemBR"},
                				"south": {"uv": [0, 0, 16, 16], "texture": "#stemBL"}
                				
                			}
                		},
                		{
                			"shade": false,
                			"from": [8, 0, -8],
                			"to": [8, 16, 8],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"east": {"uv": [0, 0, 16, 16], "texture": "#stemBR"},
                				"west": {"uv": [0, 0, 16, 16], "texture": "#stemBL"}
                				
                			}
                		},
                		{
                			"shade": false,
                			"from": [8, 0, 8],
                			"to": [24, 16, 8],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 16, 16], "texture": "#stemBL"},
                				"south": {"uv": [0, 0, 16, 16], "texture": "#stemBR"}
                				
                			}
                		},
                		{
                			"shade": false,
                			"from": [8, 0, 8],
                			"to": [8, 16, 24],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"east": {"uv": [0, 0, 16, 16], "texture": "#stemBL"},
                				"west": {"uv": [0, 0, 16, 16], "texture": "#stemBR"}
                			}
                		},
                		{
                			"shade": false,
                			"from": [-8, 16, 8],
                			"to": [8, 32, 8],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 16, 16], "texture": "#stemTR"},
                				"south": {"uv": [0, 0, 16, 16], "texture": "#stemTL"}
                			}
                		},
                		{
                			"shade": false,
                			"from": [8, 16, -8],
                			"to": [8, 32, 8],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"east": {"uv": [0, 0, 16, 16], "texture": "#stemTR"},
                				"west": {"uv": [0, 0, 16, 16], "texture": "#stemTL"}
                			}
                		},
                		{
                			"shade": false,
                			"from": [8, 16, 8],
                			"to": [24, 32, 8],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 16, 16], "texture": "#stemTL"},
                				"south": {"uv": [0, 0, 16, 16], "texture": "#stemTR"}
                			}
                		},
                		{
                			"shade": false,
                			"from": [8, 16, 8],
                			"to": [8, 32, 24],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"east": {"uv": [0, 0, 16, 16], "texture": "#stemTL"},
                				"west": {"uv": [0, 0, 16, 16], "texture": "#stemTR"}
                			}
                		},
                		{
                			"shade": false,
                			"from": [-8, 0, 8],
                			"to": [8, 16, 8],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 16, 16], "texture": "#greyscaledBR", "tintindex": 0},
                				"south": {"uv": [0, 0, 16, 16], "texture": "#greyscaledBL", "tintindex": 0}
                				
                			}
                		},
                		{
                			"shade": false,
                			"from": [8, 0, -8],
                			"to": [8, 16, 8],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"east": {"uv": [0, 0, 16, 16], "texture": "#greyscaledBR", "tintindex": 0},
                				"west": {"uv": [0, 0, 16, 16], "texture": "#greyscaledBL", "tintindex": 0}
                				
                			}
                		},
                		{
                			"shade": false,
                			"from": [8, 0, 8],
                			"to": [24, 16, 8],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 16, 16], "texture": "#greyscaledBL", "tintindex": 0},
                				"south": {"uv": [0, 0, 16, 16], "texture": "#greyscaledBR", "tintindex": 0}
                				
                			}
                		},
                		{
                			"shade": false,
                			"from": [8, 0, 8],
                			"to": [8, 16, 24],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"east": {"uv": [0, 0, 16, 16], "texture": "#greyscaledBL", "tintindex": 0},
                				"west": {"uv": [0, 0, 16, 16], "texture": "#greyscaledBR", "tintindex": 0}
                			}
                		},
                		{
                			"shade": false,
                			"from": [-8, 16, 8],
                			"to": [8, 32, 8],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 16, 16], "texture": "#greyscaledTR", "tintindex": 0},
                				"south": {"uv": [0, 0, 16, 16], "texture": "#greyscaledTL", "tintindex": 0}
                			}
                		},
                		{
                			"shade": false,
                			"from": [8, 16, -8],
                			"to": [8, 32, 8],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"east": {"uv": [0, 0, 16, 16], "texture": "#greyscaledTR", "tintindex": 0},
                				"west": {"uv": [0, 0, 16, 16], "texture": "#greyscaledTL", "tintindex": 0}
                			}
                		},
                		{
                			"shade": false,
                			"from": [8, 16, 8],
                			"to": [24, 32, 8],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 16, 16], "texture": "#greyscaledTL", "tintindex": 0},
                				"south": {"uv": [0, 0, 16, 16], "texture": "#greyscaledTR", "tintindex": 0}
                			}
                		},
                		{
                			"shade": false,
                			"from": [8, 16, 8],
                			"to": [8, 32, 24],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 8, 8]},
                			"faces": {
                				"east": {"uv": [0, 0, 16, 16], "texture": "#greyscaledTL", "tintindex": 0},
                				"west": {"uv": [0, 0, 16, 16], "texture": "#greyscaledTR", "tintindex": 0}
                			}
                		}
                	]
                }
                """;
    }
}
