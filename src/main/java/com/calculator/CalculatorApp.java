package com.calculator;

import com.calculator.io.FileWriter;
import com.calculator.io.TextFileWriter;
import com.calculator.math.Calculator;
import com.calculator.math.Operator;
import com.calculator.tool.ExtentChecker;
import com.calculator.tool.StringMaker;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.Scanner;

public class CalculatorApp {

    private Double firstNum, secondNum, result;
    private Operator operator;

    private boolean hasFirstNumber;
    private final Scanner scan;
    private final FileWriter fileWriter;

    // Initial function
    public CalculatorApp(String file) {

        scan = new Scanner(System.in);
        fileWriter = new TextFileWriter(file);
        hasFirstNumber = false;
    }

    public void run() throws IOException {

        do {
            inputNumber();
            printMenu();
            operator = pickAnOption();

            // If operator is binary, ask for the second number
            if (ExtentChecker.checkBinaryOperator(operator)) {
                inputNumber();
            }
            // If there are math errors
            if (!execCalculation(operator)) {
                System.out.println("Warning: cannot divide by 0.");
            } else {
                printResult();
                saveDataToFile();
            }
        } while (askToContinue());
    }

    // Scan and check the number input
    private void inputNumber() {
        double num;

        while (true) {
            printInputMessage();
            // If the input has double type
            if (scan.hasNextDouble()) {
                num = scan.nextDouble();
                // Check if the input is correct in range [-20, 20] -> break the loop
                if (ExtentChecker.checkNumberInRange(num))
                    break;
            } else {
                scan.next();
            }
            printInvalidNumberMessage();
        }

        if (!hasFirstNumber) {
            firstNum = num;
            hasFirstNumber = true;
        } else {
            secondNum = num;
            hasFirstNumber = false;
        }
    }

    // Read the choice of user and convert to Calculator Option
    private Operator pickAnOption() {
        int option;

        while (true) {
            System.out.print("Pick an option: ");

            if (scan.hasNextInt()) {
                option = scan.nextInt();
                if (option >= 0 && option < Operator.values().length)
                    break;
            } else {
                scan.next();
            }
            printInvalidOptionMessage();
        }

        return Operator.values()[option];
    }

    // Calculate numbers and save the result.
    // If there are errors, return false.
    private boolean execCalculation(@NotNull Operator operator) {
        switch (operator) {
            case SQUARE -> setResult(Calculator.square(firstNum));
            case SQUARE_ROOT -> setResult(Calculator.square_root(firstNum));
            case SUM -> setResult(Calculator.sum(firstNum, secondNum));
            case SUBTRACT -> setResult(Calculator.subtract(firstNum, secondNum));
            case MULTIPLY -> setResult(Calculator.multiply(firstNum, secondNum));
            case DIVIDE -> {
                if (secondNum == 0)
                    return false;
                setResult(Calculator.divide(firstNum, secondNum));
            }
            default -> {
                return false;
            }
        }
        return true;
    }

    // Ask if user want to continue calculate
    private boolean askToContinue() {
        String choice;

        scan.nextLine();
        do {
            System.out.print("Continue to calculate? (Y/N) ");
            choice = scan.nextLine();

            if (!ExtentChecker.checkValidYesNoAns(choice))
                printWrongAnswerMessage();
        } while (!ExtentChecker.checkValidYesNoAns(choice));

        return choice.toLowerCase().contains("y");
    }

    public void printInputMessage() {
        if (!hasFirstNumber) {
            System.out.print("Input number x: ");
        } else {
            System.out.print("Input number y: ");
        }
    }

    public void printMenu() {
        System.out.println("Options:");
        System.out.println("""
                0: x^2      1: x^(1/2)
                2: x + y    3: x - y
                4: x * y    5: x/y""");
    }

    public void printInvalidOptionMessage() {
        System.out.println("Invalid option, please try again...");
        printMenu();
    }

    public void printInvalidNumberMessage() {
        System.out.println("Accept only number, in range from -20 to 20.");
    }

    public void printWrongAnswerMessage() {
        System.out.println("Your answer is invalid, please try again.");
    }

    public void printResult() {
        System.out.println("--------------------");
        System.out.println(getResult());
    }

    // Save the last calculation to file
    public void saveDataToFile() throws IOException {

        String content = String.valueOf(firstNum) +
                StringMaker.makeStringCalculation(operator);

        if (ExtentChecker.checkBinaryOperator(operator))
            content += String.valueOf(secondNum);

        fileWriter.writeFile(content + " = " + String.valueOf(result));

        System.out.println("*Result saved in ../" + fileWriter.getFileName());
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