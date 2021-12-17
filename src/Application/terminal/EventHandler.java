package Application.terminal;

import Application.control.Controller;
import Application.control.Terminal;
import Application.play.GuessGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventHandler implements KeyListener, ActionListener {

    @SuppressWarnings("all")
    private boolean gameAlreadyInit = false;

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
                case 0 ->
                    Controller.ioEngine.parseInput(input);
                case 1 -> {
                    if (!gameAlreadyInit) {
                        GuessGame.start();
                        gameAlreadyInit = true;
                    }

                    GuessGame.runGame(input);
                }
                case 2 -> {}
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
