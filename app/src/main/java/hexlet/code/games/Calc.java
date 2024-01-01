package hexlet.code.games;

public class Calc {
    public static final String GAME_RULES = "What is the result of the expression?";
    public static Object[] questions = new Object[3];
    public static Object[] answers = new Object[3];
    public static void generateQuestionsAndAnswers() {
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
                answers[i] = Integer.toString(first + second);
            } else {
                first = (int) (Math.random() * (10 - 1) + 1);
                second = (int) (Math.random() * (10 - 1) + 1);
                questions[i] = first + " * " + second;
                answers[i] = Integer.toString(first + second);
            }
        }
    }



}
