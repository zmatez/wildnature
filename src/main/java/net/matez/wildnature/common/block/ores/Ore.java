/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.ores;

import net.matez.wildnature.common.block.BlockBehaviourConsumer;
import net.matez.wildnature.common.item.ores.OreFamily;
import net.matez.wildnature.common.item.ores.OreItem;


public enum Ore {
    AMBER_ORE("amber_ore","amber",OreFamily.AMBER,OreType.BLOCK, new SimpleOreDropConfig(OreItem.AMBER,1,3), (properties) -> properties.strength(2F)),
    DARK_AMETHYST_FORMATION("dark_amethyst_formation","dark_amethyst",OreFamily.DARK_AMETHYST,OreType.FORMATION_BIG_SMALL, new SizedOreDropConfig(OreItem.DARK_AMETHYST_SHARD,OreItem.DARK_AMETHYST_SHARD,1,1,3,20), (properties) -> properties.strength(6.5F,5F)),
    RUBY_FORMATION("ruby_formation","ruby",OreFamily.RUBY,OreType.FORMATION_BIG_SMALL, new SizedOreDropConfig(OreItem.RUBY_RAW,OreItem.RUBY_RAW,1,1,1,3), (properties) -> properties.strength(4.5F,3.5F)),
    SAPPHIRE_FORMATION("sapphire_formation","sapphire",OreFamily.SAPPHIRE,OreType.FORMATION_BIG_SMALL, new SizedOreDropConfig(OreItem.SAPPHIRE_RAW,OreItem.SAPPHIRE_RAW,1,1,1,3), (properties) -> properties.strength(4.5F,3.5F)),
    SILVER_ORE("silver_ore","silver",OreFamily.SILVER,OreType.BLOCK, new SimpleOreDropConfig(OreItem.SILVER_RAW,1,1), (properties) -> properties.strength(3.5F)),
    SILVER_DEEPSLATE_ORE("silver_deepslate_ore","silver",OreFamily.SILVER,OreType.BLOCK_DEEPSLATE, new SimpleOreDropConfig(OreItem.SILVER_RAW,1,1), (properties) -> properties.strength(5F,3F)),
    TIN_ORE("tin_ore","tin",OreFamily.TIN,OreType.BLOCK, new SimpleOreDropConfig(OreItem.TIN_RAW,1,1), (properties) -> properties.strength(3F)),
    TIN_DEEPSLATE_ORE("tin_deepslate_ore","tin",OreFamily.TIN,OreType.BLOCK_DEEPSLATE, new SimpleOreDropConfig(OreItem.TIN_RAW,1,1), (properties) -> properties.strength(4.5F,3F)),
    TOPAZ_FORMATION("topaz_formation","topaz",OreFamily.TOPAZ,OreType.FORMATION,
            new SizedOreDropConfig(OreItem.TOPAZ_RAW,OreItem.TOPAZ_RAW,1,1,1,2),
            (properties) -> properties.strength(5.5F,4F)
    );

    private final String id;
    private final String folder;
    private final OreFamily family;
    private final OreType type;
    private final OreDropConfig dropConfig;
    private final BlockBehaviourConsumer propertiesSupplier;

    Ore(String id, String folder, OreFamily family, OreType type, OreDropConfig dropConfig, BlockBehaviourConsumer propertiesSupplier) {
        this.id = id;
        this.folder = folder;
        this.family = family;
        this.type = type;
        this.dropConfig = dropConfig;
        this.propertiesSupplier = propertiesSupplier;
    }

    public String getId() {
        return id;
    }

    public String getFolder() {
        return folder;
    }

    public OreFamily getFamily() {
        return family;
    }

    public OreType getType() {
        return type;
    }

    public BlockBehaviourConsumer getPropertiesSupplier() {
        return propertiesSupplier;
    }

    public OreDropConfig getDropConfig() {
        return dropConfig;
    }
}
