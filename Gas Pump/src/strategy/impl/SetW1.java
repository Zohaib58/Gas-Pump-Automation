package strategy.impl;

import data.DataStore;
import data.impl.DS1;
import strategy.SetW;

public class SetW1 implements SetW {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Set W' algorithm for GasPump1 */
    @Override
    public void setW(int w, DataStore data) {
        DS1 d = (DS1) data;
        d.setW(w);
        System.out.println("Cash Flag (w) set to: " + w);
    }
}
