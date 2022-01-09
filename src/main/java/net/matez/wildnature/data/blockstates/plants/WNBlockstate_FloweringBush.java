package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_FloweringBush extends WNBlockstate {
    public WNBlockstate_FloweringBush(String id) {
        super(id);
    }

    public WNBlockstate_FloweringBush(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "variants": {
                      "flowering=false": {
                          "model": "%modid%:block/%name%"
                      },
                      "flowering=true": {
                          "model": "%modid%:block/%name%_flowering"
                      }
                  }
                }
                """;
    }
}
