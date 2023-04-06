package hexlet.code.games;

import org.apache.commons.lang3.RandomUtils;

public class Prime {

    public static Object[][] generateGameRulesAndQASet() {
        Object[][] questionAnswerIteration = new Object[3][2];

        for (int i = 0; i < questionAnswerIteration.length; i++) {
            int question = generateQuestion();
            String answer = generateAnswer(question);
            questionAnswerIteration[i][0] = question;
            questionAnswerIteration[i][1] = answer;
        }

        return questionAnswerIteration;
    }

    public static int generateQuestion() {
        int startRangeGenerateRandomNumber = 0;
        int endRangeGenerateRandomNumber = 100;

        return RandomUtils.nextInt(startRangeGenerateRandomNumber, endRangeGenerateRandomNumber);
    }

    public static String generateAnswer(int question) {
        return isPrime(question);
    }

    public static String isPrime(int number) {
        if (number <= 1) {
            return "no";
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return "no";
            }
        }

        return "yes";
    }
//
//    public static String isEven(int number) {
//        return number % 2 == 0 ? "yes" : "no";
//    }
//
//    public void start() {
//        String username = Cli.greetings();
//        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
//
//        while (COUNTER < WIN_CONDITION) {
//            boolean answer = getAnswer();
//
//            if (!answer) {
//                break;
//            }
//
//            if (COUNTER == WIN_CONDITION) {
//                System.out.println("Congratulations, " + username + "!");
//            }
//        }
//    }

//    public boolean getAnswer() {
//        Scanner scanner = new Scanner(System.in);
//        int randomNumber = RandomUtils.nextInt(0, 100);
//        String userAnswer;
//        String correctAnswer = isPrime(randomNumber);
//
//        System.out.println("Question: " + randomNumber);
//        System.out.print("Answer: ");
//        userAnswer = scanner.nextLine();
//
//        if (correctAnswer.equals(userAnswer)) {
//            System.out.println("Correct!");
//            COUNTER++;
//            return true;
//        } else {
//            System.out.println(userAnswer + " is wrong answer. ;(. Correct answer '" + correctAnswer + "'.");
//            return false;
//        }
//    }
}
