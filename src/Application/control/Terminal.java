package Application.control;

public class Terminal {

    public static Out out = new Out(Controller.terminal.outputScreen);
    public static Error err = new Error(Controller.terminal.outputScreen);

    private static int activeCycle = 0;

    public static void setActiveCycle(int toActive) {
        activeCycle = toActive;
    }

    public static int getActiveCycle() {
        return activeCycle;
    }
}
