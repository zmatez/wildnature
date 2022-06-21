/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.common.objects.initializer;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.setup.WildNature;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.moddiscovery.ModAnnotation;
import net.minecraftforge.forgespi.language.ModFileScanData;
import org.objectweb.asm.Type;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NewInitializer {
    private static final WNLogger log = WildNature.getLogger();
    private final ArrayList<InitStage> alreadyInitialized = new ArrayList<>();

    public NewInitializer() {
    }

    public void prepare() {
        log.debug("Preparing Initializer 2.0");
    }

    public void init(InitStage stage) {
        log.debug("Initializing stage " + stage.name());
        if (this.alreadyInitialized.contains(stage)) {
            log.warn("Stage " + stage.name() + " is already initialized.");

            return;
        }
        this.alreadyInitialized.add(stage);

        final List<ModFileScanData.AnnotationData> classes = ModList.get().getAllScanData().stream()
                .map(ModFileScanData::getAnnotations)
                .flatMap(Collection::stream)
                .filter(a -> Type.getType(Initialize.class).equals(a.annotationType()))
                .toList();

        for (ModFileScanData.AnnotationData data : classes) {
            String className = data.clazz().getClassName();
            var value = data.annotationData().get("value");
            if (value instanceof ModAnnotation.EnumHolder) {
                if (InitStage.valueOf(((ModAnnotation.EnumHolder) value).getValue()) == stage) {
                    try {
                        Class<?> clazz = Class.forName(className, true, this.getClass().getClassLoader());
                        log.success("Initialized stage " + stage + " for class: " + clazz.getSimpleName());
                    } catch (ClassNotFoundException e) {
                        log.error("Unable to find class: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public boolean isInitialized(InitStage stage) {
        return this.alreadyInitialized.contains(stage);
    }


}
