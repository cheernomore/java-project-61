package hexlet.code.games;

import org.apache.commons.lang3.RandomUtils;
import java.util.Arrays;

public class Progression {

    public static Object[][] generateGameRulesAndQASet(int questionAnswersCount) {
        Object[][] questionAnswerIteration = new Object[questionAnswersCount][2];

        for (int i = 0; i < questionAnswersCount; i++) {
            int[] progression = generateProgression();
            int randomIndex = getProgressionRandomIndex(progression);
            String question = generateQuestion(progression, randomIndex);
            String answer = Integer.toString(generateAnswer(progression, randomIndex));
            questionAnswerIteration[i][0] = question;
            questionAnswerIteration[i][1] = answer;
        }

        return questionAnswerIteration;
    }

    public static String generateQuestion(int[] progression, int randomIndex) {
        String[] stringNumbers = new String[progression.length];

        for (int i = 0; i < progression.length; i++) {
            if (i == randomIndex) {
                stringNumbers[i] = ".. ";
            } else {
                stringNumbers[i] = Integer.toString(progression[i]);
            }
        }

        return Arrays.toString(stringNumbers);
    }

    public static int generateAnswer(int[] progression, int randomIndex) {
        return progression[randomIndex];
    }

    public static int[] generateProgression() {
        int[] progression = new int[RandomUtils.nextInt(5, 10)];
        int start = RandomUtils.nextInt(0, 100);
        int step = RandomUtils.nextInt(0, 100);

        for (int i = 0; i < progression.length; i++) {
            start += step;
            progression[i] = start;
        }

        return progression;
    }

    public static int getProgressionRandomIndex(int[] progression) {
        return RandomUtils.nextInt(0, progression.length - 1);
    }
}
