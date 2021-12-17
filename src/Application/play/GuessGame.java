package Application.play;

import Application.control.Terminal;

public class GuessGame {

    private static final String STOP = "stop";
    private static String answer;

    @SuppressWarnings("SameParameterValue")
    private static String randPosInt(int max) {
        return "" + (int)Math.floor(Math.random() * max);
    }

    public static void runGame(String input) {
        int inputInt;
        int answerInt;
        Terminal.out.println(answer);

        if (input.equals(STOP)) {
            Terminal.out.println("Stopping game, returning to Controller...");

            Terminal.setActiveCycle(0);
        }

        try {
            inputInt = Integer.parseInt(input);
            answerInt = Integer.parseInt(answer);

            if (inputInt == answerInt) {
                Terminal.out.println("You Win!!");
                Terminal.out.println("Returning to Controller...");

                Terminal.setActiveCycle(0);
            } else if (inputInt < answerInt) {
                Terminal.out.println("Bigger");
            } else {
                Terminal.out.println("Smaller");
            }
        } catch (NumberFormatException nfe) {
            Terminal.out.println("Invalid Input");
        }
    }


    public static void start() {
        answer = randPosInt(1000);
        Terminal.setActiveCycle(1);
    }
}
