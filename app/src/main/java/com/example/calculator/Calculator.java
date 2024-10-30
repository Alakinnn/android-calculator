package com.example.calculator;
import com.example.calculator.calculatorOperations.Operation;

public class Calculator {
    private final StringBuilder currentInput = new StringBuilder();
    private final StringBuilder previousInput = new StringBuilder();
    private Operation lastOperation = null;

    public void inputNumber(int digit) {
        currentInput.append(digit);
    }

    public void setOperation(Operation operation) {
        if (currentInput.length() > 0) {
            previousInput.setLength(0);
            previousInput.append(currentInput);
            currentInput.setLength(0);
        }
        lastOperation = operation;
    }

    public double getCurrentValue() {
        return currentInput.length() > 0 ? Double.parseDouble(currentInput.toString()) : 0;
    }

    public void calculate() {
        if (lastOperation != null && previousInput.length() > 0 && currentInput.length() > 0) {
            double prevValue = Double.parseDouble(previousInput.toString());
            double currValue = Double.parseDouble(currentInput.toString());
            double result = lastOperation.operate(prevValue, currValue);

            currentInput.setLength(0);
            currentInput.append(result);
            lastOperation = null;
        }
    }

    public void clear() {
        currentInput.setLength(0);
        previousInput.setLength(0);
        lastOperation = null;
    }

    public void appendDecimal() {
        if (!currentInput.toString().contains(".")) {
            if (currentInput.length() == 0) {
                currentInput.append("0");
            }
            currentInput.append(".");
        }
    }
}


