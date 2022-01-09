package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_RandomlyRotatedCube extends WNBlockstate {
    public WNBlockstate_RandomlyRotatedCube(String id) {
        super(id);
    }

    public WNBlockstate_RandomlyRotatedCube(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "": [
                      {
                        "model": "%modid%:block/%name%"
                      },
                      {
                        "model": "%modid%:block/%name%",
                        "y": 90
                      },
                      {
                        "model": "%modid%:block/%name%",
                        "y": 180
                      },
                      {
                        "model": "%modid%:block/%name%",
                        "y": 270
                      }
                    ]
                  }
                }
                """;
    }
}
