package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int POINTS_TO_WIN = Config.POINTS_TO_WIN;
    private static final String PLAYER_NAME = Config.getPlayerName();
    private static final Scanner PLAYER_INPUT = new Scanner(System.in);
    private static int playerPoints = Config.PLAYER_POINTS;

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
                System.out.println("Let's try again, " + PLAYER_NAME + "!");
                break;
            }

            if (playerPoints == POINTS_TO_WIN) {
                System.out.println("Congratulations, " + PLAYER_NAME + "!");
            }
        }
    }

    private static boolean isUserAnswerCorrect(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer);
    }

    private static String getUserAnswer() {
        return PLAYER_INPUT.nextLine();
    }
}
