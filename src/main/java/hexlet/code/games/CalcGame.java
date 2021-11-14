package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalcGame {
    private static String rules = "What is the result of the expression?";
    private static final int COUNT_OF_OPERATORS = 3;

    public static void playCalcGame() {
        String[] questions = new String[Engine.COUNT_OF_REPEAT];
        String[] rightAnswers = new String[Engine.COUNT_OF_REPEAT];
        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            questions[i] = getQuestion();
            rightAnswers[i] = getRightAnswer(questions[i]);
        }

        Engine.play(rules, questions, rightAnswers);
    }

    public static String getQuestion() {
        return Utils.generateNum(1, 100) + " " + generateOperator() + " " + Utils.generateNum(1, 100);
    }

    public static String getRightAnswer(String expression) {
        String[] partsOfExpression = expression.split(" ");

        int num1 = Integer.parseInt(partsOfExpression[0]);
        String operator = partsOfExpression[1];
        int num2 = Integer.parseInt(partsOfExpression[2]);

        switch (operator) {
            case "+":
                return Integer.toString(num1 + num2);
            case "-":
                return Integer.toString(num1 - num2);
            case "*":
                return Integer.toString(num1 * num2);
            default:
                return "Что-то пошло не так"; //с break здесь выдает ошибку, потому что в этом случае не возвращается String
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
