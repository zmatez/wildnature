package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Wisteria extends WNBlockstate {

    public WNBlockstate_Wisteria(String id) {
        super(id);
    }

    public WNBlockstate_Wisteria(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "facing=north": {
                      "model": "%modid%:block/%name%_side"
                    },
                    "facing=east": {
                      "model": "%modid%:block/%name%_side",
                      "y": 90
                    },
                    "facing=south": {
                      "model": "%modid%:block/%name%_side",
                      "y": 180
                    },
                    "facing=west": {
                      "model": "%modid%:block/%name%_side",
                      "y": 270
                    },
                    "facing=down": {
                      "model": "%modid%:block/%name%_bottom"
                    },
                    "facing=up": {
                      "model": "%modid%:block/%name%_bottom"
                    }
                  }
                }
                """;
    }
}
