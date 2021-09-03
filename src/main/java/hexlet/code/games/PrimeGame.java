package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class PrimeGame {
    private static String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void playPrimeGame(Scanner scanner) {
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

    public static String rightAnswer(String num) {
        int checkedNum = Integer.parseInt(num);
        return isPrime(checkedNum) ? "yes" : "no";
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        int sqrtOfNum = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrtOfNum; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
