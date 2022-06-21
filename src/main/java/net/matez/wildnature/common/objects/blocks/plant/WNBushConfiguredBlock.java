/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.plant;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.blockstates.WNBlockstate_Cube;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class WNBushConfiguredBlock extends WNBushBlock implements net.minecraftforge.common.IPlantable {
    private BushType type;
    private static final double OFFSET = 3D;
    protected static final VoxelShape SHAPE = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 10.0D, 16.0D - OFFSET);

    public WNBushConfiguredBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties,type.getConfig());
        this.type = type;
    }

    public WNBushConfiguredBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties,type.getConfig());
        this.type = type;
    }

    protected boolean mayPlaceOn(BlockState state, BlockState stateOn, BlockGetter getter, BlockPos pos) {
        return getType().hasConfig() ? getType().getConfig().getPlacement().getSupplier().canPlace(state,stateOn,getter,pos) : BushPlacement.DIRT.getSupplier().canPlace(state,stateOn,getter,pos);
    }

    public BlockState updateShape(BlockState p_51032_, Direction p_51033_, BlockState p_51034_, LevelAccessor p_51035_, BlockPos p_51036_, BlockPos p_51037_) {
        return !p_51032_.canSurvive(p_51035_, p_51036_) ? Blocks.AIR.defaultBlockState() : super.updateShape(p_51032_, p_51033_, p_51034_, p_51035_, p_51036_, p_51037_);
    }

    public BushType getType() {
        return type;
    }

    @Nullable
    @Override
    public BlockColor getBlockColor() {
        if (this.getType().hasConfig() && !this.getType().getConfig().isTinted()) {
            return null;
        }
        return (state, getter, pos, num) -> {
            if(this.getType().hasConfig() && this.getType().getConfig().isGrassTint()){
                return getter != null && pos != null ? BiomeColors.getAverageGrassColor(getter, pos) : GrassColor.get(0.5D, 1.0D);
            }
            return getter != null && pos != null ? BiomeColors.getAverageFoliageColor(getter, pos) : FoliageColor.get(0.5D, 1.0D);
        };
    }

    @Nullable
    @Override
    public ItemColor getItemColor(BlockColors colors) {
        if (!this.getType().hasConfig() || (this.getType().hasConfig() && !this.getType().getConfig().isItemTinted())) {
            return null;
        }
        return (stack, num) -> {
            BlockState blockstate = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return colors.getColor(blockstate, null, null, num);
        };
    }

    @javax.annotation.Nullable
    public WNResource getItemModel() {
        if(getType().hasConfig() && getType().getConfig().isItemAsSelf()){
            return new WNItemModel_Generated(getRegName()).with("texture", this.getTextureName(getType().getVariant().getPath()));
        }
        if (getType().getItem() == null) {
            return new WNItemModel_Generated(getRegName()).with("texture", this.getTextureName(getType().getVariant().getPath()) + "_item");
        }

        return new WNItemModel_Generated(getRegName()).with("texture", this.getRegistryName().getNamespace() + ":blocks/" + getType().getVariant().getPath() + "/" + getType().getItem());
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Cube(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new WNBlock.ModelList().with(
                new WNBlockModel_TintedCross(this.getRegName()).with("texture", this.getTextureName(getType().getVariant().getPath()))
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.FLOWERS, WNTags.SMALL_FLOWERS, WNTags.ENDERMAN_HOLDABLE, WNTags.WN_FLOWERING_PLANTS
        );
    }
}
