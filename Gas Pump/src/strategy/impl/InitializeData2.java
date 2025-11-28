package strategy.impl;

import data.DataStore;
import data.impl.DS2;
import strategy.InitializeData;

public class InitializeData2 implements InitializeData {
    @Override
    public void initializeData(DataStore data) {
        DS2 d = (DS2) data;
        d.setPrice(0);
        System.out.println("Data Initialized (Price=0)");
    }
}
