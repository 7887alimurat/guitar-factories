package factorymethod;

import validation.Validation;

/** CONCRETE PRODUCT #3 - low-pitched four-string guitar (shows how easy it is to add a new product). */
public class BassGuitar implements Guitar {

    private static final int STRING_COUNT = 4;
    private static final String SOUND = "deep low-end groove that holds the rhythm together";

    private final String modelName;

    public BassGuitar(String modelName) {
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
