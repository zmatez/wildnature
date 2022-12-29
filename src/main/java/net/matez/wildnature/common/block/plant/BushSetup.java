/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.plant;

import net.matez.wildnature.common.block.plant.config.FloweringBushConfig;
import net.matez.wildnature.common.block.plant.flowering.*;
import net.matez.wildnature.common.block.plant.plants.*;
import net.matez.wildnature.common.block.plant.vines.WNFloweringVineBlock;
import net.matez.wildnature.core.registry.WNBlocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Function;

public enum BushSetup {

    BUSH(variant -> variant.getVariant().getBaseName() + ((variant.getVariantName() != null && !variant.getVariantName().equals("")) ? "_" + variant.getVariantName() : ""),(variant, blockProp) -> {
        return new WNBushConfiguredBlock(blockProp, variant);
    }),
    FLOWERING_BUSH(variant -> {
        String name = variant.getVariant().getBaseName() + "_" + variant.getColorName();
        if(variant.hasConfig() && variant.getConfig() instanceof FloweringBushConfig flowerConfig){
            if(!flowerConfig.hasColorVariants()){
                name = variant.getVariant().getBaseName();
            }
        }
        return name;
    }, (variant, blockProp) -> {
        return new WNFloweringBushBlock(blockProp, variant);
    }),
    FLOWERING_LEAFED_BUSH(variant -> {
        String name = variant.getVariant().getBaseName() + "_" + variant.getColorName();
        if(variant.hasConfig() && variant.getConfig() instanceof FloweringBushConfig flowerConfig){
            if(!flowerConfig.hasColorVariants()){
                name = variant.getVariant().getBaseName();
            }
        }
        return name;
    }, (variant, blockProp) -> {
        return new WNFloweringBushBlock(blockProp, variant);
    }),
    BIG_BUSH(variant -> {
        String name = variant.getVariant().getBaseName() + "_" + variant.getColorName();
        if(variant.hasConfig() && variant.getConfig() instanceof FloweringBushConfig flowerConfig){
            if(!flowerConfig.hasColorVariants()){
                name = variant.getVariant().getBaseName();
            }
        }
        return name;
    }, (variant, blockProp) -> {

        return new WNFloweringBushBlock(blockProp, variant);
    }),
    DOUBLE_FLOWERING_BUSH(variant -> {
        String name = variant.getVariant().getBaseName() + "_" + variant.getColorName();
        if(variant.hasConfig() && variant.getConfig() instanceof FloweringBushConfig flowerConfig){
            if(!flowerConfig.hasColorVariants()){
                name = variant.getVariant().getBaseName();
            }
        }
        return name;
    }, (variant, blockProp) -> {
        BlockBehaviour.Properties blockPropNew = BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.PLANT).sound(SoundType.GRASS).instabreak().noOcclusion().noCollission().randomTicks();
        return new WNDoubleFloweringBushBlock(blockPropNew, variant);
    }),
    DOUBLE_BUSH(variant -> variant.getVariant().getBaseName() + ((variant.getVariantName() != null && !variant.getVariantName().equals("")) ? "_" + variant.getVariantName() : ""), (variant, blockProp) -> {
        BlockBehaviour.Properties blockPropNew = BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.PLANT).sound(SoundType.GRASS).instabreak().noOcclusion().noCollission().randomTicks();
        return new WNDoublePlantBlock(blockPropNew, variant);
    }),
    DOUBLE_FLOWERING_LEAFED_BUSH(variant -> {
        String name = variant.getVariant().getBaseName() + "_" + variant.getColorName();
        if(variant.hasConfig() && variant.getConfig() instanceof FloweringBushConfig flowerConfig){
            if(!flowerConfig.hasColorVariants()){
                name = variant.getVariant().getBaseName();
            }
        }
        return name;
    }, (variant, blockProp) -> {
        BlockBehaviour.Properties blockPropNew = BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.PLANT).sound(SoundType.GRASS).instabreak().noOcclusion().noCollission().randomTicks();
        return new WNDoubleFloweringBushBlock(blockPropNew, variant);
    }),
    CLOVER(simpleId(), (variant, blockProp) -> {
        return new WNCloverBlock(blockProp,variant);
    }),
    ANEMONE(simpleId(), (variant, blockProp) -> {
        return new WNAnemoneFlowerBlock(blockProp,variant);
    }),
    THISTLE(simpleId(), (variant, blockProp) -> {
        return new WNThistleBlock(blockProp,variant);
    }),
    SHRUB(simpleId(), (variant, blockProp) -> {
        return new WNBushConfiguredBlock(blockProp,variant);
    }),
    SPIDERGRASS(simpleId(), (variant, blockProp) -> {
        return new WNSpiderGrassBlock(blockProp,variant);
    }),
    SMALL_CACTI(simpleId(), (variant, blockProp) -> {
        return new WNSmallCactiBlock(blockProp,variant);
    }),
    NETTLE(simpleId(), (variant, blockProp) -> {
        return new WNNettleBlock(blockProp,variant);
    }),
    POISON_IVY(simpleId(), (variant, blockProp) -> {
        return new WNPoisonIvyBlock(blockProp,variant);
    }),
    SUCCULENT(simpleId(), (variant, blockProp) -> {
        return new WNBushConfiguredBlock(blockProp,variant);
    }),
    PRICKLY_PEAR(simpleId(), (variant, blockProp) -> {
        return new WNPricklyPearCactus(blockProp,variant);
    }),
    FLY_TRAP(simpleId(), (variant, blockProp) -> {
        return new WNBushConfiguredBlock(blockProp,variant);
    }),
    CHINESE_LANTERN_FLOWER(simpleId(), (variant, blockProp) -> {
        return new WNChineseLanternFlowerBlock(blockProp,variant);
    }),
    LICHEN(simpleId(), (variant, blockProp) -> {
        return new WNLichenBlock(blockProp,variant);
    }),
    REEDS(simpleId(), (variant, blockProp) -> {
        return new WNReedsBlock(blockProp,variant);
    }),
    RIVER_CANE(simpleId(), (variant, blockProp) -> {
        return new WNRiverCaneBlock(blockProp,variant);
    }),
    WISTERIA(variant -> {
        String name = variant.getVariant().getBaseName() + "_" + variant.getColorName();
        if(variant.hasConfig() && variant.getConfig() instanceof FloweringBushConfig flowerConfig){
            if(!flowerConfig.hasColorVariants()){
                name = variant.getVariant().getBaseName();
            }
        }
        return name;
    },(variant, blockProp) -> {
        return new WNWisteriaBlock(blockProp, variant);
    }),
    YUCCA(simpleId(), (variant, blockProp) -> {
        return new WNYuccaBlock(blockProp,variant);
    }),
    STRANGLING_VINE(simpleId(), (variant, blockProp) -> {
        return new WNStranglingVineBlock(blockProp.strength(0.3F),variant);
    }),
    FLOWERING_VINE(variant -> {
        String name = variant.getVariant().getBaseName() + "_" + variant.getColorName();
        if(variant.hasConfig() && variant.getConfig() instanceof FloweringBushConfig flowerConfig){
            if(!flowerConfig.hasColorVariants()){
                name = variant.getVariant().getBaseName();
            }
        }
        return name;
    }, (variant, blockProp) -> {
        return new WNFloweringVineBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().randomTicks().strength(0.2F).sound(SoundType.VINE), variant);
    }),
    COTTON(simpleId(), (variant, blockProp) -> {
        return new WNCottonBlock(blockProp,variant);
    });
    private BushConstructor<BushType> constructor;
    private Function<BushType, String> nameGetter;

    BushSetup(Function<BushType, String> nameGetter, BushConstructor<BushType> constructor) {
        this.constructor = constructor;
        this.nameGetter = nameGetter;
    }

    public String createId(BushType type) {
        return nameGetter.apply(type);
    }
    public BushConstructor<BushType> getConstructor() {
        return constructor;
    }

    public static Function<BushType, String> simpleId() {
        return variant -> variant.getVariant().getBaseName();
    }
}
