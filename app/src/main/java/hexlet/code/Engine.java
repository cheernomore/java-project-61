package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int POINTS_TO_WIN = 3;
    private static boolean isWin;
    private static String errorMessage;
    public static void launchGame(String[][] gameData, String gameRules) {
        Scanner scanner = new Scanner(System.in);

        if (gameData == null) {
            System.out.println("Игры не существует");
            System.exit(0);
        }

        UserDialog.setPlayerName();

        int playerPoints = 0;
        String[] questions = gameData[0];
        String[] answers = gameData[1];
        String question;
        String correctAnswer;
        String userAnswer;

        System.out.println(gameRules);

        for (int i = 0; i < questions.length; i++) {
            question = questions[i];
            System.out.println("Question: " + question);
            System.out.print("Your answer: ");
            userAnswer = scanner.next();
            correctAnswer = answers[i];

            if (isUserAnswerCorrect(userAnswer, correctAnswer)) {
                System.out.println("Correct!");
                playerPoints++;
            } else {
                errorMessage = "'" + userAnswer + "' is wrong answer ;(."
                        + " Correct answer was '" + correctAnswer + "'";
                break;
            }

            if (playerPoints == POINTS_TO_WIN) {
                isWin = true;
            }
        }

        scanner.close();
    }

    public static boolean isWin() {
        return isWin;
    }

    public static String getErrorMessage() {
        return errorMessage;
    }

    private static boolean isUserAnswerCorrect(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer);
    }
}
