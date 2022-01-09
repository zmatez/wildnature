package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Stairs extends WNBlockstate {
    public WNBlockstate_Stairs(String id) {
        super(id);
    }

    public WNBlockstate_Stairs(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "facing=east,half=bottom,shape=inner_left": {
                      "model": "%modid%:block/%name%_inner",
                      "y": 270,
                      "uvlock": true
                    },
                    "facing=east,half=bottom,shape=inner_right": {
                      "model": "%modid%:block/%name%_inner"
                    },
                    "facing=east,half=bottom,shape=outer_left": {
                      "model": "%modid%:block/%name%_outer",
                      "y": 270,
                      "uvlock": true
                    },
                    "facing=east,half=bottom,shape=outer_right": {
                      "model": "%modid%:block/%name%_outer"
                    },
                    "facing=east,half=bottom,shape=straight": {
                      "model": "%modid%:block/%name%"
                    },
                    "facing=east,half=top,shape=inner_left": {
                      "model": "%modid%:block/%name%_inner",
                      "x": 180,
                      "uvlock": true
                    },
                    "facing=east,half=top,shape=inner_right": {
                      "model": "%modid%:block/%name%_inner",
                      "x": 180,
                      "y": 90,
                      "uvlock": true
                    },
                    "facing=east,half=top,shape=outer_left": {
                      "model": "%modid%:block/%name%_outer",
                      "x": 180,
                      "uvlock": true
                    },
                    "facing=east,half=top,shape=outer_right": {
                      "model": "%modid%:block/%name%_outer",
                      "x": 180,
                      "y": 90,
                      "uvlock": true
                    },
                    "facing=east,half=top,shape=straight": {
                      "model": "%modid%:block/%name%",
                      "x": 180,
                      "uvlock": true
                    },
                    "facing=north,half=bottom,shape=inner_left": {
                      "model": "%modid%:block/%name%_inner",
                      "y": 180,
                      "uvlock": true
                    },
                    "facing=north,half=bottom,shape=inner_right": {
                      "model": "%modid%:block/%name%_inner",
                      "y": 270,
                      "uvlock": true
                    },
                    "facing=north,half=bottom,shape=outer_left": {
                      "model": "%modid%:block/%name%_outer",
                      "y": 180,
                      "uvlock": true
                    },
                    "facing=north,half=bottom,shape=outer_right": {
                      "model": "%modid%:block/%name%_outer",
                      "y": 270,
                      "uvlock": true
                    },
                    "facing=north,half=bottom,shape=straight": {
                      "model": "%modid%:block/%name%",
                      "y": 270,
                      "uvlock": true
                    },
                    "facing=north,half=top,shape=inner_left": {
                      "model": "%modid%:block/%name%_inner",
                      "x": 180,
                      "y": 270,
                      "uvlock": true
                    },
                    "facing=north,half=top,shape=inner_right": {
                      "model": "%modid%:block/%name%_inner",
                      "x": 180,
                      "uvlock": true
                    },
                    "facing=north,half=top,shape=outer_left": {
                      "model": "%modid%:block/%name%_outer",
                      "x": 180,
                      "y": 270,
                      "uvlock": true
                    },
                    "facing=north,half=top,shape=outer_right": {
                      "model": "%modid%:block/%name%_outer",
                      "x": 180,
                      "uvlock": true
                    },
                    "facing=north,half=top,shape=straight": {
                      "model": "%modid%:block/%name%",
                      "x": 180,
                      "y": 270,
                      "uvlock": true
                    },
                    "facing=south,half=bottom,shape=inner_left": {
                      "model": "%modid%:block/%name%_inner"
                    },
                    "facing=south,half=bottom,shape=inner_right": {
                      "model": "%modid%:block/%name%_inner",
                      "y": 90,
                      "uvlock": true
                    },
                    "facing=south,half=bottom,shape=outer_left": {
                      "model": "%modid%:block/%name%_outer"
                    },
                    "facing=south,half=bottom,shape=outer_right": {
                      "model": "%modid%:block/%name%_outer",
                      "y": 90,
                      "uvlock": true
                    },
                    "facing=south,half=bottom,shape=straight": {
                      "model": "%modid%:block/%name%",
                      "y": 90,
                      "uvlock": true
                    },
                    "facing=south,half=top,shape=inner_left": {
                      "model": "%modid%:block/%name%_inner",
                      "x": 180,
                      "y": 90,
                      "uvlock": true
                    },
                    "facing=south,half=top,shape=inner_right": {
                      "model": "%modid%:block/%name%_inner",
                      "x": 180,
                      "y": 180,
                      "uvlock": true
                    },
                    "facing=south,half=top,shape=outer_left": {
                      "model": "%modid%:block/%name%_outer",
                      "x": 180,
                      "y": 90,
                      "uvlock": true
                    },
                    "facing=south,half=top,shape=outer_right": {
                      "model": "%modid%:block/%name%_outer",
                      "x": 180,
                      "y": 180,
                      "uvlock": true
                    },
                    "facing=south,half=top,shape=straight": {
                      "model": "%modid%:block/%name%",
                      "x": 180,
                      "y": 90,
                      "uvlock": true
                    },
                    "facing=west,half=bottom,shape=inner_left": {
                      "model": "%modid%:block/%name%_inner",
                      "y": 90,
                      "uvlock": true
                    },
                    "facing=west,half=bottom,shape=inner_right": {
                      "model": "%modid%:block/%name%_inner",
                      "y": 180,
                      "uvlock": true
                    },
                    "facing=west,half=bottom,shape=outer_left": {
                      "model": "%modid%:block/%name%_outer",
                      "y": 90,
                      "uvlock": true
                    },
                    "facing=west,half=bottom,shape=outer_right": {
                      "model": "%modid%:block/%name%_outer",
                      "y": 180,
                      "uvlock": true
                    },
                    "facing=west,half=bottom,shape=straight": {
                      "model": "%modid%:block/%name%",
                      "y": 180,
                      "uvlock": true
                    },
                    "facing=west,half=top,shape=inner_left": {
                      "model": "%modid%:block/%name%_inner",
                      "x": 180,
                      "y": 180,
                      "uvlock": true
                    },
                    "facing=west,half=top,shape=inner_right": {
                      "model": "%modid%:block/%name%_inner",
                      "x": 180,
                      "y": 270,
                      "uvlock": true
                    },
                    "facing=west,half=top,shape=outer_left": {
                      "model": "%modid%:block/%name%_outer",
                      "x": 180,
                      "y": 180,
                      "uvlock": true
                    },
                    "facing=west,half=top,shape=outer_right": {
                      "model": "%modid%:block/%name%_outer",
                      "x": 180,
                      "y": 270,
                      "uvlock": true
                    },
                    "facing=west,half=top,shape=straight": {
                      "model": "%modid%:block/%name%",
                      "x": 180,
                      "y": 180,
                      "uvlock": true
                    }
                  }
                }
                """;
    }
}
