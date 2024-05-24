package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS;

public class Progression {
    private static final String GAME_RULES = "What number is missing in the progression?";
    private static final int INIT_VALUE = 100;
    private static final int STEP = 100;
    private static final int SIZE = 100;
    private static final int MIN_GENERATE_NUM = 0;
    private static final int MAX_GENERATE_NUM = 9;

    public static String[][] generateGameData(int questionsCount) {
        String[] questions = new String[questionsCount];
        String[] answers = new String[questionsCount];
        String[][] questionsAnswers = new String[questionsCount][questionsCount];

        for (int i = 0; i < questions.length; i++) {
            int randomIndex = Utils.generateRandomInt(MIN_GENERATE_NUM, MAX_GENERATE_NUM);
            String[] progression = generateProgression(INIT_VALUE, STEP, SIZE);
            String correctAnswer = progression[randomIndex];
            answers[i] = correctAnswer;
            progression[randomIndex] = "..";
            questions[i] = String.join(" ", progression)
                    .replace("[", "")
                    .replace("]", "");
        }

        questionsAnswers[0] = questions;
        questionsAnswers[1] = answers;

        return questionsAnswers;
    }

    public static void run() {
        String[][] gameData = generateGameData(ROUNDS);
        Engine.launchGame(gameData, GAME_RULES);
    }

    public static String[] generateProgression(int initValue, int step, int size) {
        String[] progression = new String[size];
        for (int i = 0; i < size; i++) {
            initValue += step;
            progression[i] = Integer.toString(initValue);
        }
        return progression;
    }
}
