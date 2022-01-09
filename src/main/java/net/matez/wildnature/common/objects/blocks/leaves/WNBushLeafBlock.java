package net.matez.wildnature.common.objects.blocks.leaves;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.tags.WNTags;
import net.matez.wildnature.common.registry.setup.WNRenderType;
import net.matez.wildnature.common.util.WNUtil;
import net.matez.wildnature.data.block_models.WNBlockModel_BushLeaves;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.IForgeShearable;
import org.jetbrains.annotations.Nullable;

public class WNBushLeafBlock extends WNBlock implements IForgeShearable {
    private final LeafBushType leafBushType;
    protected static final VoxelShape SHAPE = Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D);

    public WNBushLeafBlock(ResourceLocation location, Properties properties, LeafBushType leafBushType) {
        super(location, properties);
        this.leafBushType = leafBushType;
    }

    public WNBushLeafBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, LeafBushType leafBushType) {
        super(location, properties, itemProperties);
        this.leafBushType = leafBushType;
    }


    @Nullable
    @Override
    public BlockColor getBlockColor() {
        return (a, b, c, d) -> {
            return b != null && c != null ? BiomeColors.getAverageFoliageColor(b, c) : FoliageColor.getDefaultColor();
        };
    }

    @Nullable
    @Override
    public ItemColor getItemColor(BlockColors colors) {
        return (stack, num) -> {
            BlockState blockstate = ((BlockItem)stack.getItem()).getBlock().defaultBlockState();
            return colors.getColor(blockstate, null, null, num);
        };
    }

    @Override
    public WNRenderType getRenderType() {
        return WNRenderType.CUTOUT;
    }

    @Nullable
    @Override
    public DropList getDrops(BlockState state, ServerLevel level, float luck) {
        //todo shears
        return new DropList().with(new ItemStack(Items.STICK, WNUtil.rint(1,3))).with(ItemStack.EMPTY,4);
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_BushLeaves(this.getRegName()).with("texture",this.getTextureName("trees/other")).with("branch","wildnature:blocks/trees/other/branch_leaves")
        );
    }

    @Nullable
    @Override
    public WNTags.TagList getWNTags() {
        return new WNTags.TagList(
                WNTags.MINEABLE_HOE, WNTags.PARROTS_SPAWNABLE_ON, WNTags.LAVA_POOL_STONE_CANNOT_REPLACE
        );
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockGetter getter, BlockPos pos, CollisionContext context) {
        if(getter.getBlockState(pos.above()).getBlock() instanceof WNBushLeafBlock){
            return Shapes.empty();
        }
        return SHAPE;
    }

    public VoxelShape getBlockSupportShape(BlockState p_56707_, BlockGetter p_56708_, BlockPos p_56709_) {
        return Shapes.block();
    }

    public VoxelShape getVisualShape(BlockState p_56684_, BlockGetter p_56685_, BlockPos p_56686_, CollisionContext p_56687_) {
        return Shapes.block();
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        entity.makeStuckInBlock(state, new Vec3(0.9D, (double)0.8F, 0.9D));
    }
}
