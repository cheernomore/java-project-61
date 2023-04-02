package hexlet.code.games;

import hexlet.code.Cli;
import org.apache.commons.lang3.RandomUtils;

import java.util.Scanner;

public class GCD extends Game {

    public GCD(String gameLaunchKey, String gameTitle) {
        super(gameLaunchKey, gameTitle);
    }

    public void start() {
        String username = Cli.greetings();
        System.out.println("Find the greatest common divisor of given numbers.");

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

    public int getGCD(int num1, int num2) {
        if (num1 == num2) {
            return num1;
        }

        while (num1 != num2) {
            if (num1 > num2) {
                num1 = num1 - num2;
            } else {
                num2 = num2 - num1;
            }
        }

        return num1;
    }

    public boolean getAnswer() {
        Scanner scanner = new Scanner(System.in);
        int num1 = RandomUtils.nextInt(0, 100);
        int num2 = RandomUtils.nextInt(0, 100);

        int userAnswer;
        int correctAnswer;

        System.out.println("Your answer: " + num1 + " " + num2);
        userAnswer = scanner.nextInt();

        correctAnswer = getGCD(num1, num2);
        if (correctAnswer == userAnswer) {
            System.out.println("Correct!");
            COUNTER++;
            return true;
        } else {
            System.out.println(userAnswer + " is wrong answer. ;(. Correct answer '" + correctAnswer + "'.");
            return false;
        }
    }
}
