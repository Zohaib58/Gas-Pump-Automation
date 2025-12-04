package strategy;

import data.DataStore;

public interface EjectCard {
    /* DESIGN PATTERN: Strategy - Strategy Interface */
    /* Responsibilities: Defines the interface for the 'Eject Card' algorithm */
    void ejectCard(DataStore data);
}
