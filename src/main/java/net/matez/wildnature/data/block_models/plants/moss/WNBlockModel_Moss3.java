package net.matez.wildnature.data.block_models.plants.moss;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_Moss3 extends WNBlockModel {
    /**
     * Required: texture
     */
    public WNBlockModel_Moss3(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                	"textures": {
                		"texture": "%texture%",
                		"particle": "%texture%"
                	},
                	"elements": [
                		{
                			"name": "moss",
                			"from": [1, 0, 4],
                			"to": [8, 1, 10],
                			"faces": {
                				"north": {"uv": [4, 0, 14, 1], "texture": "#texture"},
                				"east": {"uv": [2, 0, 8, 1], "texture": "#texture"},
                				"south": {"uv": [4, 0, 14, 1], "texture": "#texture"},
                				"west": {"uv": [8, 0, 14, 1], "texture": "#texture"},
                				"up": {"uv": [0, 0, 7, 6], "texture": "#texture"},
                				"down": {"uv": [0, 0, 10, 6], "texture": "#texture"}
                			}
                		},
                		{
                			"name": "moss",
                			"from": [3, 0, 2],
                			"to": [10, 1, 4],
                			"faces": {
                				"north": {"uv": [3, 0, 10, 1], "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"south": {"uv": [0, 0, 7, 1], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"up": {"uv": [0, 0, 7, 2], "texture": "#texture"},
                				"down": {"uv": [0, 0, 7, 1], "texture": "#texture"}
                			}
                		},
                		{
                			"name": "moss",
                			"from": [4, 0, 13],
                			"to": [8, 1, 14],
                			"faces": {
                				"north": {"uv": [5, 1, 9, 2], "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"south": {"uv": [0, 0, 4, 1], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"up": {"uv": [0, 0, 4, 1], "texture": "#texture"},
                				"down": {"uv": [0, 0, 4, 1], "texture": "#texture"}
                			}
                		},
                		{
                			"name": "moss",
                			"from": [3, 0, 10],
                			"to": [9, 1, 13],
                			"faces": {
                				"north": {"uv": [0, 0, 7, 1], "texture": "#texture"},
                				"east": {"uv": [3, 2, 6, 3], "texture": "#texture"},
                				"south": {"uv": [0, 0, 7, 1], "texture": "#texture"},
                				"west": {"uv": [0, 0, 3, 1], "texture": "#texture"},
                				"up": {"uv": [0, 0, 6, 3], "texture": "#texture"},
                				"down": {"uv": [0, 0, 7, 3], "texture": "#texture"}
                			}
                		},
                		{
                			"name": "moss",
                			"from": [2, 0, 3],
                			"to": [3, 1, 4],
                			"faces": {
                				"north": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"south": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"up": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"down": {"uv": [0, 0, 1, 1], "texture": "#texture"}
                			}
                		},
                		{
                			"name": "moss",
                			"from": [2, 0, 10],
                			"to": [3, 1, 11],
                			"faces": {
                				"north": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"south": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"up": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"down": {"uv": [0, 0, 1, 1], "texture": "#texture"}
                			}
                		},
                		{
                			"name": "moss",
                			"from": [11, 0, 10],
                			"to": [13, 1, 11],
                			"faces": {
                				"north": {"uv": [0, 0, 2, 1], "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"south": {"uv": [0, 0, 2, 1], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"up": {"uv": [0, 0, 2, 1], "texture": "#texture"},
                				"down": {"uv": [0, 0, 2, 1], "texture": "#texture"}
                			}
                		},
                		{
                			"name": "moss",
                			"from": [11, 0, 5],
                			"to": [13, 1, 6],
                			"faces": {
                				"north": {"uv": [0, 0, 2, 1], "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"south": {"uv": [0, 0, 2, 1], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"up": {"uv": [0, 0, 2, 1], "texture": "#texture"},
                				"down": {"uv": [0, 0, 2, 1], "texture": "#texture"}
                			}
                		},
                		{
                			"name": "moss",
                			"from": [7, 0, 1],
                			"to": [11, 1, 2],
                			"faces": {
                				"north": {"uv": [0, 0, 4, 1], "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"south": {"uv": [0, 0, 4, 1], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"up": {"uv": [5, 1, 9, 2], "texture": "#texture"},
                				"down": {"uv": [0, 0, 4, 1], "texture": "#texture"}
                			}
                		},
                		{
                			"name": "moss",
                			"from": [10, 0, 6],
                			"to": [14, 1, 10],
                			"faces": {
                				"north": {"uv": [0, 0, 4, 1], "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"south": {"uv": [0, 0, 4, 1], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"up": {"uv": [4, 2, 8, 6], "texture": "#texture"},
                				"down": {"uv": [0, 0, 4, 1], "texture": "#texture"}
                			}
                		}
                	],
                	"groups": [
                		{
                			"name": "moss_1",
                			"origin": [8, 8, 8],
                			"children": [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
                		}
                	]
                }
                """;
    }
}
