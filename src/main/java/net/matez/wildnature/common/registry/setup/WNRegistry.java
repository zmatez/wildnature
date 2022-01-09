package net.matez.wildnature.common.registry.setup;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.registry.blocks.WNBlocks;
import net.matez.wildnature.common.registry.items.WNItems;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
public class WNRegistry {
    private static final WNLogger log = WildNature.getLogger();

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event) {
        log.progress("Registering blocks");
        event.getRegistry().registerAll(WNBlocks.BLOCKS.values().toArray(new Block[]{}));
        log.success("Registered " + WNBlocks.BLOCKS.size() + " blocks");
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event) {
        log.progress("Registering block items");
        event.getRegistry().registerAll(WNItems.BLOCK_ITEMS.values().toArray(new BlockItem[]{}));
        log.success("Registered " + WNItems.BLOCK_ITEMS.size() + " block items");

        log.progress("Registering items");
        event.getRegistry().registerAll(WNItems.ITEMS.values().toArray(new Item[]{}));
        log.success("Registered " + WNItems.ITEMS.size() + " items");
    }
}
