package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Button extends WNBlockstate {
    /**
     * Required: @solid (e.g planks)
     */
    public WNBlockstate_Button(String id) {
        super(id);
    }

    /**
     * Required: @solid (e.g planks)
     */
    public WNBlockstate_Button(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "variants": {
                      "face=ceiling,facing=east,powered=false": {
                        "model": "%modid%:block/%name%",
                        "y": 270,
                        "x": 180
                      },
                      "face=ceiling,facing=east,powered=true": {
                        "model": "%modid%:block/%name%_pressed",
                        "y": 270,
                        "x": 180
                      },
                      "face=ceiling,facing=north,powered=false": {
                        "model": "%modid%:block/%name%",
                        "y": 180,
                        "x": 180
                      },
                      "face=ceiling,facing=north,powered=true": {
                        "model": "%modid%:block/%name%_pressed",
                        "y": 180,
                        "x": 180
                      },
                      "face=ceiling,facing=south,powered=false": {
                        "model": "%modid%:block/%name%",
                        "x": 180
                      },
                      "face=ceiling,facing=south,powered=true": {
                        "model": "%modid%:block/%name%_pressed",
                        "x": 180
                      },
                      "face=ceiling,facing=west,powered=false": {
                        "model": "%modid%:block/%name%",
                        "y": 90,
                        "x": 180
                      },
                      "face=ceiling,facing=west,powered=true": {
                        "model": "%modid%:block/%name%_pressed",
                        "y": 90,
                        "x": 180
                      },
                      "face=floor,facing=east,powered=false": {
                        "model": "%modid%:block/%name%",
                        "y": 90
                      },
                      "face=floor,facing=east,powered=true": {
                        "model": "%modid%:block/%name%_pressed",
                        "y": 90
                      },
                      "face=floor,facing=north,powered=false": {
                        "model": "%modid%:block/%name%"
                      },
                      "face=floor,facing=north,powered=true": {
                        "model": "%modid%:block/%name%_pressed"
                      },
                      "face=floor,facing=south,powered=false": {
                        "model": "%modid%:block/%name%",
                        "y": 180
                      },
                      "face=floor,facing=south,powered=true": {
                        "model": "%modid%:block/%name%_pressed",
                        "y": 180
                      },
                      "face=floor,facing=west,powered=false": {
                        "model": "%modid%:block/%name%",
                        "y": 270
                      },
                      "face=floor,facing=west,powered=true": {
                        "model": "%modid%:block/%name%_pressed",
                        "y": 270
                      },
                      "face=wall,facing=east,powered=false": {
                        "model": "%modid%:block/%name%",
                        "y": 90,
                        "x": 90,
                        "uvlock": true
                      },
                      "face=wall,facing=east,powered=true": {
                        "model": "%modid%:block/%name%_pressed",
                        "y": 90,
                        "x": 90,
                        "uvlock": true
                      },
                      "face=wall,facing=north,powered=false": {
                        "model": "%modid%:block/%name%",
                        "x": 90,
                        "uvlock": true
                      },
                      "face=wall,facing=north,powered=true": {
                        "model": "%modid%:block/%name%_pressed",
                        "x": 90,
                        "uvlock": true
                      },
                      "face=wall,facing=south,powered=false": {
                        "model": "%modid%:block/%name%",
                        "y": 180,
                        "x": 90,
                        "uvlock": true
                      },
                      "face=wall,facing=south,powered=true": {
                        "model": "%modid%:block/%name%_pressed",
                        "y": 180,
                        "x": 90,
                        "uvlock": true
                      },
                      "face=wall,facing=west,powered=false": {
                        "model": "%modid%:block/%name%",
                        "y": 270,
                        "x": 90,
                        "uvlock": true
                      },
                      "face=wall,facing=west,powered=true": {
                        "model": "%modid%:block/%name%_pressed",
                        "y": 270,
                        "x": 90,
                        "uvlock": true
                      }
                    }
                  }
                """;
    }
}
