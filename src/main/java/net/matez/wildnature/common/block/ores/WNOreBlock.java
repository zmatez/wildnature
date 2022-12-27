/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.block.ores;

import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeAll;
import net.matez.wildnature.data.blockstates.WNBlockstate_RandomlyRotatedCube;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WNOreBlock extends WNBlock {
    protected final Ore ore;

    public WNOreBlock(ResourceLocation location, Properties properties, Ore ore) {
        super(location, properties);
        this.ore = ore;
    }

    public WNOreBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, Ore ore) {
        super(location, properties, itemProperties);
        this.ore = ore;
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_RandomlyRotatedCube(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_CubeAll(this.getRegName()).with("texture",this.getTextureName("ores/" + this.ore.getFolder()))
        );
    }

    @Nullable
    @Override
    public DropList getDrops(BlockState state, ServerLevel level, float luck) {
        ItemStack drop = this.ore.getDropConfig().getDrops(state,level,luck);
        if(drop == null || drop.isEmpty()) {
            return super.getDrops(state, level, luck);
        }

        return new DropList().with(drop);
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader world, BlockPos pos, int fortune, int silktouch) {
        return silktouch != 0 ? 0 : this.ore.getDropConfig().getExpDrops(state,world,fortune,silktouch);
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.MINEABLE_PICKAXE, WNTags.FORGE_ORES, WNTags.WN_ORES
        );
    }
}
