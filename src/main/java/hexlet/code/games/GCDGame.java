package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCDGame {
    private static String rules = "Find the greatest common divisor of given numbers.";

    public static void playGCDGame() {
        String[] questions = new String[Engine.COUNT_OF_REPEAT];
        String[] rightAnswers = new String[Engine.COUNT_OF_REPEAT];
        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            questions[i] = getQuestion();
            rightAnswers[i] = getRightAnswer(questions[i]);
        }

        Engine.play(rules, questions, rightAnswers);
    }

    public static String getQuestion() {
        int num1 = Utils.generateNum(1, 100);
        int num2 = Utils.generateNum(1, 100);

        return num1 + " " + num2;
    }

    public static String getRightAnswer(String expression) {
        String[] numbers = expression.split(" ");
        int max = Math.max(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
        int min = Math.min(Integer.parseInt(numbers[0]), Integer.parseInt(numbers[1]));
        int temp;

        if (max % min == 0) {
            return Integer.toString(min);
        } else {
            while (min != 0) {
                temp = max;
                max = min;
                min = temp % min;
            }
            return Integer.toString(max);
        }
    }
}
