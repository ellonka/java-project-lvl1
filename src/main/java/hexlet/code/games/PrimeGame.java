package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class PrimeGame {
    private static final String RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void playPrimeGame() {
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
        return isPrime(val) ? "yes" : "no";
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        int sqrtOfNum = (int) Math.sqrt(num);
        for (int i = 2; i <= sqrtOfNum; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
