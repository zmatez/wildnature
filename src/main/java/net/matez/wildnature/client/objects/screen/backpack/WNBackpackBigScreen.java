package net.matez.wildnature.client.objects.screen.backpack;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.matez.wildnature.common.objects.containers.backpack.WNBackpackMenuBig;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class WNBackpackBigScreen extends AbstractContainerScreen<WNBackpackMenuBig> {
    private static final ResourceLocation CONTAINER_TEXTURE = new ResourceLocation(WildNature.modid, "textures/gui/backpack/backpack_big.png");

    public WNBackpackBigScreen(WNBackpackMenuBig menu, Inventory inventory, Component component) {
        super(menu, inventory, component);
        imageWidth = 224;
        imageHeight = 196;
        this.titleLabelX = 8;
        this.titleLabelY = 9;
        this.inventoryLabelX = 32;
        this.inventoryLabelY = (this.imageHeight - 94);
    }

    public void render(PoseStack p_99249_, int p_99250_, int p_99251_, float p_99252_) {
        this.renderBackground(p_99249_);
        super.render(p_99249_, p_99250_, p_99251_, p_99252_);
        this.renderTooltip(p_99249_, p_99250_, p_99251_);
    }

    protected void renderLabels(PoseStack p_97808_, int p_97809_, int p_97810_) {
        this.font.draw(p_97808_, this.title, (float) this.titleLabelX, (float) this.titleLabelY, 0xe0e0e0);
        this.font.draw(p_97808_, this.playerInventoryTitle, (float) this.inventoryLabelX, (float) this.inventoryLabelY, 0xe0e0e0);
    }

    protected void renderBg(PoseStack p_99244_, float p_99245_, int p_99246_, int p_99247_) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, CONTAINER_TEXTURE);
        int i = (this.width - this.imageWidth) / 2;
        int j = (this.height - this.imageHeight) / 2;
        this.blit(p_99244_, i, j, 0, 0, this.imageWidth, this.imageHeight);
    }


}