package strategy.impl;

import data.DataStore;
import data.impl.DS2;
import strategy.StorePrices;

public class StorePrices2 implements StorePrices {
    @Override
    public void storePrices(DataStore data) {
        DS2 d = (DS2) data;
        d.setRprice(d.getTemp_a());
        d.setDprice(d.getTemp_b());
        System.out.println("Prices Stored: Regular=" + d.getRprice() + ", Diesel=" + d.getDprice());
    }
}
