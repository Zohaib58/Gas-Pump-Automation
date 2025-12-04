package strategy.impl;

import strategy.PayMsg;

public class PayMsg1 implements PayMsg {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Pay Message' algorithm for GasPump1 */
    @Override
    public void payMsg() {
        System.out.println("Select Payment Method:");
        System.out.println("1. Credit");
        System.out.println("2. Cash");
    }
}
