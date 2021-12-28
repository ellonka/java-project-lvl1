package hexlet.code;

public class Utils {
    public static final int MAX_VALUE = 100;

    public static int generateNum(int fromNum, int toNum) {
        return fromNum + (int) (Math.random() * (toNum - fromNum));
    }
}
