package net.matez.wildnature.common.objects.initializer;

import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.setup.WildNature;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.forgespi.language.ModFileScanData;
import org.objectweb.asm.Type;

import java.lang.annotation.ElementType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.stream.Collectors;

public class Initializer {
    private final LinkedHashMap<InitStage, ArrayList<Field>> map = new LinkedHashMap<>();
    private static final WNLogger log = WildNature.getLogger();

    public Initializer(){
        log.debug("Preparing Initializer");

//        Reflections reflections = new Reflections("net.matez.wildnature");
//        Set<Class<?>> initClasses = reflections.getTypesAnnotatedWith(Initialize.class);

        final List<ModFileScanData.AnnotationData> annotations = ModList.get().getAllScanData().stream()
                .map(ModFileScanData::getAnnotations)
                .flatMap(Collection::stream)
                .filter(a -> Type.getType(Initialize.class).equals(a.annotationType()))
                .collect(Collectors.toList());

        log.debug("Found " + annotations.size() + " annotations");

        for (ModFileScanData.AnnotationData annotation : annotations) {
            //only classes
            if(annotation.targetType() == ElementType.TYPE) {
                try {
                    Class<?> clazz = Class.forName(annotation.clazz().getClassName());
                    //log.debug("Clazz: " + clazz.getName());

                    Field[] declaredFields = clazz.getDeclaredFields();
                    ArrayList<Field> fields = new ArrayList<Field>();
                    //log.debug("has fields: " + declaredFields.length);

                    for (Field field : declaredFields) {
                        if (Modifier.isStatic(field.getModifiers())) {
                            if(!field.isAnnotationPresent(ExcludeInit.class)) {
                                fields.add(field);
                            }
                        }
                    }
                    //log.debug("Found matching fields: " + fields.size());

                    if(!fields.isEmpty()) {
                        Initialize i = clazz.getAnnotationsByType(Initialize.class)[0];
                        if (i != null) {
                            InitStage stage = i.value();
                            if (map.containsKey(stage)) {
                                map.get(stage).addAll(fields);
                            } else {
                                map.put(stage, fields);
                            }
                        }else{
                            log.error("Initialize is null in class: " + clazz.getName());
                        }
                    }

                } catch (ClassNotFoundException e) {
                    log.error("Unable to find class: " + e.getMessage());
                    e.printStackTrace();
                }
            }else if(annotation.targetType() == ElementType.FIELD){
                try {
                    Class<?> clazz = Class.forName(annotation.clazz().getClassName());

                    Field field = clazz.getField(annotation.memberName());
                    if (Modifier.isStatic(field.getModifiers())) {
                        if(!field.isAnnotationPresent(ExcludeInit.class)) {
                            Initialize i = clazz.getAnnotationsByType(Initialize.class)[0];
                            if (i != null) {
                                InitStage stage = i.value();
                                if (map.containsKey(stage)) {
                                    map.get(stage).add(field);
                                } else {
                                    map.put(stage, new ArrayList<>(Arrays.asList(field)));
                                }
                            }
                        }
                    }
                } catch (ClassNotFoundException e) {
                    log.error("Unable to find class: " + e.getMessage());
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    log.error("Unable to find field: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        log.debug("Initializer complete. Results: ");
        map.forEach((stage, list) -> {
            log.debug("- " + stage.name() + ": " + list.size() + " entries");
        });
    }

    public void init(InitStage stage){
        log.debug("Initializing stage " + stage.name());
        if (map.containsKey(stage)) {
            for (Field field : map.get(stage)) {
                try {
                    field.get(null);
                }catch (Exception e){
                    log.error("Unable to initialize field: " + e.getMessage());
                }
            }

            log.debug("Initialized " + map.get(stage).size() + " fields.");
        }else{
            log.debug("No entries found.");
        }
    }
}
