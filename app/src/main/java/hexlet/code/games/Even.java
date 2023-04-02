package hexlet.code.games;

import hexlet.code.Cli;
import org.apache.commons.lang3.RandomUtils;

import java.util.Scanner;

public class Even extends Game {

    public Even(String gameLaunchKey, String gameTitle) {
        super(gameLaunchKey, gameTitle);
    }
    public void start() {
        boolean answer;
        String username;

        username = Cli.greetings();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        while (COUNTER < WIN_CONDITION) {

            answer = askQuestion();

            if (answer) {
                COUNTER++;

                if (COUNTER == WIN_CONDITION) {
                    System.out.println("Congratulations, " + username + "!");
                }
            } else {
                break;
            }
        }
    }
    public static String isEven(int number) {
        return number % 2 == 0 ? "yes" : "no";
    }

    public static boolean askQuestion() {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = RandomUtils.nextInt(0, 100);
        String userAnswer;
        System.out.println("Question: " + randomNumber);
        System.out.print("Your answer: ");
        userAnswer = scanner.nextLine();

        if (userAnswer.equals(isEven(randomNumber))) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println(userAnswer + " is wrong answer. ;(. Correct answer '" + isEven(randomNumber) + "'.");
            return false;
        }
    }
}
