package strategy.impl;

import data.DataStore;
import data.impl.DS1;
import strategy.PumpGasUnit;

public class PumpGasUnit1 implements PumpGasUnit {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Pump Gas Unit' algorithm for GasPump1 */
    @Override
    public void pumpGasUnit(DataStore data) {
        DS1 d = (DS1) data;
        d.setL(d.getL() + 1);
        d.setTotal(d.getPrice() * d.getL());
        // Note: Diagram says "disposes unit of gas and counts # of units".
        // It doesn't explicitly say update total here, but usually it's needed for
        // display.
        // The StopPump/PrintReceipt uses total.
    }
}
