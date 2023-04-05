package hexlet.code.games;

import org.apache.commons.lang3.RandomUtils;

public class Even {

    public static Object[][] generateGameRulesAndQASet(int questionAnswersCount){
        Object[][] questionAnswerIteration = new Object[questionAnswersCount][2];

        for (int i = 0; i < questionAnswersCount; i++) {
            int question = generateQuestion();
            String answer = generateAnswer(question);
            questionAnswerIteration[i][0] = question;
            questionAnswerIteration[i][1] = answer;
        }

        return questionAnswerIteration;
    }

    public static int generateQuestion() {
        return RandomUtils.nextInt(0, 100);
    }

    public static String generateAnswer(int question) {
        return isEven(question);
    }

    public static String isEven(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
