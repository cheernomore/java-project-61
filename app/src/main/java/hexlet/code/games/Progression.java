package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS;

public class Progression {
    private static final String GAME_RULES = "What number is missing in the progression?";
    private static final int MIN_INITIAL_VALUE = 0;
    private static final int MAX_INITIAL_VALUE = 50;
    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 10;
    private static final int SIZE = 10;
    private static final int MIN_GENERATE_NUM = 0;
    private static final int MAX_GENERATE_NUM = SIZE - 1;

    public static String[][] generateGameData(int questionsCount) {
        String[] questions = new String[questionsCount];
        String[] answers = new String[questionsCount];

        for (int i = 0; i < questions.length; i++) {
            int randomIndex = Utils.generateRandomInt(MIN_GENERATE_NUM, MAX_GENERATE_NUM);
            int initValue = Utils.generateRandomInt(MIN_INITIAL_VALUE, MAX_INITIAL_VALUE);
            int step = Utils.generateRandomInt(MIN_STEP, MAX_STEP);
            String[] progression = generateProgression(initValue, step, SIZE);
            String correctAnswer = progression[randomIndex];
            answers[i] = correctAnswer;
            progression[randomIndex] = "..";
            questions[i] = String.join(" ", progression);
        }

        String[][] questionsAnswers = new String[2][];
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
            progression[i] = Integer.toString(initValue + i * step);
        }
        return progression;
    }
}
