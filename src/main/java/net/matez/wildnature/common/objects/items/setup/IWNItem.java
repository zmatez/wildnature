package net.matez.wildnature.common.objects.items.setup;

import net.matez.wildnature.data.item_models.WNItemModel_BlockParent;
import net.matez.wildnature.data.setup.base.WNResource;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

public interface IWNItem {
    public void construct();

    @Nullable
    public WNResource getItemModel();
    /**
     * @return e.g "stone"
     */
    public String getRegName();
    /**
     * @return e.g "minecraft:blocks/stone"
     */
    public String getTextureName();
    /**
     * @param folders e.g rocks/stones
     * @return e.g "minecraft:blocks/rocks/stones/stone"
     */
    public String getTextureName(String folders);

    @Nullable
    public ResourceLocation getRegistryName();
}
