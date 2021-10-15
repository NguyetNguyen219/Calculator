package com.tool;

import java.util.Arrays;

public class NumberChecker {
    public static boolean checkNumber(double num) {
        return (num >= -20 && num <= 20);
    }

    public static boolean checkNumbers(double[] nums) {
        return Arrays.stream(nums).allMatch(num -> checkNumber(num));
    }
}
