package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Progression;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Calc;
import java.util.Scanner;

public class App {

    private static final int GREET_GAME_NUMBER = 1;
    private static final int EVEN_GAME_NUMBER = 2;
    private static final int CALC_NUMBER = 3;
    private static final int GCD_GAME_NUMBER = 4;
    private static final int PROGRESSION_GAME_NUMBER = 5;
    private static final int PRIME_GAME_NUMBER = 6;
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
            case GREET_GAME_NUMBER-> Cli.greetings();
            case EVEN_GAME_NUMBER -> Even.run();
            case CALC_NUMBER -> Calc.run();
            case GCD_GAME_NUMBER -> GCD.run();
            case PROGRESSION_GAME_NUMBER -> Progression.run();
            case PRIME_GAME_NUMBER -> Prime.run();
            default -> System.out.println("Введено некорректное число\nВведите число от 1 до 6.");
        }
    }
}
