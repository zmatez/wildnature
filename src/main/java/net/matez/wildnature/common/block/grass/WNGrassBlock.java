/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.grass;

import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.core.registry.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeBottomTop;
import net.matez.wildnature.data.block_models.WNBlockModel_GrassBlock;
import net.matez.wildnature.data.blockstates.WNBlockstate_GrassBlock;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WNGrassBlock extends WNAbstractGrassBlock implements BonemealableBlock {
    private final GrassType grassType;

    public WNGrassBlock(ResourceLocation location, Properties properties, GrassType grassType) {
        super(location, properties);
        this.grassType = grassType;
    }

    public WNGrassBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, GrassType grassType) {
        super(location, properties, itemProperties);
        this.grassType = grassType;
    }

    public WNBlock getDirt(){
        return WNBlocks.DIRTS.get(grassType);
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.ENDERMAN_HOLDABLE, WNTags.MOSS_REPLACEABLE, WNTags.RABBITS_SPAWNABLE_ON, WNTags.AZALEA_GROWS_ON, WNTags.FORGE_DIRT,
                WNTags.BAMBOO_PLANTABLE_ON, WNTags.PARROTS_SPAWNABLE_ON, WNTags.LUSH_GROUND_REPLACEABLE, WNTags.AZALEA_ROOT_REPLACEABLE,
                WNTags.BIG_DRIPLEAF_REPLACEABLE, WNTags.VALID_SPAWN, WNTags.ANIMALS_SPAWNABLE_ON, WNTags.MINEABLE_SHOVEL, WNTags.DIRT,
                WNTags.WOLVES_SPAWNABLE_ON, WNTags.FOXES_SPAWNABLE_ON
        );
    }

    @Nullable
    @Override
    public BlockColor getBlockColor() {
        if(!this.grassType.isTinted()){
            return null;
        }
        return (state, getter, pos, num) -> {
            return getter != null && pos != null ? BiomeColors.getAverageGrassColor(getter, pos) : GrassColor.get(0.5D, 1.0D);
        };
    }

    @Nullable
    @Override
    public ItemColor getItemColor(BlockColors colors) {
        if(!this.grassType.isTinted()){
            return null;
        }
        return (stack, num) -> {
            BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
            return colors.getColor(blockstate, null, null, num);
        };
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_GrassBlock(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList()
                .with(
                        new WNBlockModel_GrassBlock(this.getRegName())
                                .with("texture", this.getTextureName("grass/" + this.grassType.getIdBase()))
                                .with("dirt", WNBlocks.DIRTS.get(this.grassType).getTextureName("grass/" + this.grassType.getIdBase())),
                        new WNBlockModel_CubeBottomTop(this.getRegName() + "_snow")
                                .with("texture_top", this.getTextureName("grass/" + this.grassType.getIdBase()) + "_top")
                                .with("texture_bottom", WNBlocks.DIRTS.get(this.grassType).getTextureName("grass/" + this.grassType.getIdBase()))
                                .with("texture_side", this.getTextureName("grass/" + this.grassType.getIdBase()) + "_side_snowed")
                );
    }
}