package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Pillar extends WNBlockstate {
    public WNBlockstate_Pillar(String id) {
        super(id);
    }

    public WNBlockstate_Pillar(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "variants": {
                        "axis=y":  { "model": "%modid%:block/%name%" },
                        "axis=z":   { "model": "%modid%:block/%name%", "x": 90 },
                        "axis=x":   { "model": "%modid%:block/%name%", "x": 90, "y": 90 }
                    }
                }
                """;
    }
}
