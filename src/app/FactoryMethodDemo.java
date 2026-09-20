package app;

import factorymethod.AcousticGuitarMaker;
import factorymethod.BassGuitarMaker;
import factorymethod.ElectricGuitarMaker;
import factorymethod.Guitar;
import factorymethod.GuitarMaker;

/** Demonstrates Part A. The loop works only with the abstract GuitarMaker and Guitar types. */
public final class FactoryMethodDemo {

    private FactoryMethodDemo() {
    }

    public static void run() {
        System.out.println("=== PART A: FACTORY METHOD ===");

        GuitarMaker[] makers = {
            new AcousticGuitarMaker(),
            new ElectricGuitarMaker(),
            new BassGuitarMaker()
        };
        String[] models = {"Dreadnought D-100", "Stratosphere S-1", "Thunder T-4"};

        for (int i = 0; i < makers.length; i++) {
            Guitar guitar = makers[i].orderGuitar(models[i]);
            System.out.println(guitar.play());
            System.out.println(makers[i].issueReceipt(models[i]));
        }
        demonstrateValidation();
        System.out.println();
    }

    private static void demonstrateValidation() {
        try {
            new AcousticGuitarMaker().orderGuitar("  ");
        } catch (IllegalArgumentException exception) {
            System.out.println("Invalid order rejected: " + exception.getMessage());
        }
    }
}
