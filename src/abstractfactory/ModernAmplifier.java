package abstractfactory;

import factorymethod.Guitar;

/** CONCRETE PRODUCT - Modern family amplifier (digital modeling). */
public class ModernAmplifier implements Amplifier {

    private static final String NAME = "Digital Modeling Amp";
    private static final int POWER_WATTS = 100;

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
        return NAME + " (" + POWER_WATTS + "W) shapes the sound of " + guitar.getModelName() + " with digital presets";
    }
}
