/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.client.objects.render.blockentities.table;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.objects.blockentities.table.WNTableBlockEntity;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WNTableBlockEntityRenderer implements BlockEntityRenderer<WNTableBlockEntity> {
    private static final WNLogger log = WildNature.getLogger();

    public WNTableBlockEntityRenderer(BlockEntityRendererProvider.Context context){}

    @Override
    public void render(WNTableBlockEntity blockEntity, float partialTicks, PoseStack poseStack, MultiBufferSource source, int combinedLight, int combinedOverlay) {
        if(blockEntity.hasPlacedStack()){
            int id = (int)blockEntity.getBlockPos().asLong();

            poseStack.pushPose();
            poseStack.translate(0.5D, 1 + (1/16F)/2, 0.5D);
            poseStack.scale(1.3F, 1.3F, 1.3F);
            poseStack.mulPose(Vector3f.XP.rotationDegrees(90.0F));
            poseStack.mulPose(Vector3f.ZP.rotationDegrees(blockEntity.getFacing().get2DDataValue() * 90));
            poseStack.translate(0.0, -0.125D, 0.0);
            Minecraft.getInstance().getItemRenderer().renderStatic(blockEntity.getPlacedStack(), ItemTransforms.TransformType.GROUND, combinedLight, combinedOverlay, poseStack, source, id);
            poseStack.popPose();
        }
    }

    @Override
    public boolean shouldRenderOffScreen(WNTableBlockEntity blockEntity) {
        return BlockEntityRenderer.super.shouldRenderOffScreen(blockEntity);
    }

    @Override
    public int getViewDistance() {
        return BlockEntityRenderer.super.getViewDistance();
    }

    @Override
    public boolean shouldRender(WNTableBlockEntity blockEntity, Vec3 vec) {
        return BlockEntityRenderer.super.shouldRender(blockEntity, vec);
    }
}
