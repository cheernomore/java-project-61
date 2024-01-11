package hexlet.code.games;

import hexlet.code.Utils;
public class Progression {
    public static final String GAME_RULES = "What number is missing in the progression?";
    public static String[] questions = new String[3];
    public static Object[] answers = new Object[3];

    public static void generateQuestionsAndAnswers() {
        for (int i = 0; i < questions.length; i++) {
            int randomIndex = Utils.getRandomNumber(0, 9);
            String[] progression = generateProgression();
            Object correctAnswer = progression[randomIndex];
            answers[i] = correctAnswer;
            progression[randomIndex] = "..";
            questions[i] = String.join(" ", progression)
                    .replace("[", "")
                    .replace("]", "");
        }
    }

    public static String[] generateProgression() {
        int step = Utils.getRandomNumber(1, 10);
        int counter = 0;
        String[] progression = new String[10];
        for (int i = 0; i < progression.length; i++) {
            counter += step;
            progression[i] = Integer.toString(counter);
        }
        return progression;
    }
}
