package ru.toywar.homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = findViewById(R.id.implButton);
        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hello, TFSa17!");
                sendIntent.setType("text/plain");

                startActivity(sendIntent);
            }
        });

        Button button2 = findViewById(R.id.explButton);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick (View v) {
                String ACTION = "ru.toywar.android.ACTION";
                Intent explicitIntent = new Intent();
                explicitIntent.setAction(ACTION);

                startActivity(explicitIntent);
            }
        });

        Button button3 = findViewById(R.id.flagsButton);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent flagsIntent = new Intent(v.getContext(), ActivityFlags.class);
                startActivity(flagsIntent);
            }
        });

        Button button4 = findViewById(R.id.sendTextButton);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText sendText = findViewById(R.id.editText);
                String text = sendText.getText().toString();

                Intent intent = new Intent(v.getContext(), ReceiverActivity.class);
                intent.putExtra("userText", text);
                startActivity(intent);
            }
        });
    }
}
