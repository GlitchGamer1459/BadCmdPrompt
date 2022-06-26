package Application.calculate;

import Application.control.IOEngine;
import Application.control.Terminal;

public class CalcParser {

    private final Basic basicOps = new Basic();

    private double x;
    private double y;
    @SuppressWarnings("All") private double z;

    private void parseChain(String chain) {
        final IOEngine stringMethods = new IOEngine();
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

    public void parseInput(String chain, int type) {
        parseChain(chain);
        switch (type) {
            case 0 -> Terminal.out.println(sqrtAlgorithm.calcSqrt(x));
            case 1 -> Terminal.out.println(basicOps.add(x, y));
            case 2 -> Terminal.out.println(basicOps.subtract(x, y));
            default -> Terminal.out.println("Not a valid command");
        }
    }
}
