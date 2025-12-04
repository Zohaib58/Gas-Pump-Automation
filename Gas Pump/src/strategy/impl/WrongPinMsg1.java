package strategy.impl;

import strategy.WrongPinMsg;

public class WrongPinMsg1 implements WrongPinMsg {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /*
     * Responsibilities: Implements the 'Wrong PIN Message' algorithm for GasPump1
     */
    @Override
    public void wrongPinMsg() {
        // GP1 has no PIN
    }
}
