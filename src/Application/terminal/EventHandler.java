package Application.terminal;

import Application.control.Controller;
import Application.control.Terminal;
import Application.play.GuessGame;
import Application.play.TicTacToe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventHandler implements KeyListener, ActionListener {

    public boolean gameAlreadyInit = false;
    public final GuessGame guessGame = new GuessGame();

    //KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            String input = Controller.terminal.inputField.getText();
            Controller.terminal.inputField.setText("");
            switch (Terminal.getActiveCycle()) {
                case 0 -> // runs the base Terminal cycle
                    Controller.ioEngine.parseInput(input);
                case 1 -> { // runs the guessing game
                    if (!gameAlreadyInit) {
                        guessGame.start();
                        gameAlreadyInit = true;
                    }

                    guessGame.runGame(input);
                }
                case 2 -> {
                    if (!gameAlreadyInit) {
                        TicTacToe.start();
                        gameAlreadyInit = true;
                    }

                    if (TicTacToe.runGame(input) == 0) {
                        TicTacToe.reset();
                    }
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    //ActionListener methods
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
