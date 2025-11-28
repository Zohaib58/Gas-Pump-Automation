package strategy.impl;

import data.DataStore;
import data.impl.DS1;
import strategy.SetPrice;

public class SetPrice1 implements SetPrice {
    @Override
    public void setPrice(int g, DataStore data) {
        DS1 d = (DS1) data;
        d.setPrice(d.getTemp_a());
        System.out.println("Price Set: " + d.getPrice());
    }
}
