package Application.terminal;

import Application.control.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventHandler implements KeyListener, ActionListener {

    //KeyListener methods
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            String input = Controller.terminal.inputField.getText();
            Controller.terminal.inputField.setText("");
            Controller.ioEngine.parseInput(input);
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
