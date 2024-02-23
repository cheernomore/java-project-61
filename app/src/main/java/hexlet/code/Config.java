package hexlet.code;

public class Config {

    public static final int POINTS_TO_WIN = 3;
    public static final int QUESTION_COUNT = 3;
    public static final int PLAYER_POINTS = 0;
    public static String playerName = "Player";

    public static final double CALC_PLUS_CONDITION_LIMIT = 0.3;
    public static final double CALC_MINUS_CONDITION_LIMIT = 0.6;
    public static final int CALC_MIN_GENERATED_VALUE = 0;
    public static final int CALC_MAX_GENERATED_VALUE = 10;

    public static final int EVEN_LOWER_BOUND = 0;
    public static final int EVEN_UPPER_BOUND = 10;

    public static final int GCD_LOWER_BOUND = 0;
    public static final int GCD_UPPER_BOUND = 10;

    public static final int PRIME_LOWER_BOUND = 0;
    public static final int PRIME_UPPER_BOUND = 10;

    public static final int PROGRESSION_LOWER_BOUND = 0;
    public static final int PROGRESSION_UPPER_BOUND = 10;
    public static final int PROGRESSION_MIN_STEP_VALUE = 1;
    public static final int PROGRESSION_MAX_STEP_VALUE = 10;

    public static void setPlayerName(String name) {
        playerName = name;
    }

    public static String getPlayerName() {
        return playerName;
    }

}
