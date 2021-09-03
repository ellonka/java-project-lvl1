package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class EvenGame {
    private static String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void playEvenGame(Scanner scanner) {
        String[] arrayOfQuestions = new String[Engine.COUNT_OF_REPEAT];
        String[] arrayOfRightAnswers = new String[Engine.COUNT_OF_REPEAT];
        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            arrayOfQuestions[i] = question();
            arrayOfRightAnswers[i] = rightAnswer(arrayOfQuestions[i]);
        }

        Engine.play(scanner, rules, arrayOfQuestions, arrayOfRightAnswers);
    }

    public static String question() {
        return Integer.toString(Engine.generateNum());
    }

    public static String rightAnswer(String checkedNum) {
        int num = Integer.parseInt(checkedNum);
        return isEven(num) ? "yes" : "no";
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
