package hexlet.code.games;

import hexlet.code.Utils;

public class Even {
    public static final String GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
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
            answers[i] = isEven(num);
        }

        questionsAnswers[0] = questions;
        questionsAnswers[1] = answers;

        return questionsAnswers;
    }

    public static String getGameRules() {
        return GAME_RULES;
    }

    public static String isEven(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
