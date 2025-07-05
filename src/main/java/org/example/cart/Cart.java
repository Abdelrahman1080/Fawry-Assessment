package org.example.cart;

import org.example.product.Product;

import java.util.HashMap;
import java.util.Map;

public class Cart {

    Map<Product, Integer> items = new HashMap<>();

    public Cart() {}
   public void addProduct(Product product, int quantity) {

        if (product.getQuantity()< quantity+items.getOrDefault(product,0)) {
            throw new IllegalArgumentException("The amount of " + product.getName()+"is less than " + quantity);
        }

        items.put(product, items.getOrDefault(product, 0) + quantity);

    }
    public boolean isEmpty(){
        return items.isEmpty();
    }

    public  Map<Product, Integer> getItems() {
        return items;
    }
}
