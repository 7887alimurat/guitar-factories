package abstractfactory;

import factorymethod.Guitar;

/** CONCRETE PRODUCT - Modern family case. */
public class ModernGuitarCase implements GuitarCase {

    private static final String NAME = "Carbon-Fiber Flight Case";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String pack(Guitar guitar) {
        return guitar.getModelName() + " is packed into a " + NAME + " with shock-absorbing foam";
    }
}
