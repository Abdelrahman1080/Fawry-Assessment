package org.example.product;

import java.time.LocalDate;

public class ExpirableProduct extends Product {
    LocalDate expiryDate;
    public ExpirableProduct() {}

    public ExpirableProduct(String name, int price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }
}
