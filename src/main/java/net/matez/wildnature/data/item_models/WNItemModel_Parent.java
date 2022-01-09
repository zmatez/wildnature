package net.matez.wildnature.data.item_models;

import net.matez.wildnature.data.setup.base.WNItemModel;

/**
 * Required: @parent (e.g minecraft:block/stone)
 */
public class WNItemModel_Parent extends WNItemModel {
    public WNItemModel_Parent(String name) {
        super(name);
    }

    @Override
    public String getJSON() {
        return """
                {
                    "parent": "%parent%"
                }
                """;
    }
}
