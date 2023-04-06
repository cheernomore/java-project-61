package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        final int greetGameIndex = 1;
        final int evenGameIndex = 2;
        final int calcGameIndex = 3;
        final int gcdGameIndex = 4;
        final int progressionGameIndex = 5;
        final int primeGameIndex = 6;
        final int exitGameIndex = 0;
        final String[] games = new String[]{
            exitGameIndex + " - Exit",
            greetGameIndex + " - Greet",
            evenGameIndex + " - Even",
            calcGameIndex + " - Calc",
            gcdGameIndex + " - GCD",
            progressionGameIndex + " - Progression",
            primeGameIndex + " - Prime"
        };

        Scanner scanner = new Scanner(System.in);
        int userGameSelected;

        for (String game: games) {
            System.out.println(game);
        }

        System.out.print("Your choice: ");
        userGameSelected = scanner.nextInt();

        switch (userGameSelected) {
            case greetGameIndex:
                Engine.launchGame();
                break;
            case evenGameIndex:
                Engine.launchGame(
                        "Answer 'yes' if the number is even, otherwise answer 'no'.",
                        Even.generateGameRulesAndQASet());
                break;
            case calcGameIndex:
                Engine.launchGame(
                        "What is the result of the expression?",
                        Calc.generateGameRulesAndQASet());
                break;
            case gcdGameIndex:
                Engine.launchGame(
                        "Find the greatest common divisor of given numbers.",
                        GCD.generateGameRulesAndQASet());
                break;
            case progressionGameIndex:
                Engine.launchGame(
                        "What number is missing in the progression?",
                        Progression.generateGameRulesAndQASet());
                break;
            case primeGameIndex:
                Engine.launchGame(
                        "Answer 'yes' if given number is prime. Otherwise answer 'no'.",
                        Prime.generateGameRulesAndQASet());
                break;
            default:
                break;
        }
    }
}
