/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.lang;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class WNTranslations {
    public static final LinkedHashMap<Keys, ArrayList<String>> ENTRIES = new LinkedHashMap<>();
    public static LinkedHashMap<String, WNTranslation> LANGUAGES = new LinkedHashMap<>();

    static {
        addLanguage("english", "en_us");
        addLanguage("polish", "pl_pl");
    }

    public static WNTranslation addLanguage(String name, String codename) {
        var translation = new WNTranslation(name, codename);
        LANGUAGES.put(codename, translation);
        return translation;
    }

    public static void add(Keys key, String id) {
        ArrayList<String> entriesForKey = null;
        if (ENTRIES.containsKey(key)) {
            entriesForKey = ENTRIES.get(key);
        } else {
            entriesForKey = new ArrayList<>();
            ENTRIES.put(key, entriesForKey);
        }

        entriesForKey.add(id);
    }

    /**
     * Sort the entries
     */
    public static void flush() {
        ENTRIES.forEach((key, entries) -> {
            Collections.sort(entries);
        });
    }

    public static int size() {
        AtomicInteger i = new AtomicInteger();
        ENTRIES.forEach((key, entries) -> {
            i.addAndGet(entries.size());
        });
        return i.get();
    }

    public enum Keys {
        BLOCK("block.%modid%.%id%"),
        ITEM("item.%modid%.%id%"),
        ITEM_GROUP("itemGroup.%modid%.%id%"),
        ;
        private final String key;

        Keys(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public String supply(String modid, String id) {
            return this.getKey().replace("%modid%", modid).replace("%id%", id);
        }
    }
}
