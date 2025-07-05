package org.example.product;

public class ShippableProduct extends Product implements Shippable {
    public ShippableProduct() {}
    double weight;

    public ShippableProduct(String name, int price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
