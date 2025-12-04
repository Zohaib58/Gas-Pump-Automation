package strategy.impl;

import strategy.DisplayMenu;

public class DisplayMenu1 implements DisplayMenu {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Display Menu' algorithm for GasPump1 */
    @Override
    public void displayMenu() {
        // GasPump-1 has no menu (only Regular gas)
        // But the state machine might call it.
        System.out.println("Enjoy your Regular Gas.");
    }
}
