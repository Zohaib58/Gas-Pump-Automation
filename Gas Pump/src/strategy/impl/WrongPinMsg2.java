package strategy.impl;

import strategy.WrongPinMsg;

public class WrongPinMsg2 implements WrongPinMsg {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /*
     * Responsibilities: Implements the 'Wrong PIN Message' algorithm for GasPump2
     */
    @Override
    public void wrongPinMsg() {
        System.out.println("WRONG PIN");
    }
}
