package strategy;

import data.DataStore;

/*
 * Strategy Interface for PayMsg
 */
public interface PayMsg {
    /* DESIGN PATTERN: Strategy - Strategy Interface */
    /* Responsibilities: Defines the interface for the 'Pay Message' algorithm */
    void payMsg();
}
