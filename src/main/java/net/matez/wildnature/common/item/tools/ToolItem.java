/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.item.tools;

import net.matez.wildnature.common.item.ores.OreFamily;

public enum ToolItem {
    BRONZE_SWORD(OreFamily.BRONZE,"bronze_sword",ToolType.SWORD),
    BRONZE_PICKAXE(OreFamily.BRONZE,"bronze_pickaxe",ToolType.PICKAXE),
    BRONZE_AXE(OreFamily.BRONZE,"bronze_axe",ToolType.AXE),
    BRONZE_SHOVEL(OreFamily.BRONZE,"bronze_shovel",ToolType.SHOVEL),
    BRONZE_HOE(OreFamily.BRONZE,"bronze_hoe",ToolType.HOE),
    
    DARK_AMETHYST_SWORD(OreFamily.DARK_AMETHYST,"dark_amethyst_sword",ToolType.SWORD),
    DARK_AMETHYST_PICKAXE(OreFamily.DARK_AMETHYST,"dark_amethyst_pickaxe",ToolType.PICKAXE),
    DARK_AMETHYST_AXE(OreFamily.DARK_AMETHYST,"dark_amethyst_axe",ToolType.AXE),
    DARK_AMETHYST_SHOVEL(OreFamily.DARK_AMETHYST,"dark_amethyst_shovel",ToolType.SHOVEL),
    DARK_AMETHYST_HOE(OreFamily.DARK_AMETHYST,"dark_amethyst_hoe",ToolType.HOE),
    
    RUBY_SWORD(OreFamily.RUBY,"ruby_sword",ToolType.SWORD),
    RUBY_PICKAXE(OreFamily.RUBY,"ruby_pickaxe",ToolType.PICKAXE),
    RUBY_AXE(OreFamily.RUBY,"ruby_axe",ToolType.AXE),
    RUBY_SHOVEL(OreFamily.RUBY,"ruby_shovel",ToolType.SHOVEL),

    SAPPHIRE_SWORD(OreFamily.SAPPHIRE,"sapphire_sword",ToolType.SWORD),
    SAPPHIRE_PICKAXE(OreFamily.SAPPHIRE,"sapphire_pickaxe",ToolType.PICKAXE),
    SAPPHIRE_AXE(OreFamily.SAPPHIRE,"sapphire_axe",ToolType.AXE),
    SAPPHIRE_SHOVEL(OreFamily.SAPPHIRE,"sapphire_shovel",ToolType.SHOVEL),

    SILVER_SWORD(OreFamily.SILVER,"silver_sword",ToolType.SWORD),
    SILVER_PICKAXE(OreFamily.SILVER,"silver_pickaxe",ToolType.PICKAXE),
    SILVER_AXE(OreFamily.SILVER,"silver_axe",ToolType.AXE),
    SILVER_SHOVEL(OreFamily.SILVER,"silver_shovel",ToolType.SHOVEL),
    SILVER_CROSSBOW(OreFamily.SILVER,"silver_crossbow",ToolType.CROSSBOW),
    
    STEEL_SWORD(OreFamily.STEEL,"steel_sword",ToolType.SWORD),
    STEEL_PICKAXE(OreFamily.STEEL,"steel_pickaxe",ToolType.PICKAXE),
    STEEL_AXE(OreFamily.STEEL,"steel_axe",ToolType.AXE),
    STEEL_SHOVEL(OreFamily.STEEL,"steel_shovel",ToolType.SHOVEL),
    STEEL_HOE(OreFamily.STEEL,"steel_hoe",ToolType.HOE),
    
    TOPAZ_SWORD(OreFamily.TOPAZ,"topaz_sword",ToolType.SWORD),
    TOPAZ_PICKAXE(OreFamily.TOPAZ,"topaz_pickaxe",ToolType.PICKAXE),
    TOPAZ_AXE(OreFamily.TOPAZ,"topaz_axe",ToolType.AXE),
    TOPAZ_SHOVEL(OreFamily.TOPAZ,"topaz_shovel",ToolType.SHOVEL),
    ;
    private final OreFamily family;
    private final String id;
    private final String folder;
    private final ToolType type;

    ToolItem(OreFamily family, String id, String folder, ToolType type) {
        this.family = family;
        this.id = id;
        this.folder = folder;
        this.type = type;
    }

    ToolItem(OreFamily family, String id, ToolType type) {
        this(family,id,family.getName(),type);
    }

    public OreFamily getFamily() {
        return family;
    }

    public String getFolder() {
        return folder;
    }

    public String getId() {
        return id;
    }

    public ToolType getType() {
        return type;
    }
}
