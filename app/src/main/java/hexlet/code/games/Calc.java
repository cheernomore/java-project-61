package hexlet.code.games;

public class Calc {
    public static final String GAME_RULES = "What is the result of the expression?";
    public static final int DEFAULT_QUESTIONS_COUNT = 3;
    public static final int DEFAULT_ANSWERS_COUNT = 3;

    public static String[][] transferDataToEngine() {
        return generateGameData();
    }

    public static String[][] generateGameData() {
        String[] questions = new String[DEFAULT_QUESTIONS_COUNT];
        String[] answers = new String[DEFAULT_ANSWERS_COUNT];
        String[][] questionsAnswers = new String[DEFAULT_QUESTIONS_COUNT][DEFAULT_ANSWERS_COUNT];


        double conditions = Math.random();
        int first;
        int second;

        for (int i = 0; i < questions.length; i++) {
            if (conditions < 0.3) {
                first = (int) (Math.random() * (10 - 1) + 1);
                second = (int) (Math.random() * (10 - 1) + 1);
                questions[i] = first + " + " + second;
                answers[i] = Integer.toString(first + second);
            } else if (conditions > 0.3 && conditions < 0.6) {
                first = (int) (Math.random() * (10 - 1) + 1);
                second = (int) (Math.random() * (10 - 1) + 1);
                questions[i] = first + " - " + second;
                answers[i] = Integer.toString(first - second);
            } else {
                first = (int) (Math.random() * (10 - 1) + 1);
                second = (int) (Math.random() * (10 - 1) + 1);
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
