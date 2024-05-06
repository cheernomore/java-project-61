package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
public class Progression {
    public static final String GAME_RULES = "What number is missing in the progression?";

    public static String[][] generateGameData(int questionsCount) {
        String[] questions = new String[questionsCount];
        String[] answers = new String[questionsCount];
        String[][] questionsAnswers = new String[questionsCount][questionsCount];

        for (int i = 0; i < questions.length; i++) {
            int randomIndex = Utils.generateRandomInt(0, 9);
            String[] progression = generateProgression(100, 2, 10);
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
        String[][] gameData = generateGameData(3);
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
