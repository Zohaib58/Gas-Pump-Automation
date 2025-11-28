package strategy.impl;

import strategy.PayMsg;

public class PayMsg2 implements PayMsg {
    @Override
    public void payMsg() {
        System.out.println("Select Payment Method:");
        System.out.println("1. Credit");
        System.out.println("2. Debit");
    }
}
