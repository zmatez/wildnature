/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.blocks.cave_plants.specific;

import net.matez.wildnature.common.objects.blocks.cave_plants.CavePlantType;
import net.matez.wildnature.common.objects.blocks.cave_plants.WNCaveBushBlock;
import net.matez.wildnature.common.objects.blocks.setup.WNBlockProperties;
import net.matez.wildnature.data.block_models.plants.WNBlockModel_TintedCross;
import net.matez.wildnature.data.setup.base.WNBlockstate;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class WNSunShroomBlock extends WNCaveBushBlock {
    public static final BooleanProperty REFLECTS = WNBlockProperties.REFLECTS;

    public WNSunShroomBlock(ResourceLocation location, Properties properties, CavePlantType type) {
        super(location, properties, type);
    }

    public WNSunShroomBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, CavePlantType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> def) {
        super.createBlockStateDefinition(def);
        def.add(REFLECTS);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        BlockState state = super.getStateForPlacement(context);
        if(state != null && context.getPlayer() != null && context.getPlayer().isCreative()){
            return state.setValue(REFLECTS,getReflection(context.getLevel()));
        }
        return state;
    }

    @Override
    public void construct() {
        super.construct();
        this.registerDefaultState(defaultBlockState().setValue(REFLECTS,true));
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        boolean reflects = getReflection(level);
        if(state.getValue(REFLECTS) != reflects){
            level.setBlock(pos,state.setValue(REFLECTS,reflects),2);
        }
    }

    public boolean getReflection(Level level){
        return level.getDayTime() < 12000 && level.getDayTime() >= 0;
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate(this.getRegistryName()) {
            @Override
            public String getJSON() {
                return """
                        {
                          "variants": {
                            "reflects=true": {
                                "model": "%modid%:block/%name%"
                            },
                            "reflects=false": {
                                "model": "%modid%:block/%name%_night"
                            }
                          }
                        }
                        """;
            }
        };
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_TintedCross(this.getRegName()).with("texture",this.getTextureName("plants/cave/" + this.cavePlantType.getFolder())),
                new WNBlockModel_TintedCross(this.getRegName() + "_night").with("texture",this.getTextureName("plants/cave/" + this.cavePlantType.getFolder()) + "_night")
        );
    }
}
