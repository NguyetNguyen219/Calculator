package com.calculator.tool;

import com.calculator.math.Operator;

public class StringMaker {

    public static String makeStringCalculation(Operator operator) {
        String str = "";
        switch (operator) {
            case SQUARE -> str = "^2";
            case SQUARE_ROOT -> str = "^(1/2)";
            case SUM -> str = " + ";
            case SUBTRACT -> str = " - ";
            case MULTIPLY -> str = " * ";
            case DIVIDE -> str = "/";
            default -> {}
        }
        return str;
    }
}