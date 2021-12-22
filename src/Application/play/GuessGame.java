package Application.play;

import Application.control.Controller;
import Application.control.Terminal;

public class GuessGame {

    @SuppressWarnings("FieldCanBeLocal") private final String STOP = "stop";
    private String answer;

    @SuppressWarnings("SameParameterValue")
    private String randPosInt(int max) {
        return "" + (int)Math.floor(Math.random() * max);
    }

    public void runGame(String input) {
        int inputInt;
        int answerInt;

        if (input.equals(STOP)) {
            Terminal.out.println("Stopping game, returning to Controller...");

            stop();
        }

        try {
            inputInt = Integer.parseInt(input);
            answerInt = Integer.parseInt(answer);

            if (inputInt == answerInt) {
                Terminal.out.println("You Win!!");
                Terminal.out.println("Returning to Controller...");

                stop();
            } else if (inputInt < answerInt) {
                Terminal.out.println("Bigger");
            } else {
                Terminal.out.println("Smaller");
            }
        } catch (NumberFormatException nfe) {
            Terminal.out.println("Invalid Input");
        }
    }

    private void stop() {
        Controller.eventHandler.gameAlreadyInit = false;
        Terminal.setActiveCycle(0);
    }

    public void start() {
        answer = randPosInt(1000);
        Terminal.setActiveCycle(1);
    }
}
