package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

import java.util.Scanner;

public class ProgressionGame {
    static final int LENGTH_OF_PROGRESSION = 10;
    private static int[] arr = new int[LENGTH_OF_PROGRESSION];
    private static int missingPos;

    public static void playProgressionGame(Scanner scanner) {
        String name = Cli.hello(scanner);
        System.out.println("What number is missing in the progression?");

        String[] arrayOfQuestions = new String[Engine.COUNT_OF_REPEAT];
        String[] arrayOfRightAnswers = new String[Engine.COUNT_OF_REPEAT];
        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            arrayOfQuestions[i] = question();
            arrayOfRightAnswers[i] = rightAnswer();
        }

        Engine.play(scanner, name, arrayOfQuestions, arrayOfRightAnswers);
    }

    public static String question() {
        String str = "";
        generateArray();
        generateMissingPos(LENGTH_OF_PROGRESSION);
        for (int i = 0; i < arr.length; i++) {
            if (i == missingPos) {
                str += ".. ";
            } else {
                str += arr[i] + " ";
            }
        }
        return str;
    }

    public static String rightAnswer() {
        return Integer.toString(arr[missingPos]);
    }

    static void generateArray() {
        arr[0] = Engine.generateNum();
        int progressionStep = Engine.generateNum();

        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + progressionStep;
        }
    }

    static void generateMissingPos(int length) {
        missingPos = (int) (Math.random() * length);
    }

}
