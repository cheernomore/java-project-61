package hexlet.code.games;

import hexlet.code.Utils;

public class Calc {
    public static final String GAME_RULES = "What is the result of the expression?";
    public static final int QUESTIONS_COUNT = Integer.parseInt(Utils.getProperty("questionsCount"));
    public static final double PLUS_CONDITION_LIMIT = Double.parseDouble(Utils.getProperty("calcPlusConditionLimit"));
    public static final double MINUS_CONDITION_LIMIT = Double.parseDouble(Utils.getProperty("calcMinusConditionLimit"));
    public static final int MIN_GENERATED_VALUE = Integer.parseInt(Utils.getProperty("calcMinGeneratedValue"));
    public static final int MAX_GENERATED_VALUE = Integer.parseInt(Utils.getProperty("calcMaxGeneratedValue"));

    public static String[][] generateGameData() {
        String[] questions = new String[QUESTIONS_COUNT];
        String[] answers = new String[QUESTIONS_COUNT];
        String[][] questionsAnswers = new String[QUESTIONS_COUNT][QUESTIONS_COUNT];


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

    public static String getGameRules() {
        return GAME_RULES;
    }
}
