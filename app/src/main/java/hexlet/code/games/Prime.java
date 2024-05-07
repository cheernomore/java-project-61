package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    private static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    private static final int MIN_GENERATE_NUM = 1;
    private static final int MAX_GENERATE_NUM = 100;
    private static final int QUESTIONS_COUNT = 3;


    public static String[][] generateGameData(int questionsCount) {
        String[] questions = new String[questionsCount];
        String[] answers = new String[questionsCount];
        String[][] questionsAnswers = new String[questionsCount][questionsCount];

        for (int i = 0; i < questions.length; i++) {
            int num = Utils.generateRandomInt(MIN_GENERATE_NUM, MAX_GENERATE_NUM);
            questions[i] = Integer.toString(num);
            answers[i] = isPrime(num) ? "yes" : "no";
        }

        questionsAnswers[0] = questions;
        questionsAnswers[1] = answers;

        return questionsAnswers;
    }

    public static void run() {
        String[][] gameData = generateGameData(QUESTIONS_COUNT);
        Engine.launchGame(gameData, GAME_RULES);
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
