package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Progression;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Calc;
import java.util.Scanner;

public class App {
    private static final String MAIN_MENU =
            """
                0 - Exit
                1 - Greet
                2 - Even
                3 - Calc
                4 - GCD
                5 - Progression
                6 - Prime
            """;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game number and press Enter.");
        System.out.println(MAIN_MENU);
        System.out.print("Your choice: ");
        gameFactory(Integer.parseInt(scanner.nextLine()));
        scanner.close();
    }

    public static void gameFactory(int gameNumber) {
        switch (gameNumber) {
            case 1 -> Cli.greetings();
            case 2 -> Even.run();
            case 3 -> Calc.run();
            case 4 -> GCD.run();
            case 5 -> Progression.run();
            case 6 -> Prime.run();
            default -> System.out.println("Scr!");
        }
    }
}
