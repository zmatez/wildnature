package net.matez.wildnature.client.objects.blocks;

import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.common.registry.setup.WNRenderType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;

public class WNBlockRenderer {
    private static RenderType adapt(WNRenderType type){
        if(type == WNRenderType.SOLID){
            return RenderType.solid();
        }else if(type == WNRenderType.CUTOUT){
            return RenderType.cutout();
        }else if(type == WNRenderType.CUTOUT_MIPPED){
            return RenderType.cutoutMipped();
        }else if(type == WNRenderType.TRANSLUCENT){
            return RenderType.translucent();
        } else if (type == WNRenderType.TRANSLUCENT_MOVING_BLOCK) {
            return RenderType.translucentMovingBlock();
        } else if (type == WNRenderType.TRANSLUCENT_NO_CRUMBLING) {
            return RenderType.translucentNoCrumbling();
        }

        return RenderType.solid();
    }

    public static void registerAll(){
        WNBlocks.BLOCKS.forEach((key, block) -> {
            WNRenderType type = block.getRenderType();
            if(type != WNRenderType.SOLID){
                ItemBlockRenderTypes.setRenderLayer(block,adapt(type));
            }

            BlockColor color = block.getBlockColor();
            if(color != null){
                Minecraft.getInstance().getBlockColors().register(color, block);
            }
            ItemColor iColor = block.getItemColor(Minecraft.getInstance().getBlockColors());
            if(iColor != null){
                Minecraft.getInstance().getItemColors().register(iColor,block.getItem());
            }
        });
    }
}
