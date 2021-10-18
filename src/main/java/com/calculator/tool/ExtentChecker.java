package com.calculator.tool;

import com.calculator.math.Operator;

public class ExtentChecker {

    public static boolean checkNumberInRange(double num) {
        return (num >= -20 && num <= 20);
    }

    public static boolean checkBinaryOperator(Operator operator) {
        return operator == Operator.SUM ||
                operator == Operator.SUBTRACT ||
                operator == Operator.MULTIPLY ||
                operator == Operator.DIVIDE;
    }

    public static boolean checkValidYesNoAns(String str) {
        return str.equalsIgnoreCase("y") ||
                str.equalsIgnoreCase("yes") ||
                str.equalsIgnoreCase("n") ||
                str.equalsIgnoreCase("no");
    }
}
