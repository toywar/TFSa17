package ru.toywar.homework;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ReceiverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver);

        TextView textView = findViewById(R.id.enteredTextView);
        textView.setText(getIntent().getStringExtra("userText"));

        Button buttonOk = findViewById(R.id.buttonOk);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntentOk = new Intent();
                resultIntentOk.putExtra("Ok", "Пользователь нажал ОК");
                setResult(RESULT_OK, resultIntentOk);
                finish();
            }
        });

        Button buttonCancel = findViewById(R.id.buttonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntentCancel = new Intent();
                resultIntentCancel.putExtra("Cancel", "Пользователь нажал Cancel");
                setResult(RESULT_CANCELED, resultIntentCancel);
                finish();
            }
        });
    }
}
