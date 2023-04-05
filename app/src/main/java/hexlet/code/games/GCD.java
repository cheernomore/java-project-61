package hexlet.code.games;

import org.apache.commons.lang3.RandomUtils;

public class GCD {

    public static Object[][] generateGameRulesAndQASet(int questionAnswersCount){
        Object[][] questionAnswerIteration = new Object[questionAnswersCount][2];

        for (int i = 0; i < questionAnswersCount; i++) {
            int num1 = generateRandomOperand();
            int num2 = generateRandomOperand();

            String question = generateQuestion(num1, num2);
            String answer = generateAnswer(num1, num2);
            questionAnswerIteration[i][0] = question;
            questionAnswerIteration[i][1] = answer;
        }

        return questionAnswerIteration;
    }

    public static String generateQuestion(int num1, int num2) {
        return num1 + " " + num2;
    }

    public static String generateAnswer(int num1, int num2) {
        return Integer.toString(getGCD(num1, num2));
    }

    public static int generateRandomOperand() {
        return RandomUtils.nextInt(0, 100);
    }

    public static int getGCD(int num1, int num2) {
        if (num1 == num2) {
            return num1;
        }

        while (num1 != num2) {
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }

        return num1;
    }
}
