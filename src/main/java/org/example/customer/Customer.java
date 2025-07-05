package org.example.customer;

import org.example.cart.Cart;

public class Customer {
        public String name;
        int balance;

    public Customer() {

    }

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
    public void pay(double amount) {
        balance -= amount;
    }
}
