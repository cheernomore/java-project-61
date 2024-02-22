package hexlet.code.games;

import hexlet.code.Utils;

public class Even {
    public static final String GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final int QUESTIONS_COUNT = Integer.parseInt(Utils.getProperty("questionsCount"));
    public static final int LOWER_BOUND = Integer.parseInt(Utils.getProperty("evenLowerBound"));
    public static final int UPPER_BOUND = Integer.parseInt(Utils.getProperty("evenUpperBound"));

    public static String[][] generateGameData() {
        String[] questions = new String[QUESTIONS_COUNT];
        String[] answers = new String[QUESTIONS_COUNT];
        String[][] questionsAnswers = new String[QUESTIONS_COUNT][QUESTIONS_COUNT];

        for (int i = 0; i < questions.length; i++) {
            int num = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            questions[i] = Integer.toString(num);
            answers[i] = isEven(num) ? "yes" : "no";
        }

        questionsAnswers[0] = questions;
        questionsAnswers[1] = answers;

        return questionsAnswers;
    }

    public static String getGameRules() {
        return GAME_RULES;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
