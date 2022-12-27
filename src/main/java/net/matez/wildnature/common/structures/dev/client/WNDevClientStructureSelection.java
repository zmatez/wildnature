/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.structures.dev.client;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import net.matez.wildnature.common.structures.dev.WNDevStructureSelection;
import net.matez.wildnature.api.client.RenderHelper;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

public class WNDevClientStructureSelection extends WNDevStructureSelection {
    public WNDevClientStructureSelection(Player owner) {
        super(owner);
    }

    @Override
    public ClientLevel getLevel() {
        return (ClientLevel) super.getLevel();
    }

    public void render(Vec3 projectedView, float partialTicks, PoseStack poseStack) {
        Tesselator tesselator = Tesselator.getInstance();
        BufferBuilder buffer = tesselator.getBuilder();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShader(GameRenderer::getRendertypeLinesShader);
        RenderSystem.disableTexture();
        RenderSystem.disableDepthTest();
        RenderSystem.disableCull();

        buffer.begin(VertexFormat.Mode.LINES, DefaultVertexFormat.POSITION_COLOR_NORMAL);
        RenderSystem.lineWidth(5F);

        if (isComplete()) {
            poseStack.pushPose();

            BlockPos min = getMinPos();
            BlockPos max = getMaxPos();

            Vec3 relativeToPos1 = new Vec3(min.getX() - projectedView.x(), min.getY() - projectedView.y(), min.getZ() - projectedView.z());
            Vec3 relativeToPos2 = new Vec3(max.getX() - projectedView.x() + 1, max.getY() - projectedView.y() + 1, max.getZ() - projectedView.z() + 1);

            RenderHelper.drawBoundingBox(poseStack, buffer, relativeToPos1.x, relativeToPos1.y, relativeToPos1.z, relativeToPos2.x, relativeToPos2.y, relativeToPos2.z, 45, 210, 220, 255);

            var centers = getCenters();
            for (BlockPos pos : centers) {
                Vec3 relativeToPos = new Vec3(pos.getX() - projectedView.x(), pos.getY() - projectedView.y(), pos.getZ() - projectedView.z());
                poseStack.pushPose();

                RenderHelper.drawBoundingBox(poseStack, buffer, relativeToPos.x, relativeToPos.y, relativeToPos.z, relativeToPos.x + 1, relativeToPos.y + 1, relativeToPos.z + 1, centers.size() > 1 ? 165 : 20, centers.size() > 1 ? 35 : 165, centers.size() > 1 ? 25 : 85, 180);
                poseStack.popPose();
            }
            poseStack.popPose();


            //render block pos
            Vec3 rPos1 = new Vec3(getPos1().getX() - projectedView.x(), getPos1().getY() - projectedView.y(), getPos1().getZ() - projectedView.z());
            poseStack.pushPose();
            RenderHelper.drawBoundingBox(poseStack, buffer, rPos1.x, rPos1.y, rPos1.z, rPos1.x + 1, rPos1.y + 1, rPos1.z + 1, 110, 35, 180, 120);
            poseStack.popPose();
            Vec3 rPos2 = new Vec3(getPos2().getX() - projectedView.x(), getPos2().getY() - projectedView.y(), getPos2().getZ() - projectedView.z());
            poseStack.pushPose();
            RenderHelper.drawBoundingBox(poseStack, buffer, rPos2.x, rPos2.y, rPos2.z, rPos2.x + 1, rPos2.y + 1, rPos2.z + 1, 210, 110, 35, 120);
            poseStack.popPose();
        } else {
            BlockPos pos = getPos1() == null ? getPos2() : getPos1();
            if (pos != null) {
                Vec3 relativeToPos = new Vec3(pos.getX() - projectedView.x(), pos.getY() - projectedView.y(), pos.getZ() - projectedView.z());
                poseStack.pushPose();

                RenderHelper.drawBoundingBox(poseStack, buffer, relativeToPos.x, relativeToPos.y, relativeToPos.z, relativeToPos.x + 1, relativeToPos.y + 1, relativeToPos.z + 1, 220, 10, 60, 255);
                poseStack.popPose();
            }
        }


        tesselator.end();
    }
}
