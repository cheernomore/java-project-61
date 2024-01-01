package hexlet.code.games;

import hexlet.code.Utils;

public class Even {
    public static final String GAME_RULES = "Answer 'yes' if the number is even, otherwise answer 'no'.";
    public static Object[] questions = new Object[3];
    public static Object[] answers = new Object[3];

    public static void generateQuestionsAndAnswers() {
        for (int i = 0; i < questions.length; i++) {
            int num = Utils.getRandomNumber(1, 1000);
            questions[i] = Integer.toString(num);
            answers[i] = isEven(num);
        }
    }

    public static String isEven(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }
}
