/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.fruit_bush.plants;

import net.matez.wildnature.api.util.ExtraMath;
import net.matez.wildnature.common.block.fruit_bush.plants.stages.*;
import net.matez.wildnature.common.block.leaves.LeafConfig;
import net.matez.wildnature.common.block.plant.WNBushBlock;
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
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public abstract class WNFruitBushPlantTypedBlock extends WNBushBlock {
    protected final FruitPlantType fruitType;

    public WNFruitBushPlantTypedBlock(Properties properties, FruitPlantType fruitType) {
        super(properties, fruitType.getConfig());
        this.fruitType = fruitType;
        if (this.getLeafStageProperty() != null)
            this.registerDefaultState(this.defaultBlockState().setValue(this.getLeafStageProperty(), 0));
    }

    @Nullable
    public abstract IntegerProperty getLeafStageProperty();


    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return this.getLeafStageProperty() != null && state.getValue(this.getLeafStageProperty()) != this.fruitType.getConfig().getStages()-1;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        if (this.getConfig() != null && state.getValue(this.getLeafStageProperty()) != this.fruitType.getConfig().getStages()-1) {
            level.setBlock(pos, state.setValue(this.getLeafStageProperty(), state.getValue(getLeafStageProperty()) + 1), 2);
        }
    }

    @Nullable
    @Override
    public BlockColor getBlockColor() {
        if (this.fruitType.isTinted()) {
            return (a, b, c, d) -> {
                return b != null && c != null ? BiomeColors.getAverageFoliageColor(b, c) : FoliageColor.getDefaultColor();
            };
        }
        return null;
    }

    @Nullable
    @Override
    public ItemColor getItemColor(BlockColors colors) {
        return null;
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (this.getLeafStageProperty() != null) {
            ItemStack fruit = getFruit(state);
            {
                if (fruit != null) {
                    ArrayList<Integer> available = new ArrayList<>();
                    this.fruitType.getConfig().getStageConfigs().forEach((key,config) -> {
                        if(config.isAfterFruitCollect()){
                            available.add(key);
                        }
                    });

                    int stage = available.isEmpty() ? 0 : (available.get(ExtraMath.rint(0,available.size()-1)));

                    level.setBlock(pos, state.setValue(this.getLeafStageProperty(), stage), 2);
                    Block.popResourceFromFace(level, pos, result.getDirection(), fruit);

                    return InteractionResult.SUCCESS;
                }
            }
        }

        return super.use(state, level, pos, player, hand, result);
    }

    @Nullable
    public ItemStack getFruit(BlockState state) {
        if (this.getLeafStageProperty() != null) {
            int stage = state.getValue(this.getLeafStageProperty());
            if (fruitType.getConfig().getStageConfigs().containsKey(stage)) {
                LeafConfig.ItemConfig config = fruitType.getConfig().getStageConfigs().containsKey(stage) ? fruitType.getConfig().getStageConfigs().get(stage).getItemConfig() : null;
                if(config != null) {
                    Item item = config.getItem().get();
                    if (item != Items.AIR) {
                        return new ItemStack(item, config.getMin() == config.getMax() ? config.getMin() : (ExtraMath.rint(config.getMin(), config.getMax())));
                    }
                }
            }
        }
        return null;
    }

    public static IntegerProperty getStage(BlockState state) {
        if (state.getBlock() instanceof WNFruitBushPlantTypedBlock block) {
            if (block instanceof WNFruitBushPlantBlock_Stage0) {
                return WNFruitBushPlantBlock_Stage0.STAGE;
            } else if (block instanceof WNFruitBushPlantBlock_Stage1) {
                return WNFruitBushPlantBlock_Stage1.STAGE;
            } else if (block instanceof WNFruitBushPlantBlock_Stage2) {
                return WNFruitBushPlantBlock_Stage2.STAGE;
            } else if (block instanceof WNFruitBushPlantBlock_Stage3) {
                return WNFruitBushPlantBlock_Stage3.STAGE;
            } else if (block instanceof WNFruitBushPlantBlock_Stage4) {
                return WNFruitBushPlantBlock_Stage4.STAGE;
            } else if (block instanceof WNFruitBushPlantBlock_Stage5) {
                return WNFruitBushPlantBlock_Stage5.STAGE;
            } else if (block instanceof WNFruitBushPlantBlock_Stage6) {
                return WNFruitBushPlantBlock_Stage6.STAGE;
            } else if (block instanceof WNFruitBushPlantBlock_Stage7) {
                return WNFruitBushPlantBlock_Stage7.STAGE;
            } else if (block instanceof WNFruitBushPlantBlock_Stage8) {
                return WNFruitBushPlantBlock_Stage8.STAGE;
            }
        }
        return null;
    }

    public static WNFruitBushPlantTypedBlock create(Properties properties, FruitPlantType leafType) {
        switch (leafType.getConfig().getStages()-1) {
            case 0 -> {
                return new WNFruitBushPlantBlock_Stage0(properties, leafType);
            }
            case 1 -> {
                return new WNFruitBushPlantBlock_Stage1(properties, leafType);
            }
            case 2 -> {
                return new WNFruitBushPlantBlock_Stage2(properties, leafType);
            }
            case 3 -> {
                return new WNFruitBushPlantBlock_Stage3(properties, leafType);
            }
            case 4 -> {
                return new WNFruitBushPlantBlock_Stage4(properties, leafType);
            }
            case 5 -> {
                return new WNFruitBushPlantBlock_Stage5(properties, leafType);
            }
            case 6 -> {
                return new WNFruitBushPlantBlock_Stage6(properties, leafType);
            }
            case 7 -> {
                return new WNFruitBushPlantBlock_Stage7(properties, leafType);
            }
            case 8 -> {
                return new WNFruitBushPlantBlock_Stage8(properties, leafType);
            }
        }
        return null;
    }
}
