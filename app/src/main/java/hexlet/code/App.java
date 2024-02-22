package hexlet.code;

import hexlet.code.games.Even;
import hexlet.code.games.Progression;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Calc;
import java.util.Scanner;

public class App {
    private static final Scanner PLAYER_INPUT = new Scanner(System.in);
    private static final String[] MAIN_MENU = {"Greet", "Even", "Calc", "GCD", "Progression", "Prime"};

    public static void main(String[] args) {
        String[][] gameData;

        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter.");
        for (int i = 1; i < MAIN_MENU.length; i++) {
            String menuItem = MAIN_MENU[i];
            System.out.println(i + " - " + menuItem);
        }
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
        int numberOfSelectedGame = Integer.parseInt(PLAYER_INPUT.nextLine());

        System.out.print("May I have your name? ");
        String playerName = PLAYER_INPUT.nextLine();
        Utils.setProperty("playerName", playerName);

        gameData = gameFactory(numberOfSelectedGame);
        String gameRules = gameRulesFactory(numberOfSelectedGame);
        System.out.println(gameRules);
        Engine.launchGame(gameData);

        PLAYER_INPUT.close();
    }

    public static String[][] gameFactory(int gameNumber) {
        return switch (gameNumber) {
            case 1 -> Even.generateGameData();
            case 2 -> Calc.generateGameData();
            case 3 -> GCD.generateGameData();
            case 4 -> Progression.generateGameData();
            case 5 -> Prime.generateGameData();
            default -> null;
        };
    }

    public static String gameRulesFactory(int gameNumber) {
        return switch (gameNumber) {
            case 1 -> Even.getGameRules();
            case 2 -> Calc.getGameRules();
            case 3 -> GCD.getGameRules();
            case 4 -> Progression.getGameRules();
            case 5 -> Prime.getGameRules();
            default -> null;
        };
    }
}
