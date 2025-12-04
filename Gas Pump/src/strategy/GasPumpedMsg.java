package strategy;

import data.DataStore;

public interface GasPumpedMsg {
    /* DESIGN PATTERN: Strategy - Strategy Interface */
    /*
     * Responsibilities: Defines the interface for the 'Gas Pumped Message'
     * algorithm
     */
    void gasPumpedMsg(DataStore data);
}
