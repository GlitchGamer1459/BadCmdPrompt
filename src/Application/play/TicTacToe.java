package Application.play;

import Application.control.Controller;
import Application.control.IOEngine;
import Application.control.Terminal;

import java.util.Arrays;

public class TicTacToe {

    private final IOEngine stringMethods = new IOEngine();

    @SuppressWarnings("FieldCanBeLocal") private final String STOP = "stop";

    private char charToPrint = 'X';
    private char charDidPrint = 'O';
    private String message = "Default";
    private int statusCode = 1;

    @SuppressWarnings("FieldMayBeFinal")
    private char[][] values = {
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' },
            { ' ', ' ', ' ' }
    };

    private void printBoard() {
        Terminal.out.println(message);

        Terminal.out.println(" " + values[0][0] + " | " + values[0][1] + " | " + values[0][2] + " ");
        Terminal.out.println("---+---+---");
        Terminal.out.println(" " + values[1][0] + " | " + values[1][1] + " | " + values[1][2] + " ");
        Terminal.out.println("---+---+---");
        Terminal.out.println(" " + values[2][0] + " | " + values[2][1] + " | " + values[2][2] + " ");
    }

    private void parseChain(String chain) { // a chain looks like this: '1.1' or this: '0.2'
        boolean hasCaughtError = false;
        String errorMsg = "";

        if (chain.equals(STOP)) {
            stop(true);
        } else {
            try {
                int vertical = Integer.parseInt(stringMethods.getUntilFirst('.', chain));
                int horizontal = Integer.parseInt(stringMethods.getUntilSecond('.', chain));

                if (values[vertical][horizontal] == ' ') {
                    values[vertical][horizontal] = charToPrint;
                } else {
                    hasCaughtError = true;
                    errorMsg += "; That tile is already taken";
                }

                swapTurn();
            } catch (NumberFormatException nfe) {
                errorMsg += "; Not a valid input, wrong format";
            } catch (ArrayIndexOutOfBoundsException e) {
                errorMsg += "; Not A Valid Input, must be within range of 0-2";
            }

            if (hasCaughtError) {
                swapTurn();
                message += errorMsg;
            }
        }
    }

    private void scanForWin() {
        //scan rows
        for (int i = 0; i < 3; i++) {
            if (isPointsEquivalent(i,0,i,1,i,2)) {
                message = charDidPrint + " wins!";
                stop(false);
            }
        }

        //scan columns
        for (int i = 0; i < 3; i++) {
            if (isPointsEquivalent(0,i,1,i,2,i)) {
                message = charDidPrint + " wins!";
                stop(false);
            }
        }

        //check left-down-to-right diagonal
        if (isPointsEquivalent(0,0,1,1,2,2)) {
            message = charDidPrint + " wins!";
            stop(false);
        }

        //check right-down-to-left diagonal
        if (isPointsEquivalent(0,2,1,1,2,0)) {
            message = charDidPrint + " wins!";
            stop(false);
        }
    }

    private boolean isPointsEquivalent(int x1, int y1, int x2, int y2, int x3, int y3) {
        if (values[x1][y1] == ' ' ||
                values[x2][y2] == ' ' ||
                values[x3][y3] == ' ') {
            return false;
        } else {
            return values[x1][y1] == values[x2][y2] &&
                    values[x1][y1] == values[x3][y3] &&
                    values[x2][y2] == values[x3][y3];
        }
    }

    private void swapTurn() {
        if (charToPrint == 'X') {
            charToPrint = 'O';
            charDidPrint = 'X';
            message = "O's turn";
        } else {
            charToPrint = 'X';
            charDidPrint = 'O';
            message = "X's turn";
        }
    }

    public int runGame(String string) {
        Controller.ioEngine.clearTerminalScreen();
        parseChain(string);
        scanForWin();
        printBoard();

        return statusCode;
    }

    public void reset() {
        for (char[] value : values) Arrays.fill(value, ' ');
    }

    private void stop(boolean doCLS) {
        Controller.eventHandler.gameAlreadyInit = false;

        statusCode = 0;

        if (doCLS) {
            Controller.ioEngine.clearTerminalScreen();
        }

        Terminal.setActiveCycle(0);
    }

    public void start() {
        message = "Welcome to Tic Tac Toe! see 'help' for more info";
        printBoard();
        statusCode = 1;
        Terminal.setActiveCycle(2);
    }
}
