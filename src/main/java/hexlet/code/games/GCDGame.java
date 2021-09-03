package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class GCDGame {
    private static String rules = "Find the greatest common divisor of given numbers.";

    public static void playGCDGame(Scanner scanner) {
        String[] arrayOfQuestions = new String[Engine.COUNT_OF_REPEAT];
        String[] arrayOfRightAnswers = new String[Engine.COUNT_OF_REPEAT];
        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            arrayOfQuestions[i] = question();
            arrayOfRightAnswers[i] = rightAnswer(arrayOfQuestions[i]);
        }

        Engine.play(scanner, rules, arrayOfQuestions, arrayOfRightAnswers);
    }

    public static String question() {
        int num1 = Engine.generateNum();
        int num2 = Engine.generateNum();

        return num1 + " " + num2;
    }

    public static String rightAnswer(String expression) {
        String[] numbers = expression.split(" ");
        int max = Math.max(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
        int min = Math.min(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
        int temp;

        if (max % min == 0) {
            return Integer.toString(min);
        } else {
            while (min != 0) {
                temp = max;
                max = min;
                min = temp % min;
            }
            return Integer.toString(max);
        }
    }
}
