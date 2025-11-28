package strategy.impl;

import data.DataStore;
import data.impl.DS1;
import strategy.GasPumpedMsg;

public class GasPumpedMsg1 implements GasPumpedMsg {
    @Override
    public void gasPumpedMsg(DataStore data) {
        DS1 d = (DS1) data;
        System.out.println("Amount Pumped: " + d.getL() + " Liters");
    }
}
