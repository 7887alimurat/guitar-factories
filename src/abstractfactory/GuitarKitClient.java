package abstractfactory;

import factorymethod.Guitar;
import validation.Validation;

/**
 * CLIENT - talks ONLY to GuitarFamilyFactory, Guitar, Amplifier and GuitarCase.
 * It never uses "new" with a concrete class, so a new family can be added without changing this code.
 */
public class GuitarKitClient {

    private final GuitarFamilyFactory factory;

    public GuitarKitClient(GuitarFamilyFactory factory) {
        this.factory = Validation.requireNonNull(factory, "factory");
    }

    public String assembleKit() {
        Guitar guitar = factory.createGuitar();
        Amplifier amplifier = factory.createAmplifier();
        GuitarCase guitarCase = factory.createGuitarCase();

        return String.join(System.lineSeparator(),
                guitar.play(),
                amplifier.amplify(guitar),
                guitarCase.pack(guitar));
    }
}
