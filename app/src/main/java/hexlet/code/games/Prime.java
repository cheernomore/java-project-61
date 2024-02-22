package hexlet.code.games;

import hexlet.code.Utils;

public class Prime {
    public static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    public static final int QUESTIONS_COUNT = Integer.parseInt(Utils.getProperty("questionsCount"));
    public static final int LOWER_BOUND = Integer.parseInt(Utils.getProperty("primeLowerBound"));
    public static final int UPPER_BOUND = Integer.parseInt(Utils.getProperty("primeUpperBound"));

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
