package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {
    private static final int POINTS_TO_WIN = 3;
    private static boolean isWin;
    private static String errorMessage;
    public static void launchGame(int selectedGameNumber) {
        Scanner scanner = new Scanner(System.in);
        String[][] gameData = selectGame(selectedGameNumber);

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
        String gameRules = getGameRules(selectedGameNumber);

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

    public static String[][] selectGame(int gameNumber) {
        return switch (gameNumber) {
            case 2 -> Even.generateGameData();
            case 3 -> Calc.generateGameData();
            case 4 -> GCD.generateGameData();
            case 5 -> Progression.generateGameData();
            case 6 -> Prime.generateGameData();
            default -> null;
        };
    }

    public static String getGameRules(int gameNumber) {
        return switch (gameNumber) {
            case 2 -> Even.GAME_RULES;
            case 3 -> Calc.GAME_RULES;
            case 4 -> GCD.GAME_RULES;
            case 5 -> Progression.GAME_RULES;
            case 6 -> Prime.GAME_RULES;
            default -> null;
        };
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
