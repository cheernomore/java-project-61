package hexlet.code;

import java.util.Scanner;

import static hexlet.code.Engine.run;

public class App {

    private static final Scanner PLAYER_CLI_INPUT = new Scanner(System.in);
    private static final String[] MAIN_MENU = {"Greet", "Even", "Calc", "GCD", "Progression", "Prime"};

    public static void main(String[] args) {

        loadMainMenu();
        int numberOfSelectedGame = PLAYER_CLI_INPUT.nextInt();
        run(numberOfSelectedGame);
        PLAYER_CLI_INPUT.close();
    }

    public static void loadMainMenu() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter.");
        for (int i = 0; i < MAIN_MENU.length; i++) {
            String menuItem = MAIN_MENU[i];
            System.out.println(i + 1 + " - " + menuItem);
        }
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");
    }
}
