package net.matez.wildnature.data.blockstates;

import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.minecraft.resources.ResourceLocation;

public class WNBlockstate_FenceGate extends WNBlockstate {
    /**
     * Required: @solid (e.g planks)
     */
    public WNBlockstate_FenceGate(String id) {
        super(id);
    }

    /**
     * Required: @solid (e.g planks)
     */
    public WNBlockstate_FenceGate(ResourceLocation location) {
        super(location);
    }

    @Override
    public String getJSON() {
        return """
                {
                   "variants": {
                     "facing=east,in_wall=false,open=false": {
                       "uvlock": true,
                       "y": 270,
                       "model": "%modid%:block/%name%"
                     },
                     "facing=east,in_wall=false,open=true": {
                       "uvlock": true,
                       "y": 270,
                       "model": "%modid%:block/%name%_open"
                     },
                     "facing=east,in_wall=true,open=false": {
                       "uvlock": true,
                       "y": 270,
                       "model": "%modid%:block/%name%_wall"
                     },
                     "facing=east,in_wall=true,open=true": {
                       "uvlock": true,
                       "y": 270,
                       "model": "%modid%:block/%name%_wall_open"
                     },
                     "facing=north,in_wall=false,open=false": {
                       "uvlock": true,
                       "y": 180,
                       "model": "%modid%:block/%name%"
                     },
                     "facing=north,in_wall=false,open=true": {
                       "uvlock": true,
                       "y": 180,
                       "model": "%modid%:block/%name%_open"
                     },
                     "facing=north,in_wall=true,open=false": {
                       "uvlock": true,
                       "y": 180,
                       "model": "%modid%:block/%name%_wall"
                     },
                     "facing=north,in_wall=true,open=true": {
                       "uvlock": true,
                       "y": 180,
                       "model": "%modid%:block/%name%_wall_open"
                     },
                     "facing=south,in_wall=false,open=false": {
                       "uvlock": true,
                       "model": "%modid%:block/%name%"
                     },
                     "facing=south,in_wall=false,open=true": {
                       "uvlock": true,
                       "model": "%modid%:block/%name%_open"
                     },
                     "facing=south,in_wall=true,open=false": {
                       "uvlock": true,
                       "model": "%modid%:block/%name%_wall"
                     },
                     "facing=south,in_wall=true,open=true": {
                       "uvlock": true,
                       "model": "%modid%:block/%name%_wall_open"
                     },
                     "facing=west,in_wall=false,open=false": {
                       "uvlock": true,
                       "y": 90,
                       "model": "%modid%:block/%name%"
                     },
                     "facing=west,in_wall=false,open=true": {
                       "uvlock": true,
                       "y": 90,
                       "model": "%modid%:block/%name%_open"
                     },
                     "facing=west,in_wall=true,open=false": {
                       "uvlock": true,
                       "y": 90,
                       "model": "%modid%:block/%name%_wall"
                     },
                     "facing=west,in_wall=true,open=true": {
                       "uvlock": true,
                       "y": 90,
                       "model": "%modid%:block/%name%_wall_open"
                     }
                   }
                 }
                """;
    }
}
