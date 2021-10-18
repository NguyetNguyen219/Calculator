package com.calculator;

import java.io.IOException;

public class Main {

    private static final String file = "src/main/resources/OutputData.txt";

    public static void main(String[] args) {

        CalculatorApp calculator = new CalculatorApp(file);

        try {
            calculator.run();
        } catch (IOException e) {
            System.err.println("Cannot write output file.");
            e.printStackTrace();
        }
    }
}
