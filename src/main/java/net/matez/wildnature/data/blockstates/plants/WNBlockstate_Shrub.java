package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Shrub extends WNBlockstate {
    public WNBlockstate_Shrub(String id) {
        super(id);
    }

    public WNBlockstate_Shrub(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "":[
                      { "model": "%modid%:block/%name%_0" },
                      { "model": "%modid%:block/%name%_1" },
                      { "model": "%modid%:block/%name%_tall_0" },
                      { "model": "%modid%:block/%name%_tall_1" }
                    ]
                  }
                }
                """;
    }
}
