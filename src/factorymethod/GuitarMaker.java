package factorymethod;

/**
 * CREATOR (Factory Method) - declares the factory method createGuitar()
 * and uses it in business logic WITHOUT knowing the concrete guitar class.
 */
public abstract class GuitarMaker {

    /** THE FACTORY METHOD: subclasses decide which concrete Guitar to instantiate. */
    protected abstract Guitar createGuitar(String modelName);

    public Guitar orderGuitar(String modelName) {
        return createGuitar(modelName);
    }

    public String issueReceipt(String modelName) {
        Guitar guitar = orderGuitar(modelName);
        return "Receipt: " + guitar.describe();
    }
}
