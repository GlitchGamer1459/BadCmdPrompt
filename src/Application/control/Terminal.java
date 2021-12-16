package Application.control;

public class Terminal {

    public static Out out = new Out(Controller.terminal.outputScreen);
    public static Error err = new Error(Controller.terminal.outputScreen);
}
