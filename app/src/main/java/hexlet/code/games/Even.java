package hexlet.code.games;

import org.apache.commons.lang3.RandomUtils;

public class Even {

    public static Object[][] generateGameRulesAndQASet() {
        Object[][] questionAnswerIteration = new Object[3][2];

        for (int i = 0; i < questionAnswerIteration.length; i++) {
            int question = generateQuestion();
            String answer = generateAnswer(question);
            questionAnswerIteration[i][0] = question;
            questionAnswerIteration[i][1] = answer;
        }

        return questionAnswerIteration;
    }

    public static int generateQuestion() {
        int startRangeGenerateRandomNumber = 0;
        int endRangeGenerateRandomNumber = 100;
        return RandomUtils.nextInt(startRangeGenerateRandomNumber, endRangeGenerateRandomNumber);
    }

    public static String generateAnswer(int question) {
        return isEven(question);
    }

    public static String isEven(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
