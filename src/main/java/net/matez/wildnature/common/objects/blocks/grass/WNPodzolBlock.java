package net.matez.wildnature.common.objects.blocks.grass;

import net.matez.wildnature.common.objects.blocks.basic.WNSnowyDirtBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeBottomTop;
import net.matez.wildnature.data.blockstates.WNBlockstate_GrassBlock;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public class WNPodzolBlock extends WNSnowyDirtBlock {
    private final GrassType grassType;

    public WNPodzolBlock(ResourceLocation location, Properties properties, GrassType grassType) {
        super(location, properties);
        this.grassType = grassType;
    }

    public WNPodzolBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, GrassType grassType) {
        super(location, properties, itemProperties);
        this.grassType = grassType;
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_GrassBlock(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList()
                .with(
                        new WNBlockModel_CubeBottomTop(this.getRegName())
                                .with("texture_top", this.getTextureName("grass") + "_top")
                                .with("texture_bottom", WNBlocks.DIRTS.get(this.grassType).getTextureName("grass"))
                                .with("texture_side", this.getTextureName("grass") + "_side"),
                        new WNBlockModel_CubeBottomTop(this.getRegName() + "_snow")
                                .with("texture_top", WNBlocks.GRASSES.get(this.grassType).getTextureName("grass") + "_top")
                                .with("texture_bottom", WNBlocks.DIRTS.get(this.grassType).getTextureName("grass"))
                                .with("texture_side", WNBlocks.GRASSES.get(this.grassType).getTextureName("grass") + "_side_snowed")
                );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.ENDERMAN_HOLDABLE, WNTags.MOSS_REPLACEABLE, WNTags.AZALEA_GROWS_ON, WNTags.FORGE_DIRT,
                WNTags.BAMBOO_PLANTABLE_ON, WNTags.LUSH_GROUND_REPLACEABLE, WNTags.AZALEA_ROOT_REPLACEABLE,
                WNTags.BIG_DRIPLEAF_REPLACEABLE, WNTags.VALID_SPAWN, WNTags.MINEABLE_SHOVEL, WNTags.DIRT,
                WNTags.MUSHROOM_GROW_BLOCK, WNTags.FOXES_SPAWNABLE_ON
        );
    }
}
