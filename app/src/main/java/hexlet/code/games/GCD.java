package hexlet.code.games;

import org.apache.commons.lang3.RandomUtils;

public class GCD {

    public static Object[][] generateGameRulesAndQASet() {
        final int questionsCount = 3;
        Object[][] questionAnswerIteration = new Object[questionsCount][2];

        for (int i = 0; i < questionAnswerIteration.length; i++) {
            int number1 = generateRandomOperand();
            int number2 = generateRandomOperand();

            String question = generateQuestion(number1, number2);
            String answer = generateAnswer(number1, number2);
            questionAnswerIteration[i][0] = question;
            questionAnswerIteration[i][1] = answer;
        }

        return questionAnswerIteration;
    }

    public static String generateQuestion(int number1, int number2) {
        return String.format("%d %d", number1, number2);
    }

    public static String generateAnswer(int number1, int number2) {
        return Integer.toString(getGCD(number1, number2));
    }

    public static int generateRandomOperand() {
        final int startRangeGenerateRandomNumber = 0;
        final int endRangeGenerateRandomNumber = 100;

        return RandomUtils.nextInt(startRangeGenerateRandomNumber, endRangeGenerateRandomNumber);
    }

    public static int getGCD(int number1, int number2) {
        if (number1 == number2) {
            return number1;
        }

        while (number1 != number2) {
            if (number1 > number2) {
                number1 = number1 - number2;
            } else {
                number2 = number2 - number1;
            }
        }

        return number1;
    }
}
