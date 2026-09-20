package abstractfactory;

import factorymethod.Guitar;

/** CONCRETE FACTORY #2 - creates a complete, consistent Modern kit. */
public class ModernFamilyFactory implements GuitarFamilyFactory {

    @Override
    public Guitar createGuitar() {
        return new ModernGuitar();
    }

    @Override
    public Amplifier createAmplifier() {
        return new ModernAmplifier();
    }

    @Override
    public GuitarCase createGuitarCase() {
        return new ModernGuitarCase();
    }
}
