package abstractfactory;

import factorymethod.Guitar;

/** CONCRETE PRODUCT - Vintage family guitar. */
public class VintageGuitar implements Guitar {

    private static final String MODEL_NAME = "Vintage Twang 1962";
    private static final int STRING_COUNT = 6;
    private static final String SOUND = "clean, twangy tone with a classic 60s feel";

    @Override
    public String getModelName() {
        return MODEL_NAME;
    }

    @Override
    public int getStringCount() {
        return STRING_COUNT;
    }

    @Override
    public String play() {
        return describe() + " plays: " + SOUND;
    }
}
