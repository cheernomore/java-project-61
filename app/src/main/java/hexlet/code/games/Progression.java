package hexlet.code.games;

import hexlet.code.Cli;
import org.apache.commons.lang3.RandomUtils;

import java.util.Arrays;
import java.util.Scanner;

public class Progression extends Game {

    public Progression(String gameLaunchKey, String gameTitle) {
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

    public boolean getAnswer() {
        Scanner scanner = new Scanner(System.in);
        int userAnswer;
        int[] progression = generateProgression();
        int randomIndex = getProgressionRandomIndex(progression);
        int correctAnswer = progression[randomIndex];

        System.out.println("Your answer: " + showProgression(progression, randomIndex));
        userAnswer = scanner.nextInt();

        if (correctAnswer == userAnswer) {
            System.out.println("Correct!");
            COUNTER++;
            return true;
        } else {
            System.out.println(userAnswer + " is wrong answer. ;(. Correct answer '" + correctAnswer + "'.");
            return false;
        }
    }

    public int[] generateProgression() {
        int[] progression = new int[RandomUtils.nextInt(5, 10)];
        int start = RandomUtils.nextInt(0, 100);
        int step = RandomUtils.nextInt(0, 100);

        for (int i = 0; i < progression.length; i++) {
            start += step;
            progression[i] = start;
        }

        return progression;
    }

    public String showProgression(int[] progression, int randomIndex) {
        String[] stringNumbers = new String[progression.length];

        for (int i = 0; i < progression.length; i++) {
            if (i == randomIndex) {
                stringNumbers[i] = ".. ";
            } else {
                stringNumbers[i] = Integer.toString(progression[i]);
            }
        }

        return Arrays.toString(stringNumbers);
    }

    public int getProgressionRandomIndex(int[] progression) {
        return RandomUtils.nextInt(0, progression.length - 1);
    }
}
