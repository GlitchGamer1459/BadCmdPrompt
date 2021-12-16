package Application.play;

import Application.control.IOEngine;
import Application.control.Terminal;

import java.util.Scanner;

public class TicTacToe {

    private static final IOEngine stringMethods = new IOEngine();

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
        try {
            int vertical = Integer.parseInt(stringMethods.getUntilFirst('.', chain));
            int horizontal = Integer.parseInt(stringMethods.getUntilSecond('.', chain));

            if (charToPrint == 'X') {
                charToPrint = 'O';
            } else {
                charToPrint = 'X';
            }

            values[vertical][horizontal] = charToPrint;
        } catch (NumberFormatException nfe) {
            Terminal.out.println("Not A Valid Input, try again");
        } catch (ArrayIndexOutOfBoundsException e) {
            Terminal.out.println("Not A Valid Input, must be within range of 0-2");
        }
    }

    private static void scan(Scanner scanner) {
        String input;
        boolean running = true;

        while (running) {
            input = scanner.nextLine();

            parseChain(input);
            printBoard();
        }
    }

    public static void start() {
        Scanner scanner = new Scanner(System.in);

        scan(scanner);
    }
}
