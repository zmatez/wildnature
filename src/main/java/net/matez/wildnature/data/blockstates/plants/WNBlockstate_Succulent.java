package net.matez.wildnature.data.blockstates.plants;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Succulent extends WNBlockstate {
    public WNBlockstate_Succulent(String id) {
        super(id);
    }

    public WNBlockstate_Succulent(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                  "variants": {
                    "":[
                      { "model": "%modid%:block/%name%_tall_dark_green" },
                      { "model": "%modid%:block/%name%_tall_dark_green","y": 90},
                      { "model": "%modid%:block/%name%_tall_dark_green","y": 180 },
                      { "model": "%modid%:block/%name%_tall_dark_green","y": 270 },
                      { "model": "%modid%:block/%name%_tall_dark_red" },
                      { "model": "%modid%:block/%name%_tall_dark_red","y": 90},
                      { "model": "%modid%:block/%name%_tall_dark_red","y": 180 },
                      { "model": "%modid%:block/%name%_tall_dark_red","y": 270 },
                      { "model": "%modid%:block/%name%_tall_green" },
                      { "model": "%modid%:block/%name%_tall_green","y": 90},
                      { "model": "%modid%:block/%name%_tall_green","y": 180 },
                      { "model": "%modid%:block/%name%_tall_green","y": 270 },
                      { "model": "%modid%:block/%name%_tall_light_green" },
                      { "model": "%modid%:block/%name%_tall_light_green","y": 90},
                      { "model": "%modid%:block/%name%_tall_light_green","y": 180 },
                      { "model": "%modid%:block/%name%_tall_light_green","y": 270 },
                      { "model": "%modid%:block/%name%_tall_mix" },
                      { "model": "%modid%:block/%name%_tall_mix","y": 90},
                      { "model": "%modid%:block/%name%_tall_mix","y": 180 },
                      { "model": "%modid%:block/%name%_tall_mix","y": 270 },
                      { "model": "%modid%:block/%name%_tall_red" },
                      { "model": "%modid%:block/%name%_tall_red","y": 90},
                      { "model": "%modid%:block/%name%_tall_red","y": 180 },
                      { "model": "%modid%:block/%name%_tall_red","y": 270 },
                      { "model": "%modid%:block/%name%_tall_white_spots" },
                      { "model": "%modid%:block/%name%_tall_white_spots","y": 90},
                      { "model": "%modid%:block/%name%_tall_white_spots","y": 180 },
                      { "model": "%modid%:block/%name%_tall_white_spots","y": 270 },
                      
                      { "model": "%modid%:block/%name%_big_dark_green" },
                      { "model": "%modid%:block/%name%_big_dark_green","y": 90},
                      { "model": "%modid%:block/%name%_big_dark_green","y": 180 },
                      { "model": "%modid%:block/%name%_big_dark_green","y": 270 },
                      { "model": "%modid%:block/%name%_big_dark_red" },
                      { "model": "%modid%:block/%name%_big_dark_red","y": 90},
                      { "model": "%modid%:block/%name%_big_dark_red","y": 180 },
                      { "model": "%modid%:block/%name%_big_dark_red","y": 270 },
                      { "model": "%modid%:block/%name%_big_green" },
                      { "model": "%modid%:block/%name%_big_green","y": 90},
                      { "model": "%modid%:block/%name%_big_green","y": 180 },
                      { "model": "%modid%:block/%name%_big_green","y": 270 },
                      { "model": "%modid%:block/%name%_big_light_green" },
                      { "model": "%modid%:block/%name%_big_light_green","y": 90},
                      { "model": "%modid%:block/%name%_big_light_green","y": 180 },
                      { "model": "%modid%:block/%name%_big_light_green","y": 270 },
                      { "model": "%modid%:block/%name%_big_mix" },
                      { "model": "%modid%:block/%name%_big_mix","y": 90},
                      { "model": "%modid%:block/%name%_big_mix","y": 180 },
                      { "model": "%modid%:block/%name%_big_mix","y": 270 },
                      { "model": "%modid%:block/%name%_big_red" },
                      { "model": "%modid%:block/%name%_big_red","y": 90},
                      { "model": "%modid%:block/%name%_big_red","y": 180 },
                      { "model": "%modid%:block/%name%_big_red","y": 270 },
                      { "model": "%modid%:block/%name%_big_white_spots" },
                      { "model": "%modid%:block/%name%_big_white_spots","y": 90},
                      { "model": "%modid%:block/%name%_big_white_spots","y": 180 },
                      { "model": "%modid%:block/%name%_big_white_spots","y": 270 },
                      
                      { "model": "%modid%:block/%name%_small_dark_green" },
                      { "model": "%modid%:block/%name%_small_dark_green","y": 90},
                      { "model": "%modid%:block/%name%_small_dark_green","y": 180 },
                      { "model": "%modid%:block/%name%_small_dark_green","y": 270 },
                      { "model": "%modid%:block/%name%_small_dark_red" },
                      { "model": "%modid%:block/%name%_small_dark_red","y": 90},
                      { "model": "%modid%:block/%name%_small_dark_red","y": 180 },
                      { "model": "%modid%:block/%name%_small_dark_red","y": 270 },
                      { "model": "%modid%:block/%name%_small_green" },
                      { "model": "%modid%:block/%name%_small_green","y": 90},
                      { "model": "%modid%:block/%name%_small_green","y": 180 },
                      { "model": "%modid%:block/%name%_small_green","y": 270 },
                      { "model": "%modid%:block/%name%_small_light_green" },
                      { "model": "%modid%:block/%name%_small_light_green","y": 90},
                      { "model": "%modid%:block/%name%_small_light_green","y": 180 },
                      { "model": "%modid%:block/%name%_small_light_green","y": 270 },
                      { "model": "%modid%:block/%name%_small_mix" },
                      { "model": "%modid%:block/%name%_small_mix","y": 90},
                      { "model": "%modid%:block/%name%_small_mix","y": 180 },
                      { "model": "%modid%:block/%name%_small_mix","y": 270 },
                      { "model": "%modid%:block/%name%_small_red" },
                      { "model": "%modid%:block/%name%_small_red","y": 90},
                      { "model": "%modid%:block/%name%_small_red","y": 180 },
                      { "model": "%modid%:block/%name%_small_red","y": 270 },
                      { "model": "%modid%:block/%name%_small_white_spots" },
                      { "model": "%modid%:block/%name%_small_white_spots","y": 90},
                      { "model": "%modid%:block/%name%_small_white_spots","y": 180 },
                      { "model": "%modid%:block/%name%_small_white_spots","y": 270 },
                      
                      { "model": "%modid%:block/%name%_big_and_small_dark_green" },
                      { "model": "%modid%:block/%name%_big_and_small_dark_green","y": 90},
                      { "model": "%modid%:block/%name%_big_and_small_dark_green","y": 180 },
                      { "model": "%modid%:block/%name%_big_and_small_dark_green","y": 270 },
                      { "model": "%modid%:block/%name%_big_and_small_dark_red" },
                      { "model": "%modid%:block/%name%_big_and_small_dark_red","y": 90},
                      { "model": "%modid%:block/%name%_big_and_small_dark_red","y": 180 },
                      { "model": "%modid%:block/%name%_big_and_small_dark_red","y": 270 },
                      { "model": "%modid%:block/%name%_big_and_small_green" },
                      { "model": "%modid%:block/%name%_big_and_small_green","y": 90},
                      { "model": "%modid%:block/%name%_big_and_small_green","y": 180 },
                      { "model": "%modid%:block/%name%_big_and_small_green","y": 270 },
                      { "model": "%modid%:block/%name%_big_and_small_light_green" },
                      { "model": "%modid%:block/%name%_big_and_small_light_green","y": 90},
                      { "model": "%modid%:block/%name%_big_and_small_light_green","y": 180 },
                      { "model": "%modid%:block/%name%_big_and_small_light_green","y": 270 },
                      { "model": "%modid%:block/%name%_big_and_small_mix" },
                      { "model": "%modid%:block/%name%_big_and_small_mix","y": 90},
                      { "model": "%modid%:block/%name%_big_and_small_mix","y": 180 },
                      { "model": "%modid%:block/%name%_big_and_small_mix","y": 270 },
                      { "model": "%modid%:block/%name%_big_and_small_red" },
                      { "model": "%modid%:block/%name%_big_and_small_red","y": 90},
                      { "model": "%modid%:block/%name%_big_and_small_red","y": 180 },
                      { "model": "%modid%:block/%name%_big_and_small_red","y": 270 },
                      { "model": "%modid%:block/%name%_big_and_small_white_spots" },
                      { "model": "%modid%:block/%name%_big_and_small_white_spots","y": 90},
                      { "model": "%modid%:block/%name%_big_and_small_white_spots","y": 180 },
                      { "model": "%modid%:block/%name%_big_and_small_white_spots","y": 270 }
                    ]
                  }
                }
                """;
    }
}
