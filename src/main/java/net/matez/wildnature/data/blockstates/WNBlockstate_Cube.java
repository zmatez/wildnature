package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Cube extends WNBlockstate {
    public WNBlockstate_Cube(String id) {
        super(id);
    }

    public WNBlockstate_Cube(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "variants": {
                        "": { "model": "%modid%:block/%name%" }
                    }
                }
                """;
    }
}
