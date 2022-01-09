package net.matez.wildnature.common.objects.blocks.plant;

import net.matez.wildnature.common.objects.blocks.plant.config.BushConfig;
import net.matez.wildnature.common.objects.blocks.plant.config.FloweringBushConfig;
import net.matez.wildnature.common.objects.blocks.plant.flowering.*;
import net.matez.wildnature.common.objects.blocks.plant.plants.*;
import net.matez.wildnature.common.objects.blocks.plant.vines.WNFloweringVineBlock;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public enum BushSetup {
    BUSH((variant, blockProp, itemProp) -> {
        String name = variant.getVariant().getBaseName() + ((variant.getVariantName() != null && !variant.getVariantName().equals("")) ? "_" + variant.getVariantName() : "");
        return new WNBushConfiguredBlock(
                WNBlocks.location(name), blockProp, itemProp,
                variant
        );
    }),
    FLOWERING_BUSH((variant, blockProp, itemProp) -> {
        String name = variant.getVariant().getBaseName() + "_" + variant.getColorName();
        if(variant.hasConfig() && variant.getConfig() instanceof FloweringBushConfig flowerConfig){
            if(!flowerConfig.hasColorVariants()){
                name = variant.getVariant().getBaseName();
            }
        }
        return new WNFloweringBushBlock(
                WNBlocks.location(name), blockProp, itemProp,
                variant
        );
    }),
    FLOWERING_LEAFED_BUSH((variant, blockProp, itemProp) -> {
        String name = variant.getVariant().getBaseName() + "_" + variant.getColorName();
        if(variant.hasConfig() && variant.getConfig() instanceof FloweringBushConfig flowerConfig){
            if(!flowerConfig.hasColorVariants()){
                name = variant.getVariant().getBaseName();
            }
        }
        return new WNFloweringLeafedBushBlock(
                WNBlocks.location(name), blockProp, itemProp,
                variant
        );
    }),
    BIG_BUSH((variant, blockProp, itemProp) -> {
        String name = variant.getVariant().getBaseName() + "_" + variant.getColorName();
        if(variant.hasConfig() && variant.getConfig() instanceof FloweringBushConfig flowerConfig){
            if(!flowerConfig.hasColorVariants()){
                name = variant.getVariant().getBaseName();
            }
        }
        return new WNBigBushBlock(
                WNBlocks.location(name), blockProp, itemProp,
                variant
        );
    }),
    DOUBLE_FLOWERING_BUSH((variant, blockProp, itemProp) -> {
        BlockBehaviour.Properties blockPropNew = BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.PLANT)
                .sound(SoundType.GRASS)
                .instabreak()
                .noOcclusion()
                .noCollission()
                .randomTicks();
        String name = variant.getVariant().getBaseName() + "_" + variant.getColorName();
        if(variant.hasConfig() && variant.getConfig() instanceof FloweringBushConfig flowerConfig){
            if(!flowerConfig.hasColorVariants()){
                name = variant.getVariant().getBaseName();
            }
        }
        return new WNDoubleFloweringBushBlock(
                WNBlocks.location(name), blockPropNew, itemProp,
                variant
        );
    }),
    DOUBLE_BUSH((variant, blockProp, itemProp) -> {
        BlockBehaviour.Properties blockPropNew = BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.PLANT)
                .sound(SoundType.GRASS)
                .instabreak()
                .noOcclusion()
                .noCollission()
                .randomTicks();
        String name = variant.getVariant().getBaseName() + ((variant.getVariantName() != null && !variant.getVariantName().equals("")) ? "_" + variant.getVariantName() : "");

        return new WNDoublePlantBlock(
                WNBlocks.location(name), blockPropNew, itemProp,
                variant
        );
    }),
    DOUBLE_FLOWERING_LEAFED_BUSH((variant, blockProp, itemProp) -> {
        BlockBehaviour.Properties blockPropNew = BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT, MaterialColor.PLANT)
                .sound(SoundType.GRASS)
                .instabreak()
                .noOcclusion()
                .noCollission()
                .randomTicks();
        String name = variant.getVariant().getBaseName() + "_" + variant.getColorName();
        if(variant.hasConfig() && variant.getConfig() instanceof FloweringBushConfig flowerConfig){
            if(!flowerConfig.hasColorVariants()){
                name = variant.getVariant().getBaseName();
            }
        }
        return new WNDoubleFloweringLeafedBushBlock(
                WNBlocks.location(name), blockPropNew, itemProp,
                variant
        );
    }),
    CLOVER((variant, blockProp, itemProp) -> {
        return new WNCloverBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    MOSS((variant, blockProp, itemProp) -> {
        return new WNMossBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    ANEMONE((variant, blockProp, itemProp) -> {
        return new WNAnemoneFlowerBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    THISTLE((variant, blockProp, itemProp) -> {
        return new WNThistleBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    SHRUB((variant, blockProp, itemProp) -> {
        return new WNShrubBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    SPIDERGRASS((variant, blockProp, itemProp) -> {
        return new WNSpiderGrassBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    SMALL_CACTI((variant, blockProp, itemProp) -> {
        return new WNSmallCactiBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    NETTLE((variant, blockProp, itemProp) -> {
        return new WNNettleBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    POISON_IVY((variant, blockProp, itemProp) -> {
        return new WNPoisonIvyBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    SUCCULENT((variant, blockProp, itemProp) -> {
        return new WNSucculentBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    PRICKLY_PEAR((variant, blockProp, itemProp) -> {
        return new WNPricklyPearCactus(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    FLY_TRAP((variant, blockProp, itemProp) -> {
        return new WNFlytrapBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    CHINESE_LANTERN_FLOWER((variant, blockProp, itemProp) -> {
        return new WNChineseLanternFlowerBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    LICHEN((variant, blockProp, itemProp) -> {
        return new WNLichenBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    REEDS((variant, blockProp, itemProp) -> {
        return new WNReedsBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    RIVER_CANE((variant, blockProp, itemProp) -> {
        return new WNRiverCaneBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    WISTERIA((variant, blockProp, itemProp) -> {
        String name = variant.getVariant().getBaseName() + "_" + variant.getColorName();
        if(variant.hasConfig() && variant.getConfig() instanceof FloweringBushConfig flowerConfig){
            if(!flowerConfig.hasColorVariants()){
                name = variant.getVariant().getBaseName();
            }
        }
        return new WNWisteriaBlock(
                WNBlocks.location(name), blockProp, itemProp,
                variant
        );    }),
    YUCCA((variant, blockProp, itemProp) -> {
        return new WNYuccaBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp,itemProp,variant);
    }),
    STRANGLING_VINE((variant, blockProp, itemProp) -> {
        return new WNStranglingVineBlock(WNBlocks.location(variant.getVariant().getBaseName()),blockProp.strength(0.3F),itemProp,variant);
    }),
    FLOWERING_VINE((variant, blockProp, itemProp) -> {
        String name = variant.getVariant().getBaseName() + "_" + variant.getColorName();
        if(variant.hasConfig() && variant.getConfig() instanceof FloweringBushConfig flowerConfig){
            if(!flowerConfig.hasColorVariants()){
                name = variant.getVariant().getBaseName();
            }
        }
        return new WNFloweringVineBlock(
                WNBlocks.location(name), BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().randomTicks().strength(0.2F).sound(SoundType.VINE), itemProp,
                variant
        );    })
    ;
    private BushConstructor<BushType> constructor;

    BushSetup(BushConstructor<BushType> constructor) {
        this.constructor = constructor;
    }

    public BushConstructor<BushType> getConstructor() {
        return constructor;
    }
}
