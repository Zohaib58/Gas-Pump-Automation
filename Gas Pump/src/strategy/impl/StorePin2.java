package strategy.impl;

import data.DataStore;
import data.impl.DS2;
import strategy.StorePin;

public class StorePin2 implements StorePin {
    @Override
    public void storePin(DataStore data) {
        DS2 d = (DS2) data;
        d.setPin(d.getTemp_p());
        System.out.println("PIN Stored");
    }
}
