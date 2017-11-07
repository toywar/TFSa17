package ru.toywar.homework;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by romek on 07.11.2017.
 */

public class MapDeserializer implements JsonDeserializer<HashMap> {
    @Override
    public HashMap deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        HashMap<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> map = gson.fromJson(json, Map.class);

        for (Map.Entry<String, Integer> entry: map.entrySet()) {
            hashMap.put(entry.getKey(), entry.getValue());
        }
        return hashMap;
    }
}
