package strategy.impl;

import strategy.RejectMsg;

public class RejectMsg1 implements RejectMsg {
    @Override
    public void rejectMsg() {
        System.out.println("Credit Card Rejected");
    }
}
