package net.matez.wildnature.data.block_models.plants.prickly_pear;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_PricklyPear_Stage3 extends WNBlockModel {
    /**
     * Required: @stalk, @leaves
     */
    public WNBlockModel_PricklyPear_Stage3(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                	"textures": {
                 		"0": "%texture%_skin",
                 		"1": "%texture%_spikes",
                 		"2": "%texture%_fruit_stage_3",
                 		"particle": "%texture%_skin"
                 	},
                	"elements": [
                		{
                			"from": [5, 0, 8],
                			"to": [10, 4, 9],
                			"faces": {
                				"north": {"uv": [0, 0, 5, 4], "texture": "#0"},
                				"east": {"uv": [0, 0, 1, 4], "texture": "#0"},
                				"south": {"uv": [3, 2, 8, 6], "texture": "#0"},
                				"west": {"uv": [0, 0, 1, 4], "texture": "#0"},
                				"up": {"uv": [0, 0, 5, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 5, 1], "texture": "#0"}
                			}
                		},
                		{
                			"from": [4, 0, 8.5],
                			"to": [11, 5, 8.5],
                			"faces": {
                				"north": {"uv": [0, 0, 7, 5], "texture": "#1"},
                				"east": {"uv": [0, 0, 0, 5], "texture": "#1"},
                				"south": {"uv": [9, 0, 16, 5], "texture": "#1"},
                				"west": {"uv": [0, 0, 0, 5], "texture": "#1"},
                				"up": {"uv": [0, 0, 7, 0], "texture": "#1"},
                				"down": {"uv": [0, 0, 7, 0], "texture": "#1"}
                			}
                		},
                		{
                			"from": [2.07612, 4, 8.38268],
                			"to": [7.07612, 11, 9.38268],
                			"rotation": {"angle": -22.5, "axis": "y", "origin": [8, 4, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 5, 7], "texture": "#0"},
                				"east": {"uv": [0, 0, 1, 7], "texture": "#0"},
                				"south": {"uv": [3, 2, 8, 9], "texture": "#0"},
                				"west": {"uv": [0, 0, 1, 7], "texture": "#0"},
                				"up": {"uv": [0, 0, 5, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 5, 1], "texture": "#0"}
                			}
                		},
                		{
                			"from": [1.15224, 3, 8.76537],
                			"to": [8.15224, 12, 8.76537],
                			"rotation": {"angle": -22.5, "axis": "y", "origin": [8, 4, 8]},
                			"faces": {
                				"north": {"uv": [0, 7, 7, 16], "texture": "#1"},
                				"east": {"uv": [0, 7, 7, 16], "texture": "#1"},
                				"south": {"uv": [0, 7, 7, 16], "texture": "#1"},
                				"west": {"uv": [0, 7, 7, 16], "texture": "#1"},
                				"up": {"uv": [0, 7, 7, 16], "texture": "#1"},
                				"down": {"uv": [0, 7, 7, 16], "texture": "#1"}
                			}
                		},
                		{
                			"from": [0.56734, 11, 4.18583],
                			"to": [3.56734, 15, 5.18583],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 4, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 3, 4], "texture": "#0"},
                				"east": {"uv": [0, 0, 1, 4], "texture": "#0"},
                				"south": {"uv": [3, 2, 6, 6], "texture": "#0"},
                				"west": {"uv": [0, 0, 1, 4], "texture": "#0"},
                				"up": {"uv": [0, 0, 3, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 3, 1], "texture": "#0"}
                			}
                		},
                		{
                			"from": [-0.39303, 10, 4.74344],
                			"to": [4.60697, 16, 4.74344],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 4, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 5, 6], "texture": "#1"},
                				"east": {"uv": [0, 0, 0, 6], "texture": "#1"},
                				"south": {"uv": [0, 0, 5, 6], "texture": "#1"},
                				"west": {"uv": [0, 0, 0, 6], "texture": "#1"},
                				"up": {"uv": [0, 0, 5, 0], "texture": "#1"},
                				"down": {"uv": [0, 0, 5, 0], "texture": "#1"}
                			}
                		},
                		{
                			"from": [10.11772, 9, 9.87356],
                			"to": [13.11772, 13, 10.87356],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 4, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 3, 4], "texture": "#0"},
                				"east": {"uv": [0, 0, 1, 4], "texture": "#0"},
                				"south": {"uv": [3, 2, 6, 6], "texture": "#0"},
                				"west": {"uv": [0, 0, 1, 4], "texture": "#0"},
                				"up": {"uv": [0, 0, 3, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 3, 1], "texture": "#0"}
                			}
                		},
                		{
                			"from": [9.15735, 8, 10.43117],
                			"to": [14.15735, 14, 10.43117],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 4, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 5, 6], "texture": "#1"},
                				"east": {"uv": [0, 0, 0, 6], "texture": "#1"},
                				"south": {"uv": [7, 0, 12, 6], "texture": "#1"},
                				"west": {"uv": [0, 0, 0, 6], "texture": "#1"},
                				"up": {"uv": [0, 0, 5, 0], "texture": "#1"},
                				"down": {"uv": [0, 0, 5, 0], "texture": "#1"}
                			}
                		},
                		{
                			"from": [6.08937, 4, 11.03792],
                			"to": [8.08937, 7, 12.03792],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 4, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 2, 3], "texture": "#0"},
                				"east": {"uv": [0, 0, 1, 3], "texture": "#0"},
                				"south": {"uv": [3, 2, 5, 5], "texture": "#0"},
                				"west": {"uv": [0, 0, 1, 3], "texture": "#0"},
                				"up": {"uv": [0, 0, 2, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 2, 1], "texture": "#0"}
                			}
                		},
                		{
                			"from": [5.129, 3, 11.59553],
                			"to": [9.129, 8, 11.59553],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [8, 4, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 4, 5], "texture": "#1"},
                				"east": {"uv": [0, 0, 0, 5], "texture": "#1"},
                				"south": {"uv": [0, 0, 4, 5], "texture": "#1"},
                				"west": {"uv": [0, 0, 0, 5], "texture": "#1"},
                				"up": {"uv": [0, 0, 4, 0], "texture": "#1"},
                				"down": {"uv": [0, 0, 4, 0], "texture": "#1"}
                			}
                		},
                		{
                			"from": [9.20657, 9, 8.02334],
                			"to": [10.20657, 13, 11.02334],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [11, 9, 8.80844]},
                			"faces": {
                				"north": {"uv": [0, 0, 1, 4], "texture": "#0"},
                				"east": {"uv": [0, 0, 3, 4], "texture": "#0"},
                				"south": {"uv": [3, 2, 4, 6], "texture": "#0"},
                				"west": {"uv": [0, 0, 3, 4], "texture": "#0"},
                				"up": {"uv": [0, 0, 3, 1], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 3, 1], "rotation": 270, "texture": "#0"}
                			}
                		},
                		{
                			"from": [9.76418, 8, 6.98371],
                			"to": [9.76418, 14, 11.98371],
                			"rotation": {"angle": 22.5, "axis": "y", "origin": [11, 9, 8.80844]},
                			"faces": {
                				"north": {"uv": [0, 0, 0, 6], "texture": "#1"},
                				"east": {"uv": [0, 0, 5, 6], "texture": "#1"},
                				"south": {"uv": [0, 0, 0, 6], "texture": "#1"},
                				"west": {"uv": [0, 0, 5, 6], "texture": "#1"},
                				"up": {"uv": [0, 0, 5, 0], "rotation": 90, "texture": "#1"},
                				"down": {"uv": [0, 0, 5, 0], "rotation": 270, "texture": "#1"}
                			}
                		},
                		{
                			"from": [9.34799, 13, 8.87187],
                			"to": [10.34799, 16, 10.87187],
                			"rotation": {"angle": -45, "axis": "y", "origin": [9.5, 13, 8.80844]},
                			"faces": {
                				"north": {"uv": [0, 0, 1, 3], "texture": "#0"},
                				"east": {"uv": [0, 0, 2, 3], "texture": "#0"},
                				"south": {"uv": [3, 2, 4, 5], "texture": "#0"},
                				"west": {"uv": [0, 0, 2, 3], "texture": "#0"},
                				"up": {"uv": [0, 0, 2, 1], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 2, 1], "rotation": 270, "texture": "#0"}
                			}
                		},
                		{
                			"from": [9.70154, 12, 7.87187],
                			"to": [9.70154, 17, 11.87187],
                			"rotation": {"angle": -45, "axis": "y", "origin": [9.5, 13, 8.80844]},
                			"faces": {
                				"north": {"uv": [0, 0, 0, 5], "texture": "#1"},
                				"east": {"uv": [0, 0, 4, 5], "texture": "#1"},
                				"south": {"uv": [0, 0, 0, 5], "texture": "#1"},
                				"west": {"uv": [0, 0, 4, 5], "texture": "#1"},
                				"up": {"uv": [0, 0, 4, 0], "rotation": 90, "texture": "#1"},
                				"down": {"uv": [0, 0, 4, 0], "rotation": 270, "texture": "#1"}
                			}
                		},
                		{
                			"from": [9, 4, 8],
                			"to": [13, 9, 9],
                			"rotation": {"angle": -22.5, "axis": "y", "origin": [9, 6, 8.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 4, 5], "texture": "#0"},
                				"east": {"uv": [0, 0, 1, 5], "texture": "#0"},
                				"south": {"uv": [3, 2, 7, 7], "texture": "#0"},
                				"west": {"uv": [0, 0, 1, 5], "texture": "#0"},
                				"up": {"uv": [0, 0, 4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 4, 1], "texture": "#0"}
                			}
                		},
                		{
                			"from": [7.96037, 3, 8.55761],
                			"to": [13.96037, 10, 8.55761],
                			"rotation": {"angle": -22.5, "axis": "y", "origin": [9, 6, 8.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 6, 7], "texture": "#1"},
                				"east": {"uv": [0, 0, 0, 7], "texture": "#1"},
                				"south": {"uv": [1, 5, 7, 12], "texture": "#1"},
                				"west": {"uv": [0, 0, 0, 7], "texture": "#1"},
                				"up": {"uv": [0, 0, 6, 0], "texture": "#1"},
                				"down": {"uv": [0, 0, 6, 0], "texture": "#1"}
                			}
                		},
                		{
                			"from": [7.2105, 0, 11.32023],
                			"to": [10.2105, 4, 12.32023],
                			"rotation": {"angle": -45, "axis": "y", "origin": [9.91761, 2.5, 11.11313]},
                			"faces": {
                				"north": {"uv": [0, 0, 3, 4], "texture": "#0"},
                				"east": {"uv": [0, 0, 1, 4], "texture": "#0"},
                				"south": {"uv": [3, 2, 6, 6], "texture": "#0"},
                				"west": {"uv": [0, 0, 1, 4], "texture": "#0"},
                				"up": {"uv": [0, 0, 3, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 3, 1], "texture": "#0"}
                			}
                		},
                		{
                			"from": [6.2105, 0, 12.02734],
                			"to": [11.2105, 5, 12.02734],
                			"rotation": {"angle": -45, "axis": "y", "origin": [9.91761, 2.5, 11.11313]},
                			"faces": {
                				"north": {"uv": [0, 0, 5, 5], "texture": "#1"},
                				"east": {"uv": [0, 0, 0, 5], "texture": "#1"},
                				"south": {"uv": [0, 0, 5, 5], "texture": "#1"},
                				"west": {"uv": [0, 0, 0, 5], "texture": "#1"},
                				"up": {"uv": [0, 0, 5, 0], "texture": "#1"},
                				"down": {"uv": [0, 0, 5, 0], "texture": "#1"}
                			}
                		},
                		{
                 		    "shade": false,
                			"from": [3, 10.5, 7.75],
                			"to": [6, 13.5, 7.75],
                			"faces": {
                				"north": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"east": {"uv": [0, 0, 0, 3], "texture": "#2"},
                				"south": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"west": {"uv": [0, 0, 0, 3], "texture": "#2"},
                				"up": {"uv": [0, 0, 3, 0], "texture": "#2"},
                				"down": {"uv": [0, 0, 3, 0], "texture": "#2"}
                			}
                		},
                		{
                 		    "shade": false,
                			"from": [11, 12.5, 9],
                			"to": [14, 15.5, 9],
                			"faces": {
                				"north": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"east": {"uv": [0, 0, 0, 3], "texture": "#2"},
                				"south": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"west": {"uv": [0, 0, 0, 3], "texture": "#2"},
                				"up": {"uv": [0, 0, 3, 0], "texture": "#2"},
                				"down": {"uv": [0, 0, 3, 0], "texture": "#2"}
                			}
                		},
                		{
                 		    "shade": false,
                			"from": [0, 14.5, 7],
                			"to": [3, 17.5, 7],
                			"faces": {
                				"north": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"east": {"uv": [0, 0, 0, 3], "texture": "#2"},
                				"south": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"west": {"uv": [0, 0, 0, 3], "texture": "#2"},
                				"up": {"uv": [0, 0, 3, 0], "texture": "#2"},
                				"down": {"uv": [0, 0, 3, 0], "texture": "#2"}
                			}
                		},
                		{
                 		    "shade": false,
                			"from": [4.5, 10.5, 6.25],
                			"to": [4.5, 13.5, 9.25],
                			"faces": {
                				"north": {"uv": [6, 13, 6, 16], "texture": "#2"},
                				"east": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"south": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"west": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"up": {"uv": [0, 0, 0, 3], "texture": "#2"},
                				"down": {"uv": [0, 0, 0, 3], "texture": "#2"}
                			}
                		},
                		{
                 		    "shade": false,
                			"from": [12.5, 12.5, 7.5],
                			"to": [12.5, 15.5, 10.5],
                			"faces": {
                				"north": {"uv": [6, 13, 6, 16], "texture": "#2"},
                				"east": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"south": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"west": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"up": {"uv": [0, 0, 0, 3], "texture": "#2"},
                				"down": {"uv": [0, 0, 0, 3], "texture": "#2"}
                			}
                		},
                		{
                 		    "shade": false,
                			"from": [1.5, 14.5, 5.5],
                			"to": [1.5, 17.5, 8.5],
                			"faces": {
                				"north": {"uv": [6, 13, 6, 16], "texture": "#2"},
                				"east": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"south": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"west": {"uv": [6, 13, 9, 16], "texture": "#2"},
                				"up": {"uv": [0, 0, 0, 3], "texture": "#2"},
                				"down": {"uv": [0, 0, 0, 3], "texture": "#2"}
                			}
                		}
                	]
                }
                """;
    }
}
