package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Prime {
    public static final String GAME_RULES = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static String[][] generateGameData(int questionsCount) {
        String[] questions = new String[questionsCount];
        String[] answers = new String[questionsCount];
        String[][] questionsAnswers = new String[questionsCount][questionsCount];

        for (int i = 0; i < questions.length; i++) {
            int num = Utils.generateRandomInt(1, 100);
            questions[i] = Integer.toString(num);
            answers[i] = isPrime(num) ? "yes" : "no";
        }

        questionsAnswers[0] = questions;
        questionsAnswers[1] = answers;

        return questionsAnswers;
    }

    public static void run() {
        String[][] gameData = generateGameData(3);
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
