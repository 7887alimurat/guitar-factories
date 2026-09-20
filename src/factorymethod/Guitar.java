package factorymethod;

/** PRODUCT (Factory Method) - the common contract for every guitar the factories can create. */
public interface Guitar {

    String getModelName();

    int getStringCount();

    /** What this guitar sounds like when played. */
    String play();

    default String describe() {
        return getModelName() + " (" + getStringCount() + " strings)";
    }
}
