/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.items.ores;

public enum OreItem {
    AMBER(OreFamily.AMBER,"amber","amber"),
    BRONZE_INGOT(OreFamily.BRONZE,"bronze_ingot","bronze"),
    DARK_AMETHYST(OreFamily.DARK_AMETHYST,"dark_amethyst","dark_amethyst"),
    DARK_AMETHYST_SHARD(OreFamily.DARK_AMETHYST,"dark_amethyst_shard","dark_amethyst"),
    RUBY(OreFamily.RUBY,"ruby","ruby"),
    RUBY_RAW(OreFamily.RUBY,"ruby_raw","ruby"),
    SAPPHIRE(OreFamily.SAPPHIRE,"sapphire","sapphire"),
    SAPPHIRE_RAW(OreFamily.SAPPHIRE,"sapphire_raw","sapphire"),
    SILVER_INGOT(OreFamily.SILVER,"silver_ingot","silver"),
    SILVER_RAW(OreFamily.SILVER,"silver_raw","silver"),
    STEEL_INGOT(OreFamily.STEEL,"steel_ingot","steel"),
    TIN_INGOT(OreFamily.TIN,"tin_ingot","tin"),
    TIN_RAW(OreFamily.TIN,"tin_raw","tin"),
    TOPAZ(OreFamily.TOPAZ,"topaz","topaz"),
    TOPAZ_RAW(OreFamily.TOPAZ,"topaz_raw","topaz"),
    ;
    private OreFamily family;
    private String id;
    private String folder;

    OreItem(OreFamily family, String id, String folder) {
        this.family = family;
        this.id = id;
        this.folder = folder;
    }

    public OreFamily getFamily() {
        return family;
    }

    public String getId() {
        return id;
    }

    public String getFolder() {
        return folder;
    }
}
