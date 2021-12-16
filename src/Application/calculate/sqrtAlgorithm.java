package Application.calculate;

import Application.control.Terminal;

public class sqrtAlgorithm {

    @SuppressWarnings("SpellCheckingInspection")
    private static final int AVGDIV = 2;
    private static boolean running = true;

    @SuppressWarnings("SameParameterValue")
    private static double sqrtAlg(double x, double y, final double INIT) {
        int limiter = 0;
        int checkX;
        int checkY;

        while (running) {
            limiter++;

            y = (x + y) / AVGDIV; // gets the average of the 2 numbers
            x = INIT / y; // sets x for the next run

            checkX = (int)(x * 100000);
            checkY = (int)(y * 100000);

            if (checkX == checkY) {
                running = false;
            } else if (limiter == 500) {
                running = false;
                Terminal.out.println("looping limit exceeded, returning to menu...");
            }

        }

        return x;
    }

    public static double calcSqrt(double toCalc) {
        return sqrtAlg(toCalc, 1, toCalc);
    }
}
