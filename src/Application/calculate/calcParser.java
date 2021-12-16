package Application.calculate;

import Application.control.IOEngine;
import Application.control.Terminal;

public class calcParser {

    private static final IOEngine stringMethods = new IOEngine();

    private static double x;
    private static double y;
    @SuppressWarnings("All") private static double z;

    private static void parseChain(String chain) {
        x = Double.parseDouble(stringMethods.getUntilFirst(':', chain));

        String remove = stringMethods.getUntilFirst(':', chain);
        remove += ':';
        String getYFrom = chain.replaceFirst(remove, "");

        y = Double.parseDouble(stringMethods.getUntilSecond(':', getYFrom));

        remove = stringMethods.getUntilFirst(':', getYFrom);
        remove += ':';
        String getZFrom = getYFrom.replaceFirst(remove, "");

        z = Double.parseDouble(stringMethods.getUntilThird(':', getZFrom));
    }

    public static void parseInput(String chain, int type) {
        parseChain(chain);
        switch (type) {
            case 0 -> Terminal.out.println(sqrtAlgorithm.calcSqrt(x));
            case 1 -> Terminal.out.println(Basic.add(x, y));
            case 2 -> Terminal.out.println(Basic.subtract(x, y));
            default -> Terminal.out.println("Not a valid command");
        }
    }
}
