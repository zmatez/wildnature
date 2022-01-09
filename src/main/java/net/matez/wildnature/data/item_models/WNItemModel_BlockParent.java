package net.matez.wildnature.data.item_models;

import net.matez.wildnature.data.setup.base.WNItemModel;

/**
 * Required: @parent (e.g stone)
 */
public class WNItemModel_BlockParent extends WNItemModel {
    public WNItemModel_BlockParent(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "%modid%:block/%parent%"
                }
                """;
    }
}
