package net.matez.wildnature.common.block.crops;

import net.matez.wildnature.common.block.plant.BushConstructor;
import net.matez.wildnature.core.registry.WNBlocks;

public class CropHelper {
    public static BushConstructor<CropType> TEA_CONSTRUCTOR = (type, blockProperties, itemProperties)
            -> new WNTeaCropBlock(WNBlocks.location(type.getId()), blockProperties, itemProperties, type);
    public static BushConstructor<CropType> SPREADING_CONSTRUCTOR = (type, blockProperties, itemProperties)
            -> new WNSpreadingCropBlock(WNBlocks.location(type.getId()), blockProperties, itemProperties, type);
    public static BushConstructor<CropType> GIANT_CONSTRUCTOR = (type, blockProperties, itemProperties)
            -> new WNGiantCropBlock(WNBlocks.location(type.getId()), blockProperties.strength(0.35F,0.2F), itemProperties, type);
}
