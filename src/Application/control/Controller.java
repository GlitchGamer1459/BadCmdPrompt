package Application.control;

import Application.terminal.EventHandler;
import Application.terminal.TerminalFrame;

public class Controller {

    public static final IOEngine ioEngine = new IOEngine();
    public static final TerminalFrame terminal = new TerminalFrame();
    public static final EventHandler eventHandler = new EventHandler();

    private static void launchMessage() {
        Terminal.out.println("Lightning Parser for Microsoft Windows [Version 3.4.12-15-2021]");
        Terminal.out.println("(c) Jumping Jacks Incorporated. All rights reserved.");
        Terminal.out.println();
    }

    public static void start() {
        ioEngine.running = true;

        terminal.setKeyListener(eventHandler);
        launchMessage();
    }

    public static void main(String[] args) {
        start();
    }
}
