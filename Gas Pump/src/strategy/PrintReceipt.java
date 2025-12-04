package strategy;

import data.DataStore;

public interface PrintReceipt {
    /* DESIGN PATTERN: Strategy - Strategy Interface */
    /* Responsibilities: Defines the interface for the 'Print Receipt' algorithm */
    void printReceipt(DataStore data);
}
