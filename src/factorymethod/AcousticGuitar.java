package factorymethod;

import validation.Validation;

/** CONCRETE PRODUCT #1 - hollow-body guitar without electronics. */
public class AcousticGuitar implements Guitar {

    private static final int STRING_COUNT = 6;
    private static final String SOUND = "warm natural resonance from the hollow wooden body";

    private final String modelName;

    public AcousticGuitar(String modelName) {
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
