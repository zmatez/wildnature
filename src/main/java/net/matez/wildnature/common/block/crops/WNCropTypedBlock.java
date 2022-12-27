/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.crops;

import net.matez.wildnature.common.block.crops.stages.*;
import net.matez.wildnature.common.block.plant.WNBushBlock;
import net.matez.wildnature.common.item.vegetables.WNVeggieBlockItem;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.core.registry.WNBlocks;
import net.matez.wildnature.core.registry.WNItems;
import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_Crop;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_TypedCropBush;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public abstract class WNCropTypedBlock extends WNBushBlock {
    public IntegerProperty STAGE;
    protected final CropType cropType;

    public WNCropTypedBlock(ResourceLocation location, Properties properties, CropType cropType) {
        super(location, properties, cropType.getConfig());
        this.cropType = cropType;
    }

    public WNCropTypedBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, CropType cropType) {
        super(location, properties, cropType.getConfig());
        this.cropType = cropType;


        this.item = new WNVeggieBlockItem(this,itemProperties,cropType.getVeggie());
        this.item.setRegistryName(location);
        WNBlocks.BLOCK_ITEMS.put(location, this.item);
    }

    @Override
    public void construct() {
        super.construct();
        if (this.STAGE != null) {
            this.registerDefaultState(this.defaultBlockState().setValue(this.STAGE, 0));
        }
    }

    @Override
    public void onItemConstruct() {
        super.onItemConstruct();
        WNItems.VEGGIES.put(cropType.getVeggie(), this.item);
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return this.STAGE != null && state.getValue(this.STAGE) != this.cropType.getStages() - 1;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        super.randomTick(state, level, pos, random);
        if (this.STAGE != null && state.getValue(this.STAGE) != this.cropType.getStages() - 1) {
            level.setBlock(pos, state.setValue(this.STAGE, state.getValue(STAGE) + 1), 2);
        }
    }

    @Nullable
    @Override
    public BlockColor getBlockColor() {
        return null;
    }

    @Nullable
    @Override
    public ItemColor getItemColor(BlockColors colors) {
        return null;
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_TypedCropBush(this.getRegistryName(), this.cropType.getStages());
    }

    @Override
    public ModelList getBlockModels() {
        ModelList list = new ModelList();
        if(this.cropType.getStages() > 1) {
            for (int i = 0; i < this.cropType.getStages(); i++) {
                int j = i + 1;
                WNResource model = new WNBlockModel_Crop(this.getRegName() + "_stage_" + j)
                        .with("texture", this.getTextureName("crops/" + cropType.getFolder()) + "_plant_stage_" + j);
                list.with(model);
            }
        }else{
            WNResource model = new WNBlockModel_Crop(this.getRegName())
                    .with("texture", this.getTextureName("crops/" + cropType.getFolder()));
            list.with(model);
        }
        return list;
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.NONE;
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        return WNBushBlock.SHAPE;
    }

    @Override
    public WNResource getItemModel(){
        return this.item instanceof WNVeggieBlockItem item ? item.getItemModel() : null;
    }

    @Nullable
    @Override
    public DropList getDrops(BlockState state, ServerLevel level, float luck) {
        ItemStack fruit = getFruit(state);
        if (fruit != null) {
            return new DropList().with(fruit);
        }
        return super.getDrops(state, level, luck);
    }

    @Nullable
    public ItemStack getFruit(BlockState state) {
        if (this.STAGE != null) {
            if(isGrowth(state)){
                return new ItemStack(WNItems.VEGGIES.get(this.cropType.getVeggie()), ExtraMath.rint(1,cropType.getMaxDrop()));
            }
        }
        return null;
    }

    public boolean isGrowth(BlockState state){
        return state.getValue(STAGE) == cropType.getStages() - 1;
    }

    public static IntegerProperty getStage(BlockState state) {
        if (state.getBlock() instanceof WNCropTypedBlock block) {
            if (block instanceof WNCropBlock_Stage0) {
                return WNCropBlock_Stage0.STAGE_;
            } else if (block instanceof WNCropBlock_Stage1) {
                return WNCropBlock_Stage1.STAGE_;
            } else if (block instanceof WNCropBlock_Stage2) {
                return WNCropBlock_Stage2.STAGE_;
            } else if (block instanceof WNCropBlock_Stage3) {
                return WNCropBlock_Stage3.STAGE_;
            } else if (block instanceof WNCropBlock_Stage4) {
                return WNCropBlock_Stage4.STAGE_;
            } else if (block instanceof WNCropBlock_Stage5) {
                return WNCropBlock_Stage5.STAGE_;
            } else if (block instanceof WNCropBlock_Stage6) {
                return WNCropBlock_Stage6.STAGE_;
            } else if (block instanceof WNCropBlock_Stage7) {
                return WNCropBlock_Stage7.STAGE_;
            } else if (block instanceof WNCropBlock_Stage8) {
                return WNCropBlock_Stage8.STAGE_;
            }
        }
        return null;
    }

    public static WNCropTypedBlock create(ResourceLocation location, Properties properties, Item.Properties itemProperties, CropType cropType) {
        switch (cropType.getStages()-1) {
            case 0 -> {
                return new WNCropBlock_Stage0(location, properties, itemProperties, cropType);
            }
            case 1 -> {
                return new WNCropBlock_Stage1(location, properties, itemProperties, cropType);
            }
            case 2 -> {
                return new WNCropBlock_Stage2(location, properties, itemProperties, cropType);
            }
            case 3 -> {
                return new WNCropBlock_Stage3(location, properties, itemProperties, cropType);
            }
            case 4 -> {
                return new WNCropBlock_Stage4(location, properties, itemProperties, cropType);
            }
            case 5 -> {
                return new WNCropBlock_Stage5(location, properties, itemProperties, cropType);
            }
            case 6 -> {
                return new WNCropBlock_Stage6(location, properties, itemProperties, cropType);
            }
            case 7 -> {
                return new WNCropBlock_Stage7(location, properties, itemProperties, cropType);
            }
            case 8 -> {
                return new WNCropBlock_Stage8(location, properties, itemProperties, cropType);
            }
        }

        return null;
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.CROPS
        );
    }
}
