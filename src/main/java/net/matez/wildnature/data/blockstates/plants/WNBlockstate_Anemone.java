package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Anemone extends WNBlockstate {
    public WNBlockstate_Anemone(String id) {
        super(id);
    }

    public WNBlockstate_Anemone(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "variants": {
                      "stage=0": {
                          "model": "%modid%:block/%name%"
                      },
                      "stage=1": {
                          "model": "%modid%:block/%name%_stage_1"
                      },
                      "stage=2": {
                          "model": "%modid%:block/%name%_stage_2"
                      },
                      "stage=3": {
                          "model": "%modid%:block/%name%_stage_3"
                      }
                  }
                }
                """;
    }
}
