package hexlet.code.games;

import hexlet.code.Cli;
import org.apache.commons.lang3.RandomUtils;

import java.util.Scanner;

public class Prime extends Game {
    public Prime(String gameLaunchKey, String gameTitle) {
        super(gameLaunchKey, gameTitle);
    }

    public void start() {
        String username = Cli.greetings();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        while (COUNTER < WIN_CONDITION) {
            boolean answer = getAnswer();

            if (!answer) {
                break;
            }

            if (COUNTER == WIN_CONDITION) {
                System.out.println("Congratulations, " + username + "!");
            }
        }
    }

    public String isPrime(int number) {
        if (number <= 1) {
            return "no";
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return "no";
            }
        }

        return "yes";
    }

    public boolean getAnswer() {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = RandomUtils.nextInt(0, 100);
        String userAnswer;
        String correctAnswer = isPrime(randomNumber);

        System.out.println("Question: " + randomNumber);
        System.out.print("Answer: ");
        userAnswer = scanner.nextLine();

        if (correctAnswer.equals(userAnswer)) {
            System.out.println("Correct!");
            COUNTER++;
            return true;
        } else {
            System.out.println(userAnswer + " is wrong answer. ;(. Correct answer '" + correctAnswer + "'.");
            return false;
        }
    }
}
