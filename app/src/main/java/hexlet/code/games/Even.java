package hexlet.code.games;

import org.apache.commons.lang3.RandomUtils;

public class Even {

    public static Object[][] generateGameRulesAndQASet() {
        final int questionsCount = 3;

        Object[][] questionAnswerIteration = new Object[questionsCount][2];

        for (int i = 0; i < questionAnswerIteration.length; i++) {
            int question = generateQuestion();
            String answer = generateAnswer(question);
            questionAnswerIteration[i][0] = question;
            questionAnswerIteration[i][1] = answer;
        }

        return questionAnswerIteration;
    }

    public static int generateQuestion() {
        final int startRangeGenerateRandomNumber = 0;
        final int endRangeGenerateRandomNumber = 100;

        return RandomUtils.nextInt(startRangeGenerateRandomNumber, endRangeGenerateRandomNumber);
    }

    public static String generateAnswer(int question) {
        return isEven(question);
    }

    public static String isEven(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
