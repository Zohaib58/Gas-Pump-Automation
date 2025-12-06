package data.impl;

import data.DataStore;

public class DS2 extends DataStore {
    public int temp_a; // Regular Price
    public int temp_b;
    public int temp_p; // Temp PIN
    public int pin; // Stored PIN
    public int price; // Current Price
    public int G; // Gallons
    public int total; // Total Cost
    public int Rprice; // Regular Price Storage
    public int Dprice; // Diesel Price Storage

    // Getters and Setters
    public int getTemp_a() {
        return temp_a;
    }

    public void setTemp_a(int temp_a) {
        this.temp_a = temp_a;
    }

    public int getTemp_b() {
        return temp_b;
    }

    public void setTemp_b(int temp_b) {
        this.temp_b = temp_b;
    }

    public int getTemp_p() {
        return temp_p;
    }

    public void setTemp_p(int temp_p) {
        this.temp_p = temp_p;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getG() {
        return G;
    }

    public void setG(int G) {
        this.G = G;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getRprice() {
        return Rprice;
    }

    public void setRprice(int Rprice) {
        this.Rprice = Rprice;
    }

    public int getDprice() {
        return Dprice;
    }

    public void setDprice(int Dprice) {
        this.Dprice = Dprice;
    }
}
