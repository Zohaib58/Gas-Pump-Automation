package strategy.impl;

import data.DataStore;
import data.impl.DS1;
import strategy.StorePrices;

public class StorePrices1 implements StorePrices {
    @Override
    public void storePrices(DataStore data) {
        DS1 d = (DS1) data;
        d.setPrice(d.getTemp_a());
        System.out.println("Price Stored: " + d.getPrice());
    }
}
