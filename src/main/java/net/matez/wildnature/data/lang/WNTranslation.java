/*
 * Copyright (c) matez.net 2022.
 * All rights reserved.
 * Consider supporting this project on Patreon: https://patreon.com/wildnaturemod
 */

package net.matez.wildnature.data.lang;

import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import net.matez.wildnature.common.log.WNLogger;
import net.matez.wildnature.common.util.WNChatUtil;
import net.matez.wildnature.data.setup.base.WNResource;
import net.matez.wildnature.setup.WildNature;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class WNTranslation extends WNResource {
    private static final WNLogger log = WildNature.getLogger();
    private final String localizedName;

    public WNTranslation(String name, String codename) {
        super(codename);
        this.localizedName = name;
    }

    @Override
    public boolean needsOldFileContent() {
        return true;
    }

    @Override
    public String getJSON() {
        return null;
    }

    @Override
    public String parseJSON() {
        return parseJSON(null);
    }

    @Override
    public String parseJSON(@Nullable String oldContent) {
        JsonObject oldJson = null;
        if (oldContent != null && !oldContent.isEmpty()) {
            try {
                oldJson = JsonParser.parseString(oldContent).getAsJsonObject();
            } catch (JsonParseException e) {
                log.warn("Unable to parse oldJson for language " + this.getName() + ": " + e.getMessage());
            }
        }

        JsonObject object = new JsonObject();

        String credit = "";
        if (oldJson != null) {
            if (oldJson.has("credit")) {
                credit = oldJson.get("credit").getAsString();
            }
        }
        object.addProperty("credit", credit);

        LinkedHashMap<String, Entry> outputEntries = new LinkedHashMap<>();
        ArrayList<String> toTranslate = new ArrayList<>();

        JsonObject finalOldJson = oldJson;
        WNTranslations.ENTRIES.forEach((key, entries) -> {
            for (String entry : entries) {
                String jsonKey = key.supply(modid, entry);
                String value = "";
                boolean shouldTranslate = true;
                if (finalOldJson != null && finalOldJson.has(jsonKey)) {
                    value = finalOldJson.get(jsonKey).getAsString();
                    shouldTranslate = false;
                } else {
                    value = guessValue(entry);
                    if (this.localizedName.equals("english")) {
                        shouldTranslate = false;
                    }
                }

                outputEntries.put(jsonKey, new Entry(jsonKey, value, shouldTranslate));
                if (shouldTranslate) {
                    toTranslate.add(value);
                }
            }
        });

        var sTranslated = translate(toTranslate.toArray(new String[0]));
        List<String> translated = null;
        if (sTranslated != null) {
            translated = Arrays.asList(sTranslated);
        }

        List<String> finalTranslated = translated;
        outputEntries.forEach((key, entry) -> {
            String value = entry.value;
            if (entry.shouldTranslate && finalTranslated != null) {
                int index = 0;
                for (String s : toTranslate) {
                    if (s.equals(value)) {
                        break;
                    }
                    index++;
                }

                if (finalTranslated.size() > index) {
                    value = finalTranslated.get(index);
                }
            }

            object.addProperty(key, value);
        });

        return WildNature.gson.toJson(object);
    }

    private String guessValue(String id) {
        return WNChatUtil.capitalize(id.replace("_", " "), null);
    }

    @Override
    public String getPath() {
        return "/assets/" + modid + "/lang";
    }

    public String[] translate(String[] text) {
        if (text.length == 0) {
            return null;
        }
        try {
            URL url = new URL("https://translate.mentality.rip/");
            URLConnection con = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) con;
            http.setRequestMethod("POST");
            http.setDoOutput(true);

            String fText = "";
            for (String s : text) {
                fText += s + "\\n";
            }

            String json = ("{\"q\":\"" + fText + "\",\"source\":\"en\",\"target\":\"" + this.getName().substring(0, 2) + "\",\"format\":\"text\"}");
            log.debug(json);
            byte[] out = json.getBytes(StandardCharsets.UTF_8);
            int length = out.length;

            http.setFixedLengthStreamingMode(length);
            http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            http.connect();
            try (OutputStream os = http.getOutputStream()) {
                os.write(out);
            }

            var result = JsonParser.parseString(new BufferedReader(
                    new InputStreamReader(http.getInputStream(), StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"))).getAsJsonObject();

            if (result.has("translatedText")) {
                return result.get("translatedText").getAsString().split("\\n");
            }
        } catch (IOException | JsonParseException e) {
            log.error("Unable to translate " + text + ": " + e.getMessage());
        }

        return null;
    }

    public record Entry(String key, String value, boolean shouldTranslate) {
    }
}
