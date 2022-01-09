package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Slab extends WNBlockstate {
    /**
     * Required: @solid (e.g planks)
     */
    public WNBlockstate_Slab(String id) {
        super(id);
    }

    /**
     * Required: @solid (e.g planks)
     */
    public WNBlockstate_Slab(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "type=bottom": {
                      "model": "%modid%:block/%name%"
                    },
                    "type=double": {
                      "model": "%modid%:block/%solid%"
                    },
                    "type=top": {
                      "model": "%modid%:block/%name%_top"
                    }
                  }
                }
                """;
    }
}
