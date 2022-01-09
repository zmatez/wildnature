package net.matez.wildnature.common.objects.blocks.plant.plants;

import net.matez.wildnature.common.objects.blocks.plant.BushType;
import net.matez.wildnature.data.block_models.plants.wisteria.WNBlockModel_WisteriaBottom;
import net.matez.wildnature.data.block_models.plants.wisteria.WNBlockModel_WisteriaSide;
import net.matez.wildnature.data.blockstates.plants.WNBlockstate_Wisteria;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class WNWisteriaBlock extends WNVerticalBushBlock{
    public static Map<Direction, VoxelShape> SHAPE = createFacingShape(16,3);

    public WNWisteriaBlock(ResourceLocation location, Properties properties, BushType type) {
        super(location, properties, type);
    }

    public WNWisteriaBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties, BushType type) {
        super(location, properties, itemProperties, type);
    }

    @Override
    public boolean isDirectionAllowed(BlockPlaceContext context, Direction direction) {
        return direction != Direction.UP;
    }

    @Override
    public WNResource getBlockstate() {
        return new WNBlockstate_Wisteria(this.getRegistryName());
    }

    @Override
    public ModelList getBlockModels() {
        return new ModelList().with(
                new WNBlockModel_WisteriaBottom(this.getRegName() + "_bottom")
                    .with("texture",this.getTextureName(this.getType().getVariant().getPath())),
                new WNBlockModel_WisteriaSide(this.getRegName() + "_side")
                    .with("texture",this.getTextureName(this.getType().getVariant().getPath()))
        );
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.NONE;
    }
}
