package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class ProgressionGame {
    private static final String RULES = "What number is missing in the progression?";
    static final int LENGTH_OF_PROGRESSION = 10;

    public static void playProgressionGame() {
        String[] questions = new String[Engine.COUNT_OF_REPEAT];
        String[] rightAnswers = new String[Engine.COUNT_OF_REPEAT];
        for (int i = 0; i < Engine.COUNT_OF_REPEAT; i++) {
            int[] arr = generateArray(LENGTH_OF_PROGRESSION);
            int missingPos = generateMissingPos(LENGTH_OF_PROGRESSION);
            questions[i] = getQuestion(arr, missingPos);
            rightAnswers[i] = getRightAnswer(arr, missingPos);
        }

        Engine.play(RULES, questions, rightAnswers);
    }

    public static String getQuestion(int[] arr, int missingPos) {
        String question = "";
        for (int i = 0; i < arr.length; i++) {
            if (i == missingPos) {
                question += ".. ";
            } else {
                question += arr[i] + " ";
            }
        }
        return question;
    }

    public static String getRightAnswer(int[] arr, int missingPos) {
        return Integer.toString(arr[missingPos]);
    }

    static int[] generateArray(int length) {
        return generateProgression(Utils.generateNum(0, Utils.MAX_VALUE),
                    Utils.generateNum(0, Utils.MAX_VALUE), length);
    }

    static int[] generateProgression(int firstMember, int step, int length) { //вместо предлагаемого метода buildProgre
        int[] arr = new int[length];                                       //у меня уже был этот. В итоге из всех
        arr[0] = firstMember;                                              //предложений реализовала вынос методов по
        for (int i = 1; i < length; i++) {                                 //генерации прогрессии и пропущенной позиции
            arr[i] = arr[i - 1] + step;                                    //в метод play. За счет этого сильно упрос-
        }                                                                  //тился метод getRightAnswer
        return arr;
    }

    static int generateMissingPos(int arrayLength) {
        return Utils.generateNum(0, arrayLength - 1);
    }

}
