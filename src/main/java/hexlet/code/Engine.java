package hexlet.code;

import java.util.Scanner;

public class Engine {
    static final int FROM_NUM = 1;
    static final int TO_NUM = 100;
    public static final int COUNT_OF_REPEAT = 3;

    public static void play(Scanner scanner, String rules, String[] question, String[] rightAnswer) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        String name = scanner.next();
        System.out.println("Hello, " + name + "!");
        System.out.println(rules);

        for (int i = 0; i < COUNT_OF_REPEAT; i++) {
            System.out.println("Question: " + question[i]);
            System.out.print("Your answer: ");
            String answer = scanner.next();

            if (answer.equals(rightAnswer[i])) {
                System.out.println("Correct!");

                if (i == COUNT_OF_REPEAT - 1) {
                    System.out.println("Congratulations, " + name + "!");
                }
            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + rightAnswer[i] + "'.");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
        }
    }

    public static int generateNum() {
        return FROM_NUM + (int) (Math.random() * TO_NUM);
    }
}
