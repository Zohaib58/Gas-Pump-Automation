package strategy.impl;

import data.DataStore;
import strategy.EnterPinMsg;

public class EnterPinMsg2 implements EnterPinMsg {
    @Override
    public void enterPinMsg(DataStore data) {
        System.out.println("Please Enter PIN:");
    }
}
