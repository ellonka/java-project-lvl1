package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class PrimeGame {
    private static String rules = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void playPrimeGame() {
        String[] questions = new String[Engine.COUNT_OF_REPEAT];
        String[] rightAnswers = new String[Engine.COUNT_OF_REPEAT];
        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            questions[i] = getQuestion();
            rightAnswers[i] = getRightAnswer(questions[i]);
        }

        Engine.play(rules, questions, rightAnswers);
    }

    public static String getQuestion() {
        return Integer.toString(Utils.generateNum(1, 100));
    }

    public static String getRightAnswer(String num) {
        int checkedNum = Integer.parseInt(num);
        return isPrime(checkedNum) ? "yes" : "no";
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
