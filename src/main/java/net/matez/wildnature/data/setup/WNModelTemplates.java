/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.setup;

import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initialize;
import net.matez.wildnature.data.block_models.templates.*;
import net.matez.wildnature.data.block_models.templates.plants.*;
import net.matez.wildnature.data.block_models.templates.plants.succulent.WNTBlockModel_SucculentBig;
import net.matez.wildnature.data.block_models.templates.plants.succulent.WNTBlockModel_SucculentBigAndSmall;
import net.matez.wildnature.data.block_models.templates.plants.succulent.WNTBlockModel_SucculentSmall;
import net.matez.wildnature.data.block_models.templates.plants.succulent.WNTBlockModel_SucculentTall;
import net.matez.wildnature.data.block_models.templates.plants.wisteria.WNTBlockModel_WisteriaBottom;
import net.matez.wildnature.data.block_models.templates.plants.wisteria.WNTBlockModel_WisteriaSide;
import net.matez.wildnature.data.setup.base.WNResource;

import java.util.ArrayList;

@Initialize(InitStage.CONSTRUCT)
public class WNModelTemplates {
    public static final ArrayList<WNResource> TEMPLATES = new ArrayList<>();
    public static final WNResource BLOCK_BRANCH_LEAVES = register(new WNTBlockModel_BranchLeaves());
    public static final WNResource BLOCK_BRANCH_LEAVES_FLOWER = register(new WNTBlockModel_BranchLeavesFlower());
    public static final WNResource BLOCK_BRANCH_UP = register(new WNTBlockModel_BranchUp());
    public static final WNResource BLOCK_BRANCH_DOWN = register(new WNTBlockModel_BranchDown());
    public static final WNResource BLOCK_BRANCH_SIDE = register(new WNTBlockModel_BranchSide());
    public static final WNResource BLOCK_BRANCH_INVENTORY = register(new WNTBlockModel_BranchInventory());
    public static final WNResource BLOCK_BRANCH_NONE = register(new WNTBlockModel_BranchNone());
    public static final WNResource BLOCK_FLOWERING_CROSS = register(new WNTBlockModel_FloweringCross());
    public static final WNResource BLOCK_LEAFED_FLOWERING_CROSS = register(new WNTBlockModel_LeafedFloweringCross());
    public static final WNResource BLOCK_FLOWERING_CROSS_RETINTED = register(new WNTBlockModel_FloweringCrossRetinted());
    public static final WNResource BLOCK_BIG_BUSH = register(new WNTBlockModel_BigBush());
    public static final WNResource BLOCK_BIG_BUSH_FLOWERING = register(new WNTBlockModel_BigBushFlowering());
    public static final WNResource BLOCK_SUCCULENT_TALL = register(new WNTBlockModel_SucculentTall());
    public static final WNResource BLOCK_SUCCULENT_BIG = register(new WNTBlockModel_SucculentBig());
    public static final WNResource BLOCK_SUCCULENT_SMALL = register(new WNTBlockModel_SucculentSmall());
    public static final WNResource BLOCK_SUCCULENT_BIG_AND_SMALL = register(new WNTBlockModel_SucculentBigAndSmall());
    public static final WNResource BLOCK_VERTICAL_BUSH = register(new WNTBlockModel_VerticalBush());
    public static final WNResource BLOCK_WISTERIA_SIDE = register(new WNTBlockModel_WisteriaSide());
    public static final WNResource BLOCK_WISTERIA_BOTTOM = register(new WNTBlockModel_WisteriaBottom());
    public static final WNResource BLOCK_TABLE_TOP = register(new WNTBlockModel_TableTop());
    public static final WNResource BLOCK_TABLE_LEG = register(new WNTBlockModel_TableLeg());
    public static final WNResource BLOCK_TABLE_ITEM = register(new WNTBlockModel_TableInventory());
    public static final WNResource BLOCK_CHAIR = register(new WNTBlockModel_Chair());
    public static final WNResource BLOCK_CROSS_LILYPAD = register(new WNTBlockModel_CrossLilypad());
    public static final WNResource BLOCK_BENCH_SIDE = register(new WNTBlockModel_BenchSide());
    public static final WNResource BLOCK_BENCH_SINGLE = register(new WNTBlockModel_BenchSingle());
    public static final WNResource BLOCK_BENCH_MIDDLE = register(new WNTBlockModel_BenchMiddle());


    private static WNResource register(WNResource resource){
        TEMPLATES.add(resource);
        return resource;
    }
}
