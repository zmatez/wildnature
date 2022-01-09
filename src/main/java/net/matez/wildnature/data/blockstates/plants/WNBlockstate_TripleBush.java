package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_TripleBush extends WNBlockstate {
    public WNBlockstate_TripleBush(String id) {
        super(id);
    }

    public WNBlockstate_TripleBush(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "variants": {
                      "half=lower": {
                          "model": "%modid%:block/%name%_bottom"
                      },
                      "half=middle": {
                          "model": "%modid%:block/%name%_middle"
                      },
                      "half=upper": {
                          "model": "%modid%:block/%name%_top"
                      }
                  }
                }
                """;
    }
}
