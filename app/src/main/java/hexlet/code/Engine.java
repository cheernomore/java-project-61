package hexlet.code;

import java.util.Scanner;

public class Engine {
    private static final int POINTS_TO_WIN = 3;
    public static void launchGame(String[][] gameData, String gameRules) {
        Scanner scanner = new Scanner(System.in);

        int playerPoints = 0;
        String playerName;

        String[] questions = gameData[0];
        String[] answers = gameData[1];
        String question;
        String correctAnswer;
        String userAnswer;

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name?");
        playerName = scanner.nextLine();
        System.out.println("Hello, " + playerName + "!");
        System.out.println(gameRules);

        for (int i = 0; i < questions.length; i++) {
            question = questions[i];
            System.out.println("Question: " + question);
            userAnswer = scanner.nextLine();
            correctAnswer = answers[i];
            System.out.println("Your answer: " + userAnswer);

            if (isUserAnswerCorrect(userAnswer, correctAnswer)) {
                System.out.println("Correct!");
                playerPoints++;
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(."
                        + " Correct answer was '" + correctAnswer + "'");
                System.out.println("Let's try again, " + playerName + "!");
                scanner.close();
                break;
            }

            if (playerPoints == POINTS_TO_WIN) {
                System.out.println("Congratulations, " + playerName + "!");
                scanner.close();
                break;
            }
        }
    }

    private static boolean isUserAnswerCorrect(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer);
    }
}
