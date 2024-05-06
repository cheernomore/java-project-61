package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class Calc {
    public static final String GAME_RULES = "What is the result of the expression?";
    public static final double PLUS_CONDITION_LIMIT = .2;
    public static final double MINUS_CONDITION_LIMIT = .3;
    public static final int MIN_GENERATED_VALUE = 1;
    public static final int MAX_GENERATED_VALUE = 100;

    public static String[][] generateGameData(int questionsCount) {
        String[] questions = new String[questionsCount];
        String[] answers = new String[questionsCount];
        String[][] questionsAnswers = new String[questionsCount][questionsCount];


        double conditions = Math.random();
        int first;
        int second;

        for (int i = 0; i < questions.length; i++) {
            if (conditions < PLUS_CONDITION_LIMIT) {
                first = Utils.generateRandomInt(MIN_GENERATED_VALUE, MAX_GENERATED_VALUE);
                second = Utils.generateRandomInt(MIN_GENERATED_VALUE, MAX_GENERATED_VALUE);
                questions[i] = first + " + " + second;
                answers[i] = Integer.toString(first + second);
            } else if (conditions > PLUS_CONDITION_LIMIT && conditions < MINUS_CONDITION_LIMIT) {
                first = Utils.generateRandomInt(MIN_GENERATED_VALUE, MAX_GENERATED_VALUE);
                second = Utils.generateRandomInt(MIN_GENERATED_VALUE, MAX_GENERATED_VALUE);
                questions[i] = first + " - " + second;
                answers[i] = Integer.toString(first - second);
            } else {
                first = Utils.generateRandomInt(MIN_GENERATED_VALUE, MAX_GENERATED_VALUE);
                second = Utils.generateRandomInt(MIN_GENERATED_VALUE, MAX_GENERATED_VALUE);
                questions[i] = first + " * " + second;
                answers[i] = Integer.toString(first * second);
            }
        }

        questionsAnswers[0] = questions;
        questionsAnswers[1] = answers;

        return questionsAnswers;
    }

    public static void run() {
        String[][] gameData = generateGameData(5);
        Engine.launchGame(gameData, GAME_RULES);
    }
}
