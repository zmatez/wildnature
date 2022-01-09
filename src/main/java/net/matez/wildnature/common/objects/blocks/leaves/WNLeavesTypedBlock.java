package net.matez.wildnature.common.objects.blocks.leaves;

import net.matez.wildnature.common.objects.blocks.basic.WNLeavesBlock;
import net.matez.wildnature.common.objects.blocks.leaves.stages.*;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.data.block_models.WNBlockModel_Leaves;
import net.matez.wildnature.data.blockstates.WNBlockstate_TypedLeaves;
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

import java.util.Random;

public abstract class WNLeavesTypedBlock extends WNLeavesBlock {
    public IntegerProperty LEAF_STAGE;
    private final LeafType leafType;

    public WNLeavesTypedBlock(ResourceLocation location, Properties properties, LeafType leafType) {
        super(location, properties);
        this.leafType = leafType;
    }

    public WNLeavesTypedBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, LeafType leafType) {
        super(location, properties, itemProperties);
        this.leafType = leafType;
    }


    @Override
    public void construct() {
        super.construct();
        if(this.LEAF_STAGE != null){
            this.registerDefaultState(this.defaultBlockState().setValue(this.LEAF_STAGE,0));
        }
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(HYDRATED) || (this.LEAF_STAGE != null && this.leafType.getConfig().isFlowering() && state.getValue(this.LEAF_STAGE) == 1);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        super.randomTick(state, level, pos, random);
        if(state.getValue(HYDRATED)){
            if(this.LEAF_STAGE != null && this.leafType.getConfig().isFlowering() && state.getValue(this.LEAF_STAGE) == 1){
                level.setBlock(pos,state.setValue(this.LEAF_STAGE,WNUtil.rint(2,leafType.getConfig().getStages())),2);
            }
        }
    }

    @Nullable
    @Override
    public BlockColor getBlockColor() {
        if(this.leafType.isTinted()) {
            return (a, b, c, d) -> {
                return b != null && c != null ? BiomeColors.getAverageFoliageColor(b, c) : FoliageColor.getDefaultColor();
            };
        }
        return null;
    }

    @Nullable
    @Override
    public ItemColor getItemColor(BlockColors colors) {
        if(!this.leafType.isTinted()){
            return null;
        }
        return (stack, num) -> {
            BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
            return colors.getColor(blockstate, null, null, num);
        };
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_TypedLeaves(this.getRegistryName(),this.leafType.getConfig());
    }

    @Override
    public ModelList getBlockModels() {
        ModelList list = new ModelList();
        list.with(
                new WNBlockModel_Leaves(this.getRegName())
                        .with("texture",this.getTextureName("trees/" + leafType.getFolder()))
        );
        if(this.LEAF_STAGE != null){
            if(leafType.getConfig().isFlowering()){
                list.with(
                        new WNBlockModel_Leaves(this.getRegName() + "_flowering")
                                .with("texture",this.getTextureName("trees/" + leafType.getFolder()) + "_flowering")
                );
            }

            int ordinal = 1;
            for(int i = leafType.getConfig().isFlowering() ? 2 : 1; i <= leafType.getConfig().getStages(); i++, ordinal++){
                list.with(
                        new WNBlockModel_Leaves(this.getRegName() + "_fruit_" + ordinal)
                                .with("texture",this.getTextureName("trees/" + leafType.getFolder()) + "_fruit_" + ordinal)
                );
            }
        }
        return list;
    }

    @Nullable
    @Override
    public DropList getDrops(BlockState state, ServerLevel level, float luck) {
        ItemStack fruit = getFruit(state);
        if(fruit != null){
            return new DropList().with(fruit);
        }
        return super.getDrops(state, level, luck);
    }

    @Override
    public InteractionResult use(BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult result) {
        if(this.LEAF_STAGE != null) {
            ItemStack fruit = getFruit(state);
            if (fruit != null) {
                level.setBlock(pos,state.setValue(this.LEAF_STAGE,0),2);
                Block.popResourceFromFace(level,pos,result.getDirection(),fruit);

                return InteractionResult.SUCCESS;
            }
        }

        return super.use(state, level, pos, player, hand, result);
    }

    @Nullable
    public ItemStack getFruit(BlockState state){
        if(this.LEAF_STAGE != null) {
            int stage = state.getValue(this.LEAF_STAGE);
            if(leafType.getConfig().getStageDrops().containsKey(stage)){
                LeafConfig.ItemConfig config = leafType.getConfig().getStageDrops().get(stage);
                Item item = config.getItem().get();
                if(item != Items.AIR) {
                    return new ItemStack(item,config.getMin() == config.getMax() ? config.getMin() : (WNUtil.rint(config.getMin(), config.getMax())));
                }
            }
        }
        return null;
    }

    public static IntegerProperty getStage(BlockState state){
        if(state.getBlock() instanceof WNLeavesTypedBlock block){
            if(block instanceof WNLeavesTypedBlock_Stage0){
                return WNLeavesTypedBlock_Stage0.STAGE;
            }else if(block instanceof WNLeavesTypedBlock_Stage1){
                return WNLeavesTypedBlock_Stage1.STAGE;
            }else if(block instanceof WNLeavesTypedBlock_Stage2){
                return WNLeavesTypedBlock_Stage2.STAGE;
            }else if(block instanceof WNLeavesTypedBlock_Stage3){
                return WNLeavesTypedBlock_Stage3.STAGE;
            }else if(block instanceof WNLeavesTypedBlock_Stage4){
                return WNLeavesTypedBlock_Stage4.STAGE;
            }else if(block instanceof WNLeavesTypedBlock_Stage5){
                return WNLeavesTypedBlock_Stage5.STAGE;
            }else if(block instanceof WNLeavesTypedBlock_Stage6){
                return WNLeavesTypedBlock_Stage6.STAGE;
            }else if(block instanceof WNLeavesTypedBlock_Stage7){
                return WNLeavesTypedBlock_Stage7.STAGE;
            }else if(block instanceof WNLeavesTypedBlock_Stage8){
                return WNLeavesTypedBlock_Stage8.STAGE;
            }else if(block instanceof WNLeavesTypedBlock_Stage9){
                return WNLeavesTypedBlock_Stage9.STAGE;
            }
        }
        return null;
    }

    public static WNLeavesTypedBlock create(ResourceLocation location, Properties properties, Item.Properties itemProperties, LeafType leafType){
        switch (leafType.getConfig().getStages()) {
            case 0 -> {
                return new WNLeavesTypedBlock_Stage0(location, properties, itemProperties, leafType);
            }
            case 1 -> {
                return new WNLeavesTypedBlock_Stage1(location, properties, itemProperties, leafType);
            }
            case 2 -> {
                return new WNLeavesTypedBlock_Stage2(location, properties, itemProperties, leafType);
            }
            case 3 -> {
                return new WNLeavesTypedBlock_Stage3(location, properties, itemProperties, leafType);
            }
            case 4 -> {
                return new WNLeavesTypedBlock_Stage4(location, properties, itemProperties, leafType);
            }
            case 5 -> {
                return new WNLeavesTypedBlock_Stage5(location, properties, itemProperties, leafType);
            }
            case 6 -> {
                return new WNLeavesTypedBlock_Stage6(location, properties, itemProperties, leafType);
            }
            case 7 -> {
                return new WNLeavesTypedBlock_Stage7(location, properties, itemProperties, leafType);
            }
            case 8 -> {
                return new WNLeavesTypedBlock_Stage8(location, properties, itemProperties, leafType);
            }
            case 9 -> {
                return new WNLeavesTypedBlock_Stage9(location, properties, itemProperties, leafType);
            }
        }

        return null;
    }
}
