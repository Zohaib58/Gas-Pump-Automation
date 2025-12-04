package strategy;

import data.DataStore;

public interface EnterPinMsg {
    /* DESIGN PATTERN: Strategy - Strategy Interface */
    /*
     * Responsibilities: Defines the interface for the 'Enter PIN Message' algorithm
     */
    void enterPinMsg(DataStore data);
}
