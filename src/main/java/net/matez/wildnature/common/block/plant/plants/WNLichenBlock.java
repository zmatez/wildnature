package net.matez.wildnature.common.block.plant.plants;

import net.matez.wildnature.common.block.plant.BushType;

public class WNLichenBlock extends WNVerticalBushBlock{
    public WNLichenBlock(Properties properties, BushType type) {
        super(properties, type);
    }

    @Override
    public OffsetType getOffsetType() {
        return OffsetType.NONE;
    }
}
