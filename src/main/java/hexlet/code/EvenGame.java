package hexlet.code;

import java.util.Scanner;

public class EvenGame {
    static final int FROM_NUM = 0;
    static final int TO_NUM = 100;
    static final int COUNT_OF_REPEAT = 3;

    public static void playEvenGame(Scanner scanner) {
        String name = Cli.hello(scanner);

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        int k = 0;
        while (k < COUNT_OF_REPEAT) {
            int questionNum = FROM_NUM + (int) (Math.random() * TO_NUM);
            String rightAnswer = isEven(questionNum);

            System.out.println("Question: " + questionNum);
            System.out.print("Your answer: ");
            String answer = scanner.next();

            if (answer.equals(rightAnswer)) {
                System.out.println("Correct!");

                if (k == COUNT_OF_REPEAT - 1) {
                    System.out.println("Congratulations, " + name + "!");
                }

            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + rightAnswer + "'.");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
            k++;
        }
    }

    public static String isEven(int num) {
        if (num % 2 == 0) {
            return "yes";
        }
        return "no";
    }
}
