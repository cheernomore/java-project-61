package hexlet.code.games;

import org.apache.commons.lang3.RandomUtils;

public class Calc {

    public static Object[][] generateGameRulesAndQASet() {
        final int startRangeGenerateRandomNumber = 0;
        final int endRangeGenerateRandomNumber = 100;
        final int questionsCount = 3;

        Object[][] questionAnswerIteration = new Object[questionsCount][2];

        int number1;
        int number2;
        String operator;

        for (int i = 0; i < questionAnswerIteration.length; i++) {
            number1 = RandomUtils.nextInt(startRangeGenerateRandomNumber, endRangeGenerateRandomNumber);
            number2 = RandomUtils.nextInt(startRangeGenerateRandomNumber, endRangeGenerateRandomNumber);
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
        final int startRangeGenMathOperator = 0;
        final int endRangeGenMathOperator = 3;

        String[] mathOperators = new String[]{"+", "-", "*"};
        int randomOperator = RandomUtils.nextInt(startRangeGenMathOperator, endRangeGenMathOperator);

        return mathOperators[randomOperator];
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
