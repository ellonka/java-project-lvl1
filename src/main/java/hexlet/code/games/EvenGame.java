package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class EvenGame {
    static int randomNum;

    public static void playEvenGame(Scanner scanner) {
        String name = Cli.hello(scanner);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        Engine.play(scanner, name, question(), rightAnswer());
    }

    public static String question() {
        randomNum = Engine.generateNum();
        return Integer.toString(randomNum);
    }

    public static String rightAnswer() {
        return isEven(randomNum);
    }

    public static String isEven(int num) {
        if (num % 2 == 0) {
            return "yes";
        }
        return "no";
    }
}
