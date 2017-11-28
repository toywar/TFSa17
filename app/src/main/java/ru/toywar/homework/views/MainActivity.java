package ru.toywar.homework.views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.toywar.homework.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment, new TFNewsFragment(), "news")
                .commit();
    }
}