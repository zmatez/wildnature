package net.matez.wildnature.data.block_models.templates;

import net.matez.wildnature.data.setup.base.WNBlockModel;


public class WNTBlockModel_BranchUp extends WNBlockModel {
    public WNTBlockModel_BranchUp() {
        super("branch_up");
    }

    @Override
    public String getJSON() {
        return """
                {
                      "textures": {
                          "particle": "#log"
                      },
                      "elements": [
                          {
                              "name": "Cube",
                              "from": [ 4.0, 12.0, 4.0 ],
                              "to": [ 12.0, 16.0, 12.0 ],
                              "faces": {
                                  "north": { "texture": "#log", "uv": [ 4.0, 0.0, 12.0, 4.0 ] },
                                  "east": { "texture": "#log", "uv": [ 4.0, 0.0, 12.0, 4.0 ] },
                                  "south": { "texture": "#log", "uv": [ 4.0, 0.0, 12.0, 4.0 ] },
                                  "west": { "texture": "#log", "uv": [ 4.0, 0.0, 12.0, 4.0 ] },
                                  "up": { "texture": "#inside", "uv": [ 4.0, 4.0, 12.0, 12.0 ] }
                              }
                          }
                      ]
                  }
                """;
    }
}
