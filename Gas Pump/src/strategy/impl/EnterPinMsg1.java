package strategy.impl;

import data.DataStore;
import strategy.EnterPinMsg;

public class EnterPinMsg1 implements EnterPinMsg {
    @Override
    public void enterPinMsg(DataStore data) {
        // GP1 has no PIN
    }
}
