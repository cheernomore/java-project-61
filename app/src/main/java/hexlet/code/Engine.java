package hexlet.code;

import java.util.Scanner;

public class Engine {
    String[] gamesInfo = new String[]{"1 - Greet", "2 - Even", "3 - Calc", "4 - GCD", "5 - Progression", "6 - Prime", "0 - Exit"};

    public void showGamesToUser() {
        for (String game: gamesInfo) {
            System.out.println(game);
        }
    }

    public void launchGame() {
        Scanner scanner = new Scanner(System.in);
        String userChoice;

        System.out.print("Choice the game: ");
        userChoice = scanner.nextLine();

        GameFactory.createInstance(userChoice).start();
    }
}
