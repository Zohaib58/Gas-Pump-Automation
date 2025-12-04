package strategy.impl;

import data.DataStore;
import data.impl.DS1;
import strategy.PrintReceipt;

public class PrintReceipt1 implements PrintReceipt {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Print Receipt' algorithm for GasPump1 */
    @Override
    public void printReceipt(DataStore data) {
        DS1 d = (DS1) data;
        System.out.println("RECEIPT:");
        System.out.println("Liters: " + d.getL());
        System.out.println("Total: $" + d.getTotal());
    }
}
