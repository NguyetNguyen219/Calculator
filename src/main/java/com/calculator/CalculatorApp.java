package com.calculator;

import com.calculator.io.FileWriter;
import com.calculator.io.TextFileWriter;
import com.calculator.math.Calculator;
import com.calculator.math.Operator;
import com.calculator.tool.NumberChecker;
import com.calculator.tool.NumberConverter;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Scanner;

public class CalculatorApp {

    private double firstNum, secondNum, result;
    private Operator opUsed;

    private String fileOutput;
    private boolean hasFirstNumber;
    private Scanner scan;
    private FileWriter fileWriter;

    // Initial function
    public CalculatorApp(String fileOutput) {
        hasFirstNumber = false;
        scan = new Scanner(System.in);
        this.fileOutput = fileOutput;
    }

    public void run() throws IOException {

        printInputMessage();
        inputNumber();
        printMenu();
        opUsed = pickAnOption();

        // If operator is binary, ask for the second number
        if(NumberChecker.checkBinaryOperator(opUsed)) {
            printInputMessage();
            inputNumber();
        }
        execCalculatedOpt(opUsed);
        printResult();
        saveDataToFile();
    }

    // Scan and check the number input
    private void inputNumber() {

        double num;
        do {
            num = scan.nextDouble();
            if (!NumberChecker.checkNumberInRange(num)) {
                System.out.println("Accept only number in range from -20 to 20.");
                printInputMessage();
            }
        } while (!NumberChecker.checkNumberInRange(num));

        if(!hasFirstNumber) {
            firstNum = num;
            hasFirstNumber = true;
        }
        else {
            secondNum = num;
            hasFirstNumber = false;
        }
    }

    // Read the choice of user and convert to Calculator Option
    private Operator pickAnOption() {
        int option;

        do {
            System.out.print("Pick an option: ");
            option = scan.nextInt();

            if(option < 0 || option >= Operator.values().length) {
                System.out.println("Invalid option, please try again...");
                printMenu();
            }
        } while (option < 0 || option >= Operator.values().length);

        return Operator.values()[option];
    }

    // Calculate numbers and save the result
    private void execCalculatedOpt(@NotNull Operator op) {
        switch (op) {
            case SQUARE:
                setResult(Calculator.square(firstNum));
                break;
            case SQUARE_ROOT:
                setResult(Calculator.square_root(firstNum));
                break;
            case SUM:
                setResult(Calculator.sum(firstNum, secondNum));
                break;
            case SUBTRACT:
                setResult(Calculator.subtract(firstNum, secondNum));
                break;
            case MULTIPLY:
                setResult(Calculator.multiply(firstNum, secondNum));
                break;
            case DIVIDE:
                setResult(Calculator.divide(firstNum, secondNum));
                break;
            default:
                break;
        }
    }

    public void printInputMessage() {
        if(!hasFirstNumber) {
            System.out.print("Input number x: ");
        }
        else {
            System.out.print("Input number y: ");
        }
    }

    public void printMenu() {
        System.out.println("Options");
        System.out.println("0: x^2      1: x^(1/2)");
        System.out.println("2: x + y    3: x - y\n" +
                           "4: x * y    5: x/y");
    }

    public void printResult() {
        System.out.println("---------------");
        System.out.println(NumberConverter.toString(getResult()));
    }

    // Save the last calculation to file
    public void saveDataToFile() throws IOException {
        fileWriter = new TextFileWriter(fileOutput);

        String str = "Calculation:\n";
        String x = NumberConverter.toString(firstNum);
        String y = NumberConverter.toString(secondNum);
        String res = NumberConverter.toString(result);

        switch (opUsed) {
            case SQUARE:
                str = x + "^2 = " + res;
                break;
            case SQUARE_ROOT:
                str = x + "^(1/2) = " + res;
                break;
            case SUM:
                str = x + " + " + y + " = " + res;
                break;
            case SUBTRACT:
                str = x + " - " + y + " = " + res;
                break;
            case MULTIPLY:
                str = x + " * " + y + " = " + res;
                break;
            case DIVIDE:
                str = x + "/" + y + " = " + res;
                break;
            default:
                break;
        }

        fileWriter.writeFile(str);
        System.out.println("*Result saved in ../" + fileOutput);
    }

    public double getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public double getSecondNum() {
        return secondNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    protected void setResult(double res) {
        this.result = res;
    }

    public double getResult() {
        return result;
    }
}