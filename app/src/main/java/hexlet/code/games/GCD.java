package hexlet.code.games;

import hexlet.code.Utils;

public class GCD {
    public static final String GAME_RULES = "Find the greatest common divisor of given numbers.";
    public static final int QUESTIONS_COUNT = Integer.parseInt(Utils.getProperty("questionsCount"));
    public static final int LOWER_BOUND = Integer.parseInt(Utils.getProperty("gcdLowerBound"));
    public static final int UPPER_BOUND = Integer.parseInt(Utils.getProperty("gcdUpperBound"));

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
