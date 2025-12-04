package strategy;

import data.DataStore;

public interface SetInitialValues {
    /* DESIGN PATTERN: Strategy - Strategy Interface */
    /*
     * Responsibilities: Defines the interface for the 'Set Initial Values'
     * algorithm
     */
    void setInitialValues(DataStore data);
}
