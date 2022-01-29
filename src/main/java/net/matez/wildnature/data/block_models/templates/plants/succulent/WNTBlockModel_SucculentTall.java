/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.block_models.templates.plants.succulent;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_SucculentTall extends WNBlockModel {
    public WNTBlockModel_SucculentTall() {
        super("succulent_tall");
    }

    @Override
    public String getJSON() {
        return """
                {
                	"textures": {
                		"particle": "#texture"
                	},
                	"elements": [
                		{
                			"from": [7.5, -0.35355, 12.35355],
                			"to": [8.5, 0.14645, 13.35355],
                			"rotation": {"angle": -45, "axis": "x", "origin": [7.5, 0.25, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 1, 0.5], "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 0.5], "texture": "#texture"},
                				"south": {"uv": [0, 0, 1, 0.5], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 0.5], "texture": "#texture"},
                				"up": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"down": {"uv": [0, 0, 1, 1], "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [2.5, 0, 7.5],
                			"to": [3.5, 0.5, 8.5],
                			"rotation": {"angle": -45, "axis": "z", "origin": [7.5, 0.25, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 1, 0.5], "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 0.5], "texture": "#texture"},
                				"south": {"uv": [0, 0, 1, 0.5], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 0.5], "texture": "#texture"},
                				"up": {"uv": [0, 0, 1, 1], "rotation": 90, "texture": "#texture"},
                				"down": {"uv": [0, 0, 1, 1], "rotation": 270, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7.5, -0.35355, 2.64645],
                			"to": [8.5, 0.14645, 3.64645],
                			"rotation": {"angle": 45, "axis": "x", "origin": [7.5, 0.25, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 1, 0.5], "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 0.5], "texture": "#texture"},
                				"south": {"uv": [0, 0, 1, 0.5], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 0.5], "texture": "#texture"},
                				"up": {"uv": [0, 0, 1, 1], "rotation": 180, "texture": "#texture"},
                				"down": {"uv": [0, 0, 1, 1], "rotation": 180, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7.95711, 4.95711, 7.5],
                			"to": [8.45711, 5.95711, 8.5],
                			"rotation": {"angle": -45, "axis": "z", "origin": [7.5, 0.25, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 1, 0.5], "rotation": 90, "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"south": {"uv": [0, 0, 1, 0.5], "rotation": 270, "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 1], "rotation": 180, "texture": "#texture"},
                				"up": {"uv": [0, 0, 1, 0.5], "rotation": 270, "texture": "#texture"},
                				"down": {"uv": [0, 0, 1, 0.5], "rotation": 270, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [8.02582, 4.35119, 7.5],
                			"to": [8.52582, 5.85119, 8.5],
                			"rotation": {"angle": -22.5, "axis": "z", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 1.5, 0.5], "rotation": 90, "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 1.5], "texture": "#texture"},
                				"south": {"uv": [0, 0, 1.5, 0.5], "rotation": 270, "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 1.5], "rotation": 180, "texture": "#texture"},
                				"up": {"uv": [0, 0, 1, 0.5], "rotation": 270, "texture": "#texture"},
                				"down": {"uv": [0, 0, 1, 0.5], "rotation": 270, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7.50902, 4.33206, 7.5],
                			"to": [8.00902, 5.83206, 8.5],
                			"rotation": {"angle": 22.5, "axis": "z", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 1.5, 0.5], "rotation": 90, "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 1.5], "texture": "#texture"},
                				"south": {"uv": [0, 0, 1.5, 0.5], "rotation": 270, "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 1.5], "rotation": 180, "texture": "#texture"},
                				"up": {"uv": [0, 0, 1, 0.5], "rotation": 270, "texture": "#texture"},
                				"down": {"uv": [0, 0, 1, 0.5], "rotation": 270, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7.5, 4.58216, 7.9415],
                			"to": [8.5, 6.08216, 8.4415],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 1, 1.5], "texture": "#texture"},
                				"east": {"uv": [0, 0, 1.5, 0.5], "rotation": 270, "texture": "#texture"},
                				"south": {"uv": [0, 0, 1, 1.5], "rotation": 180, "texture": "#texture"},
                				"west": {"uv": [0, 0, 1.5, 0.5], "rotation": 90, "texture": "#texture"},
                				"up": {"uv": [0, 0, 1, 0.5], "rotation": 180, "texture": "#texture"},
                				"down": {"uv": [0, 0, 1, 0.5], "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7.5, 4.19948, 7.48238],
                			"to": [8.5, 5.69948, 7.98238],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 1, 1.5], "rotation": 180, "texture": "#texture"},
                				"east": {"uv": [0, 0, 1.5, 0.5], "rotation": 90, "texture": "#texture"},
                				"south": {"uv": [0, 0, 1, 1.5], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1.5, 0.5], "rotation": 270, "texture": "#texture"},
                				"up": {"uv": [0, 0, 1, 0.5], "texture": "#texture"},
                				"down": {"uv": [0, 0, 1, 0.5], "rotation": 180, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7.65, 6.79619, 6.67006],
                			"to": [8.4, 7.79619, 7.17006],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 0.75, 1], "rotation": 180, "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 0.5], "rotation": 90, "texture": "#texture"},
                				"south": {"uv": [0, 0, 0.75, 1], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 0.5], "rotation": 270, "texture": "#texture"},
                				"up": {"uv": [0, 0, 0.75, 0.5], "texture": "#texture"},
                				"down": {"uv": [0, 0, 0.75, 0.5], "rotation": 180, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [6.70812, 6.60485, 7.6],
                			"to": [7.20812, 7.60485, 8.35],
                			"rotation": {"angle": -22.5, "axis": "z", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 1, 0.5], "rotation": 90, "texture": "#texture"},
                				"east": {"uv": [0, 0, 0.75, 1], "texture": "#texture"},
                				"south": {"uv": [0, 0, 1, 0.5], "rotation": 270, "texture": "#texture"},
                				"west": {"uv": [0, 0, 0.75, 1], "rotation": 180, "texture": "#texture"},
                				"up": {"uv": [0, 0, 0.75, 0.5], "rotation": 270, "texture": "#texture"},
                				"down": {"uv": [0, 0, 0.75, 0.5], "rotation": 270, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7.65, 6.41351, 8.67006],
                			"to": [8.4, 7.41351, 9.17006],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 0.75, 1], "rotation": 180, "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 0.5], "rotation": 90, "texture": "#texture"},
                				"south": {"uv": [0, 0, 0.75, 1], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 0.5], "rotation": 270, "texture": "#texture"},
                				"up": {"uv": [0, 0, 0.75, 0.5], "texture": "#texture"},
                				"down": {"uv": [0, 0, 0.75, 0.5], "rotation": 180, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [8.70812, 6.60485, 7.6],
                			"to": [9.20812, 7.60485, 8.35],
                			"rotation": {"angle": 22.5, "axis": "z", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 1, 0.5], "rotation": 90, "texture": "#texture"},
                				"east": {"uv": [0, 0, 0.75, 1], "texture": "#texture"},
                				"south": {"uv": [0, 0, 1, 0.5], "rotation": 270, "texture": "#texture"},
                				"west": {"uv": [0, 0, 0.75, 1], "rotation": 180, "texture": "#texture"},
                				"up": {"uv": [0, 0, 0.75, 0.5], "rotation": 270, "texture": "#texture"},
                				"down": {"uv": [0, 0, 0.75, 0.5], "rotation": 270, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7.50902, 0.83206, 7],
                			"to": [8.00902, 4.33206, 9],
                			"rotation": {"angle": 22.5, "axis": "z", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 3.5, 0.5], "rotation": 90, "texture": "#texture"},
                				"east": {"uv": [0, 0, 2, 3.5], "texture": "#texture"},
                				"south": {"uv": [0, 0, 3.5, 0.5], "rotation": 270, "texture": "#texture"},
                				"west": {"uv": [0, 0, 2, 3.5], "rotation": 180, "texture": "#texture"},
                				"up": {"uv": [0, 0, 2, 0.5], "rotation": 270, "texture": "#texture"},
                				"down": {"uv": [0, 0, 2, 0.5], "rotation": 270, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7, 1.08216, 7.9415],
                			"to": [9, 4.58216, 8.4415],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 2, 3.5], "texture": "#texture"},
                				"east": {"uv": [0, 0, 3.5, 0.5], "rotation": 270, "texture": "#texture"},
                				"south": {"uv": [0, 0, 2, 3.5], "rotation": 180, "texture": "#texture"},
                				"west": {"uv": [0, 0, 3.5, 0.5], "rotation": 90, "texture": "#texture"},
                				"up": {"uv": [0, 0, 2, 0.5], "rotation": 180, "texture": "#texture"},
                				"down": {"uv": [0, 0, 2, 0.5], "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7, 0.69948, 7.48238],
                			"to": [9, 4.19948, 7.98238],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 2, 3.5], "rotation": 180, "texture": "#texture"},
                				"east": {"uv": [0, 0, 3.5, 0.5], "rotation": 90, "texture": "#texture"},
                				"south": {"uv": [0, 0, 2, 3.5], "texture": "#texture"},
                				"west": {"uv": [0, 0, 3.5, 0.5], "rotation": 270, "texture": "#texture"},
                				"up": {"uv": [0, 0, 2, 0.5], "texture": "#texture"},
                				"down": {"uv": [0, 0, 2, 0.5], "rotation": 180, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7.25, 3.29619, 6.67006],
                			"to": [8.75, 6.79619, 7.17006],
                			"rotation": {"angle": 22.5, "axis": "x", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 1.5, 3.5], "rotation": 180, "texture": "#texture"},
                				"east": {"uv": [0, 0, 3.5, 0.5], "rotation": 90, "texture": "#texture"},
                				"south": {"uv": [0, 0, 1.5, 3.5], "texture": "#texture"},
                				"west": {"uv": [0, 0, 3.5, 0.5], "rotation": 270, "texture": "#texture"},
                				"up": {"uv": [0, 0, 1.5, 0.5], "texture": "#texture"},
                				"down": {"uv": [0, 0, 1.5, 0.5], "rotation": 180, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [6.70812, 3.10485, 7.25],
                			"to": [7.20812, 6.60485, 8.75],
                			"rotation": {"angle": -22.5, "axis": "z", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 3.5, 0.5], "rotation": 90, "texture": "#texture"},
                				"east": {"uv": [0, 0, 1.5, 3.5], "texture": "#texture"},
                				"south": {"uv": [0, 0, 3.5, 0.5], "rotation": 270, "texture": "#texture"},
                				"west": {"uv": [0, 0, 1.5, 3.5], "rotation": 180, "texture": "#texture"},
                				"up": {"uv": [0, 0, 1.5, 0.5], "rotation": 270, "texture": "#texture"},
                				"down": {"uv": [0, 0, 1.5, 0.5], "rotation": 270, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7.25, 2.91351, 8.67006],
                			"to": [8.75, 6.41351, 9.17006],
                			"rotation": {"angle": -22.5, "axis": "x", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 1.5, 3.5], "rotation": 180, "texture": "#texture"},
                				"east": {"uv": [0, 0, 3.5, 0.5], "rotation": 90, "texture": "#texture"},
                				"south": {"uv": [0, 0, 1.5, 3.5], "texture": "#texture"},
                				"west": {"uv": [0, 0, 3.5, 0.5], "rotation": 270, "texture": "#texture"},
                				"up": {"uv": [0, 0, 1.5, 0.5], "texture": "#texture"},
                				"down": {"uv": [0, 0, 1.5, 0.5], "rotation": 180, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [8.70812, 3.10485, 7.25],
                			"to": [9.20812, 6.60485, 8.75],
                			"rotation": {"angle": 22.5, "axis": "z", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 3.5, 0.5], "rotation": 90, "texture": "#texture"},
                				"east": {"uv": [0, 0, 1.5, 3.5], "texture": "#texture"},
                				"south": {"uv": [0, 0, 3.5, 0.5], "rotation": 270, "texture": "#texture"},
                				"west": {"uv": [0, 0, 1.5, 3.5], "rotation": 180, "texture": "#texture"},
                				"up": {"uv": [0, 0, 1.5, 0.5], "rotation": 270, "texture": "#texture"},
                				"down": {"uv": [0, 0, 1.5, 0.5], "rotation": 270, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7, -0.35355, 8.35355],
                			"to": [9, 0.14645, 12.35355],
                			"rotation": {"angle": -45, "axis": "x", "origin": [7.5, 0.25, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 2, 0.5], "texture": "#texture"},
                				"east": {"uv": [0, 0, 4, 0.5], "texture": "#texture"},
                				"south": {"uv": [0, 0, 2, 0.5], "texture": "#texture"},
                				"west": {"uv": [0, 0, 4, 0.5], "texture": "#texture"},
                				"up": {"uv": [0, 0, 2, 4], "texture": "#texture"},
                				"down": {"uv": [0, 0, 2, 4], "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [3.5, 0, 7],
                			"to": [7.5, 0.5, 9],
                			"rotation": {"angle": -45, "axis": "z", "origin": [7.5, 0.25, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 4, 0.5], "texture": "#texture"},
                				"east": {"uv": [0, 0, 2, 0.5], "texture": "#texture"},
                				"south": {"uv": [0, 0, 4, 0.5], "texture": "#texture"},
                				"west": {"uv": [0, 0, 2, 0.5], "texture": "#texture"},
                				"up": {"uv": [0, 0, 2, 4], "rotation": 90, "texture": "#texture"},
                				"down": {"uv": [0, 0, 2, 4], "rotation": 270, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7, -0.35355, 3.64645],
                			"to": [9, 0.14645, 7.64645],
                			"rotation": {"angle": 45, "axis": "x", "origin": [7.5, 0.25, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 2, 0.5], "texture": "#texture"},
                				"east": {"uv": [0, 0, 4, 0.5], "texture": "#texture"},
                				"south": {"uv": [0, 0, 2, 0.5], "texture": "#texture"},
                				"west": {"uv": [0, 0, 4, 0.5], "texture": "#texture"},
                				"up": {"uv": [0, 0, 2, 4], "rotation": 180, "texture": "#texture"},
                				"down": {"uv": [0, 0, 2, 4], "rotation": 180, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7.95711, 0.95711, 7],
                			"to": [8.45711, 4.95711, 9],
                			"rotation": {"angle": -45, "axis": "z", "origin": [7.5, 0.25, 8]},
                			"faces": {
                				"north": {"uv": [0, 0, 4, 0.5], "rotation": 90, "texture": "#texture"},
                				"east": {"uv": [0, 0, 2, 4], "texture": "#texture"},
                				"south": {"uv": [0, 0, 4, 0.5], "rotation": 270, "texture": "#texture"},
                				"west": {"uv": [0, 0, 2, 4], "rotation": 180, "texture": "#texture"},
                				"up": {"uv": [0, 0, 2, 0.5], "rotation": 270, "texture": "#texture"},
                				"down": {"uv": [0, 0, 2, 0.5], "rotation": 270, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [8.02582, 0.85119, 7],
                			"to": [8.52582, 4.35119, 9],
                			"rotation": {"angle": -22.5, "axis": "z", "origin": [8, 0, 7.5]},
                			"faces": {
                				"north": {"uv": [0, 0, 3.5, 0.5], "rotation": 90, "texture": "#texture"},
                				"east": {"uv": [0, 0, 2, 3.5], "texture": "#texture"},
                				"south": {"uv": [0, 0, 3.5, 0.5], "rotation": 270, "texture": "#texture"},
                				"west": {"uv": [0, 0, 2, 3.5], "rotation": 180, "texture": "#texture"},
                				"up": {"uv": [0, 0, 2, 0.5], "rotation": 270, "texture": "#texture"},
                				"down": {"uv": [0, 0, 2, 0.5], "rotation": 270, "texture": "#texture"}
                			},
                			"shade": false
                		},
                		{
                			"from": [7.5, 0, 7.5],
                			"to": [8.5, 6, 8.5],
                			"faces": {
                				"north": {"uv": [0, 0, 1, 6], "texture": "#texture"},
                				"east": {"uv": [0, 0, 1, 6], "texture": "#texture"},
                				"south": {"uv": [0, 0, 1, 6], "texture": "#texture"},
                				"west": {"uv": [0, 0, 1, 6], "texture": "#texture"},
                				"up": {"uv": [0, 0, 1, 1], "texture": "#texture"},
                				"down": {"uv": [0, 0, 1, 1], "texture": "#texture"}
                			},
                			"shade": false
                		}
                	]
                }
                """;
    }
}
