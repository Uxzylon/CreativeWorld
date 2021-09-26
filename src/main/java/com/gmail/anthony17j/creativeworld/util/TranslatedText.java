package com.gmail.anthony17j.creativeworld.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.TranslatableText;
import com.gmail.anthony17j.creativeworld.Main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class TranslatedText extends TranslatableText {
    private static final boolean SERVER_TRANSLATIONS_LOADED = FabricLoader.getInstance().isModLoaded("server_translations_api");
    private static final JsonObject LANG;

    private static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .serializeNulls()
            .disableHtmlEscaping()
            .create();

    public TranslatedText(String key, Object... args) {
        super(SERVER_TRANSLATIONS_LOADED ? key : (LANG.has(key) ? LANG.get(key).getAsString() : key), args);
    }

    static {
        JsonObject LANG1;
        InputStream langStream = Main.class.getResourceAsStream("/data/creativeworld/lang/en_us.json");
        try {
            assert langStream != null;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(langStream, StandardCharsets.UTF_8))) {
                LANG1 = gson.fromJson(reader, JsonObject.class);
            }
        } catch (IOException e) {
            System.out.println("Problem occurred when trying to load language: " + e.getMessage());
            LANG1 = new JsonObject();
        }
        LANG = LANG1;
    }
}

