package hexlet.code.games;

import org.apache.commons.lang3.RandomUtils;

public class GCD {

    public static Object[][] generateGameRulesAndQASet(int questionAnswersCount){
        Object[][] questionAnswerIteration = new Object[questionAnswersCount][2];

        for (int i = 0; i < questionAnswersCount; i++) {
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
        return number1 + " " + number2;
    }

    public static String generateAnswer(int number1, int number2) {
        return Integer.toString(getGCD(number1, number2));
    }

    public static int generateRandomOperand() {
        return RandomUtils.nextInt(0, 100);
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
