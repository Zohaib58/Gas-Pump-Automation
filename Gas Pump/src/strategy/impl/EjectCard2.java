package strategy.impl;

import data.DataStore;
import strategy.EjectCard;

public class EjectCard2 implements EjectCard {
    @Override
    public void ejectCard(DataStore data) {
        System.out.println("Card Ejected");
    }
}
