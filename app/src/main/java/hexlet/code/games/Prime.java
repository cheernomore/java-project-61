package hexlet.code.games;

import hexlet.code.Utils;

public class Prime {
    public static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static Object[] questions = new Object[3];
    public static Object[] answers = new Object[3];
    public static void generateQuestionsAndAnswers() {
        for (int i = 0; i < questions.length; i++) {
            int num = Utils.getRandomNumber(1, 1000);
            questions[i] = Integer.toString(num);
            answers[i] = isPrime(num);
        }
    }

    public static String isPrime(int n) {
        if (n < 2) {
            return "no";
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
