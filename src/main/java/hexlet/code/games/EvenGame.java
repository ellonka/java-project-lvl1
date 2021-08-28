package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class EvenGame {
    private static int randomNum;

    public static void playEvenGame(Scanner scanner) {
        String name = Cli.hello(scanner);
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        String[] arrayOfQuestions = new String[Engine.COUNT_OF_REPEAT];
        String[] arrayOfRightAnswers = new String[Engine.COUNT_OF_REPEAT];
        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            arrayOfQuestions[i] = question();
            arrayOfRightAnswers[i] = rightAnswer();
        }

        Engine.play(scanner, name, arrayOfQuestions, arrayOfRightAnswers);
    }

    public static String question() {
        randomNum = Engine.generateNum();
        return Integer.toString(randomNum);
    }

    public static String rightAnswer() {
        if (isEven(randomNum)) {
            return "yes";
        } else {
            return "no";
        }
    }

    public static boolean isEven(int num) {
        if (num % 2 == 0) {
            return true;
        }
        return false;
    }
}
