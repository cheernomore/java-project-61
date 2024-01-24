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
        switch (numberOfSelectedGame) {
            case 1:
                greetings();
                break;
            case 2:
                Even.generateQuestionsAndAnswers();
                startGame(Even.questions, Even.answers, Even.GAME_RULES);
                break;
            case 3:
                Calc.generateQuestionsAndAnswers();
                startGame(Calc.questions, Calc.answers, Calc.GAME_RULES);
                break;
            case 4:
                GCD.generateQuestionsAndAnswers();
                startGame(GCD.questions, GCD.answers, GCD.GAME_RULES);
                break;
            case 5:
                Progression.generateQuestionsAndAnswers();
                startGame(Progression.questions, Progression.answers, Progression.GAME_RULES);
                break;
            case 6:
                Prime.generateQuestionsAndAnswers();
                startGame(Prime.questions, Prime.answers, Prime.GAME_RULES);
                break;
            default:
                break;
        }
    }

    public static void startGame(Object[] questions, Object[] answers, String gameRules) {
        greetings();
        showGameRules(gameRules);
        for (int i = 0; i < questions.length; i++) {
            Object question = questions[i];
            Object correctAnswer = answers[i];
            Object playerAnswer;

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

    public static Object getPlayerAnswer() {
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
