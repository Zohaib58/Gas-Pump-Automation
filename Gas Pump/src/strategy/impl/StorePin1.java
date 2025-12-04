package strategy.impl;

import data.DataStore;
import strategy.StorePin;

public class StorePin1 implements StorePin {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Store PIN' algorithm for GasPump1 */
    @Override
    public void storePin(DataStore data) {
        // GP1 has no PIN
    }
}
