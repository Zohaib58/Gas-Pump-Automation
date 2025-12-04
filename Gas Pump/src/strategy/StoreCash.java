package strategy;

import data.DataStore;

public interface StoreCash {
    /* DESIGN PATTERN: Strategy - Strategy Interface */
    /* Responsibilities: Defines the interface for the 'Store Cash' algorithm */
    void storeCash(DataStore data);
}
