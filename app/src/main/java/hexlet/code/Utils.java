package hexlet.code;

import java.util.Scanner;

public class Utils {
    public static int generateRandomInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static Scanner scanner = new Scanner(System.in);
    public static String getUserAnswer() {
        return scanner.nextLine();
    }
    public static boolean isUserAnswerCorrect(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer);
    }
}
