package hexlet.code.games;

import org.apache.commons.lang3.RandomUtils;

public class Calc {

    public static Object[][] generateGameRulesAndQASet(int questionAnswersCount) {
        Object[][] questionAnswerIteration = new Object[questionAnswersCount][2];
        int number1;
        int number2;
        String operator;

        for (int i = 0; i < questionAnswersCount; i++) {
            number1 = RandomUtils.nextInt(0, 100);
            number2 = RandomUtils.nextInt(0, 100);
            operator = generateRandomMathOperator();

            String question = generateQuestion(number1, number2, operator);
            String answer = generateAnswer(number1, number2, operator);
            questionAnswerIteration[i][0] = question;
            questionAnswerIteration[i][1] = answer;
        }

        return questionAnswerIteration;
    }

    public static String generateQuestion(int number1, int number2, String operator) {
        return number1 + " " + operator + " " + number2;
    }

    public static String generateRandomMathOperator() {
        return new String[]{"+", "-", "*"}[RandomUtils.nextInt(0, 3)];
    }

    public static String generateAnswer(int number1, int number2, String operator) {

        switch (operator) {
            case "+":
                return Integer.toString(number1 + number2);
            case "-":
                return Integer.toString(number1 - number2);
            case "*":
                return Integer.toString(number1 * number2);
            default:
                return "";
        }
    }
}
