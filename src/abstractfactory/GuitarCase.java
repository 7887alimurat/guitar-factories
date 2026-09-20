package abstractfactory;

import factorymethod.Guitar;

/** ABSTRACT PRODUCT #3 - case used to store and transport a guitar. */
public interface GuitarCase {

    String getName();

    String pack(Guitar guitar);
}
