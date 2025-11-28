package strategy.impl;

import data.DataStore;
import data.impl.DS1;
import strategy.SetInitialValues;

public class SetInitialValues1 implements SetInitialValues {
    @Override
    public void setInitialValues(DataStore data) {
        DS1 d = (DS1) data;
        d.setL(0); // L is int in DS1
        d.setTotal(0.0f); // Total is float in DS1
        System.out.println("Initial Values Set (L=0, Total=0.0)");
    }
}
