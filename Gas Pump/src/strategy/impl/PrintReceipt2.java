package strategy.impl;

import data.DataStore;
import data.impl.DS2;
import strategy.PrintReceipt;

public class PrintReceipt2 implements PrintReceipt {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Print Receipt' algorithm for GasPump2 */
    @Override
    public void printReceipt(DataStore data) {
        DS2 d = (DS2) data;
        System.out.println("RECEIPT:");
        System.out.println("Gallons: " + d.getG());
        System.out.println("Total: $" + d.getTotal());
    }
}
