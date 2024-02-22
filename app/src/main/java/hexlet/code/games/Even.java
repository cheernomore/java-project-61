package hexlet.code.games;

import hexlet.code.Config;
import hexlet.code.Utils;

public class Even {
    public static final String GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final int QUESTIONS_COUNT = Config.QUESTION_COUNT;
    public static final int LOWER_BOUND = Config.EVEN_LOWER_BOUND;
    public static final int UPPER_BOUND = Config.EVEN_UPPER_BOUND;

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
