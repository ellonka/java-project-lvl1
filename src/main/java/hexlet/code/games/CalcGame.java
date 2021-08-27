package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class CalcGame {
    private static int num1;
    private static int num2;
    private static int operator;
    private static final int COUNT_OF_OPERATORS = 3;

    public static void playCalcGame(Scanner scanner) {
        String name = Cli.hello(scanner);
        System.out.println("What is the result of the expression?");

        String[] arrayOfQuestions = new String[Engine.COUNT_OF_REPEAT];
        String[] arrayOfRightAnswers = new String[Engine.COUNT_OF_REPEAT];
        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            arrayOfQuestions[i] = question();
            arrayOfRightAnswers[i] = rightAnswer();
        }

        Engine.play(scanner, name, arrayOfQuestions, arrayOfRightAnswers);
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
        operator = (int) (Math.random() * COUNT_OF_OPERATORS);
        if (operator == 0) {
            return "+";
        } else if (operator == 1) {
            return "-";
        } else {
            return "*";
        }
    }

}
