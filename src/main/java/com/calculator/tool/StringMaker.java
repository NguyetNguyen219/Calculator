package com.calculator.tool;

import com.calculator.math.Operator;

public class StringMaker {

    public static String makeStringCalculation(String x, String y, Operator operator, String res) {
        switch (operator) {
            case SQUARE -> x += "^2";
            case SQUARE_ROOT -> x += "^(1/2)";
            case SUM -> x += " + " + y;
            case SUBTRACT -> x += " - " + y;
            case MULTIPLY -> x += " * " + y;
            case DIVIDE -> x += "/" + y;
            default -> {
            }
        }
        return (x + " = " + res);
    }
}