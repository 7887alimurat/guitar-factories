package factorymethod;

/** CONCRETE CREATOR #1 - produces acoustic guitars. */
public class AcousticGuitarMaker extends GuitarMaker {

    @Override
    protected Guitar createGuitar(String modelName) {
        return new AcousticGuitar(modelName);
    }
}
