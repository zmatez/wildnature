/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.structures;

import net.matez.wildnature.api.util.log.SimpleLogger;
import net.matez.wildnature.common.objects.structures.types.WNFallenTreeStructure;
import net.matez.wildnature.common.objects.structures.types.WNTreeStructure;
import net.matez.wildnature.setup.WildNature;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;

public class WNStructures {
    public static final LinkedHashMap<ResourceLocation, WNStructure> STRUCTURES = new LinkedHashMap<>();
    //# ---------------
    protected static final String directory = "wn_structures";
    protected static final String extension = ".wnstruct";
    private static final SimpleLogger log = WildNature.getLogger();
    private static final LinkedHashMap<String, StructureSupplier> SUPPLIERS = new LinkedHashMap<>();

    static {
        reg("tree", (entry) -> new WNTreeStructure(entry.location()));
        reg("fallen_tree", (entry) -> new WNFallenTreeStructure(entry.location()));
    }

    public static boolean isLoaded() {
        return !STRUCTURES.isEmpty();
    }

    private static void reg(String type, StructureSupplier supplier) {
        SUPPLIERS.put(type, supplier);
    }

    public static void load(ResourceManager manager) {
        if (!STRUCTURES.isEmpty()) {
            log.success("No need to load structures, already loaded " + STRUCTURES.size());
            return;
        }
        log.progress("Loading structures");
        var resources = manager.listResources(directory, (path) -> path.endsWith(extension));
        int done = 0;
        log.startProgress();
        log.progressPercentage(done, resources.size());
        for (ResourceLocation resourcelocation : resources) {
            String s = resourcelocation.getPath();
            ResourceLocation location = new ResourceLocation(resourcelocation.getNamespace(), s.substring(directory.length() + 1, s.length() - extension.length()));
            var entry = WNStructure.load(location);
            if (entry == null) {
                continue;
            }
            var structure = create(entry, entry.getType());
            structure.load(entry);
            STRUCTURES.put(location, structure);

            done++;
            log.progressPercentage(done, resources.size());
        }
        log.endProgress();
        log.success("Loaded " + done + " structures");
    }

    public static WNStructure create(WNStructure.WNStructureEntry entry, @Nullable String type) {
        if (type != null) {
            if (SUPPLIERS.containsKey(type)) {
                return SUPPLIERS.get(type).get(entry);
            }
        }

        return new WNStructure(entry.location());
    }

    public interface StructureSupplier {
        WNStructure get(WNStructure.WNStructureEntry entry);
    }
}
