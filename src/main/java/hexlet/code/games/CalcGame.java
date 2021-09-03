package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class CalcGame {
    private static String rules = "What is the result of the expression?";
    private static final int COUNT_OF_OPERATORS = 3;

    public static void playCalcGame(Scanner scanner) {
        String[] arrayOfQuestions = new String[Engine.COUNT_OF_REPEAT];
        String[] arrayOfRightAnswers = new String[Engine.COUNT_OF_REPEAT];
        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            arrayOfQuestions[i] = question();
            arrayOfRightAnswers[i] = rightAnswer(arrayOfQuestions[i]);
        }

        Engine.play(scanner, rules, arrayOfQuestions, arrayOfRightAnswers);
    }

    public static String question() {
        return Engine.generateNum() + " " + generateOperator() + " " + Engine.generateNum();
    }

    public static String rightAnswer(String expression) {
        String[] partsOfExpression = expression.split(" ");

        int num1 = Integer.parseInt(partsOfExpression[0]);
        String operator = partsOfExpression[1];
        int num2 = Integer.parseInt(partsOfExpression[2]);

        switch (operator) {
            case "+":
                return Integer.toString(num1 + num2);
            case "-":
                return Integer.toString(num1 - num2);
            default:
                return Integer.toString(num1 * num2);
        }
    }

    private static String generateOperator() {
        int operator = (int) (Math.random() * COUNT_OF_OPERATORS);

        switch (operator) {
            case 0:
                return "+";
            case 1:
                return "-";
            default:
                return "*";
        }
    }

}
