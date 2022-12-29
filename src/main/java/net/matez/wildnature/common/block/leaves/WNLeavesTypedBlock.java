/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.leaves;

import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.common.WNBlock;
import net.matez.wildnature.common.block.leaves.stages.*;
import net.matez.wildnature.common.structures.WNStructure;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

public abstract class WNLeavesTypedBlock extends LeavesBlock implements WNBlock {

    private final LeafType leafType;

    public WNLeavesTypedBlock(Properties properties, LeafType leafType) {
        super(properties);
        this.leafType = leafType;
        if (this.getLeafStageProperty() != null) {
            this.registerDefaultState(this.defaultBlockState().setValue(this.getLeafStageProperty(), 0));
        }
    }

    public static IntegerProperty getStage(BlockState state) {
        if (state.getBlock() instanceof WNLeavesTypedBlock block) {
            if (block instanceof WNLeavesTypedBlock_Stage0) {
                return WNLeavesTypedBlock_Stage0.STAGE;
            } else if (block instanceof WNLeavesTypedBlock_Stage1) {
                return WNLeavesTypedBlock_Stage1.STAGE;
            } else if (block instanceof WNLeavesTypedBlock_Stage2) {
                return WNLeavesTypedBlock_Stage2.STAGE;
            } else if (block instanceof WNLeavesTypedBlock_Stage3) {
                return WNLeavesTypedBlock_Stage3.STAGE;
            } else if (block instanceof WNLeavesTypedBlock_Stage4) {
                return WNLeavesTypedBlock_Stage4.STAGE;
            } else if (block instanceof WNLeavesTypedBlock_Stage5) {
                return WNLeavesTypedBlock_Stage5.STAGE;
            } else if (block instanceof WNLeavesTypedBlock_Stage6) {
                return WNLeavesTypedBlock_Stage6.STAGE;
            } else if (block instanceof WNLeavesTypedBlock_Stage7) {
                return WNLeavesTypedBlock_Stage7.STAGE;
            } else if (block instanceof WNLeavesTypedBlock_Stage8) {
                return WNLeavesTypedBlock_Stage8.STAGE;
            } else if (block instanceof WNLeavesTypedBlock_Stage9) {
                return WNLeavesTypedBlock_Stage9.STAGE;
            }
        }
        return null;
    }

    public static WNLeavesTypedBlock create(Properties properties, LeafType leafType) {
        switch (leafType.getConfig().getStages()) {
            case 0 -> {
                return new WNLeavesTypedBlock_Stage0(properties, leafType);
            }
            case 1 -> {
                return new WNLeavesTypedBlock_Stage1(properties, leafType);
            }
            case 2 -> {
                return new WNLeavesTypedBlock_Stage2(properties, leafType);
            }
            case 3 -> {
                return new WNLeavesTypedBlock_Stage3(properties, leafType);
            }
            case 4 -> {
                return new WNLeavesTypedBlock_Stage4(properties, leafType);
            }
            case 5 -> {
                return new WNLeavesTypedBlock_Stage5(properties, leafType);
            }
            case 6 -> {
                return new WNLeavesTypedBlock_Stage6(properties, leafType);
            }
            case 7 -> {
                return new WNLeavesTypedBlock_Stage7(properties, leafType);
            }
            case 8 -> {
                return new WNLeavesTypedBlock_Stage8(properties, leafType);
            }
            case 9 -> {
                return new WNLeavesTypedBlock_Stage9(properties, leafType);
            }
        }

        return null;
    }

    public abstract IntegerProperty getLeafStageProperty();

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(PERSISTENT) || (this.getLeafStageProperty() != null && this.leafType.getConfig().isFlowering() && state.getValue(this.getLeafStageProperty()) == 1);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        if (state.getValue(PERSISTENT)) {
            if (this.getLeafStageProperty() != null && this.leafType.getConfig().isFlowering() && state.getValue(this.getLeafStageProperty()) == 1) {
                level.setBlock(pos, state.setValue(this.getLeafStageProperty(), ExtraMath.rint(2, leafType.getConfig().getStages())), 2);
            }
        }
    }

    @Nullable
    @Override
    public BlockColor getBlockColor() {
        if (this.leafType.isTinted()) {
            return (a, b, c, d) -> {
                return b != null && c != null ? BiomeColors.getAverageFoliageColor(b, c) : FoliageColor.getDefaultColor();
            };
        }
        return null;
    }

    @Nullable
    @Override
    public ItemColor getItemColor(BlockColors colors) {
        if (!this.leafType.isTinted() || !this.leafType.getConfig().isItemTinted()) {
            return null;
        }
        return (stack, num) -> {
            BlockState blockstate = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
            return colors.getColor(blockstate, null, null, num);
        };
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (this.getLeafStageProperty() != null) {
            ItemStack fruit = getFruit(state);
            if (fruit != null) {
                level.setBlock(pos, state.setValue(this.getLeafStageProperty(), 0), 2);
                Block.popResourceFromFace(level, pos, result.getDirection(), fruit);

                return InteractionResult.SUCCESS;
            }
        }

        return super.use(state, level, pos, player, hand, result);
    }

    @Nullable
    public ItemStack getFruit(BlockState state) {
        if (this.getLeafStageProperty() != null) {
            int stage = state.getValue(this.getLeafStageProperty());
            if (leafType.getConfig().getStageDrops().containsKey(stage)) {
                LeafConfig.ItemConfig config = leafType.getConfig().getStageDrops().get(stage);
                Item item = config.getItem().get();
                if (item != Items.AIR) {
                    return new ItemStack(item, config.getMin() == config.getMax() ? config.getMin() : (ExtraMath.rint(config.getMin(), config.getMax())));
                }
            }
        }
        return null;
    }

    public LeafType getLeafType() {
        return leafType;
    }

    @Override
    public BlockState processStateOnPlace(LevelAccessor accessor, BlockState state, BlockPos pos, WNStructure structure, RandomSource random, @Nullable Rotation rotation) {
        var config = this.getLeafType().getConfig();
        if (config == null || (!config.isFlowering() && config.getStages() < 1)) {
            return state;
        }

        if (ExtraMath.rint(0, 8, random) == 0) {
            if (config.isFlowering()) {
                if (config.getStages() > 1) {
                    if (ExtraMath.rint(0, 3, random) == 0) {
                        return state.setValue(getLeafStageProperty(), ExtraMath.rint(2, config.getStages(), random));
                    } else {
                        return state.setValue(getLeafStageProperty(), 1);
                    }
                } else {
                    return state.setValue(getLeafStageProperty(), 1);
                }
            } else {
                if (config.getStages() >= 1) {
                    if (ExtraMath.rint(0, 3, random) == 0) {
                        return state.setValue(getLeafStageProperty(), ExtraMath.rint(1, config.getStages(), random));
                    }
                }
            }
        }

        return state;
    }
}
