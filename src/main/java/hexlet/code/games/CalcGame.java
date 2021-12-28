package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {
    private static final String RULES = "What is the result of the expression?";
    private static final int COUNT_OF_OPERATORS = 3;

    public static void playCalcGame() {
        String[] questions = new String[Engine.COUNT_OF_REPEAT];
        String[] rightAnswers = new String[Engine.COUNT_OF_REPEAT];

        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            int num1 = Utils.generateNum(1, Utils.MAX_VALUE);
            int num2 = Utils.generateNum(1, Utils.MAX_VALUE);
            String operator = generateOperator();
            questions[i] = getQuestion(num1, num2, operator);
            rightAnswers[i] = getRightAnswer(num1, num2, operator);
        }

        Engine.play(RULES, questions, rightAnswers);
    }

    public static String getQuestion(int num1, int num2, String operator) {
        return num1 + " " + operator + " " + num2;
    }

    public static String getRightAnswer(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return Integer.toString(num1 + num2);
            case "-":
                return Integer.toString(num1 - num2);
            case "*":
                return Integer.toString(num1 * num2);
            default:
                return "Что-то пошло не так"; //с break здесь выдает ошибку,
                                            // потому что в этом случае не возвращается String
        }
    }

    private static String generateOperator() {
        int operator = (int) (Math.random() * COUNT_OF_OPERATORS);

        switch (operator) {
            case 0:
                return "+";
            case 1:
                return "-";
            default:
                return "*";
        }
    }

}
