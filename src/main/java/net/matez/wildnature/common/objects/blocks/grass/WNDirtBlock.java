package net.matez.wildnature.common.objects.blocks.grass;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeAll;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.jetbrains.annotations.Nullable;

public class WNDirtBlock extends WNBlock {
    @Nullable
    private final GrassType grassType;

    public WNDirtBlock(ResourceLocation location, Properties properties, GrassType grassType) {
        super(location, properties);
        this.grassType = grassType;
    }

    public WNDirtBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, GrassType grassType) {
        super(location, properties, itemProperties);
        this.grassType = grassType;
    }

    public ModelList getBlockModels(){
        return new ModelList()
                .with(new WNBlockModel_CubeAll(this.getRegName()).with("texture",this.getTextureName("grass")));
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.ENDERMAN_HOLDABLE, WNTags.MOSS_REPLACEABLE, WNTags.AZALEA_GROWS_ON, WNTags.FORGE_DIRT,
                WNTags.BAMBOO_PLANTABLE_ON, WNTags.AZALEA_ROOT_REPLACEABLE,
                WNTags.BIG_DRIPLEAF_REPLACEABLE, WNTags.DRIPSTONE_REPLACEABLE_BLOCKS, WNTags.LUSH_GROUND_REPLACEABLE, WNTags.MINEABLE_SHOVEL, WNTags.DIRT
        );
    }
}
