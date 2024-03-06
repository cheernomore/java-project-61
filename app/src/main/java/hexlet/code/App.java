package hexlet.code;

public class App {
    public static void main(String[] args) {
        UserDialog.welcomeDialog();
        UserDialog.greetings(UserDialog.getSelectedGameNumber());
        Engine.launchGame(UserDialog.getSelectedGameNumber());
        UserDialog.finalDialog(Engine.isWin(), Engine.getErrorMessage());
    }
}
