package hexlet.code.games;

import hexlet.code.Config;
import hexlet.code.Utils;

public class Prime {
    public static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static final int QUESTIONS_COUNT = Config.QUESTION_COUNT;
    public static final int LOWER_BOUND = Config.PRIME_LOWER_BOUND;
    public static final int UPPER_BOUND = Config.PRIME_UPPER_BOUND;

    public static String[][] generateGameData() {
        String[] questions = new String[QUESTIONS_COUNT];
        String[] answers = new String[QUESTIONS_COUNT];
        String[][] questionsAnswers = new String[QUESTIONS_COUNT][QUESTIONS_COUNT];

        for (int i = 0; i < questions.length; i++) {
            int num = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            questions[i] = Integer.toString(num);
            answers[i] = isPrime(num);
        }

        questionsAnswers[0] = questions;
        questionsAnswers[1] = answers;

        return questionsAnswers;
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

    public static String getGameRules() {
        return GAME_RULES;
    }
}
