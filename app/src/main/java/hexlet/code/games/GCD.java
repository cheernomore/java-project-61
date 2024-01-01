package hexlet.code.games;

import hexlet.code.Utils;

public class GCD {
    public static final String GAME_RULES = "Find the greatest common divisor of given numbers.";
    public static Object[] questions = new Object[3];
    public static Object[] answers = new Object[3];

    public static void generateQuestionsAndAnswers() {
        for (int i = 0; i < questions.length; i++) {
            int first = Utils.getRandomNumber(1, 100);
            int second = Utils.getRandomNumber(1, 100);
            questions[i] = first + " " + second;
            answers[i] = Integer.toString(gcd(first, second));
        }
    }

    public static int gcd(int first, int second) {
        return second == 0 ? first : gcd(second, first % second);
    }

}
