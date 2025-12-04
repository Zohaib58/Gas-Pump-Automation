package strategy.impl;

import data.DataStore;
import strategy.EnterPinMsg;

public class EnterPinMsg1 implements EnterPinMsg {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /*
     * Responsibilities: Implements the 'Enter PIN Message' algorithm for GasPump1
     */
    @Override
    public void enterPinMsg(DataStore data) {
        // GP1 has no PIN
    }
}
