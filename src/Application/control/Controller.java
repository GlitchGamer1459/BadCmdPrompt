package Application.control;

import Application.terminal.EventHandler;
import Application.terminal.TerminalFrame;

/*
TODO: change static class properties in TicTacToe to be instance based
TODO: learn about/implement layout manager to aid resizability, i.e. BorderLayout
TODO: add more calculate commands
TODO: make hangman
TODO: come up with a new project
 */

public class Controller {

    public static final IOEngine ioEngine = new IOEngine();
    public static final TerminalFrame terminal = new TerminalFrame();
    public static final EventHandler eventHandler = new EventHandler();

    public static void launchMessage() {
        Terminal.out.println("Lightning Parser for Microsoft Windows [Version 3.4.12-15-2021]");
        Terminal.out.println("(c) Jumping Jacks Incorporated. All rights reserved.");
        Terminal.out.println();
    }

    public static void start() {
        ioEngine.running = true;
        Terminal.setActiveCycle(0);

        terminal.setKeyListener(eventHandler);
        launchMessage();
    }

    public static void main(String[] args) {
        Controller.start();
    }
}
