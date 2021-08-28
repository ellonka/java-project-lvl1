package hexlet.code;

import java.util.Scanner;

public class Engine {
    static final int FROM_NUM = 1;
    static final int TO_NUM = 100;
    public static final int COUNT_OF_REPEAT = 3;

    public static void play(Scanner scanner, String name, String[] question, String[] rightAnswer) {

        int k = 0;
        while (k < COUNT_OF_REPEAT) {
            System.out.println("Question: " + question[k]);
            System.out.print("Your answer: ");
            String answer = scanner.next();


            if (answer.equals(rightAnswer[k])) {
                System.out.println("Correct!");

                if (k == COUNT_OF_REPEAT - 1) {
                    System.out.println("Congratulations, " + name + "!");
                }

            } else {
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                        + rightAnswer[k] + "'.");
                System.out.println("Let's try again, " + name + "!");
                break;
            }
            k++;
        }
    }

    public static int generateNum() {
        return FROM_NUM + (int) (Math.random() * TO_NUM);
    }
}
