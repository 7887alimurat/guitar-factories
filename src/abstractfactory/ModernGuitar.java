package abstractfactory;

import factorymethod.Guitar;

/** CONCRETE PRODUCT - Modern family guitar. */
public class ModernGuitar implements Guitar {

    private static final String MODEL_NAME = "Nova X7";
    private static final int STRING_COUNT = 7;
    private static final String SOUND = "tight, high-gain tone with extended low range";

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
