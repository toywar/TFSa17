package ru.toywar.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.math.BigDecimal;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        case3();
    }

    public void case2() {
        //{"name":"name","any_map":{"a":"55","b":"85","c":"56"}
        Log.i("Homework", "=== Case 2 ===");
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
            Log.i("GSON", "Key: " + entry.getKey());
            Log.i("GSON", "Value: " + entry.getValue());
            Log.i("GSON", "Parse OK!");
        }
    }

    public void case4() {
        Log.i("Homework", "=== Case 4 ===");

    }
}
