package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS;

public class Even {
    private static final String GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    private static final int LOWER_BOUND = 0;
    private static final int UPPER_BOUND = 100;

    public static String[][] generateGameData(int questionsCount) {
        String[] questions = new String[questionsCount];
        String[] answers = new String[questionsCount];
        String[][] questionsAnswers = new String[questionsCount][questionsCount];

        for (int i = 0; i < questions.length; i++) {
            int num = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
            questions[i] = Integer.toString(num);
            answers[i] = isEven(num) ? "yes" : "no";
        }

        questionsAnswers[0] = questions;
        questionsAnswers[1] = answers;

        return questionsAnswers;
    }

    public static void run() {
        String[][] gameData = generateGameData(ROUNDS);
        Engine.launchGame(gameData, GAME_RULES);
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }
}
