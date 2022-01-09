package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_DoubleBush extends WNBlockstate {
    public WNBlockstate_DoubleBush(String id) {
        super(id);
    }

    public WNBlockstate_DoubleBush(ResourceLocation location) {
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
                      "half=upper": {
                          "model": "%modid%:block/%name%_top"
                      }
                  }
                }
                """;
    }
}
