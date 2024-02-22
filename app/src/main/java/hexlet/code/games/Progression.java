package hexlet.code.games;

import hexlet.code.Utils;
public class Progression {
    public static final String GAME_RULES = "What number is missing in the progression?";
    public static final int QUESTIONS_COUNT = Integer.parseInt(Utils.getProperty("questionsCount"));
    public static final int LOWER_BOUND = Integer.parseInt(Utils.getProperty("progressionLowerBound"));
    public static final int UPPER_BOUND = Integer.parseInt(Utils.getProperty("progressionUpperBound"));
    public static final int MIN_STEP_VALUE = Integer.parseInt(Utils.getProperty("progressionMinStepValue"));
    public static final int MAX_STEP_VALUE = Integer.parseInt(Utils.getProperty("progressionMaxStepValue"));

    public static String[][] generateGameData() {
        String[] questions = new String[QUESTIONS_COUNT];
        String[] answers = new String[QUESTIONS_COUNT];
        String[][] questionsAnswers = new String[QUESTIONS_COUNT][QUESTIONS_COUNT];

        for (int i = 0; i < questions.length; i++) {
            int randomIndex = Utils.generateRandomInt(MIN_STEP_VALUE, MAX_STEP_VALUE);
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
        int step = Utils.generateRandomInt(LOWER_BOUND, UPPER_BOUND);
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
