package factorymethod;

import validation.Validation;

/** CONCRETE PRODUCT #2 - solid-body guitar that needs pickups and an amplifier. */
public class ElectricGuitar implements Guitar {

    private static final int STRING_COUNT = 6;
    private static final String SOUND = "bright amplified tone from magnetic pickups";

    private final String modelName;

    public ElectricGuitar(String modelName) {
        this.modelName = Validation.requireNonBlank(modelName, "modelName");
    }

    @Override
    public String getModelName() {
        return modelName;
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
