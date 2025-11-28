package data.impl;

import data.DataStore;

public class DS1 extends DataStore {
    public float temp_c; // Cash inserted
    public float cash; // Cash stored
    public float total;
    public int L;
    public float price;
    public float temp_a; // Price from Activate? Or temp cash? Diagram says temp_a is float.
    public int w; // Flag

    // Getters and Setters
    public float getTemp_c() {
        return temp_c;
    }

    public void setTemp_c(float temp_c) {
        this.temp_c = temp_c;
    }

    public float getCash() {
        return cash;
    }

    public void setCash(float cash) {
        this.cash = cash;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getL() {
        return L;
    }

    public void setL(int L) {
        this.L = L;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getTemp_a() {
        return temp_a;
    }

    public void setTemp_a(float temp_a) {
        this.temp_a = temp_a;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }
}
