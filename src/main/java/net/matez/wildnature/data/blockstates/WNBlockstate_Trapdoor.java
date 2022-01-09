package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Trapdoor extends WNBlockstate {
    public WNBlockstate_Trapdoor(String id) {
        super(id);
    }

    public WNBlockstate_Trapdoor(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "facing=east,half=bottom,open=false": {
                      "model": "%modid%:block/%name%_bottom",
                      "y": 90
                    },
                    "facing=east,half=bottom,open=true": {
                      "model": "%modid%:block/%name%_open",
                      "y": 90
                    },
                    "facing=east,half=top,open=false": {
                      "model": "%modid%:block/%name%_top",
                      "y": 90
                    },
                    "facing=east,half=top,open=true": {
                      "model": "%modid%:block/%name%_open",
                      "x": 180,
                      "y": 270
                    },
                    "facing=north,half=bottom,open=false": {
                      "model": "%modid%:block/%name%_bottom"
                    },
                    "facing=north,half=bottom,open=true": {
                      "model": "%modid%:block/%name%_open"
                    },
                    "facing=north,half=top,open=false": {
                      "model": "%modid%:block/%name%_top"
                    },
                    "facing=north,half=top,open=true": {
                      "model": "%modid%:block/%name%_open",
                      "x": 180,
                      "y": 180
                    },
                    "facing=south,half=bottom,open=false": {
                      "model": "%modid%:block/%name%_bottom",
                      "y": 180
                    },
                    "facing=south,half=bottom,open=true": {
                      "model": "%modid%:block/%name%_open",
                      "y": 180
                    },
                    "facing=south,half=top,open=false": {
                      "model": "%modid%:block/%name%_top",
                      "y": 180
                    },
                    "facing=south,half=top,open=true": {
                      "model": "%modid%:block/%name%_open",
                      "x": 180,
                      "y": 0
                    },
                    "facing=west,half=bottom,open=false": {
                      "model": "%modid%:block/%name%_bottom",
                      "y": 270
                    },
                    "facing=west,half=bottom,open=true": {
                      "model": "%modid%:block/%name%_open",
                      "y": 270
                    },
                    "facing=west,half=top,open=false": {
                      "model": "%modid%:block/%name%_top",
                      "y": 270
                    },
                    "facing=west,half=top,open=true": {
                      "model": "%modid%:block/%name%_open",
                      "x": 180,
                      "y": 90
                    }
                  }
                }
                """;
    }
}
