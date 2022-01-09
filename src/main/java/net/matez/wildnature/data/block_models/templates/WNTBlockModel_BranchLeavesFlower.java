package net.matez.wildnature.data.block_models.templates;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_BranchLeavesFlower extends WNBlockModel {
    public WNTBlockModel_BranchLeavesFlower() {
        super("branch_leaves_flower");
    }

    @Override
    public String getJSON() {
        return """
                {
                 	"parent": "block/block",
                 	"textures": {
                 		"particle": "#leaves"
                 	},
                 	"elements": [
                 		{
                 			"name": "branch",
                 			"from": [0, 0, 0],
                 			"to": [16, 16, 16],
                 			"faces": {
                 				"north": {"uv": [0, 0, 16, 16], "texture": "#branch", "cullface": "north"},
                 				"east": {"uv": [0, 0, 16, 16], "texture": "#branch", "cullface": "east"},
                 				"south": {"uv": [0, 0, 16, 16], "texture": "#branch", "cullface": "south"},
                 				"west": {"uv": [0, 0, 16, 16], "texture": "#branch", "cullface": "west"},
                 				"up": {"uv": [0, 0, 16, 16], "texture": "#branch", "cullface": "up"},
                 				"down": {"uv": [0, 0, 16, 16], "texture": "#branch", "cullface": "down"}
                 			}
                 		},
                 		{
                 			"name": "leaves",
                 			"from": [0, 0, 0],
                 			"to": [16, 16, 16],
                 			"faces": {
                 				"north": {"uv": [0, 0, 16, 16], "texture": "#leaves", "cullface": "north", "tintindex": 0},
                 				"east": {"uv": [0, 0, 16, 16], "texture": "#leaves", "cullface": "east", "tintindex": 0},
                 				"south": {"uv": [0, 0, 16, 16], "texture": "#leaves", "cullface": "south", "tintindex": 0},
                 				"west": {"uv": [0, 0, 16, 16], "texture": "#leaves", "cullface": "west", "tintindex": 0},
                 				"up": {"uv": [0, 0, 16, 16], "texture": "#leaves", "cullface": "up", "tintindex": 0},
                 				"down": {"uv": [0, 0, 16, 16], "texture": "#leaves", "cullface": "down", "tintindex": 0}
                 			}
                 		},
                 		{
                 			"name": "flower",
                 			"from": [0, 0, 0],
                 			"to": [16, 16, 16],
                 			"faces": {
                 				"north": {"uv": [0, 0, 16, 16], "texture": "#flower", "cullface": "north"},
                 				"east": {"uv": [0, 0, 16, 16], "texture": "#flower", "cullface": "east"},
                 				"south": {"uv": [0, 0, 16, 16], "texture": "#flower", "cullface": "south"},
                 				"west": {"uv": [0, 0, 16, 16], "texture": "#flower", "cullface": "west"},
                 				"up": {"uv": [0, 0, 16, 16], "texture": "#flower", "cullface": "up"},
                 				"down": {"uv": [0, 0, 16, 16], "texture": "#flower", "cullface": "down"}
                 			}
                 		}
                 	]
                 }
                """;
    }
}
