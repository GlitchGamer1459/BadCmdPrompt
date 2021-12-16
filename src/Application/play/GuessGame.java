package Application.play;

import Application.control.Controller;

import java.util.Scanner;

public class GuessGame {

    private static final String STOP = "stop";

    @SuppressWarnings("SameParameterValue")
    private static String randPosInt(int max) {
        return "" + (int)Math.floor(Math.random() * max);
    }

    private static void scan(Scanner scanner, final String ANSWER) {
        String input;
        boolean running = true;
        int inputInt;
        int answerInt;

        while (running) {
            input = scanner.nextLine();

            if (input.equals(STOP)) {
                System.out.println("Stopping game, returning to Controller...");

                running = false;

                Controller.start();
            }

            try {
                inputInt = Integer.parseInt(input);
                answerInt = Integer.parseInt(ANSWER);

                if (inputInt == answerInt) {
                    System.out.println("You Win!!");
                    System.out.println("Returning to Controller...");

                    running = false;

                    Controller.start();
                } else if (inputInt < answerInt) {
                    System.out.println("Bigger");
                } else {
                    System.out.println("Smaller");
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid Input");
            }
        }
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);
        String answer = randPosInt(1000);

        System.out.println(answer);
        scan(scanner, answer);
    }
}
