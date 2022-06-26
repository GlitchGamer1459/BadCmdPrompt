package Application.control;

import Application.calculate.CalcParser;

public class IOEngine {

    private final CommandIndexList indexList = new CommandIndexList();
    private final CalcParser calculator = new CalcParser();

    @SuppressWarnings("UnnecessaryStringEscape")
    private void helpMenu() {
        Terminal.out.println(
                """
                 Lightning Shell V3.4 Help Menu:\n
                 stop: terminates the program\n
                 help: opens this menu\n
                 cls: clears the terminal screen of all current content\n
                 calculate: runs calculations based on secondary commands followed by input chains:
                 \ta chain looks like this:\tx:y:z\tthe x y and z are substituted for your inputs
                 \tadd: adds x and y together
                 \tsubtract: subtracts y from x
                 \tsqrt: returns the square root of x\n
                 play: runs a game based on secondary commands:
                 \thangman: runs a single-player game of hangman
                 \tguessgame: runs a single-player game where you guess a number based on ranges
                 \ttictactoe: runs a two person game of Tic Tac Toe
                """
        );
    }

    public String getUntilFirst(char terminator, String string) {
        String output = "";

        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) != terminator) {
                output += string.charAt(i);
            } else {
                break;
            }
        }

        return output;
    }

    public String getUntilSecond(char terminator, String string) {
        String output = "";
        String remove = getUntilFirst(terminator, string);
        remove += terminator;

        String getSecondFrom = string.replaceFirst(remove, "");

        for (int i = 0; i < getSecondFrom.length(); i++) {
            if (getSecondFrom.charAt(i) != terminator) {
                output += getSecondFrom.charAt(i);
            } else {
                break;
            }
        }

        return output;
    }

    public String getUntilThird(char terminator, String string) {
        String output = "";
        String remove = getUntilFirst(terminator, string) + terminator + getUntilSecond(terminator, string) + terminator;

        String getThirdFrom = string.replaceFirst(remove, "");

        for (int i = 0; i < getThirdFrom.length(); i++) {
            if (getThirdFrom.charAt(i) != terminator) {
                output += getThirdFrom.charAt(i);
            } else {
                break;
            }
        }

        return output;
    }

    public void clearTerminalScreen() {
        Controller.terminal.outputScreen.setText("");
        Controller.launchMessage();
    }

    private void parsePlay(String secondary) {
        int playIndex = indexList.PLAY_CMDS.getOrDefault(secondary, -1);
        switch (playIndex) {
            case 0 ->
                    Terminal.out.println("Hangman isn't ready yet");
            case 1 -> // switches active cycle to TicTacToe
                    Controller.eventHandler.ticTacToe.start();
            case 2 -> // switches active cycle to Guessing Game
                    Controller.eventHandler.guessGame.start();
            default -> // triggers if no match in PLAY_CMDS
                    Terminal.err.println("Not a valid command");
        }
    }

    private void parseCalc(String secondary, String tertiary) {
        int calcIndex = indexList.CALCULATE_CMDS.getOrDefault(secondary, -1);
        calculator.parseInput(tertiary , calcIndex);
    }

    public void parseInput(String input) {
        String primary = getUntilFirst(' ', input);
        String secondary = "";
        String tertiary = "";
        if (input.length() > primary.length()) {
            secondary = getUntilSecond(' ', input);
            if (input.length() > primary.length() + secondary.length()) {
                tertiary = getUntilThird(' ', input);
            }
        }

        int primaryIndex = indexList.PRIMARY_CMDS.getOrDefault(primary, -1);
        switch (primaryIndex) {
            case 0 -> // stop index in PRIMARY_CMDS
                    {
                        Terminal.out.println("Program stopping...");
                        System.exit(0);
                    }
            case 1 -> // help index in PRIMARY_CMDS
                        helpMenu();
            case 2 -> // play index in PRIMARY_CMDS
                        parsePlay(secondary);
            case 3 -> // calculate index in PRIMARY_CMDS
                        parseCalc(secondary, tertiary);
            case 4 -> // cls index in PRIMARY_CMDS
                        clearTerminalScreen();
            default -> // triggers if no match in PRIMARY_CMDS
                        Terminal.out.println("Not a valid command");
        }
    }
}
