package strategy.impl;

import data.DataStore;
import strategy.EnterPinMsg;

public class EnterPinMsg2 implements EnterPinMsg {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /*
     * Responsibilities: Implements the 'Enter PIN Message' algorithm for GasPump2
     */
    @Override
    public void enterPinMsg(DataStore data) {
        System.out.println("Please Enter PIN:");
    }
}
