package net.matez.wildnature.common.objects.blocks.basic;

import net.matez.wildnature.common.objects.blocks.setup.WNBlock;
import net.matez.wildnature.common.objects.items.setup.WNBlockItem;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public abstract class WNHorizontalDirectionalBlock extends WNBlock {
   public static final DirectionProperty FACING = BlockStateProperties.HORIZONTAL_FACING;

   public WNHorizontalDirectionalBlock(ResourceLocation location, Properties properties) {
      super(location, properties);
   }

   public WNHorizontalDirectionalBlock(ResourceLocation location, Properties properties, Item.Properties itemProperties) {
      super(location, properties, itemProperties);
   }

   public WNHorizontalDirectionalBlock(ResourceLocation location, Properties properties, WNBlockItem item) {
      super(location, properties, item);
   }


   public BlockState rotate(BlockState p_54125_, Rotation p_54126_) {
      return p_54125_.setValue(FACING, p_54126_.rotate(p_54125_.getValue(FACING)));
   }

   public BlockState mirror(BlockState p_54122_, Mirror p_54123_) {
      return p_54122_.rotate(p_54123_.getRotation(p_54122_.getValue(FACING)));
   }
}