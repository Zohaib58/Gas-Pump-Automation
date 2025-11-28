package strategy.impl;

import strategy.WrongPinMsg;

public class WrongPinMsg2 implements WrongPinMsg {
    @Override
    public void wrongPinMsg() {
        System.out.println("WRONG PIN");
    }
}
