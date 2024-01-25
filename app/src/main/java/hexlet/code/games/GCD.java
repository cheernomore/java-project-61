package hexlet.code.games;

import hexlet.code.Utils;

public class GCD {
    public static final String GAME_RULES = "Find the greatest common divisor of given numbers.";
    public static final int DEFAULT_QUESTIONS_COUNT = 3;
    public static final int DEFAULT_ANSWERS_COUNT = 3;
    public static final int DEFAULT_LOWER_BOUND = 1;
    public static final int DEFAULT_UPPER_BOUND = 100;

    public static String[][] transferDataToEngine() {
        return generateGameData();
    }

    public static String[][] generateGameData() {
        String[] questions = new String[DEFAULT_QUESTIONS_COUNT];
        String[] answers = new String[DEFAULT_ANSWERS_COUNT];
        String[][] questionsAnswers = new String[DEFAULT_QUESTIONS_COUNT][DEFAULT_ANSWERS_COUNT];

        for (int i = 0; i < questions.length; i++) {
            int first = Utils.getRandomNumber(DEFAULT_LOWER_BOUND, DEFAULT_UPPER_BOUND);
            int second = Utils.getRandomNumber(DEFAULT_LOWER_BOUND, DEFAULT_UPPER_BOUND);
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
