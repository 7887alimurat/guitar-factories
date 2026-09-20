package app;

import abstractfactory.GuitarFamilyFactory;
import abstractfactory.GuitarKitClient;
import abstractfactory.ModernFamilyFactory;
import abstractfactory.VintageFamilyFactory;

/** Demonstrates Part B. Concrete factories are chosen here, the client never sees them. */
public final class AbstractFactoryDemo {

    private AbstractFactoryDemo() {
    }

    public static void run() {
        System.out.println("=== PART B: ABSTRACT FACTORY ===");
        printKit("Vintage kit", new VintageFamilyFactory());
        printKit("Modern kit", new ModernFamilyFactory());
    }

    private static void printKit(String title, GuitarFamilyFactory factory) {
        System.out.println("--- " + title + " ---");
        System.out.println(new GuitarKitClient(factory).assembleKit());
        System.out.println();
    }
}
