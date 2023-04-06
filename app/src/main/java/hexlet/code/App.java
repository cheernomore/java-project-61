package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        String[] games = new String[]{
            "1 - Greet", "2 - Even", "3 - Calc", "4 - GCD", "5 - Progression", "6 - Prime", "0 - Exit"};
        Scanner scanner = new Scanner(System.in);
        int userGameSelected;

        for (String game: games) {
            System.out.println(game);
        }

        System.out.print("Your choice: ");
        userGameSelected = scanner.nextInt();

        switch (userGameSelected) {
            case 1:
                Engine.launchGame();
                break;
            case 2:
                Engine.launchGame(
                        "Answer 'yes' if the number is even, otherwise answer 'no'.",
                        Even.generateGameRulesAndQASet(3));
                break;
            case 3:
                Engine.launchGame(
                        "What is the result of the expression?",
                        Calc.generateGameRulesAndQASet(3));
                break;
            case 4:
                Engine.launchGame(
                        "Find the greatest common divisor of given numbers.",
                        GCD.generateGameRulesAndQASet(3));
                break;
            case 5:
                Engine.launchGame(
                        "What number is missing in the progression?",
                        Progression.generateGameRulesAndQASet(3));
                break;
            case 6:
                Engine.launchGame(
                        "Answer 'yes' if given number is prime. Otherwise answer 'no'.",
                        Prime.generateGameRulesAndQASet(3));
                break;
            default:
                break;
        }
    }
}
