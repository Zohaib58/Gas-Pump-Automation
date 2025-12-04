package strategy.impl;

import data.DataStore;
import data.impl.DS2;
import strategy.PumpGasUnit;

public class PumpGasUnit2 implements PumpGasUnit {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Pump Gas Unit' algorithm for GasPump2 */
    @Override
    public void pumpGasUnit(DataStore data) {
        DS2 d = (DS2) data;
        d.setG(d.getG() + 1);
        d.setTotal(d.getPrice() * d.getG());
    }
}
