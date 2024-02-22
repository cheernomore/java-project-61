package hexlet.code;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Utils {

    public static Properties properties = loadPropertiesFile("src/main/resources/config.properties");
    public static int generateRandomInt(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
    public static Scanner scanner = new Scanner(System.in);

    public static Properties loadPropertiesFile(String path) {
        Properties props = new Properties();
        try (FileInputStream in = new FileInputStream(path)) {
            props.load(in);
            return props;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return props;
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void setProperty(String key, String value) {
        properties.setProperty(key, value);
    }

    public static String getUserAnswer() {
        return scanner.nextLine();
    }

    public static void setPlayerName(Properties props) {
        String newPlayerName = scanner.nextLine();
        props.setProperty("playerName", newPlayerName);
    }

    public static boolean isUserAnswerCorrect(String userAnswer, String correctAnswer) {
        return userAnswer.equals(correctAnswer);
    }
}
