package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_FarmBlock extends WNBlockstate {
    public WNBlockstate_FarmBlock(String id) {
        super(id);
    }

    public WNBlockstate_FarmBlock(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "moisture=0": {
                      "model": "%modid%:block/%name%"
                    },
                    "moisture=1": {
                      "model": "%modid%:block/%name%"
                    },
                    "moisture=2": {
                      "model": "%modid%:block/%name%"
                    },
                    "moisture=3": {
                      "model": "%modid%:block/%name%"
                    },
                    "moisture=4": {
                      "model": "%modid%:block/%name%"
                    },
                    "moisture=5": {
                      "model": "%modid%:block/%name%"
                    },
                    "moisture=6": {
                      "model": "%modid%:block/%name%"
                    },
                    "moisture=7": {
                      "model": "%modid%:block/%name%_moist"
                    }
                  }
                }
                """;
    }
}
