package org.example.checkout;

import org.example.cart.Cart;
import org.example.customer.Customer;
import org.example.product.ExpirableProduct;
import org.example.product.Product;
import org.example.product.ShippableAndExpirableProduct;
import org.example.product.ShippableProduct;
import org.example.services.Shippable;
import org.example.services.ShippingServiceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Checkout {
    public static void checkout(Customer customer, Cart thecart) {
        if(thecart.isEmpty())
            throw new IllegalStateException("There's nothing to checkout");
        double subPrice = 0;
        double totalPrice = 0;
        double shippingPrice = 0;
        Map<Shippable,Integer> toShip = new HashMap<>();

        for(Map.Entry<Product, Integer> entry : thecart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double price = product.getPrice();
            if(product.getQuantity() < quantity) {
                throw new IllegalStateException("The product is out of stock ");
            }
            else
                product.setQuantity(product.getQuantity() - quantity);
            if(product instanceof ExpirableProduct || product instanceof ShippableAndExpirableProduct) {
                if(((ExpirableProduct) product).isExpired())
                    throw new IllegalStateException("Product "+product.getName()+" is expired");
            }
            if(product instanceof ShippableProduct || product instanceof ShippableAndExpirableProduct)
            {
                toShip.put((Shippable) product,quantity);
            }
            subPrice += quantity * price;

        }

            shippingPrice += ShippingServiceImpl.getTotalShippingCost(toShip);
        totalPrice = shippingPrice+subPrice;
        if(customer.getBalance() < totalPrice)
            throw new IllegalStateException("Purchase cannot be done Customer balance is less than total price");

        System.out.println("Purchase successful");
        ShippingServiceImpl.printShipping(toShip);

        for(Map.Entry<Product, Integer> entry : thecart.getItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            double price = product.getPrice();

            System.out.println("Product "+product.getName()+" has "+quantity+" items" + " with price "+price);

        }

        System.out.println("Shipping price is "+shippingPrice);
        System.out.println("Sub price is "+subPrice);
        System.out.println("Total price is "+totalPrice);


    }

}
