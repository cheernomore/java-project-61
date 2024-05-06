package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static void greetings() {
        String username;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        username = scanner.nextLine();

        System.out.println("Hello, " + username + "!");
    }
}
