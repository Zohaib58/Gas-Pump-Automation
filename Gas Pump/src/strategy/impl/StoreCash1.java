package strategy.impl;

import data.DataStore;
import data.impl.DS1;
import strategy.StoreCash;

public class StoreCash1 implements StoreCash {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Store Cash' algorithm for GasPump1 */
    @Override
    public void storeCash(DataStore data) {
        DS1 d = (DS1) data;
        d.setCash(d.getTemp_c()); // Diagram: PayCash(c) -> temp_c=c; StoreCash -> cash=temp_c
        System.out.println("Cash Stored: " + d.getCash());
    }
}
