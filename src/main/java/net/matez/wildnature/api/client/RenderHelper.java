/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.api.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.world.phys.AABB;
import org.joml.Matrix3f;
import org.joml.Matrix4f;

public final class RenderHelper {

    private RenderHelper() {
    }


    public static void drawBoundingBox(PoseStack matrixStackIn, VertexConsumer bufferIn, AABB boundingBox, int red, int green, int blue, int alpha) {
        LevelRenderer.renderLineBox(matrixStackIn, bufferIn, boundingBox.minX, boundingBox.minY, boundingBox.minZ, boundingBox.maxX, boundingBox.maxY, boundingBox.maxZ, red / 255f, green / 255f, blue / 255f, alpha / 255f);
    }

    public static void drawBoundingBox(PoseStack matrixStackIn, VertexConsumer bufferIn, double minX, double minY, double minZ, double maxX, double maxY, double maxZ, int red, int green, int blue, int alpha) {
        Matrix4f matrix4f = matrixStackIn.last().pose();
        Matrix3f matrix3f = matrixStackIn.last().normal();

        float fMinX = (float) minX;
        float fMinY = (float) minY;
        float fMinZ = (float) minZ;
        float fMaxX = (float) maxX;
        float fMaxY = (float) maxY;
        float fMaxZ = (float) maxZ;

//        //down
//        matrixStackIn.pushPose();
//        bufferIn.vertex(matrix4f, fMinX, fMinY, fMinZ).color(red, green, blue, alpha).endVertex();
//        bufferIn.vertex(matrix4f, fMaxX, fMinY, fMinZ).color(red, green, blue, alpha).endVertex();
//        bufferIn.vertex(matrix4f, fMaxX, fMinY, fMaxZ).color(red, green, blue, alpha).endVertex();
//        bufferIn.vertex(matrix4f, fMinX, fMinY, fMaxZ).color(red, green, blue, alpha).endVertex();
//        bufferIn.vertex(matrix4f, fMinX, fMinY, fMinZ).color(red, green, blue, alpha).endVertex();
//        //up
//        bufferIn.vertex(matrix4f, fMinX, fMaxY, fMinZ).color(red, green, blue, alpha).endVertex();
//        bufferIn.vertex(matrix4f, fMaxX, fMaxY, fMinZ).color(red, green, blue, alpha).endVertex();
//        bufferIn.vertex(matrix4f, fMaxX, fMaxY, fMaxZ).color(red, green, blue, alpha).endVertex();
//        bufferIn.vertex(matrix4f, fMinX, fMaxY, fMaxZ).color(red, green, blue, alpha).endVertex();
//        bufferIn.vertex(matrix4f, fMinX, fMaxY, fMinZ).color(red, green, blue, alpha).endVertex();
//
//        //sides
//        matrixStackIn.pushPose();
//        bufferIn.vertex(matrix4f, fMinX, fMinY, fMinZ).color(red, green, blue, alpha).endVertex();
//        bufferIn.vertex(matrix4f, fMinX, fMaxY, fMinZ).color(red, green, blue, alpha).endVertex();
//        matrixStackIn.popPose();
//        matrixStackIn.pushPose();
//        bufferIn.vertex(matrix4f, fMaxX, fMinY, fMinZ).color(red, green, blue, alpha).endVertex();
//        bufferIn.vertex(matrix4f, fMaxX, fMaxY, fMinZ).color(red, green, blue, alpha).endVertex();
//        matrixStackIn.popPose();
//        matrixStackIn.pushPose();
//        bufferIn.vertex(matrix4f, fMinX, fMinY, fMaxZ).color(red, green, blue, alpha).endVertex();
//        bufferIn.vertex(matrix4f, fMinX, fMaxY, fMaxZ).color(red, green, blue, alpha).endVertex();
//        matrixStackIn.popPose();
//        matrixStackIn.pushPose();
//        bufferIn.vertex(matrix4f, fMaxX, fMinY, fMaxZ).color(red, green, blue, alpha).endVertex();
//        bufferIn.vertex(matrix4f, fMaxX, fMaxY, fMaxZ).color(red, green, blue, alpha).endVertex();
//        matrixStackIn.popPose();
//        matrixStackIn.popPose();
        matrixStackIn.pushPose();
        bufferIn.vertex(matrix4f, fMinX, fMinY, fMinZ).color(red, green, blue, alpha).normal(matrix3f, 1.0F, 0.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMaxX, fMinY, fMinZ).color(red, green, blue, alpha).normal(matrix3f, 1.0F, 0.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMinX, fMinY, fMinZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMinX, fMaxY, fMinZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMinX, fMinY, fMinZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, 0.0F, 1.0F).endVertex();
        bufferIn.vertex(matrix4f, fMinX, fMinY, fMaxZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, 0.0F, 1.0F).endVertex();
        bufferIn.vertex(matrix4f, fMaxX, fMinY, fMinZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMaxX, fMaxY, fMinZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMaxX, fMaxY, fMinZ).color(red, green, blue, alpha).normal(matrix3f, -1.0F, 0.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMinX, fMaxY, fMinZ).color(red, green, blue, alpha).normal(matrix3f, -1.0F, 0.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMinX, fMaxY, fMinZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, 0.0F, 1.0F).endVertex();
        bufferIn.vertex(matrix4f, fMinX, fMaxY, fMaxZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, 0.0F, 1.0F).endVertex();
        bufferIn.vertex(matrix4f, fMinX, fMaxY, fMaxZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMinX, fMinY, fMaxZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, -1.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMinX, fMinY, fMaxZ).color(red, green, blue, alpha).normal(matrix3f, 1.0F, 0.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMaxX, fMinY, fMaxZ).color(red, green, blue, alpha).normal(matrix3f, 1.0F, 0.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMaxX, fMinY, fMaxZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, 0.0F, -1.0F).endVertex();
        bufferIn.vertex(matrix4f, fMaxX, fMinY, fMinZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, 0.0F, -1.0F).endVertex();
        bufferIn.vertex(matrix4f, fMinX, fMaxY, fMaxZ).color(red, green, blue, alpha).normal(matrix3f, 1.0F, 0.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMaxX, fMaxY, fMaxZ).color(red, green, blue, alpha).normal(matrix3f, 1.0F, 0.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMaxX, fMinY, fMaxZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMaxX, fMaxY, fMaxZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, 1.0F, 0.0F).endVertex();
        bufferIn.vertex(matrix4f, fMaxX, fMaxY, fMinZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, 0.0F, 1.0F).endVertex();
        bufferIn.vertex(matrix4f, fMaxX, fMaxY, fMaxZ).color(red, green, blue, alpha).normal(matrix3f, 0.0F, 0.0F, 1.0F).endVertex();
        matrixStackIn.popPose();
    }
}
