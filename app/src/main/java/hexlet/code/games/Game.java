package hexlet.code.games;

public class Game {
    private String gameTitle;
    private String gameLaunchKey;
    public final int WIN_CONDITION = 3;
    public int COUNTER = 0;

    public Game(String gameLaunchKey, String gameTitle) {
        this.gameTitle = gameTitle;
        this.gameLaunchKey = gameLaunchKey;
    }

    public void start() {
    }

    public String getGameTitle() {
        return gameTitle;
    }

    public String getGameLaunchKey() {
        return gameLaunchKey;
    }

}
