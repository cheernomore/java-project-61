package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import hexlet.code.games.Even;
import hexlet.code.games.Game;

public class GameFactory {
    public static Game createInstance(String condition) {
        switch (condition) {
            case "6":
                return new Prime("6", "Prime");
            case "5":
                return new Progression("5", "Progression");
            case "4":
                return new GCD("4", "GCD");
            case "3":
                return new Calc("3", "Calc");
            case "2":
                return new Even("2", "Even");
            default:
                break;
        }
        return null;
    }
}
