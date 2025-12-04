package strategy.impl;

import strategy.RejectMsg;

public class RejectMsg2 implements RejectMsg {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Reject Message' algorithm for GasPump2 */
    @Override
    public void rejectMsg() {
        System.out.println("Credit Card Rejected");
    }
}
