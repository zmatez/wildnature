package net.matez.wildnature.setup;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.matez.wildnature.client.objects.blocks.WNBlockRenderer;
import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.objects.initializer.InitStage;
import net.matez.wildnature.common.objects.initializer.Initializer;
import net.matez.wildnature.data.setup.DataGenType;
import net.matez.wildnature.data.setup.WNDataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("wildnature")
public class WildNature {
    public static final boolean debugMode = true;
    public static final String modid = "wildnature";
    public static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .disableHtmlEscaping()
            .create();

    private static final WNLogger log = getLogger();
    private final Initializer initializer;
    //---
    private final long startTime;

    // change this for data gen
    private final DataGenType dataGenType = DataGenType.GEN_REFRESH_ALL;
    //private final DataGenType dataGenType = null;

    public WildNature() {
        startTime = System.currentTimeMillis();
        log.progress("Starting WildNature Mod");
        initializer = new Initializer();

        //# --- EVENT BUS ---
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::construct);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::finish);
        //# -----------------

        MinecraftForge.EVENT_BUS.register(this);
        initializer.init(InitStage.START);
    }

    private void construct(final FMLConstructModEvent event) {
        log.progress("WildNature Construct");
        initializer.init(InitStage.CONSTRUCT);

        if (dataGenType != null) {
            WNDataGenerator dataGenerator = new WNDataGenerator(modid, dataGenType);
            dataGenerator.register();
            dataGenerator.generate();
        }
    }

    private void setup(final FMLCommonSetupEvent event) {
        log.progress("WildNature Setup");
        initializer.init(InitStage.SETUP);

        log.success("WildNature Setup Complete");
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        log.progress("WildNature Client Setup");
        WNBlockRenderer.registerAll();
        log.success("WildNature Client Setup Complete");
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {

    }

    private void processIMC(final InterModProcessEvent event) {

    }

    private void finish(final FMLLoadCompleteEvent event) {
        initializer.init(InitStage.FINISH);

        long ms = System.currentTimeMillis() - startTime;
        log.success("WildNature loaded in " + (ms / 1000) + "s");
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    public static WNLogger getLogger() {
        return new WNLogger(debugMode);
    }
}
