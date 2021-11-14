package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class EvenGame {
    private static String rules = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void playEvenGame() {
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

    public static String getRightAnswer(String checkedNum) {
        int num = Integer.parseInt(checkedNum);
        return isEven(num) ? "yes" : "no";
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
