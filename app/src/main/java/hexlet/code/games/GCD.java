package hexlet.code.games;

import hexlet.code.Config;
import hexlet.code.Utils;

public class GCD {
    public static final String GAME_RULES = "Find the greatest common divisor of given numbers.";
    public static final int QUESTIONS_COUNT = Config.QUESTION_COUNT;
    public static final int LOWER_BOUND = Config.GCD_LOWER_BOUND;
    public static final int UPPER_BOUND = Config.GCD_UPPER_BOUND;

    public static String[][] generateGameData() {
        String[] questions = new String[QUESTIONS_COUNT];
        String[] answers = new String[QUESTIONS_COUNT];
        String[][] questionsAnswers = new String[QUESTIONS_COUNT][QUESTIONS_COUNT];

        for (int i = 0; i < questions.length; i++) {
            int first = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            int second = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            questions[i] = first + " " + second;
            answers[i] = Integer.toString(gcd(first, second));
        }

        questionsAnswers[0] = questions;
        questionsAnswers[1] = answers;

        return questionsAnswers;
    }

    public static int gcd(int first, int second) {
        return second == 0 ? first : gcd(second, first % second);
    }

    public static String getGameRules() {
        return GAME_RULES;
    }
}
