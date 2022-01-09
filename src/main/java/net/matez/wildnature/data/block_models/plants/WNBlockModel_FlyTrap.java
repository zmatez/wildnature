package net.matez.wildnature.data.block_models.plants;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNBlockModel_FlyTrap extends WNBlockModel {
    /**
     * Required: @texture
     */
    public WNBlockModel_FlyTrap(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                	"textures": {
                		"0": "%texture%",
                		"particle": "%texture%"
                	},
                	"elements": [
                		{
                			"from": [5.94177, 0.25723, 7],
                			"to": [5.94177, 8.25723, 8],
                			"rotation": {"angle": 22.5, "axis": "z", "origin": [8, 4, 7.5]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "texture": "#0"},
                				"east": {"uv": [0, 0, 1, 8], "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "texture": "#0"},
                				"west": {"uv": [0, 0, 1, 8], "texture": "#0"},
                				"up": {"uv": [0, 0, 0, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0, 1], "texture": "#0"}
                			}
                		},
                		{
                			"from": [10.05823, 0.25723, 7],
                			"to": [10.05823, 6.25723, 8],
                			"rotation": {"angle": -22.5, "axis": "z", "origin": [8, 4, 7.5]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "texture": "#0"},
                				"east": {"uv": [0, 0, 1, 6], "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "texture": "#0"},
                				"west": {"uv": [0, 0, 1, 6], "texture": "#0"},
                				"up": {"uv": [0, 0, 0, 1], "rotation": 180, "texture": "#0"},
                				"down": {"uv": [0, 0, 0, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [7.53806, -0.53864, 5.55936],
                			"to": [8.53806, 3.46136, 5.55936],
                			"rotation": {"angle": -45, "axis": "x", "origin": [8.03806, 2.13311, 6.18111]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 4], "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 4], "texture": "#0"},
                				"up": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"}
                			}
                		},
                		{
                			"from": [5.69177, 0.25723, 7.25],
                			"to": [5.99177, 8.25723, 7.75],
                			"rotation": {"angle": 22.5, "axis": "z", "origin": [8, 4, 7.5]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "texture": "#0"},
                				"east": {"uv": [0, 0, 0.5, 8], "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "texture": "#0"},
                				"west": {"uv": [0, 0, 0.5, 8], "texture": "#0"},
                				"up": {"uv": [0, 0, 0.3, 0.5], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.3, 0.5], "texture": "#0"}
                			}
                		},
                		{
                			"from": [10.00823, 0.25723, 7.25],
                			"to": [10.30823, 6.25723, 7.75],
                			"rotation": {"angle": -22.5, "axis": "z", "origin": [8, 4, 7.5]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "texture": "#0"},
                				"east": {"uv": [0, 0, 0.5, 6], "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "texture": "#0"},
                				"west": {"uv": [0, 0, 0.5, 6], "texture": "#0"},
                				"up": {"uv": [0, 0, 0.3, 0.5], "rotation": 180, "texture": "#0"},
                				"down": {"uv": [0, 0, 0.3, 0.5], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [7.78806, -0.53864, 5.30936],
                			"to": [8.28806, 3.46136, 5.60936],
                			"rotation": {"angle": -45, "axis": "x", "origin": [8.03806, 2.13311, 6.18111]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "texture": "#0"},
                				"east": {"uv": [0, 0, 0.3, 4], "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "texture": "#0"},
                				"west": {"uv": [0, 0, 0.3, 4], "texture": "#0"},
                				"up": {"uv": [0, 0, 0.3, 0.5], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 0.3, 0.5], "rotation": 270, "texture": "#0"}
                			}
                		},
                		{
                			"from": [2.05, 6.93321, 6.82758],
                			"to": [4.55, 8.68321, 7.32758],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [3.5, 7.5, 7.28806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 1.75, 0.5], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [2, 13, 3.75, 15.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 1.75, 0.5], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 2.5, 0.5], "texture": "#0"},
                				"down": {"uv": [0, 0, 2.5, 0.5], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [10.7, 5.31642, 8.34211],
                			"to": [13.2, 7.06642, 8.84211],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [12.5, 7.5, 7.71194]},
                			"faces": {
                				"north": {"uv": [2, 13, 3.75, 15.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 1.75, 0.5], "rotation": 270, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 1.75, 0.5], "rotation": 90, "texture": "#0"},
                				"up": {"uv": [0, 0, 2.5, 0.5], "rotation": 180, "texture": "#0"},
                				"down": {"uv": [0, 0, 2.5, 0.5], "texture": "#0"}
                			}
                		},
                		{
                			"from": [10.25586, 1.05039, 2.46194],
                			"to": [10.75586, 2.80039, 4.96194],
                			"rotation": {"angle": -22.5, "axis": "z", "origin": [13, 7.5, 7.21194]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 270, "texture": "#0"},
                				"east": {"uv": [0, 0, 1.75, 2.5], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [1, 13, 2.75, 15.5], "rotation": 90, "texture": "#0"},
                				"up": {"uv": [0, 0, 2.5, 0.5], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 2.5, 0.5], "rotation": 90, "texture": "#0"}
                			}
                		},
                		{
                			"from": [2.05, 6.93321, 7.74854],
                			"to": [4.55, 8.68321, 8.24854],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [1, 13, 2.75, 15.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 1.75, 0.5], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 1.75, 0.5], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 2.5, 0.5], "texture": "#0"},
                				"down": {"uv": [0, 0, 2.5, 0.5], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [2.05, 8.68321, 7.24854],
                			"to": [2.45, 8.68321, 8.24854],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [10.7, 7.03772, 7.84894],
                			"to": [11.1, 7.03772, 8.84894],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [5.28221, 2.99173, 2.46306],
                			"to": [6.28221, 2.99173, 2.86306],
                			"rotation": {"angle": 22.5, "axis": "z", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 270, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"}
                			}
                		},
                		{
                			"from": [2.05, 8.86895, 6.86545],
                			"to": [2.45, 8.86895, 7.86545],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [10.7, 7.28086, 6.12647],
                			"to": [11.1, 7.28086, 7.12647],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [9.0329, 6.43028, 2.46306],
                			"to": [10.0329, 6.43028, 2.86306],
                			"rotation": {"angle": -22.5, "axis": "z", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 270, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"}
                			}
                		},
                		{
                			"from": [4.15, 8.68321, 7.24854],
                			"to": [4.55, 8.68321, 8.24854],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [12.8, 7.03772, 7.84894],
                			"to": [13.2, 7.03772, 8.84894],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [5.28221, 2.99173, 4.56306],
                			"to": [6.28221, 2.99173, 4.96306],
                			"rotation": {"angle": 22.5, "axis": "z", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 270, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"}
                			}
                		},
                		{
                			"from": [4.15, 8.86895, 6.86545],
                			"to": [4.55, 8.86895, 7.86545],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [12.8, 7.28086, 6.12647],
                			"to": [13.2, 7.28086, 7.12647],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [9.0329, 6.43028, 4.56306],
                			"to": [10.0329, 6.43028, 4.96306],
                			"rotation": {"angle": -22.5, "axis": "z", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 270, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"}
                			}
                		},
                		{
                			"from": [3.1, 8.68321, 7.24854],
                			"to": [3.5, 8.68321, 8.24854],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [11.75, 7.03772, 7.84894],
                			"to": [12.15, 7.03772, 8.84894],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [5.28221, 2.99173, 3.51306],
                			"to": [6.28221, 2.99173, 3.91306],
                			"rotation": {"angle": 22.5, "axis": "z", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 270, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"}
                			}
                		},
                		{
                			"from": [3.1, 8.86895, 6.86545],
                			"to": [3.5, 8.86895, 7.86545],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [11.75, 7.28086, 6.12647],
                			"to": [12.15, 7.28086, 7.12647],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [9.0329, 6.43028, 3.51306],
                			"to": [10.0329, 6.43028, 3.91306],
                			"rotation": {"angle": -22.5, "axis": "z", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 270, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"}
                			}
                		},
                		{
                			"from": [3.65, 8.68321, 7.24854],
                			"to": [4.05, 8.68321, 8.24854],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [12.3, 7.03772, 7.84894],
                			"to": [12.7, 7.03772, 8.84894],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [5.28221, 2.99173, 4.06306],
                			"to": [6.28221, 2.99173, 4.46306],
                			"rotation": {"angle": 22.5, "axis": "z", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 270, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"}
                			}
                		},
                		{
                			"from": [3.65, 8.86895, 6.86545],
                			"to": [4.05, 8.86895, 7.86545],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [12.3, 7.28086, 6.12647],
                			"to": [12.7, 7.28086, 7.12647],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [9.0329, 6.43028, 4.06306],
                			"to": [10.0329, 6.43028, 4.46306],
                			"rotation": {"angle": -22.5, "axis": "z", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 270, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"}
                			}
                		},
                		{
                			"from": [2.55, 8.68321, 7.24854],
                			"to": [2.95, 8.68321, 8.24854],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [11.2, 7.03772, 7.84894],
                			"to": [11.6, 7.03772, 8.84894],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [5.28221, 2.99173, 2.96306],
                			"to": [6.28221, 2.99173, 3.36306],
                			"rotation": {"angle": 22.5, "axis": "z", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 270, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"}
                			}
                		},
                		{
                			"from": [2.55, 8.86895, 6.86545],
                			"to": [2.95, 8.86895, 7.86545],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [11.2, 7.28086, 6.12647],
                			"to": [11.6, 7.28086, 7.12647],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 1], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 1], "rotation": 270, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 180, "texture": "#0"}
                			}
                		},
                		{
                			"from": [9.0329, 6.43028, 2.96306],
                			"to": [10.0329, 6.43028, 3.36306],
                			"rotation": {"angle": -22.5, "axis": "z", "origin": [3.5, 7.5, 7.78806]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 270, "texture": "#0"},
                				"east": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 0, 0.4], "rotation": 90, "texture": "#0"},
                				"up": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 0.4, 1], "rotation": 90, "texture": "#0"}
                			}
                		},
                		{
                			"from": [10.7, 5.31642, 6.08177],
                			"to": [13.2, 7.06642, 6.58177],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [12.5, 7.5, 7.21194]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 90, "texture": "#0"},
                				"east": {"uv": [0, 0, 1.75, 0.5], "rotation": 270, "texture": "#0"},
                				"south": {"uv": [1, 13, 2.75, 15.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 1.75, 0.5], "rotation": 90, "texture": "#0"},
                				"up": {"uv": [0, 0, 2.5, 0.5], "rotation": 180, "texture": "#0"},
                				"down": {"uv": [0, 0, 2.5, 0.5], "texture": "#0"}
                			}
                		},
                		{
                			"from": [5.96729, 4.68588, 2.46194],
                			"to": [6.46729, 6.43588, 4.96194],
                			"rotation": {"angle": 22.5, "axis": "z", "origin": [12.5, 7.5, 7.21194]},
                			"faces": {
                				"north": {"uv": [3, 0, 4.75, 2.5], "rotation": 270, "texture": "#0"},
                				"east": {"uv": [2, 13, 3.75, 15.5], "rotation": 90, "texture": "#0"},
                				"south": {"uv": [1, 2, 2.75, 4.5], "rotation": 90, "texture": "#0"},
                				"west": {"uv": [0, 0, 1.75, 2.5], "rotation": 90, "texture": "#0"},
                				"up": {"uv": [0, 0, 2.5, 0.5], "rotation": 90, "texture": "#0"},
                				"down": {"uv": [0, 0, 2.5, 0.5], "rotation": 90, "texture": "#0"}
                			}
                		}
                	]
                }
                """;
    }
}
