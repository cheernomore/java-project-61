package hexlet.code.games;

import hexlet.code.Utils;

public class Prime {
    public static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
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
            int num = Utils.getRandomNumber(DEFAULT_LOWER_BOUND, DEFAULT_UPPER_BOUND);
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
