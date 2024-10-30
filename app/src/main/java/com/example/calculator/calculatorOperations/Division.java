package com.example.calculator.calculatorOperations;

public class Division implements Operation {
    @Override
    public double operate(double a, double b) {
        if (b == 0) throw new ArithmeticException("Cannot divide by zero");
        return a / b;
    }
}
