package hexlet.code;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS = 3;
    public static void launchGame(String[][] gameData, String gameRules) {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        String playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
        System.out.println(gameRules);

        String[] questions = gameData[0];
        String[] answers = gameData[1];
        int playerPoints = 0;
        for (int i = 0; i < ROUNDS; i++) {
            String question = questions[i];
            System.out.println("Question: " + question);
            String userAnswer = scanner.nextLine();
            String correctAnswer = answers[i];
            System.out.println("Your answer: " + userAnswer);
            if (!isUserAnswerCorrect(userAnswer, correctAnswer)) {
                playerLostFinal(playerName, userAnswer, correctAnswer);
                break;
            }
            System.out.println("Correct!");
            playerPoints++;
            if (playerPoints == ROUNDS) {
                playerWonFinal(playerName);
            }
        }
        scanner.close();
    }

    private static boolean isUserAnswerCorrect(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer);
    }

    private static void playerWonFinal(String playerName) {
        System.out.println("Congratulations, " + playerName + "!");
    }

    private static void playerLostFinal(String playerName, String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(."
                + " Correct answer was '" + correctAnswer + "'");
        System.out.println("Let's try again, " + playerName + "!");
    }
}
