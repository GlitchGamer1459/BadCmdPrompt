package Application.play;

import Application.control.Controller;
import Application.control.IOEngine;
import Application.control.Terminal;

public class TicTacToe {

    private static final IOEngine stringMethods = new IOEngine();

    @SuppressWarnings("FieldCanBeLocal") private static final String STOP = "stop";

    private static char charToPrint = 'X';

    @SuppressWarnings("FieldMayBeFinal")
    private static char[][] values = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
    };

    private static void printBoard() {
        Terminal.out.println(" " + values[0][0] + " | " + values[0][1] + " | " + values[0][2] + " ");
        Terminal.out.println("---+---+---");
        Terminal.out.println(" " + values[1][0] + " | " + values[1][1] + " | " + values[1][2] + " ");
        Terminal.out.println("---+---+---");
        Terminal.out.println(" " + values[2][0] + " | " + values[2][1] + " | " + values[2][2] + " ");
    }

    private static void parseChain(String chain) { // a chain looks like this: '1.1' or this: '0.2'
        if (chain.equals(STOP)) {
            Terminal.setActiveCycle(0);

            stop();
        } else {
            try {
                int vertical = Integer.parseInt(stringMethods.getUntilFirst('.', chain));
                int horizontal = Integer.parseInt(stringMethods.getUntilSecond('.', chain));

                if (charToPrint == 'X') {
                    charToPrint = 'O';
                } else {
                    charToPrint = 'X';
                }

                if (values[vertical][horizontal] == ' ') {
                    values[vertical][horizontal] = charToPrint;
                } else {
                    Terminal.out.println("That tile is already taken");
                }
            } catch (NumberFormatException nfe) {
                Terminal.out.println("Not A Valid Input, try again");
            } catch (ArrayIndexOutOfBoundsException e) {
                Terminal.out.println("Not A Valid Input, must be within range of 0-2");
            }
        }
    }

    public static void runGame(String string) {
        Controller.ioEngine.clearTerminalScreen();
        parseChain(string);
        printBoard();
    }

    private static void stop() {
        Terminal.setActiveCycle(0);
        Controller.eventHandler.gameAlreadyInit = false;
        Controller.ioEngine.clearTerminalScreen();
    }

    public static void start() {
        Terminal.setActiveCycle(2);
    }
}
