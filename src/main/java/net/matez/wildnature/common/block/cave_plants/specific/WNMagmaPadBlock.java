/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.cave_plants.specific;

import net.matez.wildnature.common.block.cave_plants.CavePlantType;
import net.matez.wildnature.common.block.WNBlockProperties;
import net.matez.wildnature.common.block.water_plants.WNWaterlilyBlock;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_Lilypad;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_LilyPad;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Difficulty;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.ticks.TickPriority;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Predicate;

public class WNMagmaPadBlock extends WNWaterlilyBlock {
    protected final CavePlantType cavePlantType;
    public static BooleanProperty CRACK = WNBlockProperties.CRACK;

    public WNMagmaPadBlock(ResourceLocation location, Properties properties, CavePlantType cavePlantType) {
        super(location, properties, null);
        this.cavePlantType = cavePlantType;
    }

    public WNMagmaPadBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, CavePlantType cavePlantType) {
        super(location, properties, itemProperties, null);
        this.cavePlantType = cavePlantType;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        super.createBlockStateDefinition(def);
        def.add(CRACK);
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.defaultBlockState().setValue(CRACK, false));
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_LilyPad(this.getRegistryName());
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        return new WNItemModel_Generated(this.getRegName()).with("texture", this.getTextureName("plants/cave/" + this.cavePlantType.getFolder()) + "_item");
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_Lilypad(this.getRegName() + "_1").with("texture", this.getTextureName("plants/cave/" + this.cavePlantType.getFolder()) + "_1"),
                new WNBlockModel_Lilypad(this.getRegName() + "_2").with("texture", this.getTextureName("plants/cave/" + this.cavePlantType.getFolder()) + "_2"),
                new WNBlockModel_Lilypad(this.getRegName() + "_3").with("texture", this.getTextureName("plants/cave/" + this.cavePlantType.getFolder()) + "_3"),
                new WNBlockModel_Lilypad(this.getRegName() + "_4").with("texture", this.getTextureName("plants/cave/" + this.cavePlantType.getFolder()) + "_4")
        );
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockState stateOn, BlockGetter getter, BlockPos pos) {
        FluidState fluidstate = getter.getFluidState(pos);
        return (fluidstate.getType() == Fluids.LAVA);
    }

    @Override
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        super.entityInside(state, level, pos, entity);
        if (entity instanceof LivingEntity && (!(entity instanceof Player) || !(((Player) entity).isCreative())) && !state.getValue(CRACK)) {
            level.setBlock(pos, state.setValue(CRACK, true), 2);
            if (level.getDifficulty() != Difficulty.PEACEFUL) {
                int time = 60;
                if (level.getDifficulty() == Difficulty.EASY) {
                    time = 80;
                } else if (level.getDifficulty() == Difficulty.NORMAL) {
                    time = 40;
                } else {
                    time = 10;
                }
                level.scheduleTick(pos, this, time, TickPriority.NORMAL);
            }
        }
    }

    @Override
    public void tick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        super.tick(state, level, pos, random);
        if (level.getBlockState(pos).getValue(CRACK)) {
            Predicate<LivingEntity> predicate = new Predicate<LivingEntity>() {
                @Override
                public boolean test(LivingEntity entity) {
                    return (entity.getY() >= pos.getY() && entity.getY() < pos.getY() + 4 && entity.getBlockX() == pos.getX() && entity.getBlockZ() == pos.getZ());
                }
            };
            ArrayList<LivingEntity> entities = new ArrayList<>(level.getEntitiesOfClass(LivingEntity.class, new AABB(pos), predicate));
            if (!entities.isEmpty()) {
                level.destroyBlock(pos, false);
            } else {
                level.setBlock(pos, level.getBlockState(pos).setValue(CRACK, false), 2);
            }
        }
    }

    @Override
    public @Nullable BlockColor getBlockColor() {
        return null;
    }
}
