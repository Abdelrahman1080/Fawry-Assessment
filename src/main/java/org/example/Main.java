package org.example;

import org.example.cart.Cart;
import org.example.services.CheckoutService;
import org.example.customer.Customer;
import org.example.product.Product;
import org.example.product.ShippableAndExpirableProduct;
import org.example.product.ShippableProduct;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        //Test Cases PLEASE TRY EACH CASE SEPERATELY (COMMENT THE OTHERS)

        //Normal Usage without errors
        Product cheese = new ShippableAndExpirableProduct("Cheese", 100, 10, LocalDate.of(3025, 12, 31),1 );
        Product biscuits = new ShippableAndExpirableProduct("Biscuits", 150, 5,LocalDate.of(2025, 12, 31) ,2 );
        Product tv = new ShippableProduct("TV", 300, 3, 3.0);
        Product scratchCard = new Product("Scratch Card", 50, 100);

        Customer Ahmed = new Customer("Ahmed", 1000);
        Cart cart = new Cart();

        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        cart.addProduct(scratchCard, 1);
        cart.addProduct(tv, 1);
        CheckoutService.checkout(Ahmed, cart);


        // When the balance is smaller than the totla prices
        Product Xbox = new ShippableProduct("Xbox", 3000, 3, 3.0);
        Customer Abdelrahman = new Customer("Abdelrahman", 1000);
        Cart cart2 = new Cart();
        cart2.addProduct(Xbox, 1);
        CheckoutService.checkout(Abdelrahman, cart2);



        // When the Cart is Empty
        Product product = new ShippableProduct("product", 3000, 3, 3.0);
        Customer Ali = new Customer("Ali", 1000);
        Cart cart3 = new Cart();
        CheckoutService.checkout(Ali, cart3);


        //When one product is expired
        Product Oldcheese = new ShippableAndExpirableProduct("Oldcheese", 100, 10, LocalDate.of(1025, 12, 31),1 );
        Customer Alaa = new Customer("Alaa", 1000);
        Cart cart4 = new Cart();
        cart4.addProduct(Oldcheese, 1);
        CheckoutService.checkout(Alaa, cart4);

        //When Item is Out of Stock
        Product Newcheese = new ShippableAndExpirableProduct("Newcheese", 100, 10, LocalDate.of(1025, 12, 31),1 );
        Customer ola = new Customer("ola", 1000);
        Cart cart5 = new Cart();
        cart5.addProduct(Newcheese, 4);
         cart5.addProduct(Newcheese, 10);
        CheckoutService.checkout(ola, cart5);



    }


}