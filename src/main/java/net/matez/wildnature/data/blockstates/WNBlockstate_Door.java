package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_Door extends WNBlockstate {
    public WNBlockstate_Door(String id) {
        super(id);
    }

    public WNBlockstate_Door(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                     "variants": {
                       "facing=east,half=lower,hinge=left,open=false": {
                         "model": "%modid%:block/%name%_bottom"
                       },
                       "facing=east,half=lower,hinge=left,open=true": {
                         "model": "%modid%:block/%name%_bottom_hinge",
                         "y": 90
                       },
                       "facing=east,half=lower,hinge=right,open=false": {
                         "model": "%modid%:block/%name%_bottom_hinge"
                       },
                       "facing=east,half=lower,hinge=right,open=true": {
                         "model": "%modid%:block/%name%_bottom",
                         "y": 270
                       },
                       "facing=east,half=upper,hinge=left,open=false": {
                         "model": "%modid%:block/%name%_top"
                       },
                       "facing=east,half=upper,hinge=left,open=true": {
                         "model": "%modid%:block/%name%_top_hinge",
                         "y": 90
                       },
                       "facing=east,half=upper,hinge=right,open=false": {
                         "model": "%modid%:block/%name%_top_hinge"
                       },
                       "facing=east,half=upper,hinge=right,open=true": {
                         "model": "%modid%:block/%name%_top",
                         "y": 270
                       },
                       "facing=north,half=lower,hinge=left,open=false": {
                         "model": "%modid%:block/%name%_bottom",
                         "y": 270
                       },
                       "facing=north,half=lower,hinge=left,open=true": {
                         "model": "%modid%:block/%name%_bottom_hinge"
                       },
                       "facing=north,half=lower,hinge=right,open=false": {
                         "model": "%modid%:block/%name%_bottom_hinge",
                         "y": 270
                       },
                       "facing=north,half=lower,hinge=right,open=true": {
                         "model": "%modid%:block/%name%_bottom",
                         "y": 180
                       },
                       "facing=north,half=upper,hinge=left,open=false": {
                         "model": "%modid%:block/%name%_top",
                         "y": 270
                       },
                       "facing=north,half=upper,hinge=left,open=true": {
                         "model": "%modid%:block/%name%_top_hinge"
                       },
                       "facing=north,half=upper,hinge=right,open=false": {
                         "model": "%modid%:block/%name%_top_hinge",
                         "y": 270
                       },
                       "facing=north,half=upper,hinge=right,open=true": {
                         "model": "%modid%:block/%name%_top",
                         "y": 180
                       },
                       "facing=south,half=lower,hinge=left,open=false": {
                         "model": "%modid%:block/%name%_bottom",
                         "y": 90
                       },
                       "facing=south,half=lower,hinge=left,open=true": {
                         "model": "%modid%:block/%name%_bottom_hinge",
                         "y": 180
                       },
                       "facing=south,half=lower,hinge=right,open=false": {
                         "model": "%modid%:block/%name%_bottom_hinge",
                         "y": 90
                       },
                       "facing=south,half=lower,hinge=right,open=true": {
                         "model": "%modid%:block/%name%_bottom"
                       },
                       "facing=south,half=upper,hinge=left,open=false": {
                         "model": "%modid%:block/%name%_top",
                         "y": 90
                       },
                       "facing=south,half=upper,hinge=left,open=true": {
                         "model": "%modid%:block/%name%_top_hinge",
                         "y": 180
                       },
                       "facing=south,half=upper,hinge=right,open=false": {
                         "model": "%modid%:block/%name%_top_hinge",
                         "y": 90
                       },
                       "facing=south,half=upper,hinge=right,open=true": {
                         "model": "%modid%:block/%name%_top"
                       },
                       "facing=west,half=lower,hinge=left,open=false": {
                         "model": "%modid%:block/%name%_bottom",
                         "y": 180
                       },
                       "facing=west,half=lower,hinge=left,open=true": {
                         "model": "%modid%:block/%name%_bottom_hinge",
                         "y": 270
                       },
                       "facing=west,half=lower,hinge=right,open=false": {
                         "model": "%modid%:block/%name%_bottom_hinge",
                         "y": 180
                       },
                       "facing=west,half=lower,hinge=right,open=true": {
                         "model": "%modid%:block/%name%_bottom",
                         "y": 90
                       },
                       "facing=west,half=upper,hinge=left,open=false": {
                         "model": "%modid%:block/%name%_top",
                         "y": 180
                       },
                       "facing=west,half=upper,hinge=left,open=true": {
                         "model": "%modid%:block/%name%_top_hinge",
                         "y": 270
                       },
                       "facing=west,half=upper,hinge=right,open=false": {
                         "model": "%modid%:block/%name%_top_hinge",
                         "y": 180
                       },
                       "facing=west,half=upper,hinge=right,open=true": {
                         "model": "%modid%:block/%name%_top",
                         "y": 90
                       }
                     }
                   }
                """;
    }
}
