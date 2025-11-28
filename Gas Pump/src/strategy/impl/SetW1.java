package strategy.impl;

import data.DataStore;
import data.impl.DS1;
import strategy.SetW;

public class SetW1 implements SetW {
    @Override
    public void setW(int w, DataStore data) {
        DS1 d = (DS1) data;
        d.setW(w);
        System.out.println("Cash Flag (w) set to: " + w);
    }
}
