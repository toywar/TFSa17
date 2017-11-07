package ru.toywar.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        case2();
        case3();
        case4();
    }

    public void case2() {
        //{"name":"name","any_map":{"a":"55","b":"85","c":"56"}}
        Log.i("Homework", "=== Case 2 ===");

        String json = "{\"name\":\"name\",\"any_map\":{\"a\":\"55\",\"b\":\"85\",\"c\":\"56\"}}";
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(HashMap.class, new MapDeserializer())
                .create();

        JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
        JsonElement jsonElement = jsonObject.get("any_map");

        HashMap<String, Integer> hashMap = gson.fromJson(jsonElement, HashMap.class);

        if (hashMap instanceof HashMap) {
            for (Map.Entry entry: hashMap.entrySet()) {
                Log.i("HaspMap", "Key: " + entry.getKey());
                Log.i("HaspMap", "Value: " + entry.getValue());
            }
            Log.i("HaspMap", "HashMap OK!");
        }
    }

    public void case3() {
        // {"money_amount":"2444,88"}
        Log.i("Homework", "=== Case 3 ===");
        String json =  "{\"money_amount\":\"2444,88\"}";

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(BigDecimal.class, new BigDecimalDeserializer())
                .create();

        Map<String, BigDecimal> stringBigDecimalMap = gson.fromJson(json, Map.class);
        for (Map.Entry<String, BigDecimal> entry: stringBigDecimalMap.entrySet()) {
            Log.i("BigDecimal", "Key: " + entry.getKey());
            Log.i("BigDecimal", "Value: " + entry.getValue());
            Log.i("BigDecimal", "Parse OK!");
        }
    }

    public void case4() {
        Log.i("Homework", "=== Case 4 ===");

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(DateExample.class, new DateExampleSerializer())
                .create();

        DateExample dateExample = new DateExample(new Date(System.currentTimeMillis()));
        String json = gson.toJson(dateExample);
        Log.i("DateExample", "JSON: " + json);
    }
}
