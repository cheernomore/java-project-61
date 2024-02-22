package hexlet.code;

import static hexlet.code.Utils.getUserAnswer;
import static hexlet.code.Utils.isUserAnswerCorrect;

public class Engine {
    public static final  int POINTS_TO_WIN = Integer.parseInt(Utils.getProperty("pointsToWin"));
    public static int playerPoints = Integer.parseInt(Utils.getProperty("playerPoints"));
    public static String playerName = Utils.getProperty("playerName");

    public static void launchGame(String[][] gameData) {
        String[] questions = gameData[0];
        String[] answers = gameData[1];
        String question;
        String correctAnswer;
        String userAnswer;

        for (int i = 0; i < questions.length; i++) {
            question = questions[i];
            System.out.println("Question: " + question);
            userAnswer = getUserAnswer();
            correctAnswer = answers[i];
            System.out.println("Your answer: " + userAnswer);

            if (isUserAnswerCorrect(userAnswer, correctAnswer)) {
                System.out.println("Correct!");
                playerPoints++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(."
                        + " Correct answer was '" + correctAnswer + "'");
                System.out.println("Let's try again, " + playerName + "!");
            }

            if (playerPoints == POINTS_TO_WIN) {
                System.out.println("Congratulations, " + playerName + "!");
            }
        }
    }
}
