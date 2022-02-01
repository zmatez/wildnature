package net.matez.wildnature.client.objects.render.entities.seat;

import com.mojang.blaze3d.vertex.PoseStack;
import net.matez.wildnature.common.objects.entities.seat.WNSeatEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WNSeatEntityRenderer extends EntityRenderer<WNSeatEntity> {
    public WNSeatEntityRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(WNSeatEntity entity) {
        return null;
    }

    @Override
    public void render(WNSeatEntity p_114485_, float p_114486_, float p_114487_, PoseStack p_114488_, MultiBufferSource p_114489_, int p_114490_) {
        //super.render(p_114485_, p_114486_, p_114487_, p_114488_, p_114489_, p_114490_);
    }
}
