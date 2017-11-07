package ru.toywar.homework;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Created by romek on 07.11.2017.
 */

public class DateExampleSerializer implements JsonSerializer<DateExample> {
    //"yyyy-MM-dd"
    @Override
    public JsonElement serialize(DateExample src, Type typeOfSrc, JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date = dateFormat.format(src.getDate());
        jsonObject.addProperty("date", date);
        return jsonObject;
    }
}
