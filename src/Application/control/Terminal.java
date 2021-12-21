package Application.control;

public class Terminal {

    private static final Controller controller = new Controller();
    public static final Out out = new Out(controller.terminal.outputScreen);
    public static final Error err = new Error(controller.terminal.outputScreen);

    private static int activeCycle = 0;

    public static void setActiveCycle(int toActive) {
        activeCycle = toActive;
    }

    public static int getActiveCycle() {
        return activeCycle;
    }
}
