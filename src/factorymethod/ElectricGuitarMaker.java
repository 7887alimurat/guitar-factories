package factorymethod;

/** CONCRETE CREATOR #2 - produces electric guitars. */
public class ElectricGuitarMaker extends GuitarMaker {

    @Override
    protected Guitar createGuitar(String modelName) {
        return new ElectricGuitar(modelName);
    }
}
