package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.calculator.calculatorOperations.Addition;
import com.example.calculator.calculatorOperations.Division;
import com.example.calculator.calculatorOperations.Multiplication;
import com.example.calculator.calculatorOperations.Operation;
import com.example.calculator.calculatorOperations.Subtraction;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator;
    private TextView display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculator = new Calculator();
        display = findViewById(R.id.display);

        setupNumberButtons();
        setupOperationButtons();
        setupEqualsButton();
        setupClearButton();
    }

    private void setupNumberButtons() {
        Button button0 = findViewById(R.id.button0);
        button0.setOnClickListener(v -> appendNumber(0));

        Button button1 = findViewById(R.id.button1);
        button1.setOnClickListener(v -> appendNumber(1));

        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(v -> appendNumber(2));

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(v -> appendNumber(3));

        Button button4 = findViewById(R.id.button4);
        button4.setOnClickListener(v -> appendNumber(4));

        Button button5 = findViewById(R.id.button5);
        button5.setOnClickListener(v -> appendNumber(5));

        Button button6 = findViewById(R.id.button6);
        button6.setOnClickListener(v -> appendNumber(6));

        Button button7 = findViewById(R.id.button7);
        button7.setOnClickListener(v -> appendNumber(7));

        Button button8 = findViewById(R.id.button8);
        button8.setOnClickListener(v -> appendNumber(8));

        Button button9 = findViewById(R.id.button9);
        button9.setOnClickListener(v -> appendNumber(9));

        Button buttonDecimal = findViewById(R.id.buttonDecimal);
        buttonDecimal.setOnClickListener(v -> appendDecimal());
    }

    private void setupOperationButtons() {
        Button buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(v -> setOperation(new Addition()));

        Button buttonSubtract = findViewById(R.id.buttonSubtract);
        buttonSubtract.setOnClickListener(v -> setOperation(new Subtraction()));

        Button buttonMultiply = findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(v -> setOperation(new Multiplication()));

        Button buttonDivide = findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(v -> setOperation(new Division()));
    }

    private void setupEqualsButton() {
        Button buttonEquals = findViewById(R.id.buttonEquals);
        buttonEquals.setOnClickListener(v -> {
            calculator.calculate();
            updateDisplay();
        });
    }

    private void setupClearButton() {
        Button buttonClear = findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(v -> {
            calculator.clear();
            updateDisplay();
        });
    }

    private void appendNumber(int number) {
        calculator.inputNumber(number);
        updateDisplay();
    }

    private void appendDecimal() {
        calculator.appendDecimal();
        updateDisplay();
    }

    private void setOperation(Operation operation) {
        calculator.setOperation(operation);
        updateDisplay();
    }

    private void updateDisplay() {
        display.setText(String.valueOf(calculator.getCurrentValue()));
    }
}