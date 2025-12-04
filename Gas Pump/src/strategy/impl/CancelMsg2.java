package strategy.impl;

import strategy.CancelMsg;

public class CancelMsg2 implements CancelMsg {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Cancel Message' algorithm for GasPump2 */
    @Override
    public void cancelMsg() {
        System.out.println("Transaction Cancelled");
    }
}
