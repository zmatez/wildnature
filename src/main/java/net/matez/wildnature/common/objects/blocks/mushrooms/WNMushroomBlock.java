/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.mushrooms;

import net.matez.wildnature.common.objects.blocks.plant.WNBushBlock;
import net.matez.wildnature.common.objects.blocks.plant.config.BushConfig;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.item_models.WNItemModel_Generated;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WNMushroomBlock extends WNBushBlock {
    public static final BushConfig CONFIG = new BushConfig();
    protected final Mushroom mushroom;

    public WNMushroomBlock(ResourceLocation location, Properties properties, Mushroom mushroom) {
        super(location, properties, CONFIG);
        this.mushroom = mushroom;
    }

    public WNMushroomBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, Mushroom mushroom) {
        super(location, properties, itemProperties, CONFIG);
        this.mushroom = mushroom;
    }

    @Override
    public boolean canSurvive(BlockState p_54880_, LevelReader reader, BlockPos p_54882_) {
        BlockPos blockpos = p_54882_.below();
        BlockState blockstate = reader.getBlockState(blockpos);
        if (blockstate.is(BlockTags.MUSHROOM_GROW_BLOCK)) {
            return true;
        } else {
            return reader.getRawBrightness(p_54882_, 0) < 13 && blockstate.canSustainPlant(reader, blockpos, net.minecraft.core.Direction.UP, this);
        }
    }

    @Nullable
    @Override
    public WNResource getItemModel() {
        if(mushroom == Mushroom.PSILOCYBIN_MUSHROOM){
            return new WNItemModel_Generated(this.getRegName()).with("texture",this.getRegistryName().getNamespace() + ":blocks/plants/surface/mushrooms/shrooms");
        }
        return new WNItemModel_Generated(this.getRegName()).with("texture",this.getTextureName("plants/surface/mushrooms"));
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_TintedCross(this.getRegName()).with("texture",this.getTextureName("plants/surface/mushrooms"))
        );
    }

    @Override
    public @Nullable BlockColor getBlockColor() {
        return null;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if (random.nextInt(25) == 0) {
            int i = 5;
            int j = 4;

            for(BlockPos blockpos : BlockPos.betweenClosed(pos.offset(-4, -1, -4), pos.offset(4, 1, 4))) {
                if (level.getBlockState(blockpos).is(this)) {
                    --i;
                    if (i <= 0) {
                        return;
                    }
                }
            }

            BlockPos blockpos1 = pos.offset(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);

            for(int k = 0; k < 4; ++k) {
                if (level.isEmptyBlock(blockpos1) && state.canSurvive(level, blockpos1)) {
                    pos = blockpos1;
                }

                blockpos1 = pos.offset(random.nextInt(3) - 1, random.nextInt(2) - random.nextInt(2), random.nextInt(3) - 1);
            }

            if (level.isEmptyBlock(blockpos1) && state.canSurvive(level, blockpos1)) {
                level.setBlock(blockpos1, state, 2);
            }
        }

    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockState stateOn, BlockGetter getter, BlockPos pos) {
        return state.isSolidRender(getter, pos);
    }

    @Override
    public @Nullable WNTags.TagList getWNTags() {
        WNTags.TagList list = new WNTags.TagList(
            WNTags.MINEABLE_AXE
        );

        if(this.mushroom.isPoisonous()){
            list.with(WNTags.RED_MUSHROOM);
        }else{
            list.with(WNTags.BROWN_MUSHROOM);
        }

        return list;
    }
}
