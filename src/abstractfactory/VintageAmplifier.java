package abstractfactory;

import factorymethod.Guitar;

/** CONCRETE PRODUCT - Vintage family amplifier (tube technology). */
public class VintageAmplifier implements Amplifier {

    private static final String NAME = "Tube Amp Classic";
    private static final int POWER_WATTS = 30;

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public int getPowerWatts() {
        return POWER_WATTS;
    }

    @Override
    public String amplify(Guitar guitar) {
        return NAME + " (" + POWER_WATTS + "W) adds warm tube saturation to " + guitar.getModelName();
    }
}
