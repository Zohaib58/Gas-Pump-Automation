package data.impl;
import data.DataStore;

/**
 * DataStore for GasPump-1 (DS1)
 */
public class DS1 extends DataStore {
    public float temp_a;
    public float temp_b; // Added based on typical usage (e.g. total calculation)
    public int w;
    public float price;
    public float L;
    public float total;

    // Getters and Setters
    public float getTemp_a() {
        return temp_a;
    }

    public void setTemp_a(float temp_a) {
        this.temp_a = temp_a;
    }

    public float getTemp_b() {
        return temp_b;
    }

    public void setTemp_b(float temp_b) {
        this.temp_b = temp_b;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getL() {
        return L;
    }

    public void setL(float L) {
        this.L = L;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
