/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.water_plants;

import net.matez.wildnature.common.objects.blocks.plant.WNBushBlock;
import net.matez.wildnature.common.objects.blocks.plant.config.BushConfig;
import net.matez.wildnature.common.objects.items.waterlilies.WNWaterLilyBlockItem;
import net.matez.wildnature.common.registry.items.WNItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public abstract class WNWaterlilyBlock extends WNBushBlock {
    public static BushConfig config = new BushConfig();
    protected final WaterPlant waterPlant;

    private static final double OFFSET = 2D;
    protected static final VoxelShape SHAPE = Block.box(OFFSET, 0.0D, OFFSET, 16.0D - OFFSET, 1.0D, 16.0D - OFFSET);

    public WNWaterlilyBlock(ResourceLocation location, Properties properties, WaterPlant waterPlant) {
        super(location, properties, config);
        this.waterPlant = waterPlant;
    }

    public WNWaterlilyBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, WaterPlant waterPlant) {
        super(location, properties, itemProperties, config);
        this.waterPlant = waterPlant;
    }

    @Override
    public void createBlockItem(Item.Properties itemProperties) {
        this.item = new WNWaterLilyBlockItem(this,itemProperties);
        this.item.setRegistryName(this.getRegistryName());
        WNItems.BLOCK_ITEMS.put(this.getRegistryName(), this.item);
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.XZ;
    }

    public VoxelShape getShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        Vec3 vec3 = state.getOffset(getter, pos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockState stateOn, BlockGetter getter, BlockPos pos) {
        FluidState fluidstate = getter.getFluidState(pos);
        FluidState fluidstate1 = getter.getFluidState(pos.above());
        return (fluidstate.getType() == Fluids.WATER || state.getMaterial() == Material.ICE) && fluidstate1.getType() == Fluids.EMPTY;
    }
}
