package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class EvenGame {
    private static final String RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void playEvenGame() {
        String[] questions = new String[Engine.COUNT_OF_REPEAT];
        String[] rightAnswers = new String[Engine.COUNT_OF_REPEAT];

        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            int val = Utils.generateNum(1, Utils.MAX_VALUE);
            questions[i] = getQuestion(val);
            rightAnswers[i] = getRightAnswer(val);
        }

        Engine.play(RULES, questions, rightAnswers);
    }

    public static String getQuestion(int val) {
        return Integer.toString(val);
    }

    public static String getRightAnswer(int val) {
        return isEven(val) ? "yes" : "no";
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
