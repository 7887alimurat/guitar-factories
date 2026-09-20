package abstractfactory;

import factorymethod.Guitar;

/** ABSTRACT PRODUCT #2 - amplifier that boosts a guitar's signal. (Guitar is abstract product #1.) */
public interface Amplifier {

    String getName();

    int getPowerWatts();

    String amplify(Guitar guitar);
}
