package abstractfactory;

import factorymethod.Guitar;

/**
 * ABSTRACT FACTORY - one creation method per product type in the family.
 * Every implementation must return products that belong to the SAME style.
 */
public interface GuitarFamilyFactory {

    Guitar createGuitar();

    Amplifier createAmplifier();

    GuitarCase createGuitarCase();
}
