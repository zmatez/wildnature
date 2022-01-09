package net.matez.wildnature.common.objects.blocks.fruit_bush.plants;

import net.matez.wildnature.common.objects.blocks.plant.BushType;
import net.matez.wildnature.common.objects.blocks.plant.WNDoublePlantBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_FloweringBush;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_LeafedFloweringBush;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_ChineseLanternFlower;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Random;

public class WNBelladonnaFruitPlantBlock extends WNDoubleFruitPlantBlock {
    public static final IntegerProperty STAGE = WNBlockProperties.CHINESE_LANTERN_STAGE;

    public WNBelladonnaFruitPlantBlock(ResourceLocation location, Properties properties, FruitPlantType type) {
        super(location, properties, type);
        this.LEAF_STAGE = STAGE;
    }

    public WNBelladonnaFruitPlantBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, FruitPlantType type) {
        super(location, properties, itemProperties, type);
        this.LEAF_STAGE = STAGE;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        super.createBlockStateDefinition(def);
        def.add(STAGE);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state != null && context.getPlayer() != null && context.getPlayer().isCreative()){
            return state.setValue(STAGE,3);
        }
        return state;
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER).setValue(STAGE,0));
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_ChineseLanternFlower(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        String stalk = this.getRegistryName().getNamespace() + ":blocks/fruit_bushes/" + fruitType.getFolder() + "/" + fruitType.getIdBase() + "_stalk";
        String leaves = this.getRegistryName().getNamespace() + ":blocks/fruit_bushes/" + fruitType.getFolder() + "/" + fruitType.getIdBase() + "_leaves";
        return new ModelList().with(
                new WNBlockModel_FloweringBush(this.getRegName() + "_stage_0_bottom")
                        .with("stalk",leaves + "_bottom")
                        .with("texture",stalk + "_bottom"),
                new WNBlockModel_FloweringBush(this.getRegName() + "_stage_0_top")
                        .with("stalk",leaves + "_top")
                        .with("texture",stalk + "_top"),

                new WNBlockModel_LeafedFloweringBush(this.getRegName() + "_stage_1_bottom")
                        .with("texture",getTextureName("fruit_bushes/" + fruitType.getFolder()) + "_stage_1_bottom")
                        .with("stalk",stalk + "_bottom")
                        .with("leaves",leaves + "_bottom"),
                new WNBlockModel_LeafedFloweringBush(this.getRegName() + "_stage_1_top")
                        .with("texture",getTextureName("fruit_bushes/" + fruitType.getFolder()) + "_stage_1_top")
                        .with("stalk",stalk + "_top")
                        .with("leaves",leaves + "_top"),

                new WNBlockModel_LeafedFloweringBush(this.getRegName() + "_stage_2_bottom")
                        .with("texture",getTextureName("fruit_bushes/" + fruitType.getFolder()) + "_stage_2_bottom")
                        .with("stalk",stalk + "_bottom")
                        .with("leaves",leaves + "_bottom"),
                new WNBlockModel_LeafedFloweringBush(this.getRegName() + "_stage_2_top")
                        .with("texture",getTextureName("fruit_bushes/" + fruitType.getFolder()) + "_stage_2_top")
                        .with("stalk",stalk + "_top")
                        .with("leaves",leaves + "_top"),

                new WNBlockModel_LeafedFloweringBush(this.getRegName() + "_stage_3_bottom")
                        .with("texture",getTextureName("fruit_bushes/" + fruitType.getFolder()) + "_stage_3_bottom")
                        .with("stalk",stalk + "_bottom")
                        .with("leaves",leaves + "_bottom"),
                new WNBlockModel_LeafedFloweringBush(this.getRegName() + "_stage_3_top")
                        .with("texture",getTextureName("fruit_bushes/" + fruitType.getFolder()) + "_stage_3_top")
                        .with("stalk",stalk + "_top")
                        .with("leaves",leaves + "_top")
                );
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return state.getValue(STAGE) != 3 && state.getValue(HALF) == DoubleBlockHalf.LOWER;
    }

    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, LivingEntity entity, ItemStack stack) {
        BlockPos blockpos = pos.above();
        level.setBlock(blockpos, copyWaterloggedFrom(level, blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER).setValue(STAGE, state.getValue(STAGE))), 3);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if(state.getValue(STAGE) != 3){
            if(WNUtil.rint(0,5) == 0){
                placeAt(level,state.setValue(STAGE,state.getValue(STAGE) + 1),pos,2);
            }
        }
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

                    BlockState next = null;
                    BlockPos nextPos = null;
                    if(state.getValue(HALF) == DoubleBlockHalf.LOWER){
                        next = level.getBlockState(pos.above()).is(this) ? level.getBlockState(pos.above()) : null;
                        nextPos = pos.above();
                    }else if(state.getValue(HALF) == DoubleBlockHalf.UPPER){
                        next = level.getBlockState(pos.below()).is(this) ? level.getBlockState(pos.below()) : null;
                        nextPos = pos.below();
                    }
                    level.setBlock(pos, state.setValue(this.LEAF_STAGE, stage), 2);
                    Block.popResourceFromFace(level, pos, result.getDirection(), fruit);
                    if(next != null){
                        level.setBlock(nextPos, next.setValue(this.LEAF_STAGE, stage), 2);
                        Block.popResourceFromFace(level, pos, result.getDirection(), fruit);
                    }

                    return InteractionResult.SUCCESS;
                }
            }
        }

        return super.use(state, level, pos, player, hand, result);
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.FLOWERS, WNTags.TALL_FLOWERS, WNTags.ENDERMAN_HOLDABLE, WNTags.WN_FLOWERING_PLANTS
        );
    }
}
