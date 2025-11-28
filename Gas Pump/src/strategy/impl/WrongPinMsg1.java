package strategy.impl;

import strategy.WrongPinMsg;

public class WrongPinMsg1 implements WrongPinMsg {
    @Override
    public void wrongPinMsg() {
        // GP1 has no PIN
    }
}
