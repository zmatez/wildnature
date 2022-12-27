package net.matez.wildnature.common.block.sand;

import net.matez.wildnature.common.block.basic.WNFallingBlock;
import net.matez.wildnature.common.tags.WNTags;
import net.matez.wildnature.data.block_models.WNBlockModel_CubeAll;
import net.matez.wildnature.data.blockstates.WNBlockstate_RandomlyRotatedCube;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

public class WNSandBlock extends WNFallingBlock {
    private final SandType sandType;

    public WNSandBlock(ResourceLocation location, Properties properties, SandType sandType) {
        super(location, properties);
        this.sandType = sandType;
    }

    public WNSandBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, SandType sandType) {
        super(location, properties, itemProperties);
        this.sandType = sandType;
    }

    @Override
    public int getDustColor(BlockState state, BlockGetter getter, BlockPos pos) {
        return sandType.getDustColor();
    }

    @Override
    public WNResource getBlockstate(){
        return new WNBlockstate_RandomlyRotatedCube(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels(){
        return new ModelList()
                .with(new WNBlockModel_CubeAll(this.getRegName()).with("texture",this.getTextureName("sands")));
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.SAND, WNTags.FORGE_SAND, WNTags.BAMBOO_PLANTABLE_ON, WNTags.ENDERMAN_HOLDABLE, WNTags.RABBITS_SPAWNABLE_ON, WNTags.AZALEA_GROWS_ON, WNTags.AZALEA_ROOT_REPLACEABLE, WNTags.LUSH_GROUND_REPLACEABLE, WNTags.MINEABLE_SHOVEL
        );
    }
}
