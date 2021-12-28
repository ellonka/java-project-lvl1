package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCDGame {
    private static final String RULES = "Find the greatest common divisor of given numbers.";

    public static void playGCDGame() {
        String[] questions = new String[Engine.COUNT_OF_REPEAT];
        String[] rightAnswers = new String[Engine.COUNT_OF_REPEAT];
        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            int num1 = Utils.generateNum(1, Utils.MAX_VALUE);
            int num2 = Utils.generateNum(1, Utils.MAX_VALUE);
            questions[i] = getQuestion(num1, num2);
            rightAnswers[i] = findGcd(num1, num2);
        }

        Engine.play(RULES, questions, rightAnswers);
    }

    public static String getQuestion(int num1, int num2) {
        return num1 + " " + num2;
    }

    public static String findGcd(int num1, int num2) {
        int max = Math.max(num1, num2);
        int min = Math.min(num1, num2);

        if (max % min == 0) {
            return Integer.toString(min);
        }
        while (min != 0) {
            int temp = max;
            max = min;
            min = temp % min;
        }

        return Integer.toString(max);
    }
}
