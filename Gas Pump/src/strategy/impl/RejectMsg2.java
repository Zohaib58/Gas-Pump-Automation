package strategy.impl;

import strategy.RejectMsg;

public class RejectMsg2 implements RejectMsg {
    @Override
    public void rejectMsg() {
        System.out.println("Credit Card Rejected");
    }
}
