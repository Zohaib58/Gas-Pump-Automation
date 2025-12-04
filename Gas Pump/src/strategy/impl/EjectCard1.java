package strategy.impl;

import data.DataStore;
import strategy.EjectCard;

public class EjectCard1 implements EjectCard {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Eject Card' algorithm for GasPump1 */
    @Override
    public void ejectCard(DataStore data) {
        // GP1 has no card
    }
}
