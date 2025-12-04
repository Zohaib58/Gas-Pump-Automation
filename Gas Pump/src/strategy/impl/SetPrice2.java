package strategy.impl;

import data.DataStore;
import data.impl.DS2;
import strategy.SetPrice;

public class SetPrice2 implements SetPrice {
    /* DESIGN PATTERN: Strategy - Concrete Strategy */
    /* Responsibilities: Implements the 'Set Price' algorithm for GasPump2 */
    @Override
    public void setPrice(int g, DataStore data) {
        DS2 d = (DS2) data;
        if (g == 1) {
            d.setPrice(d.getRprice()); // Regular
        } else if (g == 2) {
            d.setPrice(d.getDprice()); // Diesel
        }
        System.out.println("Price Set: " + d.getPrice());
    }
}
