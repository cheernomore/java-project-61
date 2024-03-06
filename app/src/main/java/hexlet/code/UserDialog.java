package hexlet.code;

import java.util.Scanner;

public class UserDialog {

    private static final Scanner PLAYER_INPUT = new Scanner(System.in);
    private static final String[] MAIN_MENU = {"Greet", "Even", "Calc", "GCD", "Progression", "Prime"};
    private static String playerName;
    private static int selectedGameNumber;
    public static void welcomeDialog() {
        System.out.println("Please enter the game number and press Enter.");
        for (int i = 1; i < MAIN_MENU.length + 1; i++) {
            String menuItem = MAIN_MENU[i - 1];
            System.out.println(i + " - " + menuItem);
        }
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        selectedGameNumber = Integer.parseInt(PLAYER_INPUT.nextLine());
    }

    public static void setPlayerName() {
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        playerName = PLAYER_INPUT.nextLine();
        System.out.println("Hello, " + playerName + "!");
    }

    public static void finalDialog(boolean isWin, String errorMessage) {
        if (isWin) {
            System.out.println("Congratulations, " + playerName + "!");
        } else {
            System.out.println(errorMessage);
            System.out.println("Let's try again, " + playerName + "!");
        }

        PLAYER_INPUT.close();
    }

    public static void greetings(int selectedGameNumber) {
        if (selectedGameNumber == 1) {
            System.out.println();
            System.out.println("Welcome to the Brain Games!");
            System.exit(0);
        }
    }

    public static int getSelectedGameNumber() {
        return selectedGameNumber;
    }
}
