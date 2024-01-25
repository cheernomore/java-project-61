package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {
    private static final int WIN_CONDITIONS = 3;
    private static final Scanner PLAYER_CLI_INPUT = new Scanner(System.in);
    private static int playerPointsCounter = 0;
    private static String playerName;

    public static void run(int numberOfSelectedGame) {

        String[][] questionsAnswers;
        String[] questions;
        String[] answers;
        String gameRules;

        switch (numberOfSelectedGame) {
            case 1:
                greetings();
                break;
            case 2:
                questionsAnswers = Even.transferDataToEngine();
                questions = questionsAnswers[0];
                answers = questionsAnswers[1];
                gameRules = Even.getGameRules();
                startGame(questions, answers, gameRules);
                break;
            case 3:
                questionsAnswers = Calc.transferDataToEngine();
                questions = questionsAnswers[0];
                answers = questionsAnswers[1];
                gameRules = Calc.getGameRules();
                startGame(questions, answers, gameRules);
                break;
            case 4:
                questionsAnswers = GCD.transferDataToEngine();
                questions = questionsAnswers[0];
                answers = questionsAnswers[1];
                gameRules = GCD.getGameRules();
                startGame(questions, answers, gameRules);
                break;
            case 5:
                questionsAnswers = Progression.transferDataToEngine();
                questions = questionsAnswers[0];
                answers = questionsAnswers[1];
                gameRules = Progression.getGameRules();
                startGame(questions, answers, gameRules);
                break;
            case 6:
                questionsAnswers = Prime.transferDataToEngine();
                questions = questionsAnswers[0];
                answers = questionsAnswers[1];
                gameRules = Prime.getGameRules();
                startGame(questions, answers, gameRules);
                break;
            default:
                break;
        }
    }

    public static void startGame(String[] questions, String[] answers, String gameRules) {
        greetings();
        showGameRules(gameRules);
        for (int i = 0; i < questions.length; i++) {
            String question = questions[i];
            String correctAnswer = answers[i];
            String playerAnswer;

            askQuestion(question);
            System.out.print("Answer: ");
            playerAnswer = getPlayerAnswer();

            if (playerAnswer.equals(answers[i])) {
                System.out.println("Correct!");
                addOnePointToPlayer();

                if (playerPointsCounter == WIN_CONDITIONS) {
                    congratulations();
                    break;
                }
            } else {
                System.out.println(playerAnswer + " is wrong answer ;(. Correct answer was " + correctAnswer + ".");
                System.out.println("Let's try again, " + playerName + "!");
                break;
            }
        }
        PLAYER_CLI_INPUT.close();
    }
    public static void addOnePointToPlayer() {
        playerPointsCounter++;
    }

    public static void askQuestion(Object question) {
        System.out.println("Question: " + question);
    }

    public static String getPlayerAnswer() {
        return PLAYER_CLI_INPUT.nextLine();
    }

    public static void congratulations() {
        System.out.println("Congratulations, " + playerName + "!");
    }

    public static String setPlayerName() {
        return PLAYER_CLI_INPUT.nextLine();
    }

    public static void greetings() {
        System.out.print("May I have your name? ");
        playerName = setPlayerName();
        System.out.println("Hello, " + playerName + "!");
    }

    public static void showGameRules(String gameRules) {
        System.out.println(gameRules);
    }
}
