package net.matez.wildnature.common.objects.blocks.fruit_bush.plants;

import net.matez.wildnature.common.objects.blocks.fruit_bush.plants.stages.*;
import net.matez.wildnature.common.objects.blocks.leaves.LeafConfig;
import net.matez.wildnature.common.objects.blocks.plant.WNBushBlock;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FloweringBush;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_TypedFruitBush;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
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
import java.util.Random;

public abstract class WNFruitBushPlantTypedBlock extends WNBushBlock {
    public IntegerProperty LEAF_STAGE;
    protected final FruitPlantType fruitType;

    public WNFruitBushPlantTypedBlock(ResourceLocation location, Properties properties, FruitPlantType fruitType) {
        super(location, properties, fruitType.getConfig());
        this.fruitType = fruitType;
    }

    public WNFruitBushPlantTypedBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, FruitPlantType fruitType) {
        super(location, properties, itemProperties, fruitType.getConfig());
        this.fruitType = fruitType;
    }


    @Override
    public void construct() {
        super.construct();
        if (this.LEAF_STAGE != null) {
            this.registerDefaultState(this.defaultBlockState().setValue(this.LEAF_STAGE, 0));
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return this.LEAF_STAGE != null && state.getValue(this.LEAF_STAGE) != this.fruitType.getConfig().getStages()-1;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        super.randomTick(state, level, pos, random);
        if (this.LEAF_STAGE != null && state.getValue(this.LEAF_STAGE) != this.fruitType.getConfig().getStages()-1) {
            level.setBlock(pos, state.setValue(this.LEAF_STAGE, state.getValue(LEAF_STAGE) + 1), 2);
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
    public WNResource getBlockstate() {
        return new WNBlockstate_TypedFruitBush(this.getRegistryName(), this.fruitType.getConfig());
    }

    @Override
    public ModelList getBlockModels() {
        ModelList list = new ModelList();
        for (int i = 0; i < this.fruitType.getConfig().getStages(); i++) {
            FruitBushConfig.StageConfig config = this.fruitType.getConfig().getStageConfigs().get(i);
            WNResource model = null;
            
            String path = config == null || config.isPathRelativeToBlock() ? this.getTextureName("fruit_bushes/" + fruitType.getFolder()) : (this.getRegistryName().getNamespace() + ":blocks/fruit_bushes/" + fruitType.getFolder() + "/");

            int j = i + 1;
            if (config == null) {
                model = new WNBlockModel_TintedCross(this.getRegName() + "_stage_" + j)
                        .with("texture", path + "_stage_" + j);
            } else if (config.getCross() == null) {
                if (config.getOverlay() == null) {
                    model = new WNBlockModel_TintedCross(this.getRegName() + "_stage_" + j)
                            .with("texture", path + "_stage_" + j);
                } else {
                    model = new WNBlockModel_FloweringBush(this.getRegName() + "_stage_" + j)
                            .with("stalk", path + "_stage_" + j)
                            .with("texture", path + config.getOverlay());
                }
            } else {
                if (config.getOverlay() == null) {
                    model = new WNBlockModel_TintedCross(this.getRegName() + "_stage_" + j)
                            .with("texture", path + config.getCross());
                } else {
                    model = new WNBlockModel_FloweringBush(this.getRegName() + "_stage_" + j)
                            .with("stalk", path + config.getCross())
                            .with("texture", path + config.getOverlay());
                }
            }
            list.with(model);
        }

        return list;
    }

    @javax.annotation.Nullable
    public WNResource getItemModel() {
        return new WNItemModel_Generated(getRegName()).with("texture", this.getRegistryName().getNamespace() + ":blocks/fruit_bushes/" + fruitType.getFolder() + "/" + this.getRegName() + "_item");
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

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if (this.LEAF_STAGE != null) {
            ItemStack fruit = getFruit(state);
            {
                if (fruit != null) {
                    ArrayList<Integer> available = new ArrayList<>();
                    this.fruitType.getConfig().getStageConfigs().forEach((key,config) -> {
                        if(config.isAfterFruitCollect()){
                            available.add(key);
                        }
                    });

                    int stage = available.isEmpty() ? 0 : (available.get(WNUtil.rint(0,available.size())));

                    level.setBlock(pos, state.setValue(this.LEAF_STAGE, stage), 2);
                    Block.popResourceFromFace(level, pos, result.getDirection(), fruit);

                    return InteractionResult.SUCCESS;
                }
            }
        }

        return super.use(state, level, pos, player, hand, result);
    }

    @Nullable
    public ItemStack getFruit(BlockState state) {
        if (this.LEAF_STAGE != null) {
            int stage = state.getValue(this.LEAF_STAGE);
            if (fruitType.getConfig().getStageConfigs().containsKey(stage)) {
                LeafConfig.ItemConfig config = fruitType.getConfig().getStageConfigs().containsKey(stage) ? fruitType.getConfig().getStageConfigs().get(stage).getItemConfig() : null;
                if(config != null) {
                    Item item = config.getItem().get();
                    if (item != Items.AIR) {
                        return new ItemStack(item, config.getMin() == config.getMax() ? config.getMin() : (WNUtil.rint(config.getMin(), config.getMax())));
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

    public static WNFruitBushPlantTypedBlock create(ResourceLocation location, Properties properties, Item.Properties itemProperties, FruitPlantType leafType) {
        switch (leafType.getConfig().getStages()-1) {
            case 0 -> {
                return new WNFruitBushPlantBlock_Stage0(location, properties, itemProperties, leafType);
            }
            case 1 -> {
                return new WNFruitBushPlantBlock_Stage1(location, properties, itemProperties, leafType);
            }
            case 2 -> {
                return new WNFruitBushPlantBlock_Stage2(location, properties, itemProperties, leafType);
            }
            case 3 -> {
                return new WNFruitBushPlantBlock_Stage3(location, properties, itemProperties, leafType);
            }
            case 4 -> {
                return new WNFruitBushPlantBlock_Stage4(location, properties, itemProperties, leafType);
            }
            case 5 -> {
                return new WNFruitBushPlantBlock_Stage5(location, properties, itemProperties, leafType);
            }
            case 6 -> {
                return new WNFruitBushPlantBlock_Stage6(location, properties, itemProperties, leafType);
            }
            case 7 -> {
                return new WNFruitBushPlantBlock_Stage7(location, properties, itemProperties, leafType);
            }
            case 8 -> {
                return new WNFruitBushPlantBlock_Stage8(location, properties, itemProperties, leafType);
            }
        }

        return null;
    }
}
