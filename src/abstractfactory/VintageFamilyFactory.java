package abstractfactory;

import factorymethod.Guitar;

/** CONCRETE FACTORY #1 - creates a complete, consistent Vintage kit. */
public class VintageFamilyFactory implements GuitarFamilyFactory {

    @Override
    public Guitar createGuitar() {
        return new VintageGuitar();
    }

    @Override
    public Amplifier createAmplifier() {
        return new VintageAmplifier();
    }

    @Override
    public GuitarCase createGuitarCase() {
        return new VintageGuitarCase();
    }
}
