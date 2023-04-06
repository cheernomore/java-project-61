package hexlet.code;

import java.util.Scanner;

public class Engine {

    public static void launchGame() {
        Scanner scanner = new Scanner(System.in);
        String username;

        System.out.print("May I have your name? ");
        username = scanner.nextLine();

        System.out.println("Hello, " + username + "!");
    }
    public static void launchGame(String rules, Object[][] askAnswers) {
        final int winCondition = 3;
        int counter = 0;
        String userAnswer;
        String username;
        Scanner scanner = new Scanner(System.in);

        System.out.print("May I have your name? ");
        username = scanner.nextLine();
        System.out.println(rules);

        for (int i = 0; i < winCondition; i++) {
            askQuestion(askAnswers[i][0]);
            System.out.print("Your answer: ");
            userAnswer = scanner.nextLine();

            if (userAnswer.equals(askAnswers[i][1])) {
                counter++;
                System.out.println("Success!");
            } else {
                System.out.println(
                    "'" + userAnswer + "' is wrong answer. Correct answer is was '" + askAnswers[i][1] + "'.");
                break;
            }

            if (counter == winCondition) {
                System.out.println("Congratulations, " + username + "!");
            }
        }
    }

    public static void askQuestion(Object question) {
        System.out.println("Question: " + question);
    }
}
