package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_GrassBlock extends WNBlockstate {
    public WNBlockstate_GrassBlock(String id) {
        super(id);
    }

    public WNBlockstate_GrassBlock(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "snowy=false": [
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
                    ],
                    "snowy=true": {
                      "model": "%modid%:block/%name%_snow"
                    }
                  }
                }
                """;
    }
}
