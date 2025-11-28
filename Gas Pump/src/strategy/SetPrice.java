package strategy;

import data.DataStore;

public interface SetPrice {
    void setPrice(int g, DataStore data); // g is the gas grade index (1, 2, 3...)
}
