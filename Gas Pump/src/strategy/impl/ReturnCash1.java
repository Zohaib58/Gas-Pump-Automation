package strategy.impl;

import data.DataStore;
import data.impl.DS1;
import strategy.ReturnCash;

public class ReturnCash1 implements ReturnCash {
    @Override
    public void returnCash(DataStore data) {
        DS1 d = (DS1) data;
        float refund = d.getCash() - d.getTotal();
        if (refund < 0) refund = 0; // Should not happen if logic is correct
        System.out.println("Returning Cash: $" + refund);
        d.setCash(0); // Reset cash after return
    }
}
