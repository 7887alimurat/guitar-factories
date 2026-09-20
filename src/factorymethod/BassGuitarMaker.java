package factorymethod;

/** CONCRETE CREATOR #3 - produces bass guitars. */
public class BassGuitarMaker extends GuitarMaker {

    @Override
    protected Guitar createGuitar(String modelName) {
        return new BassGuitar(modelName);
    }
}
