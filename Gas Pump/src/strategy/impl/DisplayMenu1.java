package strategy.impl;

import strategy.DisplayMenu;

public class DisplayMenu1 implements DisplayMenu {
    @Override
    public void displayMenu() {
        // GasPump-1 has no menu (only Regular gas)
        // But the state machine might call it.
        System.out.println("Enjoy your Regular Gas.");
    }
}
