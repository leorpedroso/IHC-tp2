package com.example.questao1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText num1, num2;
    private Button button;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = (EditText) findViewById(R.id.editTextNumber1);
        num2 = (EditText) findViewById(R.id.editTextNumber2);
        button = (Button) findViewById(R.id.button);
        result = (TextView) findViewById(R.id.textViewResult);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int sum_result = Integer.parseInt(num1.getText().toString().trim()) +
                            Integer.parseInt(num2.getText().toString().trim());
                    result.setText(String.valueOf(sum_result));
                }
                catch (Exception e) {
                    result.setText("Type two numbers");
                }
            }
        });
    }
}