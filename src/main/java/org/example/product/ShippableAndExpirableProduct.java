package org.example.product;

import java.time.LocalDate;

public class ShippableAndExpirableProduct extends ExpirableProduct implements Shippable {
    double weight;
    public ShippableAndExpirableProduct() {

    }

    public ShippableAndExpirableProduct(String name, int price, int quantity, LocalDate expiryDate,double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;

    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
