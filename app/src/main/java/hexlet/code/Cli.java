package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String greetings() {
        Scanner scanner = new Scanner(System.in);
        String username;
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        username = scanner.nextLine();
        System.out.println("Hello, " + username + "!");

        return username;
    }
}
