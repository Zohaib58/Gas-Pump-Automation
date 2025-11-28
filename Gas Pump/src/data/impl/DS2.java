package data.impl;
import data.DataStore;

/**
 * DataStore for GasPump-2 (DS2)
 */
public class DS2 extends DataStore {
    public float temp_a;
    public float temp_b;
    public float temp_c;
    public float cash;
    public float price;
    public int L; // GasPump-2 might use int for L or G based on diagram, assuming float/int
                  // consistency
    public float total;
    public int G; // Gallons
    public String pin; // For Debit card

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getL() {
        return L;
    }

    public void setL(int L) {
        this.L = L;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public int getG() {
        return G;
    }

    public void setG(int G) {
        this.G = G;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
