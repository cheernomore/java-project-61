package hexlet.code.games;

import hexlet.code.Utils;

public class Even {
    public static final String GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static final int QUESTIONS_COUNT = 3;
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 10;

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
    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
