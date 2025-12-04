package strategy;

import data.DataStore;

public interface PumpGasUnit {
    /* DESIGN PATTERN: Strategy - Strategy Interface */
    /* Responsibilities: Defines the interface for the 'Pump Gas Unit' algorithm */
    void pumpGasUnit(DataStore data);
}
