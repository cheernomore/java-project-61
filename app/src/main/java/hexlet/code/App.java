package hexlet.code;

public class App {
    public static void main(String[] args) {
        Engine engine = new Engine();

        engine.showGamesToUser();
        engine.launchGame();


//        Scanner scanner = new Scanner(System.in);
//        int userChoice;
//        String[] menu = new String[]{"0 - Exit", "3 - Calc", "2 - Even", "1 - Greet"};
//
//        System.out.println("Please enter the game number and press Enter.");
//
//        for (int i = menu.length - 1; i >= 0; i--) {
//            System.out.println(menu[i]);
//        }
//
//
//        userChoice = scanner.nextInt();
//        System.out.print("Your choice: " + userChoice);
//
//        switch (userChoice) {
//            case 2:
//                Even.startApplication();
//            case 3:
//                new Calc().startApplication();
//        }
    }
}
