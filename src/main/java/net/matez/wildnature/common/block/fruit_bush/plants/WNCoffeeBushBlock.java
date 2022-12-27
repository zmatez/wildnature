/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.fruit_bush.plants;

import net.matez.wildnature.common.block.WNBlockProperties;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_CoffeeBush;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import org.jetbrains.annotations.Nullable;

public class WNCoffeeBushBlock extends WNBelladonnaFruitPlantBlock{
    public static final IntegerProperty STAGE = WNBlockProperties.COFFEE_BUSH_STAGE;

    public WNCoffeeBushBlock(ResourceLocation location, Properties properties, FruitPlantType type) {
        super(location, properties, type);
        max = 2;
        this.LEAF_STAGE = STAGE;
    }

    public WNCoffeeBushBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, FruitPlantType type) {
        super(location, properties, itemProperties, type);
        max = 2;
        this.LEAF_STAGE = STAGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        def.add(HALF,STAGE);
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_CoffeeBush(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String texture = getTextureName("fruit_bushes/" + fruitType.getFolder()) + "_stage_";
        return new ModelList().with(
                new WNBlockModel_TintedCross(this.getRegName() + "_stage_0_bottom")
                        .with("texture",texture + "1_bottom"),
                new WNBlockModel_TintedCross(this.getRegName() + "_stage_0_top")
                        .with("texture",texture + "1_top"),

                new WNBlockModel_TintedCross(this.getRegName() + "_stage_1_bottom")
                        .with("texture",texture + "2_bottom"),
                new WNBlockModel_TintedCross(this.getRegName() + "_stage_1_top")
                        .with("texture",texture + "2_top"),

                new WNBlockModel_TintedCross(this.getRegName() + "_stage_2_bottom")
                        .with("texture",texture + "3_bottom"),
                new WNBlockModel_TintedCross(this.getRegName() + "_stage_2_top")
                        .with("texture",texture + "3_top")

        );
    }

    @Override
    public @Nullable BlockColor getBlockColor() {
        return null;
    }
}
