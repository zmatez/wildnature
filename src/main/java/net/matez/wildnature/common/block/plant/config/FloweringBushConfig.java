package net.matez.wildnature.common.block.plant.config;

import java.util.function.Supplier;

public class FloweringBushConfig extends BushConfig{
    public static final Supplier<BushConfig> NO_COLORS = () -> new FloweringBushConfig().noColorVariants();
    protected boolean hasColorVariants = true;

    public BushConfig noColorVariants(){
        this.hasColorVariants = false;
        return this;
    }
    //-----
    public boolean hasColorVariants() {
        return hasColorVariants;
    }
}
