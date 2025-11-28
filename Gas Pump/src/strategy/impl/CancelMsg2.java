package strategy.impl;

import strategy.CancelMsg;

public class CancelMsg2 implements CancelMsg {
    @Override
    public void cancelMsg() {
        System.out.println("Transaction Cancelled");
    }
}
