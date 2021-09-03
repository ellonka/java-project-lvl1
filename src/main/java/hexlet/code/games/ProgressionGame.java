package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Scanner;

public class ProgressionGame {
    private static String rules = "What number is missing in the progression?";
    static final int LENGTH_OF_PROGRESSION = 10;

    public static void playProgressionGame(Scanner scanner) {
        String[] arrayOfQuestions = new String[Engine.COUNT_OF_REPEAT];
        String[] arrayOfRightAnswers = new String[Engine.COUNT_OF_REPEAT];
        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            arrayOfQuestions[i] = question();
            arrayOfRightAnswers[i] = rightAnswer(arrayOfQuestions[i]);
        }

        Engine.play(scanner, rules, arrayOfQuestions, arrayOfRightAnswers);
    }

    public static String question() {
        String str = "";
        int[] arr = generateArray(LENGTH_OF_PROGRESSION);
        int missingPos = generateMissingPos(arr);
        for (int i = 0; i < arr.length; i++) {
            if (i == missingPos) {
                str += ".. ";
            } else {
                str += arr[i] + " ";
            }
        }
        return str;
    }

    public static String rightAnswer(String str) {
        String sequence = str.trim();
        String[] progression = sequence.split(" ");
        int missingNum = 0;
        for (int i = 0; i < progression.length; i++) {
            if ("..".equals(progression[i])) {
                missingNum = (Integer.parseInt(progression[i - 1]) + Integer.parseInt(progression[i + 1])) / 2;
            }
        }
        return Integer.toString(missingNum);
    }

    static int[] generateArray(int length) {
        int[] arr = new int[length];
        arr[0] = Engine.generateNum();
        int progressionStep = Engine.generateNum();

        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + progressionStep;
        }

        return arr;
    }

    static int generateMissingPos(int[] arr) {
        int missingPos = (int) (Math.random() * (arr.length - 1));
        return missingPos;
    }

}
