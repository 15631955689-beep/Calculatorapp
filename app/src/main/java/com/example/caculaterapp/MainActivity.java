package com.example.caculaterapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText inputFirstNumber;
    EditText inputSecondNumber;

    Button buttonPlus;
    Button buttonMinus;
    Button buttonMultiply;
    Button buttonDivide;

    TextView textResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputFirstNumber = findViewById(R.id.inputFirstNumber);
        inputSecondNumber = findViewById(R.id.inputSecondNumber);

        buttonPlus = findViewById(R.id.buttonPlus);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonDivide = findViewById(R.id.buttonDivide);

        textResult = findViewById(R.id.textResult);

        buttonPlus.setOnClickListener(v -> {
            int a = Integer.parseInt(inputFirstNumber.getText().toString());
            int b = Integer.parseInt(inputSecondNumber.getText().toString());
            int result = a + b;
            textResult.setText("Result: " + result);
        });

        buttonMinus.setOnClickListener(v -> {
            int a = Integer.parseInt(inputFirstNumber.getText().toString());
            int b = Integer.parseInt(inputSecondNumber.getText().toString());
            int result = a - b;
            textResult.setText("Result: " + result);
        });

        buttonMultiply.setOnClickListener(v -> {
            int a = Integer.parseInt(inputFirstNumber.getText().toString());
            int b = Integer.parseInt(inputSecondNumber.getText().toString());
            int result = a * b;
            textResult.setText("Result: " + result);
        });

        buttonDivide.setOnClickListener(v -> {
            int a = Integer.parseInt(inputFirstNumber.getText().toString());
            int b = Integer.parseInt(inputSecondNumber.getText().toString());

            if (b == 0) {
                textResult.setText("Cannot divide by zero");
            } else {
                int result = a / b;
                textResult.setText("Result: " + result);
            }
        });
    }
}