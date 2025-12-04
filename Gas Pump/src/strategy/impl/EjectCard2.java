package strategy.impl;

import data.DataStore;
import strategy.EjectCard;

public class EjectCard2 implements EjectCard {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Eject Card' algorithm for GasPump2 */
    @Override
    public void ejectCard(DataStore data) {
        System.out.println("Card Ejected");
    }
}
