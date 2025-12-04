package strategy.impl;

import strategy.DisplayMenu;

public class DisplayMenu2 implements DisplayMenu {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Display Menu' algorithm for GasPump2 */
    @Override
    public void displayMenu() {
        System.out.println("Select Fuel Grade:");
        System.out.println("1. Regular");
        System.out.println("2. Diesel");
    }
}
