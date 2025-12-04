package strategy.impl;

import data.DataStore;
import data.impl.DS2;
import strategy.SetInitialValues;

public class SetInitialValues2 implements SetInitialValues {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /*
     * Responsibilities: Implements the 'Set Initial Values' algorithm for GasPump2
     */
    @Override
    public void setInitialValues(DataStore data) {
        DS2 d = (DS2) data;
        d.setG(0);
        d.setTotal(0);
        System.out.println("Initial Values Set (G=0, Total=0)");
    }
}
