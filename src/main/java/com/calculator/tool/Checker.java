package com.calculator.tool;

import com.calculator.math.Operator;

public class Checker {

    public static boolean checkNumberInRange(double num) {
        return (num >= -20 && num <= 20);
    }

    public static boolean checkBinaryOperator(Operator op) {
        return op == Operator.SUM ||
                op == Operator.SUBTRACT ||
                op == Operator.MULTIPLY ||
                op == Operator.DIVIDE;
    }

    public static boolean checkNumIsInteger(double op) {
        return (Math.floor(op) == op);
    }
}
