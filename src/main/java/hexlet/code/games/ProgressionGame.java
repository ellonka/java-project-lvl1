package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class ProgressionGame {
    private static String rules = "What number is missing in the progression?";
    static final int LENGTH_OF_PROGRESSION = 10;

    public static void playProgressionGame() {
        String[] questions = new String[Engine.COUNT_OF_REPEAT];
        String[] rightAnswers = new String[Engine.COUNT_OF_REPEAT];
        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            questions[i] = getQuestion();
            rightAnswers[i] = getRightAnswer(questions[i]);
        }

        Engine.play(rules, questions, rightAnswers);
    }

    public static String getQuestion() {
        String question = "";
        int[] arr = generateArray(LENGTH_OF_PROGRESSION);
        int missingPos = generateMissingPos(LENGTH_OF_PROGRESSION);
        for (int i = 0; i < arr.length; i++) {
            if (i == missingPos) {
                question += ".. ";
            } else {
                question += arr[i] + " ";
            }
        }
        return question;
    }

    public static String getRightAnswer(String str) {
        String sequence = str.trim();
        String[] progression = sequence.split(" ");
        int missingNum = 0;
        for (int i = 0; i < progression.length; i++) {
            if ("..".equals(progression[i]) && i != 0) {
                missingNum = (Integer.parseInt(progression[i - 1]) + Integer.parseInt(progression[i + 1])) / 2;
            } else if ("..".equals(progression[i])) {
                missingNum = 2 * Integer.parseInt(progression[i + 1]) - Integer.parseInt(progression[i + 2]);
            }
        }
        return Integer.toString(missingNum);
    }

    static int[] generateArray(int length) {
        return generateProgression(Utils.generateNum(0, 100), Utils.generateNum(0, 100), length);
    }

    static int[] generateProgression(int firstMember, int step, int length) {
        int[] arr = new int[length];
        arr[0] = firstMember;
        for (int i = 1; i < length; i++) {
            arr[i] = arr[i - 1] + step;
        }
        return arr;
    }

    static int generateMissingPos(int arrayLength) {
        return Utils.generateNum(0, arrayLength);
    }

}
