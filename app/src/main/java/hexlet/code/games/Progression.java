package hexlet.code.games;

import hexlet.code.Utils;
public class Progression {
    public static final String GAME_RULES = "What number is missing in the progression?";
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
            int randomIndex = Utils.getRandomNumber(0, 9);
            String[] progression = generateProgression();
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

    public static String[] generateProgression() {
        int step = Utils.getRandomNumber(DEFAULT_LOWER_BOUND, DEFAULT_UPPER_BOUND);
        int counter = 0;
        String[] progression = new String[10];
        for (int i = 0; i < progression.length; i++) {
            counter += step;
            progression[i] = Integer.toString(counter);
        }
        return progression;
    }

    public static String getGameRules() {
        return GAME_RULES;
    }
}
