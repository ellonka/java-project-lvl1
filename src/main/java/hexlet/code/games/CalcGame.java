package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class CalcGame {
    static int num1;
    static int num2;
    static int operator;

    public static void playCalcGame(Scanner scanner) {
        String name = Cli.hello(scanner);
        System.out.println("What is the result of the expression?");
        Engine.play(scanner, name, question(), rightAnswer());
    }

    public static String question() {
        num1 = Engine.generateNum();
        num2 = Engine.generateNum();

        return num1 + " " + generateOperator() + " " + num2;
    }

    public static String rightAnswer() {
        int result;
        if (operator == 0) {
            result = num1 + num2;
            return Integer.toString(result);
        } else if (operator == 1) {
            result = num1 - num2;
            return Integer.toString(result);
        } else {
            result = num1 * num2;
            return Integer.toString(result);
        }
    }

    private static String generateOperator() {
        operator = (int) (Math.random() * 3);
        if (operator == 0) {
            return "+";
        } else if (operator == 1) {
            return "-";
        } else {
            return "*";
        }
    }

}
