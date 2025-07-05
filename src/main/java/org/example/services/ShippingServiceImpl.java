package org.example.services;

import org.example.product.Shippable;

import java.util.Map;

public class ShippingServiceImpl {
    public static double getTotalShippingCost(Map<Shippable,Integer> shippableProducts) {
        double totalShippingCost = 0;
       for (Map.Entry<Shippable,Integer> entry : shippableProducts.entrySet()) {
            totalShippingCost += entry.getKey().getWeight()*10*entry.getValue(); //every kilo costs 10 for shipping
        }
        return totalShippingCost;
    }

    public static void printShipping(Map<Shippable,Integer> items) {
        double totalWeight = 0;
        System.out.println("** Shipping Details **");
        System.out.println("Shipping Cost is 10 for each kilo : ");
        for (Map.Entry<Shippable,Integer> entry : items.entrySet()) {
            System.out.println(entry.getKey().getName());
            System.out.println("Single weight "+entry.getKey().getWeight()+" Total weight :"+entry.getKey().getWeight()*entry.getValue()+ "kg");
            totalWeight += entry.getKey().getWeight()*entry.getValue();
        }
        System.out.println("Total package weight "+ totalWeight+"kg\n");
    }
}
