package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static final String GAME_RULES = "Find the greatest common divisor of given numbers.";
    public static final int LOWER_BOUND = 1;
    public static final int UPPER_BOUND = 100;

    public static String[][] generateGameData(int questionsCount) {
        String[] questions = new String[questionsCount];
        String[] answers = new String[questionsCount];
        String[][] questionsAnswers = new String[questionsCount][questionsCount];

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

    public static void run() {
        String[][] gameData = generateGameData(5);
        Engine.launchGame(gameData, GAME_RULES);
    }
}
