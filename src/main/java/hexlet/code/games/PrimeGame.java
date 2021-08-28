package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class PrimeGame {
    private static int checkedNum;

    public static void playPrimeGame(Scanner scanner) {
        String name = Cli.hello(scanner);
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        String[] arrayOfQuestions = new String[Engine.COUNT_OF_REPEAT];
        String[] arrayOfRightAnswers = new String[Engine.COUNT_OF_REPEAT];
        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            arrayOfQuestions[i] = question();
            arrayOfRightAnswers[i] = rightAnswer();
        }

        Engine.play(scanner, name, arrayOfQuestions, arrayOfRightAnswers);
    }

    public static String question() {
        checkedNum = Engine.generateNum();
        return Integer.toString(checkedNum);
    }

    public static String rightAnswer() {
        if (isPrime(checkedNum)) {
            return "yes";
        } else {
            return "no";
        }
    }

    private static boolean isPrime(int num) {
        int sqrtOfNum = (int) Math.sqrt(num);
        int k = 2;

        if (num < 2) {
            return false;
        }

        while (k <= sqrtOfNum) {
            if (num % k == 0) {
                return false;
            }
            k++;
        }
        return true;
    }
}
