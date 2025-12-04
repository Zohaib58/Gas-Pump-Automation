package strategy.impl;

import data.DataStore;
import strategy.SetW;

public class SetW2 implements SetW {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Set W' algorithm for GasPump2 */
    @Override
    public void setW(int w, DataStore data) {
        // GP2 does not use w flag
    }
}
