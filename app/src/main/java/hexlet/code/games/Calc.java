package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import static hexlet.code.Engine.ROUNDS;

public class Calc {
    private static final String GAME_RULES = "What is the result of the expression?";
    private static final int MIN_GENERATED_VALUE = 1;
    private static final int MAX_GENERATED_VALUE = 100;
    private static final String[] OPERATORS = {"+", "-", "*"};

    public static String[][] generateGameData(int questionsCount) {
        String[] questions = new String[questionsCount];
        String[] answers = new String[questionsCount];

        for (int i = 0; i < questionsCount; i++) {
            int first = Utils.generateRandomInt(MIN_GENERATED_VALUE, MAX_GENERATED_VALUE);
            int second = Utils.generateRandomInt(MIN_GENERATED_VALUE, MAX_GENERATED_VALUE);
            String operator = OPERATORS[Utils.generateRandomInt(0, OPERATORS.length - 1)];

            questions[i] = first + " " + operator + " " + second;
            answers[i] = calculate(first, second, operator);
        }

        String[][] questionsAnswers = new String[2][];
        questionsAnswers[0] = questions;
        questionsAnswers[1] = answers;

        return questionsAnswers;
    }

    public static void run() {
        String[][] gameData = generateGameData(ROUNDS);
        Engine.launchGame(gameData, GAME_RULES);
    }

    public static String calculate(int num1, int num2, String operator) {
        return switch (operator) {
            case "+" -> String.valueOf(num1 + num2);
            case "-" -> String.valueOf(num1 - num2);
            case "*" -> String.valueOf(num1 * num2);
            default -> null;
        };
    }
}
