package strategy.impl;

import strategy.RejectMsg;

public class RejectMsg1 implements RejectMsg {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Reject Message' algorithm for GasPump1 */
    @Override
    public void rejectMsg() {
        System.out.println("Credit Card Rejected");
    }
}
