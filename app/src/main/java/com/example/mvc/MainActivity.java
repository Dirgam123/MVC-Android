package com.example.mvc.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvc.R;
import com.example.mvc.controller.CalculatorController;

public class MainActivity extends AppCompatActivity {

    private EditText inputNumber1, inputNumber2;
    private TextView resultText;
    private CalculatorController calculatorController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputNumber1 = findViewById(R.id.input_number1);
        inputNumber2 = findViewById(R.id.input_number2);
        resultText = findViewById(R.id.text_result);

        calculatorController = new CalculatorController();

        Button btnAdd = findViewById(R.id.btn_add);
        Button btnSubtract = findViewById(R.id.btn_subtract);
        Button btnMultiply = findViewById(R.id.btn_multiply);
        Button btnDivide = findViewById(R.id.btn_divide);

        btnAdd.setOnClickListener(v -> calculate("+"));
        btnSubtract.setOnClickListener(v -> calculate("-"));
        btnMultiply.setOnClickListener(v -> calculate("*"));
        btnDivide.setOnClickListener(v -> calculate("/"));
    }

    private void calculate(String operation) {
        try {
            double number1 = Double.parseDouble(inputNumber1.getText().toString());
            double number2 = Double.parseDouble(inputNumber2.getText().toString());

            double result = calculatorController.calculate(number1, number2, operation);

            resultText.setText("Result: " + result);

        } catch (NumberFormatException e) {
            resultText.setText("Please enter valid numbers");
        } catch (ArithmeticException e) {
            resultText.setText(e.getMessage());
        }
    }
}
