package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class App {
    public static void main(String[] args) {
        UserDialog.welcomeDialog();
        UserDialog.greetings();

        String[][] gameData = selectGame(UserDialog.getSelectedGameNumber());
        String gameRules = getGameRules(UserDialog.getSelectedGameNumber());

        Engine.launchGame(gameData, gameRules);

        UserDialog.finalDialog(Engine.isWin(), Engine.getErrorMessage());
    }
    public static String[][] selectGame(int gameNumber) {
        return switch (gameNumber) {
            case 2 -> Even.generateGameData();
            case 3 -> Calc.generateGameData();
            case 4 -> GCD.generateGameData();
            case 5 -> Progression.generateGameData();
            case 6 -> Prime.generateGameData();
            default -> null;
        };
    }
    public static String getGameRules(int gameNumber) {
        return switch (gameNumber) {
            case 2 -> Even.GAME_RULES;
            case 3 -> Calc.GAME_RULES;
            case 4 -> GCD.GAME_RULES;
            case 5 -> Progression.GAME_RULES;
            case 6 -> Prime.GAME_RULES;
            default -> null;
        };
    }
}
