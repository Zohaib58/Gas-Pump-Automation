package strategy.impl;

import data.DataStore;
import strategy.ReturnCash;

public class ReturnCash2 implements ReturnCash {
    @Override
    public void returnCash(DataStore data) {
        // GP2 is Debit, so no cash to return usually.
        System.out.println("No cash to return (Debit transaction).");
    }
}
