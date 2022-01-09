package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_DoubleFloweringBush extends WNBlockstate {
    public WNBlockstate_DoubleFloweringBush(String id) {
        super(id);
    }

    public WNBlockstate_DoubleFloweringBush(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "variants": {
                      "flowering=false,half=lower": {
                          "model": "%modid%:block/%name%_bottom"
                      },
                      "flowering=false,half=upper": {
                          "model": "%modid%:block/%name%_top"
                      },
                      "flowering=true,half=lower": {
                          "model": "%modid%:block/%name%_bottom_flowering"
                      },
                      "flowering=true,half=upper": {
                          "model": "%modid%:block/%name%_top_flowering"
                      }
                  }
                }
                """;
    }
}
