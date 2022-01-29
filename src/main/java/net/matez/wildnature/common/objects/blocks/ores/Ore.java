/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.ores;

import net.matez.wildnature.common.objects.blocks.setup.BlockPropertiesSupplier;
import net.matez.wildnature.common.objects.blocks.setup.ModelSupplier;
import net.matez.wildnature.common.objects.items.ores.OreFamily;
import net.matez.wildnature.common.objects.items.ores.OreItem;
import net.matez.wildnature.data.block_models.ores.*;

import javax.annotation.Nullable;

public enum Ore {
    AMBER_ORE("amber_ore","amber",OreFamily.AMBER,OreType.BLOCK, new SimpleOreDropConfig(OreItem.AMBER,1,3), (properties) -> {
        return properties.strength(2F);
    }),
    DARK_AMETHYST_FORMATION("dark_amethyst_formation","dark_amethyst",OreFamily.DARK_AMETHYST,OreType.FORMATION_BIG_SMALL,
            new SizedOreDropConfig(OreItem.DARK_AMETHYST_SHARD,OreItem.DARK_AMETHYST_SHARD,1,1,3,20),
            (properties) -> {
                return properties.strength(6.5F,5F);
            }, (block) -> new WNBlockModel_AmethystFormationSmall(block.getRegName() + "_small"),
            (block) -> new WNBlockModel_AmethystFormationBig(block.getRegName() + "_big")
    ),
    RUBY_FORMATION("ruby_formation","ruby",OreFamily.RUBY,OreType.FORMATION_BIG_SMALL,
            new SizedOreDropConfig(OreItem.RUBY_RAW,OreItem.RUBY_RAW,1,1,1,3),
            (properties) -> {
                return properties.strength(4.5F,3.5F);
            }, (block) -> new WNBlockModel_RubySapphireFormationSmall(block.getRegName() + "_small"),
            (block) -> new WNBlockModel_RubySapphireFormationBig(block.getRegName() + "_big")
    ),
    SAPPHIRE_FORMATION("sapphire_formation","sapphire",OreFamily.SAPPHIRE,OreType.FORMATION_BIG_SMALL,
            new SizedOreDropConfig(OreItem.SAPPHIRE_RAW,OreItem.SAPPHIRE_RAW,1,1,1,3),
            (properties) -> {
                return properties.strength(4.5F,3.5F);
            }, (block) -> new WNBlockModel_RubySapphireFormationSmall(block.getRegName() + "_small"),
            (block) -> new WNBlockModel_RubySapphireFormationBig(block.getRegName() + "_big")
    ),
    SILVER_ORE("silver_ore","silver",OreFamily.SILVER,OreType.BLOCK, new SimpleOreDropConfig(OreItem.SILVER_RAW,1,1), (properties) -> {
        return properties.strength(3.5F);
    }),
    SILVER_DEEPSLATE_ORE("silver_deepslate_ore","silver",OreFamily.SILVER,OreType.BLOCK_DEEPSLATE, new SimpleOreDropConfig(OreItem.SILVER_RAW,1,1), (properties) -> {
        return properties.strength(5F,3F);
    }),
    TIN_ORE("tin_ore","tin",OreFamily.TIN,OreType.BLOCK, new SimpleOreDropConfig(OreItem.TIN_RAW,1,1), (properties) -> {
        return properties.strength(3F);
    }),
    TIN_DEEPSLATE_ORE("tin_deepslate_ore","tin",OreFamily.TIN,OreType.BLOCK_DEEPSLATE, new SimpleOreDropConfig(OreItem.TIN_RAW,1,1), (properties) -> {
        return properties.strength(4.5F,3F);
    }),
    TOPAZ_FORMATION("topaz_formation","topaz",OreFamily.TOPAZ,OreType.FORMATION,
            new SizedOreDropConfig(OreItem.TOPAZ_RAW,OreItem.TOPAZ_RAW,1,1,1,2),
            (properties) -> {
                return properties.strength(5.5F,4F);
            }, (block) -> new WNBlockModel_TopazFormation(block.getRegName())
    )
    ;

    private final String id;
    private final String folder;
    private final OreFamily family;
    private final OreType type;
    private final OreDropConfig dropConfig;
    private final BlockPropertiesSupplier propertiesSupplier;
    @Nullable private ModelSupplier[] models;

    Ore(String id, String folder, OreFamily family, OreType type, OreDropConfig dropConfig, BlockPropertiesSupplier propertiesSupplier) {
        this.id = id;
        this.folder = folder;
        this.family = family;
        this.type = type;
        this.dropConfig = dropConfig;
        this.propertiesSupplier = propertiesSupplier;
    }

    Ore(String id, String folder, OreFamily family, OreType type, OreDropConfig dropConfig, BlockPropertiesSupplier propertiesSupplier, @Nullable ModelSupplier... model) {
        this.id = id;
        this.folder = folder;
        this.family = family;
        this.type = type;
        this.dropConfig = dropConfig;
        this.propertiesSupplier = propertiesSupplier;
        this.models = model;
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

    @Nullable
    public ModelSupplier[] getModels() {
        return models;
    }

    public BlockPropertiesSupplier getPropertiesSupplier() {
        return propertiesSupplier;
    }

    public OreDropConfig getDropConfig() {
        return dropConfig;
    }
}
