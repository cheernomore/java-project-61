package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class Engine {
    static Scanner playerCliInput = new Scanner(System.in);
    static int playerPointsCounter = 0;
    static final int WIN_CONDITIONS = 3;
    static String playerName;
    static int game;

    public static void run() {
        String[] menu = {"Greet", "Even", "Calc", "GCD", "Progression", "Prime"};

        System.out.println("Please enter the game number and press Enter.");
        for (int i = 0; i < menu.length; i++) {
            String menuItem = menu[i];
            System.out.println(i + 1 + " - " + menuItem);
        }
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        game = chooseGame();

        switch (game) {
            case 1:
                greetings();
                break;
            case 2:
                greetings();
                System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
                startGame(Even.questions, Even.answers);
                break;
            case 3:
                greetings();
                Calc.generateQuestionsAndAnswers();
                System.out.println("What is the result of the expression?");
                startGame(Calc.questions, Calc.answers);
                break;
            case 4:
                greetings();
                GCD.generateQuestionsAndAnswers();
                System.out.println("Find the greatest common divisor of given numbers.");
                startGame(GCD.questions, GCD.answers);
                break;
            case 5:
                greetings();
                Progression.generateQuestionsAndAnswers();
                System.out.println("What number is missing in the progression?");
                startGame(Progression.questions, Progression.answers);
                break;
            case 6:
                greetings();
                Prime.generateQuestionsAndAnswers();
                System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
                startGame(Prime.questions, Prime.answers);
                break;
            default:
                break;
        }
    }

    public static void startGame(Object[] questions, Object[] answers) {
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
                break;
            }
        }
    }
    public static void addOnePointToPlayer() {
        playerPointsCounter++;
    }

    public static void askQuestion(Object question) {
        System.out.println("Question: " + question);
    }

    public static Object getPlayerAnswer() {
        return playerCliInput.nextLine();
    }

    public static void congratulations() {
        System.out.println("Congratulations, " + playerName + "!");
    }

    public static String setPlayerName() {
        return playerCliInput.nextLine();
    }

    public static int chooseGame() {
        game = playerCliInput.nextInt();
        playerCliInput.nextLine();

        return game;
    }

    public static void greetings() {
        System.out.print("May I have your name? ");
        playerName = setPlayerName();
        System.out.println("Hello, " + playerName + "!");
    }
}
