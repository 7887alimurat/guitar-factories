package abstractfactory;

import factorymethod.Guitar;

/** CONCRETE PRODUCT - Vintage family case. */
public class VintageGuitarCase implements GuitarCase {

    private static final String NAME = "Tweed Hard Case";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String pack(Guitar guitar) {
        return guitar.getModelName() + " is packed into a " + NAME + " with velvet lining";
    }
}
