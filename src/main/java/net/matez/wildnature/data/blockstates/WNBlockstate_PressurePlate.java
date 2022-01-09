package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_PressurePlate extends WNBlockstate {
    public WNBlockstate_PressurePlate(String id) {
        super(id);
    }

    public WNBlockstate_PressurePlate(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "powered=false": {
                      "model": "%modid%:block/%name%"
                    },
                    "powered=true": {
                      "model": "%modid%:block/%name%_down"
                    }
                  }
                }
                """;
    }
}
