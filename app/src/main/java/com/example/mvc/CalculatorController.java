package com.example.mvc.controller;

import com.example.mvc.model.CalculatorModel;

public class CalculatorController {

    private final CalculatorModel calculatorModel;

    public CalculatorController() {
        this.calculatorModel = new CalculatorModel();
    }

    public double calculate(double number1, double number2, String operation) throws ArithmeticException {
        switch (operation) {
            case "+":
                return calculatorModel.add(number1, number2);
            case "-":
                return calculatorModel.subtract(number1, number2);
            case "*":
                return calculatorModel.multiply(number1, number2);
            case "/":
                return calculatorModel.divide(number1, number2);
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }
}
