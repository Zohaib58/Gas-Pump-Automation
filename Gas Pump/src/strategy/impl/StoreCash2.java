package strategy.impl;

import data.DataStore;
import strategy.StoreCash;

public class StoreCash2 implements StoreCash {
    @Override
    public void storeCash(DataStore data) {
        // GasPump2 does not support cash payment, so this method is empty.
        // Or it could log an error if this state is reached unexpectedly.
    }
}
