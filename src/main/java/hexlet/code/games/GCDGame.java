package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class GCDGame {
    private static int num1;
    private static int num2;

    public static void playGCDGame(Scanner scanner) {
        String name = Cli.hello(scanner);
        System.out.println("Find the greatest common divisor of given numbers.");

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

        return num1 + " " + num2;
    }

    public static String rightAnswer() {
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);
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
