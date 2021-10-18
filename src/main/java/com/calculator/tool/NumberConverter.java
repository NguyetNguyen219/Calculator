package com.calculator.tool;

public class NumberConverter {

    public static String toString(double d) {

        if(NumberChecker.checkNumIsInteger(d))
            return String.valueOf((int)d);
        else
            return String.valueOf(d);
    }
}
