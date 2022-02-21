package com.example.questao2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button2);
        message = findViewById(R.id.editTextEnterMessage);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                send(view);
            }
        });
    }

    private void send(View view) {
        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("data", message.getText().toString());
        startActivity(i);
    }
}