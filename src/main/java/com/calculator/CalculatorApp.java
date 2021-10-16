package com.calculator;

import com.calculator.io.FileWriter;
import com.calculator.io.TextFileWriter;
import com.calculator.tool.NumberChecker;

import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.in;

public class Calculator {

    private static String fileOutput = "src/main/resources/OutputData.txt";

    private double firstNum;
    private double secondNum;
    private Scanner scan;
    private boolean hasFirstNumber;
    private FileWriter fileWriter;

    public Calculator() {
        firstNum = 0;
        secondNum = 0;
        scan = new Scanner(System.in);
        hasFirstNumber = false;
        fileWriter = new TextFileWriter(fileOutput);
    }

    public void run() {

        printInputNumber();
        inputNumber();

        printMenu();
        Option opt = pickAnOption();
        if()
        executeOption(opt);
    }

    public void setFirstNum(double firstNum) {
        this.firstNum = firstNum;
    }

    public void setSecondNum(double secondNum) {
        this.secondNum = secondNum;
    }

    private void inputNumber() {

        double num;
        do {
            num = scan.nextDouble();
            if (!NumberChecker.checkNumber(num)) {
                System.out.println("Accept only number in range from -20 to 20.");
                printInputNumber();
            }
        } while (!NumberChecker.checkNumber(num));

        if(!hasFirstNumber) {
            firstNum = num;
            hasFirstNumber = true;
        }
        else {
            secondNum = num;
            hasFirstNumber = false;
        }
    }

    private Option pickAnOption() {
        int option;

        do {
            System.out.print("Pick an option: ");
            option = scan.nextInt();

            if(option < 0 || option > 5) {
                System.out.println("Invalid option, please try again.");
            }
        } while (option < 0 || option > 5);

        return Option.values()[option];
    }

    private void executeOption(Option op) {
        switch (op) {
            case SQUARE:
                setFirstNum(sum(firstNum, secondNum));
                printRes(firstNum);
                break;
            case SQUARE_ROOT:
                setFirstNum();
                printRes(firstNum);
                break;
            case SUM:
                setFirstNum(sum(firstNum, secondNum));
                printRes(firstNum);
                break;
            case SUBTRACT:
                setFirstNum(minus(firstNum, secondNum));
                printRes(firstNum);
                break;
            case MULTIPLY:     //Multiplication
                setFirstNum(multiply(firstNum, secondNum));
                printRes(firstNum);
                break;
            case DIVIDE:     //Division
                setFirstNum(divide(firstNum, secondNum));
                printRes(firstNum);
                break;
            default:
                break;
        }
    }

    public void printInputNumber() {
        System.out.print("Input a number: ");
    }

    public void printMenu() {
        System.out.println("---option----");
        System.out.println("0: 1/x\t1: x^2");
        System.out.println("2: +\t3: -\n" +
                "4: *\t5: /");
    }

    public void printRes(double res) {
        System.out.println("---result----");
        if (res % 1 == 0) {
            System.out.println((int)res);
            fileWriter.writeFile((int)res);
        }
        else {
            System.out.println(res);
            fileWriter.writeFile(res);
        }
    }

    public double sum(double firstNum, double secondNum) {
        return firstNum + secondNum;
    }

    public double minus(double firstNum, double secondNum) {
        return firstNum - secondNum;
    }

    public double divide(double firstNum, double secondNum) {
        return firstNum / secondNum;
    }

    public double multiply(double firstNum, double secondNum) {
        return firstNum * secondNum;
    }
}