package hexlet.code.games;

import org.apache.commons.lang3.RandomUtils;

public class Progression {

    public static Object[][] generateGameRulesAndQASet() {
        Object[][] questionAnswerIteration = new Object[3][2];

        for (int i = 0; i < questionAnswerIteration.length; i++) {
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
        String example = "";

        for (int i = 0; i < progression.length; i++) {
            if (i == randomIndex) {
                stringNumbers[i] = "..";
                example += stringNumbers[i] + " ";
            } else {
                stringNumbers[i] = Integer.toString(progression[i]);
                example += stringNumbers[i] + " ";
            }
        }

        return example.trim();
    }

    public static int generateAnswer(int[] progression, int randomIndex) {
        return progression[randomIndex];
    }

    public static int[] generateProgression() {
        int progressionSizeLenMin = 5;
        int progressionSizeLenMax = 10;
        int startRangeGenerateRandomNumber = 0;
        int endRangeGenerateRandomNumber = 100;
        int[] progression = new int[RandomUtils.nextInt(progressionSizeLenMin, progressionSizeLenMax)];
        int start = RandomUtils.nextInt(startRangeGenerateRandomNumber, endRangeGenerateRandomNumber);
        int step = RandomUtils.nextInt(startRangeGenerateRandomNumber, endRangeGenerateRandomNumber);

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
