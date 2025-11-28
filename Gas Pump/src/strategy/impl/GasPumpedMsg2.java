package strategy.impl;

import data.DataStore;
import data.impl.DS2;
import strategy.GasPumpedMsg;

public class GasPumpedMsg2 implements GasPumpedMsg {
    @Override
    public void gasPumpedMsg(DataStore data) {
        DS2 d = (DS2) data;
        System.out.println("Amount Pumped: " + d.getG() + " Gallons");
    }
}
