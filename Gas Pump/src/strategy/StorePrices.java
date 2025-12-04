package strategy;

import data.DataStore;

public interface StorePrices {
    /* DESIGN PATTERN: Strategy - Strategy Interface */
    /* Responsibilities: Defines the interface for the 'Store Prices' algorithm */
    void storePrices(DataStore data);
}
