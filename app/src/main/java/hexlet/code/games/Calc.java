package hexlet.code.games;

import hexlet.code.Cli;
import org.apache.commons.lang3.RandomUtils;

import java.util.Scanner;

public class Calc extends Game {
    private int arithmeticOperationRangeStart = 0;
    private int getArithmeticOperationRangeEnd = 2;

    private String[] arithmeticOperations = new String[]{"+", "-", "*"};

    public Calc(String gameLaunchKey, String gameTitle) {
        super(gameLaunchKey, gameTitle);
    }

    public void start() {
        boolean answer;
        String username;

        username = Cli.greetings();
        System.out.println("What is the result of the expression?");

        while (COUNTER < WIN_CONDITION) {

            answer = askQuestion();

            if (answer) {
                COUNTER++;

                if (COUNTER == WIN_CONDITION) {
                    System.out.println("Congratulations, " + username + "!");
                }
            } else {
                break;
            }
        }
    }

    public String getRandomArithmeticOperation() {
        return arithmeticOperations[RandomUtils.nextInt(arithmeticOperationRangeStart, getArithmeticOperationRangeEnd)];
    }

    public int generateArithmeticExpression(String arithmeticOperand, int num1, int num2) {
        switch (arithmeticOperand) {
            case "+" -> {
                return num1 + num2;
            }
            case "-" -> {
                return num1 - num2;
            }
            case "*" -> {
                return num1 * num2;
            }
            default -> {
                return 0;
            }
        }
    }

    public void printArithmeticExpression(String arithmeticOperand, int num1, int num2) {
        System.out.println("Question: " + num1 + " " + arithmeticOperand + " " + num2);
    }

    public boolean askQuestion() {
        int firstNumber = RandomUtils.nextInt(0, 100);
        int secondNumber = RandomUtils.nextInt(0, 100);
        String randomArithmeticExpression = getRandomArithmeticOperation();
        Scanner scanner = new Scanner(System.in);
        int userAnswer;

        printArithmeticExpression(randomArithmeticExpression, firstNumber, secondNumber);
        System.out.print("Your answer: ");
        userAnswer = scanner.nextInt();

        int answer = generateArithmeticExpression(randomArithmeticExpression, firstNumber, secondNumber);

        if (answer == userAnswer) {
            System.out.println("Correct!");
            return true;
        } else {
            System.out.println(userAnswer + " is wrong answer. ;(. Correct answer '" + answer + "'.");
            return false;
        }
    }
}
