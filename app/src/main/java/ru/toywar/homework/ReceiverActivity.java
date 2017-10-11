package ru.toywar.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        TextView textView = findViewById(R.id.enteredTextView);
        textView.setText(getIntent().getStringExtra("userText"));
    }
}
