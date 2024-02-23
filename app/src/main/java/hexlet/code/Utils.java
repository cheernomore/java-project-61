package hexlet.code;

import java.util.Scanner;

public class Utils {
    public static int generateRandomInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
