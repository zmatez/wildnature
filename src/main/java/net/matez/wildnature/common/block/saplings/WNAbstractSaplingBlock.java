/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.saplings;

import net.matez.wildnature.common.block.plant.BushPlacement;
import net.matez.wildnature.common.block.plant.WNBushBlock;
import net.matez.wildnature.common.block.plant.config.BushConfig;
import net.matez.wildnature.common.block.WNBlockProperties;
import net.matez.wildnature.common.structures.WNStructure;
import net.matez.wildnature.common.structures.WNStructurePlacement;
import net.matez.wildnature.core.registry.WNItems;
import net.matez.wildnature.api.util.ExtraMath;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BoneMealItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;

import java.util.Random;

public abstract class WNAbstractSaplingBlock extends WNBushBlock implements BonemealableBlock {
    public static final IntegerProperty STAGE = BlockStateProperties.STAGE;
    public static final BooleanProperty FERTILIZED = WNBlockProperties.FERTILIZED;
    private final WNStructurePlacement placement, bigPlacement;

    public WNAbstractSaplingBlock(ResourceLocation location, Properties properties, WNStructurePlacement placement, WNStructurePlacement bigPlacement, BushPlacement bushPlacement) {
        super(location, properties, new BushConfig().withPlacement(bushPlacement));
        this.placement = placement;
        this.bigPlacement = bigPlacement;
    }

    public WNAbstractSaplingBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, WNStructurePlacement placement, WNStructurePlacement bigPlacement, BushPlacement bushPlacement) {
        super(location, properties, itemProperties, new BushConfig().withPlacement(bushPlacement));
        this.placement = placement;
        this.bigPlacement = bigPlacement;
    }

    @Override
    public void construct() {
        super.construct();
        registerDefaultState(defaultBlockState().setValue(FERTILIZED, false));
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (player.getItemInHand(hand).is(WNItems.FERTILIZER) && !state.getValue(FERTILIZED) && this.bigPlacement != null) {
            BoneMealItem.addGrowthParticles(level, pos, 0);
            level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0F, 1.0F, false);
            level.setBlock(pos, state.setValue(FERTILIZED, true), 3);
            return InteractionResult.SUCCESS;
        }
        return super.use(state, level, pos, player, hand, result);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if (level.getMaxLocalRawBrightness(pos.above()) >= 9 && random.nextInt(7) == 0) {
            if (!level.isAreaLoaded(pos, 1))
                return; // Forge: prevent loading unloaded chunks when checking neighbor's light
            this.place(level, pos, state, random);
        }
    }

    public void place(ServerLevel level, BlockPos pos, BlockState state, Random random) {
        if (state.getValue(STAGE) == 0) {
            level.setBlock(pos, state.cycle(STAGE), 3);
        } else {
            if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(level, random, pos)) return;
            WNStructurePlacement.Entry<WNStructure> struct = null;

            placement.load();
            if (this.bigPlacement != null) {
                bigPlacement.load();

                if (state.getValue(FERTILIZED)) {
                    struct = bigPlacement.get(random);
                }

                if (struct == null) {
                    struct = placement.get(random);
                }
            } else {
                struct = placement.get(random);
            }

            if (struct != null) {
                var structure = struct.structure();
                var height = structure.getMax().getY() + 1;

                for (int i = 1; i < height; i++) {
                    BlockPos checkPos = pos.above(i);
                    if (!level.getBlockState(checkPos).isAir()) {
                        return;
                    }
                }

                struct.structure().place(level, pos.below(), Rotation.values()[ExtraMath.rint(0, 3, random)], struct.config(), random, 3);
            }
        }
    }

    @Override
    public boolean isValidBonemealTarget(BlockGetter p_55991_, BlockPos p_55992_, BlockState p_55993_, boolean p_55994_) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level p_55996_, Random p_55997_, BlockPos p_55998_, BlockState p_55999_) {
        return (double) p_55996_.random.nextFloat() < 0.45D;
    }

    @Override
    public void performBonemeal(ServerLevel p_55986_, Random p_55987_, BlockPos p_55988_, BlockState p_55989_) {
        this.place(p_55986_, p_55988_, p_55989_, p_55987_);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        def.add(STAGE, FERTILIZED);
    }
}
