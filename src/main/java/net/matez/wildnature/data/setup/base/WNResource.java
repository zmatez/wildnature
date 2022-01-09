package net.matez.wildnature.data.setup.base;

import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;

public abstract class WNResource {
    private final LinkedHashMap<String, Param<?>> params = new LinkedHashMap<>();
    public static String modid;
    private final String name;

    public WNResource(String name){
        this.name = name;
        with("name",this.name);
        with("modid",modid);
    }

    public String getName() {
        return name;
    }

    public abstract String getJSON();

    public abstract String getPath();

    public WNResource with(String name, String value){
        params.put(name, new Param<>(name,value));
        return this;
    }
    public WNResource with(String name, boolean value){
        params.put(name, new Param<>(name,value));
        return this;
    }
    public WNResource with(String name, int value){
        params.put(name, new Param<>(name,value));
        return this;
    }
    public WNResource with(String name, double value){
        params.put(name, new Param<>(name,value));
        return this;
    }
    public WNResource with(String name, float value){
        params.put(name, new Param<>(name,value));
        return this;
    }

    public String parseJSON(){
        AtomicReference<String> template = new AtomicReference<>(getJSON());
        this.params.forEach((key, value) -> {
            if(value == null || value.value == null){
                return;
            }
            template.set(template.get().replaceAll("%" + value.name + "%",value.value.toString()));
        });

        return template.get();
    }

    public static class Param<T>{
        private final String name;
        private final T value;

        public Param(String name, T value) {
            this.name = name;
            this.value = value;
        }
    }
}
