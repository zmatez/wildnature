/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.feature.tree;

import net.matez.wildnature.common.feature.WNFeature;
import net.matez.wildnature.common.structures.WNStructurePlacement;
import net.matez.wildnature.api.util.ExtraMath;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class WNTreeFeature extends WNFeature {
    private final WNStructurePlacement placement;

    public WNTreeFeature(WNStructurePlacement placement) {
        this.placement = placement;
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        this.placement.load();
        var placement = this.placement.get(context.random());
        if (placement == null) {
            return false;
        }

        var structure = placement.structure();
        var height = structure.getMax().getY() + 1;

        for (int i = 1; i < height; i += 4) {
            BlockPos checkPos = context.origin().above(i);
            if (!context.level().getBlockState(checkPos).isAir()) {
                return false;
            }
        }

        structure.place(context.level(), context.origin().below(), Rotation.values()[ExtraMath.rint(0, 3, context.random())], placement.config(), context.random(), 19);

        return true;
    }
}
