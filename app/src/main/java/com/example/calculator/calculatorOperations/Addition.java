package com.example.calculator.calculatorOperations;

public class Addition implements Operation {
    @Override
    public double operate(double a, double b) {
        return a + b;
    }
}