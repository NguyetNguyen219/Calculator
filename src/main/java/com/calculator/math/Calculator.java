package com.calculator.tool;

import com.calculator.service.Operator;

public class Calculator {

    public static boolean checkBinaryOperator(Operator op) {
        return op == Operator.SUM ||
                op == Operator.SUBTRACT ||
                op == Operator.MULTIPLY ||
                op == Operator.DIVIDE;
    }

    public static double square(double A) {
        return A * A;
    }

    public static double square_root(double A) {
        return Math.sqrt(A);
    }

    public static double sum(double A, double B) {
        return A + B;
    }

    public static double subtract(double A, double B) {
        return A - B;
    }

    public static double divide(double A, double B) {
        return A / B;
    }

    public static double multiply(double A, double B) {
        return A * B;
    }
}
