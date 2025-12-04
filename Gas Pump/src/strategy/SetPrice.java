package strategy;

import data.DataStore;

public interface SetPrice {
    /* DESIGN PATTERN: Strategy - Strategy Interface */
    /* Responsibilities: Defines the interface for the 'Set Price' algorithm */
    void setPrice(int g, DataStore data); // g is the gas grade index (1, 2, 3...)
}
